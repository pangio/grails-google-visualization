package com.pangio.company

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(EmployeeService)
@Mock([Employee])
class EmployeeServiceSpec extends Specification {

    def employeeList

    def setup() {
        new Employee(firstName: 'John', lastName: 'Something', salary: 51234L, gender: Gender.MALE, country: Country.UNITED_STATES).save(flush: true)
        new Employee(firstName: 'Wong', lastName: 'Something', salary: 41234L, gender: Gender.FEMALE, country: Country.CHINA).save(flush: true)
        new Employee(firstName: 'Vlarimir', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.RUSSIA).save(flush: true)
        new Employee(firstName: 'Gilbert', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.CANADA).save(flush: true)
        new Employee(firstName: 'Pierre', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.CANADA).save(flush: true)
        new Employee(firstName: 'Matt', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.CANADA).save(flush: true)
        new Employee(firstName: 'Susan', lastName: 'Something', salary: 21234L, gender: Gender.FEMALE, country: Country.UNITED_KINGDOM).save(flush: true)
    }

    def cleanup() {
        employeeList = null
    }

    void "test find by salary and gender"() {

        when: "Search between 20k and 40k and Female"
        employeeList = service.findAllBySalaryBetweenAndGender(20000L, 40000L, Gender.FEMALE)

        then: "1 is found"
        assertEquals employeeList.size(), 1

        when: "Search between 40k and 45k and Female"
        employeeList = service.findAllBySalaryBetweenAndGender(40000L, 45000L, Gender.FEMALE)

        then: "1 is found"
        assertEquals employeeList.size(), 1

        when: "Search between 20k and 40k and Male"
        employeeList = service.findAllBySalaryBetweenAndGender(20000L, 40000L, Gender.MALE)

        then: "4 are found"
        assertEquals employeeList.size(), 4

        when: "Search between 40k and 60k and Male"
        employeeList = service.findAllBySalaryBetweenAndGender(40000L, 60000L, Gender.MALE)

        then: "1 is found"
        assertEquals employeeList.size(), 1

    }

    void "test find by gender"() {
        when: "Search by Male"
        employeeList = service.findAllByGender(Gender.MALE)

        then: "5 are found"
        assertEquals employeeList.size(), 5

        when: "Search by Female"
        employeeList = service.findAllByGender(Gender.FEMALE)

        then: "2 are found"
        assertEquals employeeList.size(), 2
    }

    void "test find by country"() {
        when: "Search by Canada"
        employeeList = service.findAllByCountry(Country.CANADA)

        then: "3 are found"
        assertEquals employeeList.size(), 3

        when: "Search by China"
        employeeList = service.findAllByCountry(Country.CHINA)

        then: "1 is found"
        assertEquals employeeList.size(), 1

    }
}
