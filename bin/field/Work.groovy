package field
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Work {
    String initDate
    double duration
    String typeWork
    Planting planting
    Material material 
    

    static constraints = {
    }
}