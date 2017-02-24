package it.uiip.digitalgarage.ebuonweekend.controller;

import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.Pdf;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.page.PageType;
import org.springframework.web.bind.annotation.*;

import it.uiip.digitalgarage.ebuonweekend.entity.GenericReturn;
import it.uiip.digitalgarage.ebuonweekend.entity.Utente;
import it.uiip.digitalgarage.ebuonweekend.ibe.UtenteService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
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
		try {


		Pdf pdf = new Pdf();
		pdf.addPage("http://localhost:4200/#jkjkj", PageType.url);
		// pdf.addToc();
			pdf.saveAs("C:"+ File.separator+"Users"+ File.separator+"gvasa"+ File.separator+"Desktop"+ File.separator+ "test.pdf");
		} catch ( IOException | InterruptedException e) {
			e.printStackTrace();
		}

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

	@CrossOrigin(origins = "http://localhost:4200")
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