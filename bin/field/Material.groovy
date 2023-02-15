package field
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Material {
    String provider
    String material
    double cost
    String description
    
    static constraints = {
    }

}