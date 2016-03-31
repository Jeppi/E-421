<%-- 
    Document   : jeu
    Created on : 19 mars 2016, 18:13:11
    Author     : JP
--%>

<%@page import="entites.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% int oDe1=(Integer)(session.getAttribute("oDe1"));%> 
    <% int oDe2=(Integer)(session.getAttribute("oDe2"));%> 
    <% int oDe3=(Integer)(session.getAttribute("oDe3"));%>
    
    <% String jDe1=(String)(session.getAttribute("jDe1"));%> 
    <% String jDe2=(String)(session.getAttribute("jDe2"));%> 
    <% String jDe3=(String)(session.getAttribute("jDe3"));%> 
    
    <% int count = (Integer)(session.getAttribute("count"));%>
    <% String resultat = (String)(request.getAttribute("resultat"));
    Joueur joueur =(Joueur) session.getAttribute("joueur");%>
    <body>
        <%@ include file="/entete.jsp" %>
        <table border="1" cellspacing="1">
            L'ordinateur a joué : <br><br>
            <thead>
                <tr>
                    <th><%=oDe1%></th>
                    <th><%=oDe2%></th>
                    <th><%=oDe3%></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Dé1</td>
                    <td>Dé2</td>
                    <td>Dé3</td>
                </tr>
            </tbody>
        </table><br>
        
        <table border="1" cellspacing="1">
            A vous de jouer :<br><br>
            <thead>
                <tr>
                    <th><%=jDe1%></th>
                    <th><%=jDe2%></th>
                    <th><%=jDe3%></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Dé1</td>
                    <td>Dé2</td>
                    <td>Dé3</td>
                </tr>
            </tbody>
        </table>
        <br><br>
        <% if(resultat!=null) out.println(resultat+", voici une nouvelle partie");%>
        <br><br>
        <form method="POST" action="Jouer">
        <input type="submit" value="lancer les dés" />
        <%=count%>/3 tentatives
        </form>
        <br><br>
        <form method="POST" action="Deconnexion">
        <input type="submit" value="déconnexion" />
        </form>
        
        <form action="Resultat" method="POST">
            <input type="hidden" name="joueur" value="<%=joueur%>">
            <input type="submit" value="résultats" />    
        </form>

    </body>

