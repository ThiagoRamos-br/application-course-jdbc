package model.dao;

import entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert (Department dp);
    void update (Department dp);
    void deleteById (Integer id);
    Department FindById(Integer id);
    List<Department> listDp();


}
