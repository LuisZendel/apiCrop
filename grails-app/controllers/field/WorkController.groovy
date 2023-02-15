package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WorkController {

    WorkService workService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond workService.list(params), model:[workCount: workService.count()]
    }

    def show(Long id) {
        respond workService.get(id)
    }

    def save(Work work) {
        if (work == null) {
            render status: NOT_FOUND
            return
        }

        try {
            workService.save(work)
        } catch (ValidationException e) {
            respond work.errors, view:'create'
            return
        }

        respond work, [status: CREATED, view:"show"]
    }

    def update(Work work) {
        if (work == null) {
            render status: NOT_FOUND
            return
        }

        try {
            workService.save(work)
        } catch (ValidationException e) {
            respond work.errors, view:'edit'
            return
        }

        respond work, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        workService.delete(id)

        render status: NO_CONTENT
    }
}
