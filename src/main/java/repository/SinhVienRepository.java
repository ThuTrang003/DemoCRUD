package repository;

import domainmodels.LopHoc;
import domainmodels.SinhVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilies.HibernateUtil;
import viewmodels.SinhVienView;
import viewmodels.SinhVienViewModel;

/**
 *
 * @author thangncph26123
 */
public class SinhVienRepository {

    public List<SinhVienViewModel> getList() {
        List<SinhVienViewModel> list = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();// truy vấn trên đối tượng
            String hql = "SELECT new viewmodels.SinhVienViewModel(a.id, a.ma, a.ten, a.lopHoc.ma, a.lopHoc.ten) FROM SinhVien a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<SinhVienView> getAll() {
        List<SinhVienView> list = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();// truy vấn trên đối tượng
            String hql = "SELECT new viewmodels.SinhVienView(a.id, a.ma, a.ten) FROM SinhVien a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public List<SinhVien> getListSinhVien() {
        List<SinhVien> list = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();// truy vấn trên đối tượng
            String hql = "SELECT a FROM SinhVien a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean saveOrUpdate(SinhVien sinhVien) {
        boolean check = false;
        try {
            Session session = HibernateUtil.getSession(); // mở kết nối
            Transaction trans = session.beginTransaction(); // mở transaction để đẩy dữ liệu
            session.saveOrUpdate(sinhVien); // lưu tạm thời vào bộ nhớ đệm
            trans.commit(); // đẩy dữ liệu vào DB
            session.close();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public SinhVien findByMa(String ma) {
        SinhVien sinhVien = null;
        try {
            Session session = HibernateUtil.getSession();// truy vấn trên đối tượng
            String hql = "SELECT a FROM SinhVien a WHERE a.ma = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            if (query.getSingleResult() != null) {
                sinhVien = (SinhVien) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return sinhVien;
    }

    public boolean delete(SinhVien sinhVien) {
        boolean check = false;
        try {
            Session session = HibernateUtil.getSession(); // mở kết nối
            Transaction trans = session.beginTransaction(); // mở transaction để đẩy dữ liệu
            session.delete(sinhVien); // lưu tạm thời vào bộ nhớ đệm
            trans.commit(); // đẩy dữ liệu vào DB
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public static void main(String[] args) {
        List<SinhVienViewModel> list = new SinhVienRepository().getList();
        System.out.println(list);
        //làm thêm sửa xóa sinh viên, lớp học cho chọn combobox
    }
}
