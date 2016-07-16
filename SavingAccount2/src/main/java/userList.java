/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/userList"})
public class userList extends HttpServlet {

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
        Integer userId = (Integer)request.getAttribute("userId");
        KeyHolder apiKey = new KeyHolder();
        DBUserList userList = new DBUserList();
        ObjectMapper mapper = new ObjectMapper();
        String itemIds = userList.getUserList(userId);
        float budget = userList.checkFunds(userId);
        System.out.println(budget);
        float[] difference = new float[20];
        String userName = userList.getUserName(userId);
        System.out.println(userName);
        request.setAttribute("userName", userName);
        request.setAttribute("budget", budget);
        request.setAttribute("items", "");
        
        if (itemIds != ""){
            URL url = new URL("http://api.walmartlabs.com/v1/items?ids=" + itemIds + "&apiKey=" + apiKey.getKey() + "&format=json");
        
            Map<String, Object> map = mapper.readValue(url, Map.class);

            for (String key : map.keySet()) {          
                  System.out.println(key + ": " + map.get(key)); 
            }

            List<Map> itemList = (List)map.get("items");
            
            Integer index = 0;
            for (Object item : itemList) { 
                  Map<String, Object> innerMap = (Map<String, Object>)item; 
                  for (String key : innerMap.keySet()) { 
                        System.out.println(key + ": " + innerMap.get(key));
                        if (key == "salePrice") {
                            //difference[index] = budget - innerMap.get(key);
                            //index += 1;
                        }
                  }
            }
            
            //request.setAttribute("difference", difference);
            request.setAttribute("items", itemList);
        }
        
        
        request.getRequestDispatcher("/MainUserPage.jsp").forward(request, response);
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
