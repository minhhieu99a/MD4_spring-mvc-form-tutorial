package com.codegym.service;

import com.codegym.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployeeService {
    private static final Map<Integer, Employee> employees;

    static {
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "John", "john@codegym.vn"));
        employees.put(2, new Employee(2, "Bill", "bill@codegym.vn"));
        employees.put(3, new Employee(3, "Alex", "alex@codegym.vn"));
        employees.put(4, new Employee(4, "Adam", "adam@codegym.vn"));
        employees.put(5, new Employee(5, "Sophia", "sophia@codegym.vn"));
        employees.put(6, new Employee(6, "Rose", "rose@codegym.vn"));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public void save(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public Employee findById(int id) {
        return employees.get(id);
    }

    @Override
    public void update(int id, Employee customer) {
        employees.put(id, customer);

    }

    @Override
    public void remove(int id) {
        employees.remove(id);
    }
}
