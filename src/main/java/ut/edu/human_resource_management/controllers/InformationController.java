package ut.edu.human_resource_management.controllers;

import ut.edu.human_resource_management.models.Information;
import ut.edu.human_resource_management.models.NhanVien;
import ut.edu.human_resource_management.repositories.InformationRepository;
import ut.edu.human_resource_management.repositories.NhanVienRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    // Hiển thị trang thông tin + form phản hồi
    @GetMapping
    public String showInformationPage(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien == null) {
            return "redirect:/login";
        }

        // Thêm nhân viên
        model.addAttribute("nhanVien", nhanVien);

        // Tạo object Information cho form
        Information info = new Information();
        info.setName(nhanVien.getHoTen()); // gán tên nhân viên
        model.addAttribute("information", info);

        // Load danh sách phản hồi
        model.addAttribute("listInfo", informationRepository.findAll());

        return "information"; // dùng chung template
    }

    // Xử lý gửi phản hồi
    @PostMapping("/add")
    public String addInformation(@ModelAttribute Information info, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
            if (nv != null) {
                info.setName(nv.getHoTen()); // gán tên nhân viên vào phản hồi
            }
        }
        informationRepository.save(info);
        return "redirect:/information"; // redirect về trang chung
    }
}
