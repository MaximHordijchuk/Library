package com.guitartips.library.web;

import com.guitartips.library.domain.Book;
import com.guitartips.library.service.BookService;
import com.guitartips.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by max on 10.02.15.
 * Have fun!
 */
@Controller
@RequestMapping("/")
public class HomeController {
    public static final int MAX_DESCRIPTION_LENGTH = 100;

    private BookService bookService;
    private UserService userService;

    @Autowired
    public HomeController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Book> books = userService.getUserBooks(auth.getName());
        model.put("books", books);
        model.put("descriptionLength", MAX_DESCRIPTION_LENGTH);
        model.put("isSelectedBook", false);
        return "home";
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public String  userInfo(@PathVariable int bookId, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Book> books = userService.getUserBooks(auth.getName());
        model.put("books", books);
        model.put("descriptionLength", MAX_DESCRIPTION_LENGTH);
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

}
