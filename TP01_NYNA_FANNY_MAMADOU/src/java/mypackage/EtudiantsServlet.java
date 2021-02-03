/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NYNA FANNY
 */
public class EtudiantsServlet extends HttpServlet {

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
            out.println("<title>Servlet EtudiantsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
              out.println("<h1><center>Liste des étudiants</center></h1>");
              out.println("<table border='2px'>");
              out.println("<tr>");
              out.println("<th>Nom</th>");
              out.println("<th>Prenom</th>");
              out.println("<th>Email</th>");
              out.println("</tr>");
               try{
        BufferedReader br = new BufferedReader(new FileReader("etudiants.csv"));
                String line;
        while((line = br.readLine()) != null){
            String[] donne = line.split(",");
            out.println("<tr>");
            out.println("<td>"+donne[0]+"</td>");
            out.println("<td>"+donne[1]+"</td>");
            out.println("<td>"+donne[2]+"</td>");
            out.println("</tr>");
        }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
            out.println("<table>");
            
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
        processRequest(request, response);
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
        processRequest(request, response);
        String file_header = "nom,prenom,email";
        String nom= request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
      traitement (nom,prenom,email, mycsv);
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
    String mycsv = "fichier.csv";
    public static void traitement(String nom, String prenom, String email,String mycsv)
        {
            try
           {
             FileWriter file= new FileWriter (mycsv, true);
             BufferedWriter buff = new  BufferedWriter(file);
             PrintWriter ecrire = new PrintWriter (buff);

             ecrire.println(nom + ','+ prenom + ','+email);
             ecrire.flush();
             ecrire.close();
           }catch(IOException E)
          {
             
          }
        }

}
