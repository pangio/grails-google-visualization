package com.pangio.company

import org.apache.commons.logging.LogFactory

class FiringJob {

    private static final log = LogFactory.getLog(this)

    def employee

    static triggers = {
        cron name: 'firingTrigger', cronExpression: "0/5 * * * * ?"
    }

    def group = "firingGroup"
    def description = "Firing job with Cron Trigger"


    def execute(){

        try {
            employee = Employee.find("FROM Employee ")
            log.info(employee.firstName + ' has been fired')
            employee.delete()
        } catch (NullPointerException e) {
            log.info('Employee not found. Nobody has been fired!')
        }
    }
}
