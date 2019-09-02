APP.controller('usuarioCtrl', function ($scope, usuarioService) {
    $scope.usuarios = {}
    // $scope.user = {
    //     status: 1
    // }

    // Prepara datos para insertar datos
    $scope.btnAgregarUsuario = function () {
        // btn agregar ususario
        $scope.user = {
            status: 1
        }
    }


    $scope.editarUsuario = function (user) {
        $scope.user = user
    }


    $scope.mostrarDatos = function () {
        $scope.user = null
    }

    
    // VALIDA
    $scope.submitFormUsuario = function (valid) {
        if(valid){
            if ($scope.user.id) {
                console.log("Editar")
                $scope.putUsuario()
                
            } else {
                console.log("Agregar")
                $scope.postUsuario()
            }
        }
    }
    
    // GET
    $scope.getUsuario = function () {
        usuarioService.get().then(
            (data) => {
                console.log("Ctrl: ", data);
                $scope.usuarios = data;
            },
            (reject) => {
                console.log("Ctrl: ", reject);
            });
    }

    // POST
    $scope.postUsuario = function () {
    	$scope.user.status = 1;
        usuarioService.post($scope.user).then(
            (data) => {
                
                document.getElementById("myFormUser").reset();
                $scope.getUsuario()
            },
            (reject) => {
                console.log("Ctrl: ", reject);
            });
        INITCONTROLLER()
        $scope.user = null
    }

    // PUT
    $scope.putUsuario = function (user) {
        console.log("editando", user)
        usuarioService.put($scope.user).then(
            (data) => {
                console.log("Ctrl: ", data);
                document.getElementById("myFormUser").reset();
                $scope.getUsuario()
                $scope.user = null
            },
            (reject) => {
                console.log("Ctrl: reject", reject);
            });
    }

    // DELETE
    $scope.deleteUsuario = function (user) {
        console.log("borrando...", user)
        // $scope.taskEliminar = task

        usuarioService.delete(user).then(
            (data) => {
                console.log("Ctrl: ", data);
                $scope.getUsuario()
                user = null;
            },
            (reject) => {
                console.log("Ctrl: ", reject.data.message.toString());
            });
    }


    $scope.btnBorrar = function (task) {
        console.log("borrando...", task)
        // $scope.taskEliminar = task

        tareaService.delete(task).then(
            (data) => {
                console.log("Ctrl: ", data);
                $scope.obtenerTareas()
                task = null;
            },
            (reject) => {
                console.log("Ctrl: ", reject.data.message.toString());
            });
    }



    const INITCONTROLLER = function () {
        $scope.getUsuario()
    }

    angular.element(document).ready(function () {
        INITCONTROLLER();
    })

})