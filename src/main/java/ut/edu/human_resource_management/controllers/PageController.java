package ut.edu.human_resource_management.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

     @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/introduce")
    public String introduce() {
        return "introduce"; 
    }

    @GetMapping("/recruitment")
    public String recruitment() {
        return "recruitment"; 
    }
}
