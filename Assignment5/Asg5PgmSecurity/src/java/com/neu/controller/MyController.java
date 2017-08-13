/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.bean.Books;
import com.neu.dao.BooksDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author gupta.abhi
 */
public class MyController implements Controller {

    private BooksDao bookdao;

    public BooksDao getBookdao() {
        return bookdao;
    }

    public void setBookdao(BooksDao bookdao) {
        this.bookdao = bookdao;
    }

    private void askForPassword(HttpServletResponse response) {
        response.setStatus(response.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate", "BASIC realm=\"Insider-Trading\"");
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        String authorization = hsr.getHeader("Authorization");
        ModelAndView mv = new ModelAndView();
        if (authorization == null) {
            askForPassword(hsr1);
        } else {

            String action = hsr.getParameter("action");
            if (action.equalsIgnoreCase("add")) {

                String isbn, title, author;
                int rowInserted;
                float price;
                int rows = Integer.parseInt(hsr.getParameter("num"));

                for (int i = 0; i < rows; i++) {
                    isbn = hsr.getParameter("column" + i + "0");
                    title = hsr.getParameter("column" + i + "1");
                    author = hsr.getParameter("column" + i + "2");
                    price = Float.parseFloat(hsr.getParameter("column" + i + "3"));
                    Books book = getBookdao().setBooks(isbn, title, author, price);

                    getBookdao().saveBook(book);

                }

                HttpSession session = hsr.getSession();
                session.setAttribute("insertedBooks", 1);

            }

            mv.setViewName("index");
        }
        return mv;

    }

}
