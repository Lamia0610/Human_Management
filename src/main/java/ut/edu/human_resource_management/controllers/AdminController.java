package ut.edu.human_resource_management.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // Kiểm tra admin trong session trước khi trả view
    private boolean isAdmin(HttpSession session) {
        return Boolean.TRUE.equals(session.getAttribute("admin"));
    }

    @GetMapping("admin_dashboard")
    public String adminDashboard(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin"; // admin.html
    }

    @GetMapping("admin_home")
    public String adminHome(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_home";
    }

    @GetMapping("admin_employees")
    public String adminEmployees(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_employees";
    }

    @GetMapping("admin_introduce")
    public String adminIntroduce(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_introduce";
    }

    @GetMapping("admin_recruitment")
    public String adminRecruitment(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_recruitment";
    }

    @GetMapping("admin_information")
    public String adminInformation(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_information";
    }

    @GetMapping("admin_attendance")
    public String adminAttendance(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_attendance";
    }

    @GetMapping("admin_training")
    public String adminTraining(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_training";
    }

    @GetMapping("admin_productivity")
    public String adminProductivity(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_productivity";
    }

    @GetMapping("admin_newspaper")
    public String adminNewspaper(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_newspaper";
    }

    @GetMapping("/admin_uploadnewspaper")
    public String adminUploadNewspaper(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        return "admin_uploadnewspaper";
    }
}
