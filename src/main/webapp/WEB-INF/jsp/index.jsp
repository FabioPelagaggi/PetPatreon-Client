<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
      <meta charset="UTF-8" />
      <title>Pet Patreon</title>
    </head>

    <body>
      <c:import url="/WEB-INF/jsp/modal.jsp" />

      <div class="p-5 bg-primary text-white text-center">
        <h1>Pet Patreon</h1>
        <p>Support loving pets in need...</p>
      </div>

      <c:import url="/WEB-INF/jsp/navbar.jsp" />

      <div class="container mt-5">
        
        <div class="row">

          <div class="col-sm-4 d-flex flex-column justify-content-center">
            
            <div class="align-self-center">
              <h2>About Me</h2>
              <img class="rounded-circle" height="120" width="" x="30" y="40" src="https://media.tenor.com/nyfBe4ukoDgAAAAM/hellinheavns.gif"></image>
            </div>
            
            <div>
              <h5 class="m-5">Fábio Rodrigues Pelagaggi Nunes</h5>
              <ul class="nav nav-pills flex-column">
                <li class="nav-item m-1">
                  <a class="nav-link active" href="https://fabio.pelagaggi.com/">Portifolio</a>
                </li>
                <li class="nav-item m-1">
                  <a class="nav-link active" href="https://github.com/FabioPelagaggi?tab=repositories">GitHub</a>
                </li>
              </ul>
            </div>
            
          </div>

          <div class="col-sm-8">
            <h2>BLOCO DESENVOLVIMENTO JAVA</h2>
            <h5>GRADUAÇÃO EM ENGENHARIA DE SOFTWARE</h5>
            <h2 class="mt-5">Projeto de Bloco - DESENVOLVIMENTO WEB JAVA</h2>
            <h5>Prof.: Elberth Moraes</h5>
          </div>

        </div>
       
      </div>

      <div class="mt-5 p-4 bg-dark text-white text-center">
        <p><strong>Fábio </strong>Rodrigues Pelagaggi Nunes</p>
      </div>
    </body>

    </html>