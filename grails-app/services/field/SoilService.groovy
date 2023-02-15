package field

import grails.gorm.services.Service

@Service(Soil)
interface SoilService {

    Soil get(Serializable id)

    List<Soil> list(Map args)

    Long count()

    void delete(Serializable id)

    Soil save(Soil soil)

}