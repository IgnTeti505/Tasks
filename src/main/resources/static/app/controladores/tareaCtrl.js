APP.controller('tareaCtrl', function ($scope, tareaService) {
    $scope.suma = 2 + 2;

    $scope.tareas = {}

    $scope.btnAgregar = function () {
        $scope.task = {
            fecha: new Date(),

        }
    }


    $scope.btnEditar = function (task) {
        $scope.task = task
        console.log("editar", $scope.task)
    }


    
    // VALIDA
    $scope.submitForm = function (valid) {
        if(valid){
            if ($scope.task.id) {
                console.log("Editar")
                $scope.btnEditar2()
                
            } else {
                console.log("Agregar")
                $scope.agregarTarea()
            }
        }
       
        
        console.log("tarea: ", $scope.tarea);
    }
    
    // GET
    $scope.obtenerTareas = function () {
        tareaService.get().then(
            (data) => {
                console.log("Ctrl: ", data);
                $scope.tareas = data;
            },
            (reject) => {
                console.log("Ctrl: ", reject);
            });
    }

    // POST
    $scope.agregarTarea = function () {
        tareaService.post($scope.task).then(
            (data) => {
                console.log("Ctrl: ", data);
                document.getElementById("myForm").reset();
                $scope.obtenerTareas()
            },
            (reject) => {
                console.log("Ctrl: ", reject);
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
                console.log("Ctrl: ", data);
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