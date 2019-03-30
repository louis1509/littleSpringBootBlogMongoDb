package application.controllers;

import application.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewsController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", "gros message");
        System.out.println("putain de sa grand mere la pute !!");
       return "home";
    }
    @RequestMapping("/greeting")
    public String articleFragment(Model model) {

        model.addAttribute("articles",  articleService.getAllArticles());
        System.out.println("qsdqsfsdfsdf");
        return "articlesList :: articlesList";
    }
}
