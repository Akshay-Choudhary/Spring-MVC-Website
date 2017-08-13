/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.bean.MoviesBean;
import com.myapp.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class SearchController extends HttpServlet {

    private List<MoviesBean> movieBeanList;

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

            HttpSession session = request.getSession();

            /*if (null != session.getAttribute("keyword")) {

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Results.jsp");
                rd.forward(request, response);
                return;
            }*/
            
            String keyword = request.getParameter("keyword");
            String option = request.getParameter("keywordSearch");

            String dburl = getServletContext().getInitParameter("dburl");
            String dbuser = getServletContext().getInitParameter("dbuser");
            String dbpassword = getServletContext().getInitParameter("dbpassword");
            String dbdriver = getServletContext().getInitParameter("dbdriver");

            Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);
            if (option.equals("searchtitle")) {
                String queryLogin = "select * from movies where title=? ";
                PreparedStatement loginstmt = conn.prepareStatement(queryLogin);
                loginstmt.setString(1, keyword);

                ResultSet resultSet = loginstmt.executeQuery();
                if(resultSet.next()){
                movieBeanList = new ArrayList<>();
                while (resultSet.next()) {
                    MoviesBean moviebean = new MoviesBean();
                    moviebean.setMovieTitle(resultSet.getString("title"));
                    moviebean.setLeadActor(resultSet.getString("actor"));
                    moviebean.setLeadActress(resultSet.getString("actress"));
                    moviebean.setGenre(resultSet.getString("genre"));
                    moviebean.setYear(resultSet.getInt("year"));
                    movieBeanList.add(moviebean);
                }

                resultSet.close();
                loginstmt.close();
                conn.close();

                session.setAttribute("keyword", keyword);
                session.setAttribute("movielist", movieBeanList);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Results.jsp");
                rd.forward(request, response);
                return;
            }else{
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/BrowseMovies.jsp?error=true");
                    rd.forward(request, response);
                }
                    }
            if (option.equals("searchActor")) {
                String queryLogin = "select * from movies where actor=? ";
               
                
                PreparedStatement loginstmt = conn.prepareStatement(queryLogin);
                loginstmt.setString(1, keyword);

                ResultSet resultSet = loginstmt.executeQuery();
                 if(resultSet.next())
                {
                List<MoviesBean> movieBeanList = new ArrayList<>();
                while (resultSet.next()) {
                    MoviesBean moviebean = new MoviesBean();
                    moviebean.setMovieTitle(resultSet.getString("title"));
                    moviebean.setLeadActor(resultSet.getString("actor"));
                    moviebean.setLeadActress(resultSet.getString("actress"));
                    moviebean.setGenre(resultSet.getString("genre"));
                    moviebean.setYear(resultSet.getInt(5));
                    movieBeanList.add(moviebean);
                }

                resultSet.close();
                loginstmt.close();
                conn.close();

                session.setAttribute("keyword", keyword);
                session.setAttribute("movielist", movieBeanList);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Results.jsp");
                rd.forward(request, response);
            }else{
                     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/BrowseMovies.jsp?error=true");
                    rd.forward(request, response);
                }
            }
            if (option.equals("searchActress")) {
                String queryLogin = "select * from movies where actress=? ";
                PreparedStatement loginstmt = conn.prepareStatement(queryLogin);
                loginstmt.setString(1, keyword);

                ResultSet resultSet = loginstmt.executeQuery();
                if(resultSet.next()){
                List<MoviesBean> movieBeanList = new ArrayList<>();
                while (resultSet.next()) {
                    MoviesBean moviebean = new MoviesBean();
                    moviebean.setMovieTitle(resultSet.getString("title"));
                    moviebean.setLeadActor(resultSet.getString("actor"));
                    moviebean.setLeadActress(resultSet.getString("actress"));
                    moviebean.setGenre(resultSet.getString("genre"));
                    moviebean.setYear(resultSet.getInt("year"));
                    movieBeanList.add(moviebean);
                }

                resultSet.close();
                loginstmt.close();
                conn.close();

                session.setAttribute("keyword", keyword);
                session.setAttribute("movielist", movieBeanList);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Results.jsp");
                rd.forward(request, response);
                return;
            }
                else{
                     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/BrowseMovies.jsp?error=true");
                    rd.forward(request, response);
                }
        }}
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
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
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
