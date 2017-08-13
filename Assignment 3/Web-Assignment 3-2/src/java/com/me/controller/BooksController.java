/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aksha
 */
public class BooksController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            
            int count =0;

            String pagenumber = request.getParameter("page");

            
            if (pagenumber.equals("page1")) {
                String n= request.getParameter("noofbooks");
                request.setAttribute("n", n);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/AddBooks.jsp");
                rd.forward(request, response);

            } else if (pagenumber.equals("page2")) {
                String nu = request.getParameter("bookerror");
                int numberofBooks = Integer.parseInt(nu.trim());
                String dburl = getServletContext().getInitParameter("dburl");
                String dbuser = getServletContext().getInitParameter("dbuser");
                String dbpassword = getServletContext().getInitParameter("dbpassword");
                String dbdriver = getServletContext().getInitParameter("dbdriver");
                Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);
                String[] isbn = request.getParameterValues("isbn");
                String[] bookTitle = request.getParameterValues("booktitle");
                String[] authors = request.getParameterValues("authors");
                String[] price = request.getParameterValues("price");
                float[] priceArray = new float[price.length];
                for (int i = 0; i < price.length; i++) {
                    priceArray[i] = Float.parseFloat(price[i]);
                }

                for (int i = 0; i < numberofBooks; i++) {
                    String queryMessage = "INSERT INTO books (isbn,title,authors,price)\n"
                            + "                        values ('" + isbn[i] + "','" + bookTitle[i] + "','" + authors[i] + "'," + priceArray[i] + ")";
                    Statement statement = conn.createStatement();
                int result = statement.executeUpdate(queryMessage);
                count++;
                
                }
               conn.close();
               request.setAttribute("nu", nu);
                
                if (count > 0){
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Success.jsp");
                    rd.forward(request, response);
                }
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
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
