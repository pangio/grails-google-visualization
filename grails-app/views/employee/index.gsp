<%@ page import="com.pangio.company.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav navbar" role="navigation">
    <ul>
        <li><g:link action="index">Employees List</g:link></li>
        <li><g:link action="charts">Charts</g:link></li>
        <li>
            <sec:ifLoggedIn> <g:link controller="logout" action="index" >Welcome, <sec:username/> Logout</g:link> </sec:ifLoggedIn>
        </li>
    </ul>

</div>
<div id="list-employee" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" />

    <g:remoteLink asynchronous="true" controller="employee" action="index"
                  update="allEmployees">Update</g:remoteLink>
    </h1>

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <div id="allEmployees">
        <g:render template="employees"></g:render>
    </div>

</div>
</body>
</html>
