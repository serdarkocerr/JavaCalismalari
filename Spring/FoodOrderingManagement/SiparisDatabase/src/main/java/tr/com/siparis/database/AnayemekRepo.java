package tr.com.siparis.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.siparis.database.model.anayemek;
@Repository
public interface AnayemekRepo  extends JpaRepository<anayemek, Integer>{
	List<anayemek> findByAnayemekadi(String anayemekadi); 

}
