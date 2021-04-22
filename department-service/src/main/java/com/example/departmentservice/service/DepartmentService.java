package com.example.departmentservice.service;

import com.example.departmentservice.model.Department;

import java.util.List;

public interface DepartmentService {

    public Department createDepartment(Department department);
    public List<Department> displayAllDepartment();
}
