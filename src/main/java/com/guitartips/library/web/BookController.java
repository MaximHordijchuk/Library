package com.guitartips.library.web;

import com.guitartips.library.domain.Book;
import com.guitartips.library.service.BookService;
import com.guitartips.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by max on 18.03.15.
 * Have fun!
 */
@Controller
@RequestMapping("/book/")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{bookId}", method = RequestMethod.GET)
    public String  getBookInfoById(@PathVariable int bookId, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Book> books = userService.getUserBooks(auth.getName());
        model.put("books", books);
        boolean isSelectedBook = false;
        for (Book book : books) {
            if (book.getId() == bookId) {
                model.put("selectedBook", book);
                isSelectedBook = true;
                break;
            }
        }
        model.put("isSelectedBook", isSelectedBook);
        return "book";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String  addNewBook(ModelMap model, @ModelAttribute Book book) {
        if (book != null) {
            // return errors
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int bookId = bookService.addBook(book);
        userService.addBook(auth.getName(), bookId);
        return "redirect:/";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String  addBookViewForm() {
        return "addBook";
    }
}
