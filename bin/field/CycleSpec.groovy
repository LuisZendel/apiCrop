package field

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CycleSpec extends Specification implements DomainUnitTest<Cycle> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        true == false
    }
}
