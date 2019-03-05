package application.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewsController {

   @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", "gros message");
       return "home";
   }
    @RequestMapping("/greeting")
    public String articleFragment(Model model) {
        model.addAttribute("message", "wesh loulou");
        System.out.println("qsdqsfsdfsdf");
        return "articlesList :: articlesList";
    }
}
