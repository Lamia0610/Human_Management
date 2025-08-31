package ut.edu.human_resource_management.repositories;

import ut.edu.human_resource_management.models.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {
    // Có thể thêm query tùy chỉnh ở đây nếu cần sau này
}
