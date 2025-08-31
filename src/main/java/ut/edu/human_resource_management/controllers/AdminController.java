package ut.edu.human_resource_management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // trả về admin.html trong templates
    }

    @GetMapping("/admin_employees")
    public String adminemployees() {
        return "admin_employees"; // file admin_users.html
    }

    @GetMapping("/admin_introduce")
    public String adminintroduce() {
        return "admin_introduce"; // file admin_applications.html
    }

    @GetMapping("/admin_recruitment")
    public String adminrecruitment() {
        return "admin_recruitment"; // file admin_applications.html
    }

    @GetMapping("/admin_information")
    public String admininformation() {
        return "admin_information"; // file admin_applications.html
    }

    @GetMapping("/admin_attendance")
    public String adminattendance() {
        return "admin_attendance"; // file admin_applications.html
    }

    @GetMapping("/admin_training")
    public String admintraining() {
        return "admin_training"; // file admin_applications.html
    }

    @GetMapping("/admin_productivity")
    public String adminproductivity() {
        return "admin_productivity"; // file admin_applications.html
    }

    @GetMapping("/admin_newspaper")
    public String adminnewspaper() {
        return "admin_newspaper"; // file admin_applications.html
    }

    @GetMapping("/admin_uploadnewspaper")
    public String adminuploadnewspaper() {
        return "admin_uploadnewspaper"; // file admin_applications.html
    }
}
