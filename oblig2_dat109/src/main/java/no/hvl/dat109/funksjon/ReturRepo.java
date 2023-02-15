package no.hvl.dat109.funksjon;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturRepo extends JpaRepository<Retur, String> {

	List<Retur> findAll();

	//Deltager finnID(Integer mobil);
	
}