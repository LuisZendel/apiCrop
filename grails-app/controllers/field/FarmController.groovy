package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FarmController {

    FarmService farmService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond farmService.list(params), model:[farmCount: farmService.count()]
    }

    def show(Long id) {
        respond farmService.get(id)
    }

    def save(Farm farm) {
        if (farm == null) {
            render status: NOT_FOUND
            return
        }

        try {
            farmService.save(farm)
        } catch (ValidationException e) {
            respond farm.errors, view:'create'
            return
        }

        respond farm, [status: CREATED, view:"show"]
    }

    def update(Farm farm) {
        if (farm == null) {
            render status: NOT_FOUND
            return
        }

        try {
            farmService.save(farm)
        } catch (ValidationException e) {
            respond farm.errors, view:'edit'
            return
        }

        respond farm, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        farmService.delete(id)

        render status: NO_CONTENT
    }
}
