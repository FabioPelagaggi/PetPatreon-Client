<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
            <meta charset="UTF-8">
            <title>Register New Patreon</title>
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
                            No agencies registered!
                        </div>
                    </c:if>
                    <form action="/patreon/add" method="post">
                        <div class="d-flex flex-column">
                            <h2 class="mt-3 align-self-center">New Patreon</h2>

                            <div class="form-group mb-3 mt-3">
                                <label>Name:</label>
                                <input type="text" name="name" value="Simon Belmont" class="form-control">
                            </div>

                            <div class="form-group mb-3">
                                <label>Password:</label>
                                <input type="password" name="password" value="666" class="form-control">
                            </div>

                            <div class="form-group mb-3">
                                <label>E-mail:</label>
                                <input type="email" name="email" value="ze@mane.com" class="form-control">
                            </div>

                            <div class="form-group mb-3">
                                <label>Phone:</label>
                                <input type="text" name="phone" value="0000000" class="form-control">
                            </div>

                            <div class="mb-3">
                                <label>Administrator</label>
                                <select class="form-select " name="admin">
                                    <option value="1">Yes</option>
                                    <option value="0">No</option>
                                </select>
                            </div>

                            <div class="form-group mb-3">
                                <label>CEP:</label>
                                <input type="text" name="cep" value="20541300" class="form-control">
                            </div>

                            <div class="mb-3">
                                <c:if test="${not empty agencies}">
                                    <label class="mb-1">Agency</label>
                                    <select class="form-select" name="agencyId">
                                        <c:forEach items="${agencies}" var="agency">
                                            <option value="${agency.id}">${agency.name}</option>
                                        </c:forEach>
                                    </select>
                                </c:if>
                            </div>

                            <button ${buttonStatus} type="submit"
                                class="align-self-center btn btn-primary m-3">Comfirm</button>

                            <c:if test="${empty agencies}">
                                <a type="button" class="align-self-center btn btn-info"
                                    href="/agency/registerFirst">Register New Agency</a>
                            </c:if>

                        </div>
                    </form>
                </div>
            </div>
        </body>

        </html>