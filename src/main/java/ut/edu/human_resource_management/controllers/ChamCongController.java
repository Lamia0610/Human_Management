package ut.edu.human_resource_management.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ut.edu.human_resource_management.models.ChamCong;
import ut.edu.human_resource_management.models.NhanVien;
import ut.edu.human_resource_management.repositories.ChamCongRepository;
import ut.edu.human_resource_management.repositories.NhanVienRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class ChamCongController {

    @Autowired
    private ChamCongRepository chamCongRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("/attendance")
    public String showAttendance(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        NhanVien nhanVien = nhanVienRepository.findById(userId).orElse(null);
        if (nhanVien == null) {
            return "redirect:/login";
        }

        // Lấy tất cả bản ghi chấm công của nhân viên để hiển thị trên bảng
        List<ChamCong> chamCongList = chamCongRepository.findByNhanVienOrderByNgayDesc(nhanVien);
        model.addAttribute("chamCongList", chamCongList);

        // Lấy trạng thái chấm công hôm nay để hiển thị
        ChamCong chamCongHomNay = chamCongRepository.findByNhanVienAndNgay(nhanVien, LocalDate.now());
        String statusMessage;
        if (chamCongHomNay == null) {
            statusMessage = "Trạng thái hiện tại: Chưa chấm công";
        } else if (chamCongHomNay.getGioRa() == null) {
            statusMessage = "Trạng thái hiện tại: Đã chấm công vào lúc " + chamCongHomNay.getGioVao();
        } else {
            statusMessage = "Trạng thái hiện tại: Đã hoàn tất chấm công";
        }
        model.addAttribute("statusMessage", statusMessage);
        
        // Thêm nhân viên vào model để Thymeleaf sử dụng
        model.addAttribute("nhanVien", nhanVien);

        return "attendance";
    }

    @PostMapping("/attendance/checkin")
    public String chamCongVao(HttpSession session, RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv == null) {
            return "redirect:/login";
        }

        LocalDate today = LocalDate.now();
        ChamCong chamCong = chamCongRepository.findByNhanVienAndNgay(nv, today);

        if (chamCong != null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Bạn đã thực hiện chấm công vào ngày hôm nay rồi!");
        } else {
            chamCong = new ChamCong();
            chamCong.setNhanVien(nv);
            chamCong.setNgay(today);
            chamCong.setGioVao(LocalTime.now());
            chamCongRepository.save(chamCong);
            redirectAttributes.addFlashAttribute("successMessage", "✅ Chấm công vào thành công!");
        }

        return "redirect:/attendance";
    }

    @PostMapping("/attendance/checkout")
    public String chamCongRa(HttpSession session, RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        NhanVien nv = nhanVienRepository.findById(userId).orElse(null);
        if (nv == null) {
            return "redirect:/login";
        }

        LocalDate today = LocalDate.now();
        ChamCong chamCong = chamCongRepository.findByNhanVienAndNgay(nv, today);

        if (chamCong == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Bạn phải chấm công vào trước khi chấm công ra!");
        } else if (chamCong.getGioRa() != null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Bạn đã thực hiện chấm công ra ngày hôm nay rồi!");
        } else {
            chamCong.setGioRa(LocalTime.now());
            chamCongRepository.save(chamCong);
            redirectAttributes.addFlashAttribute("successMessage", "✅ Chấm công ra thành công!");
        }

        return "redirect:/attendance";
    }
}