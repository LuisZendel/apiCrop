package field

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MaterialController {

    MaterialService materialService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond materialService.list(params), model:[materialCount: materialService.count()]
    }

    def show(Long id) {
        respond materialService.get(id)
    }

    def save(Material material) {
        if (material == null) {
            render status: NOT_FOUND
            return
        }

        try {
            materialService.save(material)
        } catch (ValidationException e) {
            respond material.errors, view:'create'
            return
        }

        respond material, [status: CREATED, view:"show"]
    }

    def update(Material material) {
        if (material == null) {
            render status: NOT_FOUND
            return
        }

        try {
            materialService.save(material)
        } catch (ValidationException e) {
            respond material.errors, view:'edit'
            return
        }

        respond material, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        materialService.delete(id)

        render status: NO_CONTENT
    }
}
