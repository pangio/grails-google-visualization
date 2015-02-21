<%@ page import="com.pangio.company.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <gvisualization:apiImport/>

</head>
<body>
<a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><g:link action="index">Employees List</g:link></li>
        <li><g:link action="charts">Charts</g:link></li>
        <li>
            <sec:ifLoggedIn> <g:link controller="logout" action="index">Welcome, <sec:username/> Logout</g:link> </sec:ifLoggedIn>
        </li>
    </ul>
</div>
<div id="list-employee" class="content scaffold-list" role="main">
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <h1>Charts: gender/salary/country

        <g:remoteLink asynchronous="true" controller="employee" action="charts"
                      update="allCharts">Update</g:remoteLink><br/>
    </h1>

    <div id="allCharts">
        <g:render template="charts"></g:render>
    </div>

</div>
</body>
</html>