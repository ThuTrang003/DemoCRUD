package domainmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thangncph26123
 */
@Table(name = "sinh_vien") // đánh dấu table trong database
@AllArgsConstructor// contructor có tham số
@NoArgsConstructor // contructor ko tham số
@Data // getter setter tostring
@Entity // đánh dấu là 1 thực thể
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //mã tự sinh theo dạng + 1
    @Column(name = "Id") // cột trong Db
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
    
    @ManyToOne
    @JoinColumn(name = "IdLopHoc")
    private LopHoc lopHoc;
    
    
}
