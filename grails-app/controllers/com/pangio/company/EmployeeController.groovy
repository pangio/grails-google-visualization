package com.pangio.company

import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class EmployeeController {

    def employeeService

    def genderChartColumns
    def genderChartData

    def salaryChartColumns
    def salaryChartData

    def countryChartColumns
    def countryChartData

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Employee.list(sort: 'salary', order: 'desc'), model:[employeeInstanceCount: Employee.count()]
    }

    @Secured(['ROLE_USER'])
    def charts() {

        buildGenderChart()
        buildSalaryChart()
        buildCountryChart()

        [   genderChartData: genderChartData,
                genderChartColumns: genderChartColumns,
                salaryChartData: salaryChartData,
                salaryChartColumns: salaryChartColumns,
                countryChartColumns: countryChartColumns,
                countryChartData: countryChartData
        ]
    }

    private buildCountryChart() {

        countryChartColumns = [['string', 'Country'], ['number', 'Employees']]

        countryChartData = []
        Country.values().each {
            def countryAndQty = []
            def qty = employeeService.findAllByCountry(it).size()
            countryAndQty = [it,qty]

            countryChartData.add(countryAndQty)

        }
    }

    private buildSalaryChart() {

        salaryChartColumns = [['string', 'Employe'], ['number', 'Male'], ['number', 'Female']]

        def firstBandMale = employeeService.findAllBySalaryBetweenAndGender(0L, 20000L, Gender.MALE)
        def firstBandFemale = employeeService.findAllBySalaryBetweenAndGender(0L, 20000L, Gender.FEMALE)
        def secondBandMale = employeeService.findAllBySalaryBetweenAndGender(20001L, 40000L, Gender.MALE)
        def secondBandFemale = employeeService.findAllBySalaryBetweenAndGender(20001L, 40000L, Gender.FEMALE)
        def thirdBandMale = employeeService.findAllBySalaryBetweenAndGender(40001L, 60000L, Gender.MALE)
        def thirdBandFemale = employeeService.findAllBySalaryBetweenAndGender(40001L, 60000L, Gender.FEMALE)

        salaryChartData = [
                ['40-60 k', thirdBandMale.size(), thirdBandFemale.size()],
                ['20-40 k', secondBandMale.size(), secondBandFemale.size()],
                ['0-20 k', firstBandMale.size(), firstBandFemale.size()]
        ]
    }

    private buildGenderChart() {
        genderChartColumns = [['string', 'Gender'], ['number', 'Number']]
        def male = employeeService.findAllByGender(Gender.MALE)
        def female = employeeService.findAllByGender(Gender.FEMALE)
        genderChartData = [['Male', male.size()], ['Female', female.size()]]

    }
}
