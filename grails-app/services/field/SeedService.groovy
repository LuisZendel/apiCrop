package field

import grails.gorm.services.Service

@Service(Seed)
interface SeedService {

    Seed get(Serializable id)

    List<Seed> list(Map args)

    Long count()

    void delete(Serializable id)

    Seed save(Seed seed)

}