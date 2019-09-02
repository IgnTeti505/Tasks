APP.factory('sessionStorageFactory', ['$rootScope', function($rootScope) {

    return {
        get: function(key) {
            return JSON.parse(sessionStorage.getItem(key));
        },
        save: function(key, data) {
            sessionStorage.setItem(key, JSON.stringify(data));
        }, 
        remove: function(key) {
            sessionStorage.removeItem(key);
        },
        clear: function() {
            sessionStorage.clear();
        }
        
    };
}]);