package com.raimiyashiro.lifeprogressbar.service

import com.raimiyashiro.lifeprogressbar.data.entity.Person
import com.raimiyashiro.lifeprogressbar.data.repository.PersonRepository
import spock.lang.Specification
import spock.lang.Subject

class PersonServiceTest extends Specification {

    def personRepository = Mock(PersonRepository)

    @Subject
    def personService = new PersonService(personRepository)


    def static final PERSON_ID = UUID.randomUUID()

    def "FindById"() {
        given:
        1 * personRepository.getReferenceById(*_) >> Person.builder().id(PERSON_ID).build()

        when:
        def response = personService.findById(PERSON_ID)

        then:
        PERSON_ID == response.id
    }

    def "Create"() {
    }
}
