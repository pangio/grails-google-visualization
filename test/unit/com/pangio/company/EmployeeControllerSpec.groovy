package com.pangio.company

import grails.test.mixin.*
import spock.lang.*

/*
 * Unit Test for the controller {@link EmployeeController}
 * See also {@link Employee}
 *
 * @author pangio
 */
@TestFor(EmployeeController)
@Mock([Employee])
class EmployeeControllerSpec extends Specification {

    def setup () {
        new Employee(firstName: 'John', lastName: 'Something', salary: 51234L, gender: Gender.MALE, country: Country.UNITED_STATES).save(flush: true)
        new Employee(firstName: 'Wong', lastName: 'Something', salary: 41234L, gender: Gender.FEMALE, country: Country.CHINA).save(flush: true)
        new Employee(firstName: 'Vlarimir', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.RUSSIA).save(flush: true)
        new Employee(firstName: 'Gilbert', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.BRAZIL).save(flush: true)
        new Employee(firstName: 'Pierre', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.CANADA).save(flush: true)
        new Employee(firstName: 'Matt', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.AUSTRALIA).save(flush: true)
        new Employee(firstName: 'Susan', lastName: 'Something', salary: 21234L, gender: Gender.FEMALE, country: Country.UNITED_KINGDOM).save(flush: true)
    }

    void "Test the Index action returns the right employees in correct order"() {

        when:"The Index action is executed"
        controller.index()

        then:"The list is correct and ordered by salary"
        response.status == 200
        model.employeeInstanceList != null
        model.employeeInstanceCount == 7

        Employee john = model.employeeInstanceList.get(0)
        assertEquals john.firstName, 'John'
        assertEquals john.salary, 51234L
        assertEquals john.gender, Gender.MALE
        assertEquals john.country, Country.UNITED_STATES

        Employee wong = model.employeeInstanceList.get(1)
        assertEquals wong.firstName, 'Wong'
        assertEquals wong.salary, 41234L
        assertEquals wong.gender, Gender.FEMALE
        assertEquals wong.country, Country.CHINA
    }
}
