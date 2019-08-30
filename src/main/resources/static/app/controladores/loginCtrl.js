APP.controller('loginCtrl', function ($scope, loginService) {
    // POST
    // $scope.user = { }
    $scope.postLogin = function () {
        loginService.post($scope.user).then(
            (data) => {
                console.log("Ctrl: ", data);
            },
            (reject) => {
                console.log("Ctrl: ", reject);
            });
        
    }

    $scope.submitFormUser = function (valid) {
        console.log("funcion login...")
        if(valid){
            if ($scope.user.usuario && $scope.user.pass) {
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