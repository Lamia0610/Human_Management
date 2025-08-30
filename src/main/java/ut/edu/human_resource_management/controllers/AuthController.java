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
        return "LoginPage"; // Trả về trang HTML
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, 
                               @RequestParam String mat_khau, 
                               HttpSession session, 
                               Model model) {
        NhanVien nhanVien = nhanVienRepository.findByEmail(email);
        
        if (nhanVien == null) {
            model.addAttribute("error", "Email không tồn tại.");
            return "LoginPage"; 
        }

        if (!mat_khau.equals(nhanVien.getMatKhau())) {
            model.addAttribute("error", "Mật khẩu không đúng.");
            return "LoginPage"; 
        }

        // ✅ Lưu userId vào session
        session.setAttribute("userId", nhanVien.getId());
        System.out.println("Đăng nhập thành công, lưu session với userId = " + nhanVien.getId());

        return "redirect:/employees";
    }

    @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.invalidate(); 
            return "redirect:/index";
        }
            
     @GetMapping("/employees")    
    public String showEmployees(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId = " + userId);

        if (userId == null) {
            return "redirect:/login"; 
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
            return "employees";
        } else {
            return "redirect:/login";
        }
    }


    // @GetMapping("/attendance")
    // public String showAttendance(HttpSession session, Model model) {
    //     Long userId = (Long) session.getAttribute("userId");
    //     System.out.println("Session userId = " + userId);

    //     if (userId == null) {
    //         return "redirect:/login"; 
    //     }

    //     NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
    //     if (nhanVien != null) {
    //         model.addAttribute("nhanVien", nhanVien);
    //         return "attendance";
    //     } else {
    //         return "redirect:/login";
    //     }
    // }

    @GetMapping("/document")
    public String showDocument(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId = " + userId);

        if (userId == null) {
            return "redirect:/login"; 
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
            return "document"; 
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/productivity")
    public String showProductivity(HttpSession session, Model model) {  
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId = " + userId);

        if (userId == null) {
            return "redirect:/login"; 
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
            return "productivity"; 
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/training")
    public String showTraining(HttpSession session, Model model) {          
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId = " + userId);

        if (userId == null) {
            return "redirect:/login"; 
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
            return "training"; 
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/information")
    public String showInformation(HttpSession session, Model model) {          
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId = " + userId);

        if (userId == null) {
            return "redirect:/login"; 
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
            return "information"; 
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/upload")
    public String showUpload(HttpSession session, Model model) {          
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId = " + userId);

        if (userId == null) {
            return "redirect:/login"; 
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
            return "upload"; 
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/home")
    public String showHome(HttpSession session, Model model) {        
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId = " + userId);

        if (userId == null) {
            return "redirect:/login"; 
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
            return "home"; 
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/newspaper")
    public String showNewspaper(HttpSession session, Model model) {        
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId = " + userId);

        if (userId == null) {
            return "redirect:/login"; 
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
            return "newspaper"; 
        } else {
            return "redirect:/login";
        }
    }


}


