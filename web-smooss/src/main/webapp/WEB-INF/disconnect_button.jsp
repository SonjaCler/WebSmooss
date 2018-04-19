<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/disconnect_button.css">
<div id="volet_clos">
    <div id="volet">
        <p>
            <a id="disconnect" href="<%= request.getContextPath()%>/LogoutController">Disconnect</a>
        </p>
        <a href="#volet" class="ouvrir" aria-hidden="true">
            <i class="fas fa-power-off"></i>
        </a>
        <a href="#volet_clos" class="fermer" aria-hidden="true">
            <i class="fas fa-power-off"></i>
        </a>
    </div>
</div>