package com.demo.SpringBootDemo.service;

import com.demo.SpringBootDemo.entity.Address;
import com.demo.SpringBootDemo.entity.Employee;
import com.demo.SpringBootDemo.repo.AddressRepository;
import com.demo.SpringBootDemo.repo.EmployeeRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;

    public EmployeeService() {
        System.out.println("emp service");
    }
    public Employee insertEmployee(Employee employee) {
        if (! employeeRepository.existsById(employee.getEid())) {
            Employee savedEmployee = this.employeeRepository.save(employee);
            return savedEmployee;
        }
        throw new EntityExistsException("Employee with id "+employee.getEid()+" already exists, hence cannot save");
    }

    public Address insertAddress(Address address, int empid) {
//        Address sAddress = this.addressRepository.save(address);
//        return sAddress;
        Optional<Employee> optional = employeeRepository.findById(empid);
        if(optional.isPresent()){
            // associate employee and address
            address.setEmployee(optional.get());
            Address sAddress = this.addressRepository.save(address);
            return sAddress;
        }
        throw new EntityNotFoundException("Employee with id "+empid+" does not exist and hence cannpt save the addres");
    }

    @Transactional
    public Employee insertEmployeeAndAddress(Employee employee) {

        if(this.employeeRepository.existsById(employee.getEid()))
            throw new EntityExistsException("Employee "+employee.getEid()+" already exist");

        Employee savedEmployee = this.employeeRepository.save(employee);

        Address address = employee.getAddress();
        if(address == null)
            throw new RuntimeException("ERROR could not insert address");
        address.setEmployee(savedEmployee);
        Address savedAddress = this.addressRepository.save(address);
        savedEmployee.setAddress(savedAddress);
        return savedEmployee;
    }

    public Employee findEmployeeByEmail(String email){
        return this.employeeRepository.findByEmail(email);
    }



}
