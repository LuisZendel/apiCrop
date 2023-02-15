package field

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FarmServiceSpec extends Specification {

    FarmService farmService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Farm(...).save(flush: true, failOnError: true)
        //new Farm(...).save(flush: true, failOnError: true)
        //Farm farm = new Farm(...).save(flush: true, failOnError: true)
        //new Farm(...).save(flush: true, failOnError: true)
        //new Farm(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //farm.id
    }

    void "test get"() {
        setupData()

        expect:
        farmService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Farm> farmList = farmService.list(max: 2, offset: 2)

        then:
        farmList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        farmService.count() == 5
    }

    void "test delete"() {
        Long farmId = setupData()

        expect:
        farmService.count() == 5

        when:
        farmService.delete(farmId)
        sessionFactory.currentSession.flush()

        then:
        farmService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Farm farm = new Farm()
        farmService.save(farm)

        then:
        farm.id != null
    }
}
