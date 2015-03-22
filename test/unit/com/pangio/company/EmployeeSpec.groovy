package com.pangio.company

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Unit Test for the the Domain class {@link Employee}
 *
 * @author pangio
 */
@TestFor(Employee)
class EmployeeSpec extends Specification {

    def employee
    def invalidEmployee

    def setup() {
        employee = new Employee()
        employee.firstName= 'John'
        employee.lastName = 'Doe'
        employee.country = Country.AUSTRALIA
        employee.gender = Gender.MALE
        employee.salary = 20000L

        def invalidEmployee = new Employee()
        invalidEmployee.firstName= 'John'

    }

    void "Test Employee's constraints"() {
        when: 'Employee is created with complete personal information'

        then: 'validations succeed'
        employee.validate()
        !employee.hasErrors()

        when: 'Employee is created with just a name'
        employee = new Employee()
        employee.firstName = 'Just John'

        then: 'validations fail'
        !employee.validate()
        employee.hasErrors()
    }

    void "Test Employee's personal data"() {

        when: 'attributes are set'

        then: "the attributes have expected values"
        assertEquals employee.firstName, 'John'
        assertEquals employee.lastName, 'Doe'
        assertEquals employee.salary, 20000L
        assertEquals employee.country, Country.AUSTRALIA
        assertEquals employee.gender, Gender.MALE

        employee.validate()
        !employee.hasErrors()

        when: 'the first name is set'
        employee.firstName = 'Richard'

        then: "it's updated"
        assertEquals employee.firstName, 'Richard'

        employee.validate()
        !employee.hasErrors()
    }

    def cleanup() {
        employee = null
        invalidEmployee = null
    }

}
