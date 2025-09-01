package ut.edu.human_resource_management.dto;

public class ApplicationDto {
    private String fullName;
    private String email;
    private String phone;
    private String position;
    private String dob; // we'll parse to LocalDate in service/controller
    private String gender;
    private String address;
    private String education;
    private String cvLink;
    private String coverLetter;

    public ApplicationDto() {}

    // getters & setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

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
}
