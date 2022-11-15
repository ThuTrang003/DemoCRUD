package viewmodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@AllArgsConstructor
@NoArgsConstructor
public class LopHocViewModel {

    private Integer id;
    private String ma;
    private String ten;

    public Object[] toDataRow() {
        return new Object[]{ma, ten};
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ten;
    }

    
    
    
}
