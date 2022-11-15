/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodels.SinhVien;
import java.util.List;
import repository.SinhVienRepository;
import service.SinhVienServiec;
import viewmodels.SinhVienView;
import viewmodels.SinhVienViewModel;

/**
 *
 * @author ADMIN
 */
public class SinhVienServiecImpl implements SinhVienServiec{

    private SinhVienRepository svRepo;
    public SinhVienServiecImpl() {
        this.svRepo = new SinhVienRepository();
    }
    
    @Override
    public List<SinhVienViewModel> getList() {
        return this.svRepo.getList();
    }

    @Override
    public String insert(SinhVien sinhVien) {
        boolean check = svRepo.saveOrUpdate(sinhVien);
        if (check) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(SinhVien sinhVien) {
        boolean check = svRepo.saveOrUpdate(sinhVien);
        if (check) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(SinhVien sinhVien) {
        boolean check = svRepo.delete(sinhVien);
        if (check) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    @Override
    public SinhVien findByMa(String ma) {
        return this.svRepo.findByMa(ma);
    }

    @Override
    public List<SinhVienView> getAll() {
        return this.svRepo.getAll();
    }
    
}
