package com.dev.api.springrest.services;


import com.dev.api.springrest.dtos.EmployeeDTO;
import com.dev.api.springrest.dtos.ProductDTO;
import com.dev.api.springrest.models.Employee;
import com.dev.api.springrest.models.Product;
import com.dev.api.springrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employeeToDTO(employeeDTO, employee);
        employeeRepository.save(employee);
    }

    public void employeeToDTO(EmployeeDTO employeeDTO, Employee employee){

        employee.setName(employeeDTO.getName());
        employee.setCpf(employeeDTO.getCpf().replace(".", "").replace("-", ""));


    }

    public Employee dtoToEmployee(EmployeeDTO employeeDTO, Employee employee){

        employeeDTO.setName(employee.getName());
        employeeDTO.setCpf(employee.getCpf().replace(".", "").replace("-", ""));

        return employee;
    }

    public EmployeeDTO findOneEmployee(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employeeOnData;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if (employee.isPresent()){
            employeeOnData = employee.get();
            employeeToDTO(employeeDTO, employee.get());
        }
        return employeeDTO;
    }

    public void updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employeeOnBank = new Employee();

        if (employee.isPresent()) {
            employeeOnBank = employee.get();
            if (employeeDTO.getName() != null) {
                employeeOnBank.setName(employeeDTO.getName());
            }
            if (employeeDTO.getCpf() != null) {
                employeeOnBank.setCpf(employeeDTO.getCpf());
            }
            employeeRepository.save(employeeOnBank);
        }
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> listAll()
    {
        return employeeRepository.findAll();
    }
}
