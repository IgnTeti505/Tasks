APP.controller('loginCtrl', function ($scope, $location, loginService, sessionStorageFactory) {
    // app.controller('myCtrl',['storageService',function(storageService) {

    // POST
    // $scope.user = { }
    $scope.postLogin = function () {
        loginService.post($scope.user).then(
            (data) => {
                console.log("Ctrl: ", data);
                sessionStorageFactory.save('usuario', data);
                console.log("session:", sessionStorageFactory.get('usuario'))
            },
            (reject) => {
                console.log("Ctrl: ", reject);
            });
        
    }

    $scope.submitFormUser = function (valid) {
        console.log("funcion login...")
        if(valid){
            if ($scope.user.usuario && $scope.user.contrasenia) {
                console.log("usuario & pass ok")
                $scope.postLogin()
            } else {
                console.log("introduce los dos campos")
            }
        } else {
            console.log("no valid")
        }
    }

})