package it.uiip.digitalgarage.ebuonweekend.controller;

import org.springframework.web.bind.annotation.*;

import it.uiip.digitalgarage.ebuonweekend.entity.GenericReturn;
import it.uiip.digitalgarage.ebuonweekend.entity.Utente;
import it.uiip.digitalgarage.ebuonweekend.ibe.UtenteService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UtenteController{
	
	@Autowired
	UtenteService utenteService;
	
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

	@RequestMapping("/login")
	public GenericReturn<Utente> login(@RequestParam(value = "email", defaultValue = "undefined") String email,
									   @RequestParam(value = "pass", defaultValue = "undefined") String pass){

		Utente u = new Utente(0, email, pass);

		if(utenteService.authentication(u)){
			return new GenericReturn<>(u);
		}
		else{
			return new GenericReturn<>(null);
		}
	}
	
	
	
}