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

            <div class="d-flex justify-content-center">
                <div class="shadow p-3 mb-5 bg-white container card card-block w-auto m-5">
                    <form action="/agency/add" method="post">
                        <div class="d-flex flex-column">
                            <h2 class="mt-3 align-self-center">New Agency</h2>

                            <div class="form-group mb-3 mt-3">
                                <label>Name:</label>
                                <input type="text" name="name" value="Animals Rescue" class="form-control">
                            </div>

                            <div class="form-group mb-3">
                                <label>E-mail:</label>
                                <input type="email" name="email" value="arescue@gmail.com" class="form-control">
                            </div>

                            <button type="submit" class="align-self-center btn btn-primary m-3">Comfirm</button>
                        </div>
                    </form>
                </div>
            </div>
        </body>

        </html>