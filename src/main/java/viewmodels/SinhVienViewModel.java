package viewmodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thangncph26123
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SinhVienViewModel {
    
    private int id;
    private String ma;
    private String ten;
    private String maLop;
    private String tenLop;
    
    public Object[] toDataRow() {
        return new Object[]{ma, ten, maLop, tenLop};
    }
    
}
