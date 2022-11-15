package repository;

import domainmodels.LopHoc;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilies.HibernateUtil;
import viewmodels.LopHocViewModel;

public class LopHocRepository {

    public List<LopHocViewModel> getList() {
        List<LopHocViewModel> list = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();// truy vấn trên đối tượng
            String hql = "SELECT new viewmodels.LopHocViewModel(a.id, a.ma, a.ten) FROM LopHoc a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<LopHoc> getListLopHoc() {
        List<LopHoc> list = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();// truy vấn trên đối tượng
            String hql = "SELECT a FROM LopHoc a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean saveOrUpdate(LopHoc lopHoc) {
        boolean check = false;
        try {
            Session session = HibernateUtil.getSession(); // mở kết nối
            Transaction trans = session.beginTransaction(); // mở transaction để đẩy dữ liệu
            session.saveOrUpdate(lopHoc); // lưu tạm thời vào bộ nhớ đệm
            trans.commit(); // đẩy dữ liệu vào DB
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public LopHoc findByMa(String ma) {
        LopHoc lopHoc = null;
        try {
            Session session = HibernateUtil.getSession();// truy vấn trên đối tượng
            String hql = "SELECT a FROM LopHoc a WHERE a.ma = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            if (query.getSingleResult() != null) {
                lopHoc = (LopHoc) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return lopHoc;
    }

    public boolean delete(LopHoc lopHoc) {
        boolean check = false;
        try {
            Session session = HibernateUtil.getSession(); // mở kết nối
            Transaction trans = session.beginTransaction(); // mở transaction để đẩy dữ liệu
            session.delete(lopHoc); // lưu tạm thời vào bộ nhớ đệm
            trans.commit(); // đẩy dữ liệu vào DB
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
