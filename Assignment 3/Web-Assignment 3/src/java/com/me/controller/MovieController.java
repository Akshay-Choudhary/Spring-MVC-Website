/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.myapp.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aksha
 */
public class MovieController extends HttpServlet {
    static class FilteredRequest extends HttpServletRequestWrapper {

static String allowedChars = "+-0123456789#*";
public FilteredRequest(ServletRequest request) {
    		super((HttpServletRequest)request);
    	}

public String sanitize(String input) {
    		String result = "";
    		for (int i = 0; i < input.length(); i++) {
    			if (allowedChars.indexOf(input.charAt(i)) >= 0) {
    				result += input.charAt(i);
    			}
    		}
    		return result;
    	}
@Override
public String getParameter(String paramName) {
    		String value = super.getParameter(paramName);
    		if ("year".equals(paramName)) {
    			value = sanitize(value);
    		}
    		return value;
    	}
 public void doFilter(ServletRequest request, ServletResponse response,
    		FilterChain chain) throws IOException, ServletException {
    	chain.doFilter(new FilteredRequest(request), response); 
    }}
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

            String pageno = request.getParameter("movielist");
            String pagenumber = request.getParameter("page");

            if (pagenumber.equals("page1")) {
                
                    if (pageno.equals("browse")) {
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/BrowseMovies.jsp");
                        rd.forward(request, response);
                    } else if (pageno.equals("add")) {
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/AddMovies.jsp");
                        rd.forward(request, response);
                    }
                
            } else if (pagenumber.equals("page2")) {
                
                String dburl = getServletContext().getInitParameter("dburl");
                String dbuser = getServletContext().getInitParameter("dbuser");
                String dbpassword = getServletContext().getInitParameter("dbpassword");
                String dbdriver = getServletContext().getInitParameter("dbdriver");
                
                Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);
                
                String title = request.getParameter("movietitle");
                String actor = request.getParameter("leadactor");
                String actress = request.getParameter("leadactress");
                String genre = request.getParameter("genre");
                int year = Integer.parseInt(request.getParameter("year"));
                
                

                String queryMessage = "INSERT INTO movies (title, actor, actress, genre, year)\n" +
"                        values ('"+title+"','"+actor+"','"+actress+"','"+genre+"',"+year+")";

                Statement statement = conn.createStatement();
                int result = statement.executeUpdate(queryMessage);
                conn.close();
                if (result > 0) {
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
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold

}
