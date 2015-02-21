<table>
    <thead>
    <tr>
        <g:sortableColumn property="firstName" title="${message(code: 'employee.firstName.label', default: 'First Name')}" />
        <g:sortableColumn property="lastName" title="${message(code: 'employee.lastName.label', default: 'Last Name')}" />
        <g:sortableColumn property="country" title="${message(code: 'employee.country.label', default: 'Country')}" />
        <g:sortableColumn property="gender" title="${message(code: 'employee.gender.label', default: 'Gender')}" />
        <g:sortableColumn property="salary" title="${message(code: 'employee.salary.label', default: 'Salary')}" />
    </tr>
    </thead>
    <tbody>
    <g:each in="${employeeInstanceList}" status="i" var="employeeInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>${fieldValue(bean: employeeInstance, field: "firstName")}</td>
            <td>${fieldValue(bean: employeeInstance, field: "lastName")}</td>
            <td>${fieldValue(bean: employeeInstance, field: "country")}</td>
            <td>${fieldValue(bean: employeeInstance, field: "gender")}</td>
            <td>${fieldValue(bean: employeeInstance, field: "salary")}</td>
        </tr>
    </g:each>
    </tbody>
</table>
<div class="pagination">
    <g:paginate total="${employeeInstanceCount ?: 0}" />
</div>
