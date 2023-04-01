<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>

    <head>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
      <meta charset="UTF-8">
      <title>Patreon Data Table</title>
    </head>

    <body>
      <c:import url="/WEB-INF/jsp/modal.jsp" />
      
      <c:import url="/WEB-INF/jsp/navbar.jsp" />
      
      <div class="d-flex justify-content-center">
        <div class="shadow p-3 mb-5 bg-white container card card-block w-auto m-5">

          <c:if test="${not empty message}">
            <div class="alert alert-success">
              <strong>Success!</strong> ${message}
            </div>
          </c:if>

          <c:if test="${not empty messageError}">
            <div class="alert alert-danger">
              <strong>Error!</strong> ${messageError}
            </div>
          </c:if>

          <ul class="nav justify-content-end">
            <li class="nav-item">
              <a class="nav-link align-self-right" href="/patreon/tableAll">All Patreons</a>
            </li>
          </ul>

          <form action="/" method="get">

            <div class="d-flex flex-column">
              <h2 class="m-3 align-self-center">Patreons Data</h2>

              <c:if test="${empty patreons}">
                <div class="alert alert-danger">
                  <strong>Warning!</strong> No patreons registered yet.
                </div>
              </c:if>

              <c:if test="${not empty patreons}">
                <div>
                  <div>
                    <h5 class="m-3 align-self-center">Patreons # ${patreons.size()}</h5>
                  </div>
                  <table class="table">
                   
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Password</th>
                        <th scope="col">Admin</th>
                        <th scope="col">Agency</th>
                        <th scope="col">CEP</th>
                        <th scope="col">Logradouro</th>
                        <th scope="col">UF</th>
                        <th scope="col">Donations</th>
                        <th scope="col">Pets</th>
                        <c:if test="${logedPatreon.admin}">
                          <th scope="col">Delete</th>
                        </c:if>                   
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${patreons}" var="patreon">
                        <tr>
                          <th scope="row">${patreon.id}</th>
                          <td>${patreon.name}</td>
                          <td>${patreon.email}</td>
                          <td>${patreon.phone}</td>
                          <td>${patreon.password}</td>
                          <td>${patreon.admin}</td>
                          <td>${patreon.agency.name}</td>
                          <td>${patreon.address.cep}</td>
                          <td>${patreon.address.logradouro}</td>
                          <td>${patreon.address.uf}</td>
                          <td>${patreon.donations.size()}</td>
                          <td>${patreon.getDonationsPets().size()}</td>
                          <c:if test="${logedPatreon.admin}">
                            <c:if test="${patreon.name != logedPatreon.name}">
                              <td>
                                <a href="/patreon/${patreon.id}/remove">
                                  <i class="fa fa-trash-o ms-3" style="font-size:24px;color:red"></i>
                                </a>
                              </td>
                            </c:if>
                            <c:if test="${patreon.name == logedPatreon.name}">
                              <td>
                                  <i class="fa fa-trash-o ms-3" style="font-size:24px;color:gray"></i>
                              </td>
                            </c:if>
                          </c:if>
                        </tr>
                      </c:forEach>
                    </tbody>

                  </table>
                </div>
              </c:if>

              <button type="submit" class="align-self-center btn btn-primary m-3">Home</button>
              
              <c:if test="${logedPatreon.admin}">
                <a type="button" class="align-self-center btn btn-info" href="/patreon/register">Register New Patreon</a>
              </c:if>

            </div>

          </form>
        </div>
      </div>
    </body>

    </html>