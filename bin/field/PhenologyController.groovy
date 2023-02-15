package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PhenologyController {

    PhenologyService phenologyService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond phenologyService.list(params), model:[phenologyCount: phenologyService.count()]
    }

    def show(Long id) {
        respond phenologyService.get(id)
    }

    def save(Phenology phenology) {
        if (phenology == null) {
            render status: NOT_FOUND
            return
        }

        try {
            phenologyService.save(phenology)
        } catch (ValidationException e) {
            respond phenology.errors, view:'create'
            return
        }

        respond phenology, [status: CREATED, view:"show"]
    }

    def update(Phenology phenology) {
        if (phenology == null) {
            render status: NOT_FOUND
            return
        }

        try {
            phenologyService.save(phenology)
        } catch (ValidationException e) {
            respond phenology.errors, view:'edit'
            return
        }

        respond phenology, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        phenologyService.delete(id)

        render status: NO_CONTENT
    }
}
