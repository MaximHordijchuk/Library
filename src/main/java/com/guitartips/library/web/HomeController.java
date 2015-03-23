package com.guitartips.library.web;

import com.guitartips.library.domain.Book;
import com.guitartips.library.service.BookService;
import com.guitartips.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by max on 10.02.15.
 * Have fun!
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Book> books = userService.getUserBooks(auth.getName());
        model.put("books", books);
        model.put("isSelectedBook", false);
        return "home";
    }

}
