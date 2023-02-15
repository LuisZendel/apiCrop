package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CycleController {

    CycleService cycleService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cycleService.list(params), model:[cycleCount: cycleService.count()]
    }

    def show(Long id) {
        respond cycleService.get(id)
    }

    def save(Cycle cycle) {
        if (cycle == null) {
            render status: NOT_FOUND
            return
        }

        try {
            cycleService.save(cycle)
        } catch (ValidationException e) {
            respond cycle.errors, view:'create'
            return
        }

        respond cycle, [status: CREATED, view:"show"]
    }

    def update(Cycle cycle) {
        if (cycle == null) {
            render status: NOT_FOUND
            return
        }

        try {
            cycleService.save(cycle)
        } catch (ValidationException e) {
            respond cycle.errors, view:'edit'
            return
        }

        respond cycle, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        cycleService.delete(id)

        render status: NO_CONTENT
    }
}
