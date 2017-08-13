/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.servlet;

import com.me.Dao.BooksDao;
import com.me.pojo.Books;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author aksha
 */
public class BooksController implements Controller {

    BooksDao booksDao;

    public BooksController(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        int count = 0;
        String action = hsr.getParameter("page");
        ModelAndView mv = new ModelAndView();
        if (action.equals("page1")) {
            String n = hsr.getParameter("noofbooks");

            hsr.setAttribute("n", n);
            mv.setViewName("addBooks");
        } else if (action.equals("page2")) {
            int numberOfBooks = Integer.parseInt(hsr.getParameter("bookerror"));
            
            String[] isbnArray = hsr.getParameterValues("isbn");
            String[] bookTitleArray = hsr.getParameterValues("booktitle");
            String[] authorsArray = hsr.getParameterValues("authors");
            String[] priceArray = hsr.getParameterValues("price");
            float[] price = new float[priceArray.length];
            for (int i = 0; i < price.length; i++) {
                price[i] = Float.parseFloat(priceArray[i]);
            }
            for(int i =0;i<numberOfBooks;i++)
            {
                String isbn = isbnArray[i];
                String bookTitle = bookTitleArray[i];
                String authors = authorsArray[i];
                float priceBook = price[i];
                Books b = new Books();
                b.setISBN(isbn);
                b.setBookTitle(bookTitle);
                b.setAuthors(authors);
                b.setPrice(priceBook);
                booksDao.addBooks(b);
                count++;
            }
            hsr.setAttribute("count", count);
            mv.setViewName("success");
        }
        return mv;
    }

}
