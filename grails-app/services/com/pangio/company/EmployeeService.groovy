package com.pangio.company

import grails.transaction.Transactional

@Transactional
class EmployeeService {

    def findAllBySalaryBetweenAndGender(Long from, Long to, Gender gender) {
        Employee.findAllBySalaryBetweenAndGender(from, to, gender)
    }

    def findAllByGender(Gender gender) {
        Employee.findAllByGender(gender)
    }

    def findAllByCountry(Country country) {
        Employee.findAllByCountry(country)
    }
}
