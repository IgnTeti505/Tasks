APP.service('loginService', function($q, factory)  {
    const SELF = this;
    // nombre del restController
    const PATH = 'login';
    // recibe url y data
    SELF.post = (user) => {
        return $q((success, error) => {
            factory.post(PATH, user).then(
                (resolve) => {
                    success(resolve)
                },
                (reject) => {
                    error(reject)
                })
        })
    }
    // realizar conttrolador y terminar el REST
})