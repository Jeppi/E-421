/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.DAOResultat;
import entites.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JP
 */
public class Jouer extends HttpServlet {
    private int oDe1;
    private int oDe2;
    private int oDe3;
    
    private int count = 0;
    private int vic = -2;
    
    private Joueur joueur;
    
    public int lanceDe(){
        int x=(int)(Math.random()*6 + 1);
        return x;
    }
    
    public int victoire(int ordi, int joueur1){
        if (joueur1>ordi)return 1;
        if (joueur1==ordi)return 0;
        return -1;
    }
    
    public String resultat(int vic){
        switch(vic)
        {
            case -1: return "Vous avez perdu";
            case 0: return "Vous êtes à égalité";
            case 1: return "Vous avez gagné";
        }
        return null;
    }
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Jouer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Jouer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //je dois vérifier qu'il n'y a pas une session en cours, une partie non terminée
        HttpSession laSession = request.getSession(true);
        
        if(laSession.getAttribute("oDe1")!=null && vic!=1 && count!=3){
           RequestDispatcher dispatch = request.getRequestDispatcher("jeu.jsp"); 
           dispatch.forward(request, response); 
        }
        
        //si on fini une partie ou il n'y a pas de session en cours on relance les les dés de l'ordinateur
        
        oDe1 = lanceDe();
        oDe2 = lanceDe();
        oDe3 = lanceDe(); 
               
        laSession.setAttribute("oDe1", oDe1);
        laSession.setAttribute("oDe2", oDe2);
        laSession.setAttribute("oDe3", oDe3);
        
        laSession.setAttribute("jDe1", "-");
        laSession.setAttribute("jDe2", "-");
        laSession.setAttribute("jDe3", "-");
        
        laSession.setAttribute("count", count);
        
        joueur = (Joueur) laSession.getAttribute("joueur");
       
        request.setAttribute("resultat", resultat(vic));
         
        
        DAOResultat daoResultat = new DAOResultat();
        
        if (daoResultat.select(joueur) == null)
            daoResultat.create(joueur);
                
        if(vic == 1)
            daoResultat.ajouteVictoire(joueur);
        if(vic == -1)
            daoResultat.ajouteDefaite(joueur);
        
                              
        //après avoir envoyé le resultat de la partie précédente on réinitialise
        count = 0;
        vic = -2;
        
        RequestDispatcher dispatch = request.getRequestDispatcher("jeu.jsp"); 
        dispatch.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (vic == 1 || count == 3) doGet(request, response);
        else{
        int j1 = lanceDe();
        int j2 = lanceDe();
        int j3 = lanceDe();
        
        count++;
        //pour préserver l'égalité on met une condition
        if(vic != 0 || victoire(oDe1+oDe2+oDe3, j1+j2+j3) == 1)
        vic = victoire(oDe1+oDe2+oDe3, j1+j2+j3);
        
        String jDe1 = Integer.toString(j1);
        String jDe2 = Integer.toString(j2);
        String jDe3 = Integer.toString(j3);
        
        HttpSession laSession = request.getSession(true);
        
        oDe1 = (Integer) laSession.getAttribute("oDe1");
        oDe2 = (Integer) laSession.getAttribute("oDe2");
        oDe3 = (Integer) laSession.getAttribute("oDe3");
        
        laSession.setAttribute("jDe1", jDe1);
        laSession.setAttribute("jDe2", jDe2);
        laSession.setAttribute("jDe3", jDe3);
        
        laSession.setAttribute("count", count);
                
        RequestDispatcher dispatch = request.getRequestDispatcher("jeu.jsp"); 
        dispatch.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
