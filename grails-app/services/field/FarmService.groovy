package field

import grails.gorm.services.Service

@Service(Farm)
interface FarmService {

    Farm get(Serializable id)

    List<Farm> list(Map args)

    Long count()

    void delete(Serializable id)

    Farm save(Farm farm)

}