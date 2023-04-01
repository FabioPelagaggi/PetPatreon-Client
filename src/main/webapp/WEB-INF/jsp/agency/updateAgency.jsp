<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
            <meta charset="UTF-8">
            <title>Register New Agency</title>
        </head>

        <body>
            <c:import url="/WEB-INF/jsp/modal.jsp" />

            <c:import url="/WEB-INF/jsp/navbar.jsp" />

            <c:set var="buttonStatus" value="enabled" />

            <div class="d-flex justify-content-center">
                <div class="shadow p-3 mb-5 bg-white container card card-block w-auto m-5">
                    <c:if test="${empty agencies}">
                        <c:set var="buttonStatus" value="disabled" />
                        <div class="alert alert-danger">
                            No Agencies registered!
                        </div>
                    </c:if>
                    <form action="/agency/update" method="post">
                        <div class="d-flex flex-column">
                            <h2 class="mt-3 align-self-center">Select An Agency</h2>

                            <c:if test="${not empty agencies}">
                                <label class="mb-2">Agencies:</label>
                            
                                <table class="table">
                                    <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Select</th>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Email</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${agencies}" var="agency">
                                        <tr>
                                            <td class="ms-3">
                                                <input class="ms-3" type="checkbox" name="agencyId" value="${agency.id}">
                                            </td>
                                            <td scope="row">${agency.id}</td>
                                            <td>${agency.name}</td>
                                            <td>${agency.email}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                           
                            <button ${buttonStatus} type="submit" class="align-self-center btn btn-primary m-3">Comfirm</button>
                        </div>
                    </form>
                </div>
            </div>
        </body>

        </html>