APP.controller("tareaCtrl", function ($scope, tareaService) {
    $scope.suma = 2 + 2;

    $scope.tareas = {}
    
    tareaService.get().then(
        (data) => {
            console.log("Ctrl: ", data);
            $scope.tareas = data;
        },
        (reject) => {
            console.log("Ctrl: ", reject);
        });

    // tareaService.post()
})