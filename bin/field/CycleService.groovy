package field

import grails.gorm.services.Service

@Service(Cycle)
interface CycleService {

    Cycle get(Serializable id)

    List<Cycle> list(Map args)

    Long count()

    void delete(Serializable id)

    Cycle save(Cycle cycle)

}