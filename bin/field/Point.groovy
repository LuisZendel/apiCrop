package field
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Point {
        
    String altitude
    String latitude
    String longitude
    String nombre

}