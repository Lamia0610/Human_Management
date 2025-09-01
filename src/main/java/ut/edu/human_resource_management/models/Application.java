package ut.edu.human_resource_management.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column
    private String phone;

    @Column
    private String position;

    @Column
    private LocalDate dob;

    @Column
    private String gender;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column
    private String education;

    @Column(name = "cv_link")
    private String cvLink;

    @Column(columnDefinition = "TEXT")
    private String coverLetter;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Application() {}

    // Full constructor (without id)
    public Application(String fullName, String email, String phone, String position, LocalDate dob, String gender,
                       String address, String education, String cvLink, String coverLetter, LocalDateTime createdAt) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.education = education;
        this.cvLink = cvLink;
        this.coverLetter = coverLetter;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getCvLink() { return cvLink; }
    public void setCvLink(String cvLink) { this.cvLink = cvLink; }

    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
