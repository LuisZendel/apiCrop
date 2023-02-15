package field

import grails.gorm.services.Service

@Service(Phenology)
interface PhenologyService {

    Phenology get(Serializable id)

    List<Phenology> list(Map args)

    Long count()

    void delete(Serializable id)

    Phenology save(Phenology phenology)

}