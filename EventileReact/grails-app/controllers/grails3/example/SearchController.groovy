package grails3.example

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

@Secured(['ROLE_USER'])
class SearchController {

    static responseFormats = ['json']

    def searchService
    def EventbriteService
    def springSecurityService

    def search(String q) {
        // Gets the current user name - can be used to control permissions
        def info = springSecurityService.currentUser.username
        log.debug("Searching by query = ${q}...")

        // perform a GET requestion to Eventbrite's API using EventbriteService class
        def response_eventbrite = EventbriteService.search(q)
        System.out.println("yaya")
        System.out.println(response_eventbrite.json.toString())




        def result = searchService.search(q.trim())
        respond result
    }

    def handleIllegalArgument(IllegalArgumentException ex) {
        log.debug("Handling IllegalArgumentException ${ex}... Returning NO_CONTENT.")
        respond Collections.emptyList()
    }
}
