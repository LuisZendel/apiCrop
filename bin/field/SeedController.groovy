package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SeedController {

    SeedService seedService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond seedService.list(params), model:[seedCount: seedService.count()]
    }

    def show(Long id) {
        respond seedService.get(id)
    }

    def save(Seed seed) {
        if (seed == null) {
            render status: NOT_FOUND
            return
        }

        try {
            seedService.save(seed)
        } catch (ValidationException e) {
            respond seed.errors, view:'create'
            return
        }

        respond seed, [status: CREATED, view:"show"]
    }

    def update(Seed seed) {
        if (seed == null) {
            render status: NOT_FOUND
            return
        }

        try {
            seedService.save(seed)
        } catch (ValidationException e) {
            respond seed.errors, view:'edit'
            return
        }

        respond seed, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        seedService.delete(id)

        render status: NO_CONTENT
    }
}
