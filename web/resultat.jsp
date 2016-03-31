<%-- 
    Document   : resultat
    Created on : 20 mars 2016, 18:20:38
    Author     : JP
--%>

<%@page import="entites.Joueur"%>
<%@page import="entites.Resultat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pourcentage de victoires</title>
    </head>
    <% Resultat res = (Resultat) request.getAttribute("resultat");
    Joueur joueur = res.getJoueur();%>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>nom</th>
                    <th>prenom</th>
                    <th>parties gagnées par le Joueur</th>
                    <th>parties gagnées par l'ordinateur</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=joueur.getNom()%></td>
                    <td><%=joueur.getPrenom()%></td>
                    <td><%=res.getNbV()%></td>
                    <td><%=res.getNbD()%></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
