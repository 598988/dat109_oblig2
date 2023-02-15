package no.hvl.dat109.funksjon;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtleiekontorRepo extends JpaRepository<Utleiekontor, Integer> {

	List<Utleiekontor> findAll();

	//Deltager finnID(Integer mobil);
	
}
