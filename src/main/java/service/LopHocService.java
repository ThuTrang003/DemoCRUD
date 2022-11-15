package service;

import domainmodels.LopHoc;
import java.util.List;
import viewmodels.LopHocViewModel;

public interface LopHocService {
    
    List<LopHocViewModel> getList();
    
    String insert(LopHoc lopHoc);
    
    String update(LopHoc lopHoc);
    
    LopHoc findByMa(String ma);
}
