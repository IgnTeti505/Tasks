APP.controller('tareaCtrl', function ($scope, $location, tareaService, sessionStorageFactory) {
    $scope.suma = 2 + 2;

    $scope.tareas = {}
    let sesion = sessionStorageFactory.get('usuario')

    $scope.btnAgregar = function () {
        $scope.task = {
            fecha: new Date()
        }
    }

    $scope.btnEditar = function (task) {
        $scope.task = task
        console.log("editar", $scope.task)
    }

    // BORRA SESION E IR A INICIO
    $scope.deleteSession = function () {
        sessionStorageFactory.remove('usuario')
        $location.path("/")
    }

    // VALIDA
    $scope.submitForm = function (valid) {
        if (valid) {
            if ($scope.task.id) {
                console.log("Editar")
                $scope.btnEditar2()

            } else {
                $scope.task.usuario = $scope.user;
                console.log("Agregar")
                $scope.agregarTarea()
            }
        }


        console.log("tarea: ", $scope.tarea);
    }

    // GET
    $scope.obtenerTareas = function () {
        $scope.user = sessionStorageFactory.get('usuario')
        if ($scope.user) {

            console.log("usuario_GEt", $scope.user)
            tareaService.getById($scope.user.id).then(
                (data) => {
                    console.log("Ctrl: ", data);
                    $scope.tareas = data;
                },
                (reject) => {
                    console.log("Ctrl: fallo get", reject); 
                });
        } else {
            $location.path("/")
        }
    }

    // POST
    $scope.agregarTarea = function () {
        console.log("usuario loged id: ", sesion.id)
        tareaService.post($scope.task).then(
            (data) => {
                console.log("Ctrl: ", data);
                document.getElementById("myForm").reset();
                $scope.obtenerTareas()
            },
            (reject) => {
                console.log("Ctrl POST fallo: ", reject);
            });
        INITCONTROLLER()
        $scope.task = null
    }

    // PUT
    $scope.btnEditar2 = function (task) {


        tareaService.put($scope.task).then(
            (data) => {
                console.log("Ctrl: ", data);
                document.getElementById("myForm").reset();
                $scope.obtenerTareas()
                $scope.task = null
            },
            (reject) => {
                console.log("Ctrl: ", reject);
            });
    }

    // DELETE
    $scope.btnBorrar = function (task) {
        console.log("borrando...", task)
        // $scope.taskEliminar = task

        tareaService.delete(task).then(
            (data) => {
                console.log("Ctrl: delete ->", data);
                $scope.obtenerTareas()
                task = null;
            },
            (reject) => {
                console.log("Ctrl: ", reject.data.message.toString());
            });
    }

    $scope.mostrarDatos = function () {
        $scope.task = null
    }


    const INITCONTROLLER = function () {
        $scope.obtenerTareas()
    }

    angular.element(document).ready(function () {
        INITCONTROLLER();
    })

})