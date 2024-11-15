package SpringBootProjectTest.SpringBootTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProjectTest.SpringBootTest.model.Employee;

@Repository
public interface Employeerepo extends JpaRepository<Employee, Integer>{

}
