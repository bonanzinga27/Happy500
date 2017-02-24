package it.uiip.digitalgarage.ebuonweekend.ibe;

import it.uiip.digitalgarage.ebuonweekend.entity.Utente;

public interface UtenteService {
	
	boolean insert(Utente user);
	boolean authentication(Utente u);
	
	
	
}