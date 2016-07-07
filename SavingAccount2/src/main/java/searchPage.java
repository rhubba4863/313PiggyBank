/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Braden
 */
@WebServlet(urlPatterns = {"/searchPage"})
public class searchPage extends HttpServlet {

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
        KeyHolder apiKey = new KeyHolder();
        Integer strt = (Integer) request.getAttribute("start");
        String search = (String) request.getAttribute("search");
        
        System.out.println("Submit value = " + request.getParameter("page"));
        
        if ("Next".equals(request.getParameter("page"))) {
            strt = strt + 10;
        }
        else {
            strt = strt - 10;
        }
        
        String encoded = URLEncoder.encode(search, "UTF-8");
        
        URL url = new URL("http://api.walmartlabs.com/v1/search?apiKey=" + apiKey.getKey() + "&query=" + encoded + "&start=" + strt);

        ObjectMapper mapper = new ObjectMapper(); 
        Map<String, Object> map = mapper.readValue(url, Map.class);

        for (String key : map.keySet()) {          
              System.out.println(key + ": " + map.get(key)); 
        }
        
        List list = (List)map.get("items");
        //List titles;

        //System.out.println("helppppppppp");
        for (Object item : list) { 
              Map<String, Object> innerMap = (Map<String, Object>)item; 
              for (String key : innerMap.keySet()) { 
                    System.out.println(key + ": " + innerMap.get(key));
                    //if (key == "Title")
                      //  titles.add(innerMap.get(key));
              } 
        }
        
        request.setAttribute("results", list);
        request.setAttribute("start", strt);
        request.setAttribute("search", search);
        
        request.getRequestDispatcher("/SearchResults.jsp").forward(request, response);
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
