/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 *
 * @author robert
 */
@WebServlet(urlPatterns = {"/WebRead"})
public class WebRead extends HttpServlet {

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
              
        
        
        /*//http://stackoverflow.com/questions/6159118/using-java-to-pull-data-from-a-webpage
        // Make a URL to the web page
        URL url = new URL("http://api.walmartlabs.com/v1/search?query=ipod&format=json&apiKey=5wjugsmujh4pn62fv7727e5h");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.
        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.
        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            System.out.println(line + "help");
        }*/
        
        
        
        
        /*URL oracle = new URL("http://www.oracle.com/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();*/
        
        
        //http://stackoverflow.com/questions/12634213/how-to-access-a-url-and-get-its-response-from-java-servlet
        /*URL urldemo = new URL("http://www.demo.com/");
        URLConnection yc = urldemo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();*/
        
        System.out.println("hilll");
        
        URL url = new URL("http://www.omdbapi.com/?t=True%20Grit&y=1969");

        ObjectMapper mapper = new ObjectMapper(); 
        Map<String, Object> map = mapper.readValue(url, Map.class);

        /*for (String key : map.keySet()) {          
              System.out.println(key + ": " + map.get(key)); 
        }*/
        
        String title = request.getParameter("Username");
        
        url = new URL("http://www.omdbapi.com/?s=" + title);

        mapper = new ObjectMapper();

        map = mapper.readValue(url, Map.class);

        List list = (List)map.get("Search");
        //List titles;

        System.out.println("helppppppppp");
        for (Object item : list) { 
              Map<String, Object> innerMap = (Map<String, Object>)item; 
              for (String key : innerMap.keySet()) { 
                    System.out.println(key + ": " + innerMap.get(key));
                    //if (key == "Title")
                      //  titles.add(innerMap.get(key));
              } 
        }
        
        request.setAttribute("results", list);
        
        request.getRequestDispatcher("/DisplayResults2.jsp").forward(request, response);/**/
  
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
