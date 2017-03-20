import grails3.example.Role
import grails3.example.User
import grails3.example.UserRole

class BootStrap {

    def init = { servletContext ->
        def role = new Role(authority: 'ROLE_USER').save()
        def user1 = new User(username: 'test', password: '2212', age: '100', location: 'London').save()
        UserRole.create(user1, role, true)
        user1.addToPreferences("Music").save()
        user1.addToCategory_ids("103").save()
        user1.addToPreferences("Film, Media & Entertainment").save()
        user1.addToCategory_ids("104").save()



        def user2 = new User(username: 'test2', password: '2212', age: '100', location: 'London').save()
        UserRole.create(user2, role, true)
    }
    def destroy = {
    }
}
