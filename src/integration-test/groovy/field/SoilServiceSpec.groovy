package field

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SoilServiceSpec extends Specification {

    SoilService soilService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Soil(...).save(flush: true, failOnError: true)
        //new Soil(...).save(flush: true, failOnError: true)
        //Soil soil = new Soil(...).save(flush: true, failOnError: true)
        //new Soil(...).save(flush: true, failOnError: true)
        //new Soil(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //soil.id
    }

    void "test get"() {
        setupData()

        expect:
        soilService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Soil> soilList = soilService.list(max: 2, offset: 2)

        then:
        soilList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        soilService.count() == 5
    }

    void "test delete"() {
        Long soilId = setupData()

        expect:
        soilService.count() == 5

        when:
        soilService.delete(soilId)
        sessionFactory.currentSession.flush()

        then:
        soilService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Soil soil = new Soil()
        soilService.save(soil)

        then:
        soil.id != null
    }
}
