package ut.edu.human_resource_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.human_resource_management.models.ChamCong;
import ut.edu.human_resource_management.models.NhanVien;

import java.time.LocalDate;
import java.util.List;

public interface ChamCongRepository extends JpaRepository<ChamCong, Long> {

    // Lấy danh sách chấm công theo nhân viên
    List<ChamCong> findByNhanVien(NhanVien nhanVien);

    // Lấy danh sách chấm công theo nhân viên, sắp xếp giảm dần theo ngày
    List<ChamCong> findByNhanVienOrderByNgayDesc(NhanVien nhanVien);

    // Kiểm tra nhân viên đã chấm công trong ngày chưa
    ChamCong findByNhanVienAndNgay(NhanVien nhanVien, LocalDate ngay);
}