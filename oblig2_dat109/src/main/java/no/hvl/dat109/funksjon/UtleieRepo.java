package no.hvl.dat109.funksjon;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtleieRepo extends JpaRepository<Utleie, String> {

	List<Utleie> findAll();

	//Deltager finnID(Integer mobil);
	
}