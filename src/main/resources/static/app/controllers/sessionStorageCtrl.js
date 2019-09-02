APP.controller('sessionStorageCtrl',['storageService',function(sessionStorageFactory) {

    // Save session data to sessionStorageFactory
    sessionStorageFactory.save('key', 'value');
  
    // Get saved session data from sessionStorageFactory
    let sessionData = sessionStorageFactory.get('key');
  
  }])

  