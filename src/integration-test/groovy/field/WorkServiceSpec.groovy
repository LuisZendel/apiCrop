package field

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WorkServiceSpec extends Specification {

    WorkService workService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Work(...).save(flush: true, failOnError: true)
        //new Work(...).save(flush: true, failOnError: true)
        //Work work = new Work(...).save(flush: true, failOnError: true)
        //new Work(...).save(flush: true, failOnError: true)
        //new Work(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //work.id
    }

    void "test get"() {
        setupData()

        expect:
        workService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Work> workList = workService.list(max: 2, offset: 2)

        then:
        workList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        workService.count() == 5
    }

    void "test delete"() {
        Long workId = setupData()

        expect:
        workService.count() == 5

        when:
        workService.delete(workId)
        sessionFactory.currentSession.flush()

        then:
        workService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Work work = new Work()
        workService.save(work)

        then:
        work.id != null
    }
}
