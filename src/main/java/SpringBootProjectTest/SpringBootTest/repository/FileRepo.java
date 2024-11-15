package SpringBootProjectTest.SpringBootTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProjectTest.SpringBootTest.model.EntityClass;

@Repository
public interface FileRepo extends JpaRepository<EntityClass, Integer>{

}
