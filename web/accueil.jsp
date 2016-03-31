<%-- 
    Document   : accueil
    Created on : 11 févr. 2016, 04:54:40
    Author     : JP
--%>

<%@page import="entites.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% String nom = request.getParameter("nom");
    int age = (Integer)(request.getAttribute("age"));%>         
            
    <body>
    <%@ include file="/entete.jsp" %>    
        Bonjour M. <%=nom%><br>
        (<%=age%> PRINTEMPS)<br>
        Vous êtes autorisé<br> 
        à jouer<br><br>
        <form method="GET" action="Jouer">
        <input type="submit" value="continuer" />
    </body>
</html>
