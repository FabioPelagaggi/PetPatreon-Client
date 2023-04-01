<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
            <meta charset="UTF-8">
            <title>Register New Donation</title>
        </head>

        <body>
            <c:import url="/WEB-INF/jsp/modal.jsp" />

            <c:import url="/WEB-INF/jsp/navbar.jsp" />

            <c:set var="buttonStatus" value="enabled" />

            <div class="d-flex justify-content-center">
                <div class="shadow p-3 mb-5 bg-white container card card-block w-auto m-5">
                    <c:if test="${empty pets}">
                        <c:set var="buttonStatus" value="disabled" />
                        <div class="alert alert-danger">
                            No pets registered!
                        </div>
                    </c:if>
                    <form action="/donation/add" method="post">
                        <div class="d-flex flex-column">
                            <h2 class="mt-3 align-self-center">New Donation</h2>

                            <div class="form-group mb-3 mt-3">
                                <label>Donation Amount:</label>
                                <input type="number" name="donationAmount" value="1000" class="form-control">
                            </div>
                            <c:if test="${not empty pets}">
                                <label class="mb-2">Pets:</label>
                            
                                <table class="table">
                                    <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Select</th>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Animal Type</th>
                                        <th scope="col">Monthly Cost (R$)</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pets}" var="pet">
                                        <tr>
                                        <td class="ms-3">
                                            <input class="ms-3" type="checkbox" name="pets" value="${pet.id}">
                                        </td>
                                        <td scope="row">${pet.id}</td>
                                        <td>${pet.name}</td>
                                        <td>${pet.animalType}</td>
                                        <td>${pet.calcMonthlyCost()}</td>
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