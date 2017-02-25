package it.uiip.digitalgarage.ebuonweekend.controller;

import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.Pdf;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.page.PageType;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;

import it.uiip.digitalgarage.ebuonweekend.entity.GenericReturn;
import it.uiip.digitalgarage.ebuonweekend.entity.Utente;
import it.uiip.digitalgarage.ebuonweekend.ibe.UtenteService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = {"/uploadFile"}, headers = "content-type=multipart/*", method = RequestMethod.POST)
	@ResponseBody
	public GenericReturn<String> uploadAllegato(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
		System.out.println(file.getName() + " - " + file.getContentType());

		Path dbFolder = Paths.get("/home/tomcat/e-buonweekend/profiles/");

		String error = "";

		Boolean created = true;
		if (Files.notExists(dbFolder)) {
			System.out.println("path doesn't exist");
			created = new File("/home/tomcat/e-buonweekend/profiles/").mkdirs();
			if (created)
				System.out.println("path created!");
			else
				System.out.println(error+="error creating path");
		}
		if (created) {

			String fileName= "image_" + (Files.list(Paths.get("/home/tomcat/e-buonweekend/profiles/")).count() + 1) + "." + FilenameUtils.getExtension(file.getOriginalFilename());
			File convFile = new File("/home/tomcat/e-buonweekend/profiles/" + fileName);

			System.out.println(convFile.getAbsolutePath());
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();

			String path="http://138.68.133.189/ebuonweekend-web/external/profiles/"+fileName;

			//convFile.getAbsolutePath().replace("\\","/")
			return new GenericReturn<>(path, null);
		} else {
			System.out.println("Error uploading file.");
			return new GenericReturn<>("Something failed"+error, null);

		}


	}
	
	
	
}