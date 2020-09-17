package tr.com.siparis.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.siparis.database.model.test;
@Repository
public interface TestRepo  extends JpaRepository<test, Integer>{
	List<test> findByTestadi(String testadi); 

}
