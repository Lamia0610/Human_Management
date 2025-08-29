package ut.edu.human_resource_management.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

     @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/employees")
    public String employees() {
        return "employees";
    }

    @GetMapping("/login")
    public String login() {
        return "LoginPage"; 
    }

    @GetMapping("/recruitment")
    public String recruitment() {
        return "recruitment"; 
    }

    @GetMapping("/introduce")
    public String introduce() {
        return "introduce"; 
    }

    @GetMapping("/information")
    public String information() {
        return "information"; 
    }

    @GetMapping("/attendance")
    public String attendance() {
        return "attendance"; 
    }

    @GetMapping("/productivity")
    public String productivity() {
        return "productivity"; 
    }

    @GetMapping("/training")
    public String training() {
        return "training"; 
    }

    @GetMapping("/document")
    public String document() {
        return "document"; 
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload"; 
    }
}
