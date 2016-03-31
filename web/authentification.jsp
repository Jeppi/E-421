<%-- 
    Document   : authentification
    Created on : 11 févr. 2016, 02:33:15
    Author     : JP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-421</title>
    </head>
    <body>
        <%@ include file="/entete.jsp" %>
        <% String nom=request.getParameter("nom"); 
        if (nom==null || nom.equals("")) nom="Votre nom";%>
        
        <form method="POST" action="Authentification">
            <input type="text" name="nom" value="<%=nom%>" >
            <input type="submit" value="valider" />
        </form>
        
    </body>
</html>
