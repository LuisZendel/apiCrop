package field
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Planting {
    String datePlanting
    int numberSeed
    String notes
    Farm farm
    Cycle cycle 
    Seed seed




    static constraints = {
    }
}