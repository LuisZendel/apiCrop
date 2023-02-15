package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SoilController {

    SoilService soilService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond soilService.list(params), model:[soilCount: soilService.count()]
    }

    def show(Long id) {
        respond soilService.get(id)
    }

    def save(Soil soil) {
        if (soil == null) {
            render status: NOT_FOUND
            return
        }

        try {
            soilService.save(soil)
        } catch (ValidationException e) {
            respond soil.errors, view:'create'
            return
        }

        respond soil, [status: CREATED, view:"show"]
    }

    def update(Soil soil) {
        if (soil == null) {
            render status: NOT_FOUND
            return
        }

        try {
            soilService.save(soil)
        } catch (ValidationException e) {
            respond soil.errors, view:'edit'
            return
        }

        respond soil, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        soilService.delete(id)

        render status: NO_CONTENT
    }
}
