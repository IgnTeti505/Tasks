APP.service('tareaService', ($q, factory) => {
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
            factory.post(PATH, data).then(
                (resolve) => {
                    success(resolve)
                },
                (reject) => {
                    error(reject)
                })
        })
    }
    SELF.put() = (tarea) => {
        return $q((success, error) => {
            factory.put(PATH)
        })
    }
    SELF.delete()
    // realizar conttrolador y terminar el REST
})