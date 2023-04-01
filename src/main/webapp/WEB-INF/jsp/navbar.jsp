<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <ul class="navbar-nav">

                    <li class="nav-item">
                        <a class="nav-link" href="/home">Home</a>
                    </li>

                    <c:if test="${logedPatreon.admin}">
                        <li class="nav-item">
                            <a class="nav-link" href="/donation/register"><strong>Make Donation</strong></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/patreon/table">Patreons Agency</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/agency/table">Agencies</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/pet/table">Pets</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/donation/table">Donations</a>
                        </li>
                    </c:if>

                    <c:if test="${not empty logedPatreon}">
                        <c:if test="${not logedPatreon.admin}">
                            <li class="nav-item">
                                <a class="nav-link" href="/donation/register"><strong>Make Donation</strong></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/patreon/table">Patreons Table</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/agency/table">Agencies Table</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/pet/table">Pets Table</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/donation/table">Donations Table</a>
                            </li>
                        </c:if>
                    </c:if>
                </ul>

                <ul class="navbar-nav navbar-right">

                    <c:if test="${empty logedPatreon}">
                        <li class="nav-item">
                            <a href="/patreon/register" class="nav-link">
                                Register
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/login" class="nav-link active btn btn-primary">
                                Login
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${not empty logedPatreon}">
                        <button type="button" class="btn btn-secondary" data-bs-toggle="modal"
                            data-bs-target="#logoutModal">
                            Logout, ${logedPatreon.name} <strong>- ${logedPatreon.agency.name} -</strong>
                        </button>
                    </c:if>

                </ul>
            </div>
        </nav>