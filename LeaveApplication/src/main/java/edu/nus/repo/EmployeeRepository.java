package edu.nus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.nus.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
      
}
