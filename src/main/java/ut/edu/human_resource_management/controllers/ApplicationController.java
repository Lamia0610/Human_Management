package ut.edu.human_resource_management.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ut.edu.human_resource_management.dto.ApplicationDto;
import ut.edu.human_resource_management.models.Application;
import ut.edu.human_resource_management.services.ApplicationService;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*") // tạm thời cho phép mọi origin; trong production nên set origin cụ thể
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    // POST nhận form x-www-form-urlencoded từ <form>
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<?> submitApplication(ApplicationDto dto) {
        // simple validation
        if (dto.getFullName() == null || dto.getFullName().isBlank()) {
            return ResponseEntity.badRequest().body("fullName is required");
        }
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            return ResponseEntity.badRequest().body("email is required");
        }

        LocalDate dob = ApplicationService.parseDob(dto.getDob());

        Application app = new Application();
        app.setFullName(dto.getFullName());
        app.setEmail(dto.getEmail());
        app.setPhone(dto.getPhone());
        app.setPosition(dto.getPosition());
        app.setDob(dob);
        app.setGender(dto.getGender());
        app.setAddress(dto.getAddress());
        app.setEducation(dto.getEducation());
        app.setCvLink(dto.getCvLink());
        app.setCoverLetter(dto.getCoverLetter());
        app.setCreatedAt(LocalDateTime.now());

        Application saved = service.saveApplication(app);

        // trả về 201 Created với id
        // return ResponseEntity.created(URI.create("/api/applications/" + saved.getId())).body(saved);
        return ResponseEntity.ok()
        .body("<script>alert('Ứng tuyển thành công!'); window.location.href='/recruitment';</script>");

    }

    // GET tất cả applications (dành cho admin)
    @GetMapping
    public List<Application> listApplications() {
        return service.getAllApplications();
    }

    // GET single application
    @GetMapping("/{id}")
    public ResponseEntity<Application> getOne(@PathVariable Long id) {
        return service.getAllApplications().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
