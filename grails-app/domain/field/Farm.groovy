package field
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Farm {
    String name 
    String locationKey
    double area
    Point point 
    Soil soil 

    static constraints = {
    }
}