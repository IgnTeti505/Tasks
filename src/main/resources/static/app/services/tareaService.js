APP.service('tareaService', ($q, factory) => {
    const SELF = this;
    // nombre del restController
    const PATH = 'Tarea';

    SELF.get = () => {
        return $q((success, error) => {
            factory.get(PATH).then(
                (resolve) => {
                    success(resolve)
                },
                (reject) => {
                    error(reject)
                })
        })
    }
    // recibe url y data
    SELF.post = (tarea) => {
        return $q((success, error) => {
            factory.get(PATH, ).then(
                (resolve) => {
                    success(resolve)
                },
                (reject) => {
                    error(reject)
                })
        })
    }
    SELF.put()
    SELF.delete()
    // realizar conttrolador y terminar el REST
})