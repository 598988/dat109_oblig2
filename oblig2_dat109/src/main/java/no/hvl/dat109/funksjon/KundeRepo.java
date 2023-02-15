package no.hvl.dat109.funksjon;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KundeRepo extends JpaRepository<Kunde, String> {

	List<Kunde> findAll();

	//Deltager finnID(Integer mobil);
	
}
