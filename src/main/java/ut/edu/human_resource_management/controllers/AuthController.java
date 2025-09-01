package ut.edu.human_resource_management.controllers;

import ut.edu.human_resource_management.models.NhanVien;
import ut.edu.human_resource_management.repositories.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "LoginPage"; // file LoginPage.html
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam(name = "mat_khau") String mat_khau,
                               HttpSession session,
                               Model model) {
        // --- admin cứng ---
        final String ADMIN_EMAIL = "admin@example.com";
        final String ADMIN_PASS  = "Admin@123";

        if (ADMIN_EMAIL.equals(email) && ADMIN_PASS.equals(mat_khau)) {
            session.setAttribute("admin", true);
            // bạn đặt url admin nào hợp lý thì redirect về đó
            return "redirect:/admin/admin_home";
        }

        // --- nhân viên từ DB ---
        NhanVien nv = nhanVienRepository.findByEmail(email);
        if (nv == null) {
            model.addAttribute("error", "Email không tồn tại.");
            return "LoginPage";
        }

        // Nếu mật khẩu của bạn đang dùng BCrypt thì đổi check sang passwordEncoder.matches(...)
        if (!mat_khau.equals(nv.getMatKhau())) {
            model.addAttribute("error", "Mật khẩu không đúng.");
            return "LoginPage";
        }

        // Lưu session cho nhân viên
        session.setAttribute("userId", nv.getId());
        // tuỳ bạn muốn lưu full object:
        session.setAttribute("nhanVien", nv);

        return "redirect:/employees";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // Hiển thị trang employees (chỉ cho user đã login)
    @GetMapping("/employees")
    public String showEmployees(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv != null) {
            model.addAttribute("nhanVien", nv);
            return "employees";
        } else {
            return "redirect:/login";
        }
    }

    // Các trang khác của user (copy pattern trên, dùng tên biến nv để tránh trùng)
    @GetMapping("/document")
    public String showDocument(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/login";

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv != null) {
            model.addAttribute("nhanVien", nv);
            return "document";
        } else return "redirect:/login";
    }

    @GetMapping("/productivity")
    public String showProductivity(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/login";

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv != null) {
            model.addAttribute("nhanVien", nv);
            return "productivity";
        } else return "redirect:/login";
    }

    @GetMapping("/training")
    public String showTraining(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/login";

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv != null) {
            model.addAttribute("nhanVien", nv);
            return "training";
        } else return "redirect:/login";
    }

    @GetMapping("/upload")
    public String showUpload(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/login";

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv != null) {
            model.addAttribute("nhanVien", nv);
            return "upload";
        } else return "redirect:/login";
    }

    @GetMapping("/home")
    public String showHome(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/login";

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv != null) {
            model.addAttribute("nhanVien", nv);
            return "home";
        } else return "redirect:/login";
    }

    @GetMapping("/newspaper")
    public String showNewspaper(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/login";

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv != null) {
            model.addAttribute("nhanVien", nv);
            return "newspaper";
        } else return "redirect:/login";
    }
}
