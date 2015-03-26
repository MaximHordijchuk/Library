package com.guitartips.library.web;

import com.guitartips.library.domain.Book;
import com.guitartips.library.domain.Commit;
import com.guitartips.library.service.BookService;
import com.guitartips.library.service.CommitService;
import com.guitartips.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @Autowired
    private CommitService commitService;

    @RequestMapping(value = "{bookId}", method = RequestMethod.GET)
    public String  getBookInfoById(@PathVariable int bookId, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Commit commit = commitService.getCommitById(auth.getName(), bookId);
        model.put("commit", commit);
        return "book";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String commitBook(ModelMap model, @ModelAttribute Commit commit, @ModelAttribute Book book) {
        if (commit == null) {
            System.out.println("ERROR");
            // check
            // return errors
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userService.commitBook(auth.getName(), book, commit);
        return "redirect:/";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String  commitBookForm() {
        return "commitBook";
    }
}
