package field
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Cycle {
    String name
    int year
    String description

    static constraints = {
    }
}