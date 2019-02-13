package application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewsController {

   @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public String index(){
        System.out.println("home");
       return "home";
   }
    @RequestMapping("/greeting")
    public void greeting(@RequestParam (value="name", defaultValue="World") String name) {
        System.out.println("greeting");
    }
}
