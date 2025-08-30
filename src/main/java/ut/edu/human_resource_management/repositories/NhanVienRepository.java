package ut.edu.human_resource_management.repositories;

import ut.edu.human_resource_management.models.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    // Tìm nhân viên theo email
    NhanVien findByEmail(String email);
}
