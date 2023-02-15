package field

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CycleServiceSpec extends Specification {

    CycleService cycleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Cycle(...).save(flush: true, failOnError: true)
        //new Cycle(...).save(flush: true, failOnError: true)
        //Cycle cycle = new Cycle(...).save(flush: true, failOnError: true)
        //new Cycle(...).save(flush: true, failOnError: true)
        //new Cycle(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //cycle.id
    }

    void "test get"() {
        setupData()

        expect:
        cycleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Cycle> cycleList = cycleService.list(max: 2, offset: 2)

        then:
        cycleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cycleService.count() == 5
    }

    void "test delete"() {
        Long cycleId = setupData()

        expect:
        cycleService.count() == 5

        when:
        cycleService.delete(cycleId)
        sessionFactory.currentSession.flush()

        then:
        cycleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Cycle cycle = new Cycle()
        cycleService.save(cycle)

        then:
        cycle.id != null
    }
}
