package it.uiip.digitalgarage.ebuonweekend.controller;


import it.uiip.digitalgarage.ebuonweekend.entity.GenericReturn;
import it.uiip.digitalgarage.ebuonweekend.entity.Utente;
import it.uiip.digitalgarage.ebuonweekend.ibe.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UtenteController{
	
	@Autowired
	UtenteService utenteService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/register")
	public GenericReturn<Utente> register(@RequestParam(value = "email", defaultValue = "undefined") String email,
										  @RequestParam(value = "pass", defaultValue="undefined") String password){
		
		List<String> err = new ArrayList<>();
		
		
		if(!email.equals("undefined") && !password.equals("undefined")){
			
			
			Utente u = new Utente(0, email, password);
			
			if(utenteService.insert(u)){
				return new GenericReturn<>(u);
			}
			else{
				err.add("ERRORE INSERIMENTO UTENTE");
				return new GenericReturn<>(null, err);
			}
			
		}
		else{
				err.add("USERNAME O PASSWORD ERRATI");
				return new GenericReturn<>(null, err);
		}
	}
	
	
	
}