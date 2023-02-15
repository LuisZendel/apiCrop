package field

import spock.lang.*
import static org.springframework.http.HttpStatus.*
import grails.validation.ValidationException
import grails.testing.web.controllers.ControllerUnitTest
import grails.testing.gorm.DomainUnitTest

class SoilControllerSpec extends Specification implements ControllerUnitTest<SoilController>, DomainUnitTest<Soil> {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct response"() {
        given:
        controller.soilService = Mock(SoilService) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The index action is executed"
            controller.index()

        then:"The response is correct"
            response.text == '[]'
    }


    void "Test the save action with a null instance"() {
        when:
        request.contentType = JSON_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:
        response.status == NOT_FOUND.value()
    }

    void "Test the save action correctly persists"() {
        given:
        controller.soilService = Mock(SoilService) {
            1 * save(_ as Soil)
        }

        when:
        response.reset()
        request.contentType = JSON_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def soil = new Soil(params)
        soil.id = 1

        controller.save(soil)

        then:
        response.status == CREATED.value()
        response.json
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.soilService = Mock(SoilService) {
            1 * save(_ as Soil) >> { Soil soil ->
                throw new ValidationException("Invalid instance", soil.errors)
            }
        }

        when:
        request.contentType = JSON_CONTENT_TYPE
        request.method = 'POST'
        def soil = new Soil()
        soil.validate()
        controller.save(soil)

        then:
        response.status == UNPROCESSABLE_ENTITY.value()
        response.json.errors
    }

    void "Test the show action with a null id"() {
        given:
        controller.soilService = Mock(SoilService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == NOT_FOUND.value()
    }

    void "Test the show action with a valid id"() {
        given:
        controller.soilService = Mock(SoilService) {
            1 * get(2) >> new Soil()
        }

        when:"A domain instance is passed to the show action"
        controller.show(2)

        then:"A model is populated containing the domain instance"
        response.status == OK.value()
        response.json
    }

    void "Test the update action with a null instance"() {
        when:
        request.contentType = JSON_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:
        response.status == NOT_FOUND.value()
    }

    void "Test the update action correctly persists"() {
        given:
        controller.soilService = Mock(SoilService) {
            1 * save(_ as Soil)
        }

        when:
        response.reset()
        request.contentType = JSON_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def soil = new Soil(params)
        soil.id = 1

        controller.update(soil)

        then:
        response.status == OK.value()
        response.json
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.soilService = Mock(SoilService) {
            1 * save(_ as Soil) >> { Soil soil ->
                throw new ValidationException("Invalid instance", soil.errors)
            }
        }

        when:
        request.contentType = JSON_CONTENT_TYPE
        request.method = 'PUT'
        def soil = new Soil()
        soil.validate()
        controller.update(soil)

        then:
        response.status == UNPROCESSABLE_ENTITY.value()
        response.json.errors
    }

    void "Test the delete action with a null instance"() {
        when:
        request.contentType = JSON_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:
        response.status == NOT_FOUND.value()
    }

    void "Test the delete action with an instance"() {
        given:
        controller.soilService = Mock(SoilService) {
            1 * delete(2)
        }

        when:
        request.contentType = JSON_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:
        response.status == NO_CONTENT.value()
    }
}