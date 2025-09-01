package ut.edu.human_resource_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ut.edu.human_resource_management.models.ChamCong;
import ut.edu.human_resource_management.models.NhanVien;
import ut.edu.human_resource_management.repositories.ChamCongRepository;
import ut.edu.human_resource_management.repositories.NhanVienRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private ChamCongRepository chamCongRepository;

    @Override
    public void run(String... args) throws Exception {
        // Tạo dữ liệu nhân viên chỉ khi bảng nhân viên trống
        if (nhanVienRepository.count() == 0) {
            System.out.println("Bắt đầu tạo dữ liệu nhân viên giả...");

            List<NhanVien> nhanVienList = List.of(
                new NhanVien("NV001", "Lê Văn An", "Nam", "1992-03-15", "an.le@example.com", "0987123456", "Kỹ sư phần mềm", "Kỹ thuật", "12345678"),
                new NhanVien("NV002", "Trần Thị Bích", "Nữ", "1995-07-22", "bich.tran@example.com", "0912345678", "Lập trình viên", "Kỹ thuật", "12345678"),
                new NhanVien("NV003", "Nguyễn Văn Cường", "Nam", "1990-01-11", "cuong.nguyen@example.com", "0909876543", "Kỹ sư mạng", "Kỹ thuật", "12345678"),
                new NhanVien("NV004", "Phạm Minh Dũng", "Nam", "1994-09-05", "dung.pham@example.com", "0976543210", "Kỹ sư phần mềm", "Kỹ thuật", "12345678"),
                new NhanVien("NV005", "Hoàng Thị Giang", "Nữ", "1993-11-30", "giang.hoang@example.com", "0965432109", "Chuyên viên IT", "Kỹ thuật", "12345678"),
                new NhanVien("NV006", "Đỗ Anh Hùng", "Nam", "1996-04-18", "hung.do@example.com", "0943210987", "Lập trình viên", "Kỹ thuật", "12345678"),
                new NhanVien("NV007", "Bùi Thị Lan", "Nữ", "1991-02-08", "lan.bui@example.com", "0932109876", "Kỹ sư bảo mật", "Kỹ thuật", "12345678"),
                new NhanVien("NV008", "Phan Văn Nam", "Nam", "1997-06-25", "nam.phan@example.com", "0921098765", "Chuyên viên hỗ trợ kỹ thuật", "Kỹ thuật", "12345678"),
                new NhanVien("NV009", "Trịnh Thị Oanh", "Nữ", "1998-10-14", "oanh.trinh@example.com", "0910987654", "Kỹ sư phần mềm", "Kỹ thuật", "12345678"),
                new NhanVien("NV010", "Vũ Minh Quang", "Nam", "1990-05-03", "quang.vu@example.com", "0909098765", "Trưởng phòng Kỹ thuật", "Kỹ thuật", "12345678"),
                new NhanVien("NV011", "Nguyễn Thị Phương", "Nữ", "1993-08-21", "phuong.nguyen@example.com", "0912123456", "Chuyên viên kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV012", "Trần Văn Quyết", "Nam", "1991-01-09", "quyet.tran@example.com", "0987654321", "Chuyên viên kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV013", "Lê Minh Rõ", "Nam", "1995-04-17", "ro.le@example.com", "0909123456", "Trợ lý kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV014", "Phạm Thị Sen", "Nữ", "1994-02-28", "sen.pham@example.com", "0976123456", "Chuyên viên kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV015", "Đỗ Văn Tùng", "Nam", "1992-07-13", "tung.do@example.com", "0965123456", "Chuyên viên kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV016", "Bùi Thị Uyên", "Nữ", "1996-03-06", "uyen.bui@example.com", "0943123456", "Nhân viên kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV017", "Phan Văn Vinh", "Nam", "1990-09-19", "vinh.phan@example.com", "0932123456", "Trưởng phòng Kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV018", "Trịnh Thị Xuân", "Nữ", "1997-05-02", "xuan.trinh@example.com", "0921123456", "Nhân viên kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV019", "Vũ Văn Yến", "Nam", "1998-11-28", "yen.vu@example.com", "0910123456", "Chuyên viên kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV020", "Nguyễn Minh Cường", "Nam", "1992-12-07", "cuong.nguyenminh@example.com", "0909123456", "Nhân viên kinh doanh", "Kinh doanh", "12345678"),
                new NhanVien("NV021", "Nguyễn Thị Ánh", "Nữ", "1994-04-03", "anh.nguyen@example.com", "0987234567", "Chuyên viên Content", "Marketing", "12345678"),
                new NhanVien("NV022", "Trần Văn Bình", "Nam", "1992-08-25", "binh.tran@example.com", "0912456789", "Chuyên viên Digital Marketing", "Marketing", "12345678"),
                new NhanVien("NV023", "Lê Thị Chi", "Nữ", "1996-10-19", "chi.le@example.com", "0909234567", "Chuyên viên SEO/SEM", "Marketing", "12345678"),
                new NhanVien("NV024", "Phạm Văn Đạt", "Nam", "1991-03-07", "dat.pham@example.com", "0976234567", "Chuyên viên Marketing", "Marketing", "12345678"),
                new NhanVien("NV025", "Hoàng Thị Hạnh", "Nữ", "1995-06-12", "hanh.hoang@example.com", "0965234567", "Chuyên viên Social Media", "Marketing", "12345678"),
                new NhanVien("NV026", "Đỗ Văn Khoa", "Nam", "1993-11-30", "khoa.do@example.com", "0943234567", "Chuyên viên Marketing", "Marketing", "12345678"),
                new NhanVien("NV027", "Bùi Thị Mai", "Nữ", "1997-01-14", "mai.bui@example.com", "0932234567", "Trợ lý Marketing", "Marketing", "12345678"),
                new NhanVien("NV028", "Phan Văn Lộc", "Nam", "1990-09-22", "loc.phan@example.com", "0921234567", "Trưởng phòng Marketing", "Marketing", "12345678"),
                new NhanVien("NV029", "Trịnh Thị Ngân", "Nữ", "1998-07-05", "ngan.trinh@example.com", "0910234567", "Chuyên viên Marketing", "Marketing", "12345678"),
                new NhanVien("NV030", "Vũ Văn Oai", "Nam", "1995-02-18", "oai.vu@example.com", "0909234567", "Chuyên viên Content", "Marketing", "12345678"),
                new NhanVien("NV031", "Nguyễn Thị Phượng", "Nữ", "1992-05-26", "phuong.nguyenthi@example.com", "0987345678", "Chuyên viên Tuyển dụng", "Nhân sự", "12345678"),
                new NhanVien("NV032", "Trần Văn Quý", "Nam", "1995-09-04", "quy.tranvan@example.com", "0912345678", "Chuyên viên Đào tạo", "Nhân sự", "12345678"),
                new NhanVien("NV033", "Lê Thị Rung", "Nữ", "1993-02-11", "rung.le@example.com", "0909345678", "Chuyên viên Lương thưởng", "Nhân sự", "12345678"),
                new NhanVien("NV034", "Phạm Văn Sang", "Nam", "1991-07-19", "sang.pham@example.com", "0976345678", "Chuyên viên Nhân sự", "Nhân sự", "12345678"),
                new NhanVien("NV035", "Đỗ Thị Thanh", "Nữ", "1996-12-08", "thanh.do@example.com", "0965345678", "Chuyên viên Chế độ chính sách", "Nhân sự", "12345678"),
                new NhanVien("NV036", "Bùi Văn Tín", "Nam", "1994-03-03", "tin.bui@example.com", "0943345678", "Trưởng phòng Nhân sự", "Nhân sự", "12345678"),
                new NhanVien("NV037", "Phan Thị Uyên", "Nữ", "1997-10-16", "uyen.phan@example.com", "0932345678", "Chuyên viên Tuyển dụng", "Nhân sự", "12345678"),
                new NhanVien("NV038", "Trịnh Văn Vĩnh", "Nam", "1990-01-24", "vinh.trinh@example.com", "0921345678", "Chuyên viên Nhân sự", "Nhân sự", "12345678"),
                new NhanVien("NV039", "Vũ Thị Yến", "Nữ", "1998-08-29", "yen.vu.thi@example.com", "0910345678", "Trợ lý Nhân sự", "Nhân sự", "12345678"),
                new NhanVien("NV040", "Nguyễn Văn Lâm", "Nam", "1995-04-07", "lam.nguyenvan@example.com", "0909345678", "Chuyên viên Đào tạo", "Nhân sự", "12345678"),
                new NhanVien("NV041", "Trần Minh Ái", "Nữ", "1993-06-10", "ai.tran@example.com", "0987456789", "Kế toán viên", "Tài chính", "12345678"),
                new NhanVien("NV042", "Lê Văn Bách", "Nam", "1991-09-15", "bach.le@example.com", "0912567890", "Chuyên viên tài chính", "Tài chính", "12345678"),
                new NhanVien("NV043", "Phạm Thị Châu", "Nữ", "1995-03-01", "chau.pham@example.com", "0909567890", "Kế toán viên", "Tài chính", "12345678"),
                new NhanVien("NV044", "Hoàng Văn Đạt", "Nam", "1992-08-20", "dat.hoang@example.com", "0976567890", "Chuyên viên phân tích tài chính", "Tài chính", "12345678"),
                new NhanVien("NV045", "Đỗ Thị Huyền", "Nữ", "1990-11-28", "huyen.do@example.com", "0965567890", "Kế toán trưởng", "Tài chính", "12345678"),
                new NhanVien("NV046", "Bùi Văn Kiên", "Nam", "1996-04-05", "kien.bui@example.com", "0943567890", "Kế toán viên", "Tài chính", "12345678"),
                new NhanVien("NV047", "Phan Thị Lan", "Nữ", "1997-02-17", "lan.phan@example.com", "0932567890", "Chuyên viên tài chính", "Tài chính", "12345678"),
                new NhanVien("NV048", "Trịnh Văn Lộc", "Nam", "1994-10-23", "loc.trinh@example.com", "0921567890", "Trưởng phòng Tài chính", "Tài chính", "12345678"),
                new NhanVien("NV049", "Vũ Thị Mai", "Nữ", "1998-01-09", "mai.vu@example.com", "0910567890", "Kế toán viên", "Tài chính", "12345678"),
                new NhanVien("NV050", "Nguyễn Minh Tuấn", "Nam", "1993-07-12", "tuan.nguyenminh@example.com", "0909567890", "Kế toán viên", "Tài chính", "12345678"),
                new NhanVien("NV051", "Trần Văn An", "Nam", "1994-05-04", "an.tranvan@example.com", "0987678901", "Chuyên viên Hành chính", "Hành chính", "12345678"),
                new NhanVien("NV052", "Lê Thị Bình", "Nữ", "1996-08-19", "binh.lethi@example.com", "0912789012", "Thư ký văn phòng", "Hành chính", "12345678"),
                new NhanVien("NV053", "Phạm Văn Chính", "Nam", "1992-02-25", "chinh.pham@example.com", "0909789012", "Chuyên viên Lễ tân", "Hành chính", "12345678"),
                new NhanVien("NV054", "Hoàng Thị Đào", "Nữ", "1995-09-13", "dao.hoang@example.com", "0976789012", "Chuyên viên Quản lý tài sản", "Hành chính", "12345678"),
                new NhanVien("NV055", "Đỗ Minh Hiếu", "Nam", "1993-11-07", "hieu.do@example.com", "0965789012", "Chuyên viên Hành chính", "Hành chính", "12345678"),
                new NhanVien("NV056", "Bùi Thị Kiều", "Nữ", "1997-01-02", "kieu.bui@example.com", "0943789012", "Chuyên viên Hành chính", "Hành chính", "12345678"),
                new NhanVien("NV057", "Phan Văn Long", "Nam", "1990-04-21", "long.phanvan@example.com", "0932789012", "Trưởng phòng Hành chính", "Hành chính", "12345678"),
                new NhanVien("NV058", "Trịnh Thị Nguyệt", "Nữ", "1998-06-16", "nguyet.trinh@example.com", "0921789012", "Trợ lý Hành chính", "Hành chính", "12345678"),
                new NhanVien("NV059", "Vũ Văn Thành", "Nam", "1991-03-28", "thanh.vuvan@example.com", "0910789012", "Chuyên viên Hành chính", "Hành chính", "12345678"),
                new NhanVien("NV060", "Nguyễn Thị Thu", "Nữ", "1994-12-05", "thu.nguyenthi@example.com", "0909789012", "Thư ký văn phòng", "Hành chính", "12345678")
            );

            nhanVienRepository.saveAll(nhanVienList);
            System.out.println("Đã tạo " + nhanVienList.size() + " nhân viên giả thành công!");
        }

        // Tạo dữ liệu chấm công chỉ khi bảng chấm công trống
        if (chamCongRepository.count() == 0) {
            System.out.println("Bắt đầu tạo dữ liệu chấm công giả cho tháng 8...");

            List<NhanVien> nhanVienList = nhanVienRepository.findAll();

            if (!nhanVienList.isEmpty()) {
                int year = LocalDate.now().getYear();
                LocalDate startDate = LocalDate.of(year, 8, 1);
                LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
                Random random = new Random();

                for (NhanVien nhanVien : nhanVienList) {
                    for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                        // Bỏ qua Thứ 7 (6) và Chủ Nhật (7)
                        if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                            continue;
                        }

                        LocalTime checkInTime = LocalTime.of(8, random.nextInt(15), random.nextInt(59));
                        LocalTime checkOutTime = LocalTime.of(17, random.nextInt(15), random.nextInt(59));

                        ChamCong chamCong = new ChamCong();
                        chamCong.setNhanVien(nhanVien);
                        chamCong.setNgay(date);
                        chamCong.setGioVao(checkInTime);
                        chamCong.setGioRa(checkOutTime);

                        chamCongRepository.save(chamCong);
                    }
                }
                System.out.println("Đã tạo dữ liệu chấm công giả thành công cho " 
                    + nhanVienList.size() + " nhân viên trong tháng 8!");
            } else {
                System.out.println("Không tìm thấy dữ liệu nhân viên, vui lòng nhập dữ liệu nhân viên trước.");
            }
        } else {
            System.out.println("Cơ sở dữ liệu đã có dữ liệu chấm công, bỏ qua bước tạo dữ liệu giả.");
        }
    }
}