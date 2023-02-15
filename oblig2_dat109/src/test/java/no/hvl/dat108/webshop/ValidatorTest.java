package no.hvl.dat108.webshop;

import static org.junit.jupiter.api.Assertions.assertFalse;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

import no.hvl.dat109.funksjon.Bil;
import no.hvl.dat109.funksjon.BilRepo;
import no.hvl.dat109.funksjon.BilUtleieSelskap;
import no.hvl.dat109.funksjon.Kunde;
import no.hvl.dat109.funksjon.KundeRepo;
import no.hvl.dat109.funksjon.Retur;
import no.hvl.dat109.funksjon.ReturRepo;
import no.hvl.dat109.funksjon.Utleie;
import no.hvl.dat109.funksjon.UtleieRepo;
import no.hvl.dat109.funksjon.Utleiekontor;
import no.hvl.dat109.funksjon.UtleiekontorRepo;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
public class ValidatorTest {

	
	@Mock(lenient = true)
	KundeRepo kRepo; //= Mockito.mock(KundeRepo.class, withSettings().lenient());
	@Mock(lenient = true)
	UtleiekontorRepo ukRepo;
	@Mock(lenient = true) 
	BilRepo bRepo;
	@Mock(lenient = true) 
	UtleieRepo utleieRepo;
	@Mock(lenient = true) 
	ReturRepo returRepo;
	
	
	 Kunde kunde;
	 Utleiekontor kontor;
	 Utleie utleie;
	 Retur retur;
	 Bil bil;
	 
public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

	 
 @BeforeEach
 public void setup(){
	        //employeeRepository = Mockito.mock(EmployeeRepository.class);
	        //employeeService = new EmployeeServiceImpl(employeeRepository);
 	kunde = new Kunde("11122333", "Mori", "Kori", "Bammm", "1234567812345678");
 	kontor = new Utleiekontor("Storgata", "55577888");
 	bil = new Bil("EN44456", "Tesla", "X", "grønn", "B", true, "mellomstor", kontor);
 	utleie = new Utleie(kunde, kontor, kontor, "31,11,2004", "21:59", "31,11,2004", "21:59", bil);
 	retur = new Retur(kunde, "31,11,2004","21:59");
	    }
	 
	 
    @Test
    public void poMeldingavkunde()  {    	
    	given(kRepo.findById(kunde.getMobil())).willReturn(Optional.empty());
    	given(kRepo.save(kunde)).willReturn(null);
    	
    	System.out.println(kRepo);
    	System.out.println(kunde);
    	
    	
    	assertThat(kunde).isNotNull();
    	assertThat(kunde.getMobil()).isEqualTo("11122333");
    	
    }
    
    @Test
    public void kundeRegistererUtleie() {
    	given(kRepo.findById(kunde.getMobil())).willReturn(Optional.empty());
    	given(kRepo.save(kunde)).willReturn(null);
    	
    	given(bRepo.findById(kunde.getMobil())).willReturn(Optional.empty());
    	given(bRepo.save(bil)).willReturn(null);
    	
    	given(ukRepo.findById(kontor.getId())).willReturn(Optional.empty());
    	given(ukRepo.save(kontor)).willReturn(null);
    	
    	given(utleieRepo.findById(kunde.getMobil())).willReturn(Optional.empty());
    	given(utleieRepo.save(utleie)).willReturn(null);
    	

    	
    	System.out.println(kRepo);
    	System.out.println(kunde);
    	System.out.println(bil);
    	System.out.println(kontor);
    	System.out.println(utleie);
    	
    	
    	assertThat(kunde).isNotNull();
    	assertThat(bil).isNotNull();
    	assertThat(kontor).isNotNull();
    	assertThat(utleie).isNotNull();
    	assertThat(kunde.getMobil()).isEqualTo(utleie.getKunde().getMobil());

    }
    
    @Test
    public void KundeRegistererRetur() {
    	given(kRepo.findById(kunde.getMobil())).willReturn(Optional.empty());
    	given(kRepo.save(kunde)).willReturn(null);
    	
    	given(returRepo.findById(kunde.getMobil())).willReturn(Optional.empty());
    	given(returRepo.save(retur)).willReturn(null);

    	
    	System.out.println(kRepo);
    	System.out.println(kunde);
    	System.out.println(bil);
    	
    	assertThat(kunde).isNotNull();
    	assertThat(retur).isNotNull();
    	assertThat(kunde.getMobil()).isEqualTo(retur.getKunde().getMobil());

;
    	
    }  

}
