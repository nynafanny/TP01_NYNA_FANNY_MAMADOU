/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;


import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;import java.io.BufferedReader;
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
            out.println("<body >");
             out.println("<h1>LISTE DES ETUDIANTS</h1>");
            try{
                
                InputStream flux=new FileInputStream("fichier1.csv"); 
                InputStreamReader lecture=new InputStreamReader(flux);
                BufferedReader buff=new BufferedReader(lecture);
                String ligne;
                string nom ;
                final String sep = ",";
 
                out.println("<table border=1;style=\"color:red\">");
                out.println("<TBODY >"); 
                out.println("<tr>"); 
                out.println("<td>NOM</td>");
                out.println("<td>PRENOM</td>");
                out.println("<td>EMAIL</td>");
                out.println("</tr>");
                while ((ligne=buff.readLine())!=null)
                    {
                        //out.println(ligne);
                    out.println("<br>");
                    String mots[] = ligne.split(sep);
                    out.println("<tr>");
                    for (int i = 0; i < mots.length; i++) {
                        out.println("<td>");
                        out.println("\t"+mots[i]+"\t");
                        out.println("</td>");
                    }
                }
                    out.println("</tr>");
                    out.println("</TBODY>"); 
                    out.println("</table>");
                    buff.close(); 
            }	
            catch (Exception e)
            {
                System.out.println(e.toString());
            }
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
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        //out.println(request.getParameter("nom"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        
         enregistre(nom , prenom ,email,fichier);
         doGet(request,response);
         
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

        String fichier = "fichier1.csv";       
        public static void enregistre(String nom, String prenom, String email,String fichier)
        {
            try
           {
            FileWriter filread = new FileWriter (fichier , true);
            BufferedWriter bw = new  BufferedWriter(filread);
            PrintWriter write = new PrintWriter (bw);
            write.println(nom + ','+ prenom + ','+email );
            write.flush();
            write.close();

           }
          catch(Exception E)
          {
           }
        }

}