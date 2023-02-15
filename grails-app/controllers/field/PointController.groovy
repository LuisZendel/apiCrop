package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PointController {

    PointService pointService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pointService.list(params), model:[pointCount: pointService.count()]
    }

    def show(Long id) {
        respond pointService.get(id)
    }

    def save(Point point) {
        if (point == null) {
            render status: NOT_FOUND
            return
        }

        try {
            pointService.save(point)
        } catch (ValidationException e) {
            respond point.errors, view:'create'
            return
        }

        respond point, [status: CREATED, view:"show"]
    }

    def update(Point point) {
        if (point == null) {
            render status: NOT_FOUND
            return
        }

        try {
            pointService.save(point)
        } catch (ValidationException e) {
            respond point.errors, view:'edit'
            return
        }

        respond point, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        pointService.delete(id)

        render status: NO_CONTENT
    }
}
