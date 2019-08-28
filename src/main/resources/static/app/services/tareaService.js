APP.service('tareaService', function($q, factory)  {
    const SELF = this;
    // nombre del restController
    const PATH = 'tarea';

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
            factory.post(PATH, tarea).then(
                (resolve) => {
                    success(resolve)
                },
                (reject) => {
                    error(reject)
                })
        })
    }
    SELF.put = (tarea) => {
        return $q((success, error) => {
            factory.put(PATH, tarea).then(
                (resolve) => {
                    success(resolve)
                },
                (reject) => {
                    error(reject)
                }
            )
        })
    }
    SELF.delete = (tarea) => {
        return $q((success, error) => {
            factory.delete(PATH, tarea).then(
                (resolve) => {
                    success(resolve)
                },
                (reject) => {
                    error(reject)
                }
            )
        })
    }
    // realizar conttrolador y terminar el REST
})