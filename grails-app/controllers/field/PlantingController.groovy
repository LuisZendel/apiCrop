package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PlantingController {

    PlantingService plantingService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond plantingService.list(params), model:[plantingCount: plantingService.count()]
    }

    def show(Long id) {
        respond plantingService.get(id)
    }

    def save(Planting planting) {
        if (planting == null) {
            render status: NOT_FOUND
            return
        }

        try {
            plantingService.save(planting)
        } catch (ValidationException e) {
            respond planting.errors, view:'create'
            return
        }

        respond planting, [status: CREATED, view:"show"]
    }

    def update(Planting planting) {
        if (planting == null) {
            render status: NOT_FOUND
            return
        }

        try {
            plantingService.save(planting)
        } catch (ValidationException e) {
            respond planting.errors, view:'edit'
            return
        }

        respond planting, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        plantingService.delete(id)

        render status: NO_CONTENT
    }
}
