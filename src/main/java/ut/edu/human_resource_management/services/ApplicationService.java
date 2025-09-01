package ut.edu.human_resource_management.services;

import org.springframework.stereotype.Service;
import ut.edu.human_resource_management.models.Application;
import ut.edu.human_resource_management.repositories.ApplicationRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository repo;

    public ApplicationService(ApplicationRepository repo) {
        this.repo = repo;
    }

    public Application saveApplication(Application application) {
        if (application.getCreatedAt() == null) {
            application.setCreatedAt(LocalDateTime.now());
        }
        return repo.save(application);
    }

    public List<Application> getAllApplications() {
        return repo.findAll();
    }

    // helper to parse date string yyyy-MM-dd
    public static LocalDate parseDob(String dobStr) {
        if (dobStr == null || dobStr.isBlank()) return null;
        try {
            return LocalDate.parse(dobStr);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}
