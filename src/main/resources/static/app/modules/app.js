const APP = angular.module("AppTasks", ["ngRoute"]);



// constantes, values, router... todo lo que tiene que ver con congiguraciones
APP.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl: "views/login.html",
    })
    .when("/registro", {
        templateUrl: "views/registro.html",
    })
    .when("/tareas", {
        templateUrl: "views/tarea.html",
    })
    .when("/usuarios", {
        templateUrl: "views/usuario.html",
    })
    .otherwise({
        redirectTo: '/'
    });
});
