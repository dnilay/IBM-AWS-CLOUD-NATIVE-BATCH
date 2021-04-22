package com.example.departmentservice.service;

import com.example.departmentservice.dao.DepartmentDao;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class DepartmentServicempl implements DepartmentService {
    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServicempl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override

    public Department createDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override

    public List<Department> displayAllDepartment() {
        return departmentDao.findAll();
    }
}
