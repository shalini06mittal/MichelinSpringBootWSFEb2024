package com.demo.SpringBootDemo.service;

import com.demo.SpringBootDemo.entity.Address;
import com.demo.SpringBootDemo.entity.Employee;
import com.demo.SpringBootDemo.exception.InvalidCredentialsException;
import com.demo.SpringBootDemo.repo.AddressRepository;
import com.demo.SpringBootDemo.repo.EmployeeRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public Employee getEmployeeById(int eid) {
        System.out.println("Emp service "+eid);
        return this.employeeRepository
                .findById(eid).orElseThrow(()-> new EntityNotFoundException("Employee "+eid+" not found"));
    }
    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<Employee>();
        this.employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    // 50 records : 4 5
    public Page<Employee> getFilteredEmployees(Integer pageno, Integer size){


        Pageable pageable = PageRequest.of(pageno, size, Sort.by(Sort.Direction.DESC, "email"));

        List<Employee> employees = new ArrayList<Employee>();

        return this.employeeRepository.findAll(pageable);

    }

    public Employee updateEmployee(Employee employee) {
        if(!this.employeeRepository.existsById(employee.getEid()))
            throw new EntityNotFoundException("Employee "+employee.getEid()+" not found and cannot be updated");
        return this.employeeRepository.save(employee);
    }

    @Transactional
    public boolean deleteEmployee(int eid) {
        if(!this.employeeRepository.existsById(eid))
            throw new EntityNotFoundException("Employee "+eid+" not found and cannot be deleted");
        this.employeeRepository.deleteById(eid);
        return true;
    }
//    @Transactional
//    public boolean deleteAddressByEmployeeId(int eid) {
//        if(!this.employeeRepository.existsById(eid))
//            throw new EntityNotFoundException("Employee "+eid+" not found and cannot be deleted");
//        Integer addressid = addressRepository.findAddressIdByEmployeeEid(eid) ;
//        System.out.println("address id "+addressid);
//        if(addressid!= null)
//            this.addressRepository.deleteById(addressid);
//        return true;
//    }

    public boolean loginEmployee(String email, String password) throws InvalidCredentialsException
    {

        String pwd = this.employeeRepository.findPasswordByEmployeeEmail(email);
        if(pwd!=null)
        {
            if(pwd.equals(password))
                return true;
        }
        throw new InvalidCredentialsException("Invalid credentials, Please try again");
    }




}
