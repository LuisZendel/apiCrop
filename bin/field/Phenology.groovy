package field
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Phenology {
    
    String phase 
    String week 
    String description
    String notes
    Seed seed
    
    static constraints = {
    }

}