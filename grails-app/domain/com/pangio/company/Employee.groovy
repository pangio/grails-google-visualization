package com.pangio.company

class Employee {

    String firstName
    String lastName
    Long salary
    Gender gender
    Country country

    static constraints = {
        firstName nullable: false
        lastName nullable: false
        salary nullable: false
        gender nullable: false
        country nullable: false
    }
}
