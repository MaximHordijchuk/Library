package com.guitartips.library.web;

import com.guitartips.library.domain.Commit;
import com.guitartips.library.service.BookService;
import com.guitartips.library.service.CommitService;
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
    @Autowired
    private CommitService commitService;

    //TODO: if empty collection : redirect to book add page
    @RequestMapping("/")
    public String home(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Commit> commits = userService.getUserCommits(auth.getName());
        model.put("commits", commits);
        return "home";
    }

}
