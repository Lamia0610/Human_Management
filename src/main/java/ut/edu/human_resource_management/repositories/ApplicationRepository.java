package ut.edu.human_resource_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.human_resource_management.models.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // thêm query methods nếu cần
}
