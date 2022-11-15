package service.impl;

import domainmodels.LopHoc;
import java.util.List;
import repository.LopHocRepository;
import service.LopHocService;
import viewmodels.LopHocViewModel;

/**
 *
 * @author thangncph26123
 */
public class LopHocServiceImpl implements LopHocService {

    private LopHocRepository lopHocRepository = new LopHocRepository();

    @Override
    public List<LopHocViewModel> getList() {
        return lopHocRepository.getList();
    }

    @Override
    public String insert(LopHoc lopHoc) {
        if (lopHoc.getMa().isEmpty()) {
            return "Mã ko đc trống";
        }
        if (lopHoc.getTen().isEmpty()) {
            return "Tên ko đc trống";
        }
        boolean check = lopHocRepository.saveOrUpdate(lopHoc);
        if (check) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(LopHoc lopHoc) {
        if (lopHoc.getMa().isEmpty()) {
            return "Mã ko đc trống";
        }
        if(lopHocRepository.findByMa(lopHoc.getMa()) != null){
            return "Mã ko đc trùng";
        }
        if (lopHoc.getTen().isEmpty()) {
            return "Tên ko đc trống";
        }
        boolean check = lopHocRepository.saveOrUpdate(lopHoc);
        if (check) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public LopHoc findByMa(String ma) {
        return this.lopHocRepository.findByMa(ma);
    }

}
