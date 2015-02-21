package com.pangio.company

import org.apache.commons.logging.LogFactory

class HiringJob {

    private static final log = LogFactory.getLog(this)

    def employee

    static triggers = {
        cron name: 'hiringTrigger', cronExpression: "0/2 * * * * ?"
    }

    def group = "hiringGroup"
    def description = "Hiring job with Cron Trigger"

    def execute(){

        Random random = new Random();
        int randomSalary = random.nextInt((50000 - 15000) + 1) + 15000;

        employee = new Employee(firstName: FirstName.getRandom(), lastName: 'Somebody', salary: randomSalary.longValue(), gender: Gender.getRandom(), country: Country.getRandom()).save(flush: true)
        log.info(employee.lastName + ' has been hired in ' + employee.country)
    }
}
