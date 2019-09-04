APP.controller('chatCtrl', function ($scope, $location, tareaService, sessionStorageFactory) {

    let chatPage = document.querySelector('#chat-page');
    let messageArea = document.querySelector('#messageArea');
    let connectingElement = document.querySelector('.connecting');
    let colors = [
        '#2196F3', '#32c787', '#00BCD4', '#ff5652',
        '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
    ];
    let user = sessionStorageFactory.get('usuario');
    let username = user.usuario
    let stompClient = null;

    // SI SESION ACTIVA
    if (username) {
        // usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        let socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    } else {
        console.log("sesion no activa")
        $location.path("/")
    }

    // SUSCRIBIENDOSE AL SOCKET
    function onConnected () {
        // Subscribe to the Public Topic
        stompClient.subscribe('/topic/public', onMessageReceived);

        // Tell your username to the server
        stompClient.send("/app/chat.addUser", {},
            JSON.stringify({
                sender: username,
                type: 'JOIN'
            })
        )
        connectingElement.classList.add('hidden');
    }

    // ERROR DE AL SUSCRIBIRSE AL SOCKET
    function onError(error) {
        connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
        connectingElement.style.color = 'red';
    }

    function onMessageReceived(payload) {
        let message = JSON.parse(payload.body);

        let messageElement = document.createElement('li');

        if (message.type === 'JOIN') {
            messageElement.classList.add('event-message');
            message.content = message.sender + ' se ha unido!';
        } else if (message.type === 'LEAVE') {
            messageElement.classList.add('event-message');
            message.content = message.sender + ' salió!';
        } else {
            messageElement.classList.add('chat-message');

            let avatarElement = document.createElement('i');
            let avatarText = document.createTextNode(message.sender[0]);
            avatarElement.appendChild(avatarText);
            avatarElement.style['background-color'] = getAvatarColor(message.sender);

            messageElement.appendChild(avatarElement);

            let usernameElement = document.createElement('span');
            let usernameText = document.createTextNode(message.sender);
            usernameElement.appendChild(usernameText);
            messageElement.appendChild(usernameElement);
        }

        let textElement = document.createElement('p');
        let messageText = document.createTextNode(message.content);
        textElement.appendChild(messageText);

        messageElement.appendChild(textElement);

        messageArea.appendChild(messageElement);
        messageArea.scrollTop = messageArea.scrollHeight;
    }

    $scope.sendMessage = function () {
        $scope.messageContent.trim();
        if ($scope.messageContent && stompClient) {
            let chatMessage = {
                sender: username,
                content: $scope.messageContent,
                type: 'CHAT'
            };
            stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
            $scope.messageContent = '';
        }
    }

    function getAvatarColor(messageSender) {
        let hash = 0;
        for (let i = 0; i < messageSender.length; i++) {
            hash = 31 * hash + messageSender.charCodeAt(i);
        }
        let index = Math.abs(hash % colors.length);
        return colors[index];
    }

});