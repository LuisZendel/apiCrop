package field

import grails.gorm.services.Service

@Service(Planting)
interface PlantingService {

    Planting get(Serializable id)

    List<Planting> list(Map args)

    Long count()

    void delete(Serializable id)

    Planting save(Planting planting)

}