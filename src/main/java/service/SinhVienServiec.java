/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.SinhVien;
import java.util.List;
import viewmodels.SinhVienView;
import viewmodels.SinhVienViewModel;

/**
 *
 * @author ADMIN
 */
public interface SinhVienServiec {
    List<SinhVienViewModel> getList();
    
    List<SinhVienView> getAll();
    
    String insert(SinhVien sinhVien);
    
    String update(SinhVien sinhVien);
    
    String delete(SinhVien sinhVien);
    
    SinhVien findByMa(String ma);
}
