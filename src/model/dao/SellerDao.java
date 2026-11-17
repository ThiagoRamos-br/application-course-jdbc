package model.dao;

import entities.Department;
import entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert (Department sl);
    void update (Department sl);
    void deleteById (Integer id);
    Seller FindById(Integer id);
    List<Seller> lisSl();
}
