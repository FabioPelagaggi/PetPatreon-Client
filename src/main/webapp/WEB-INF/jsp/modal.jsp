<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- The Modal -->
    <div class="modal fade" id="logoutModal">
        <div class="modal-dialog">
          <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
              <h4 class="modal-title">Loging Out</h4>
              <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="alert alert-danger">
              <strong>Warning!</strong> Are you sure you want to logout?
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
              <a href="/logout" class="btn btn-success">Yes</a>
              <button type="button" class="btn btn-danger" data-bs-dismiss="modal">No</button>
            </div>

          </div>
        </div>
      </div>