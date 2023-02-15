package field
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Soil {
    String typeSoil
    String description
    String picture

    static constraints = {
    }
}