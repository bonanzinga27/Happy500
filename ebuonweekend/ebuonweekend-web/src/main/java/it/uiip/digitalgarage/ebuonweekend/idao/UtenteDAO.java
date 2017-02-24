package it.uiip.digitalgarage.ebuonweekend.idao;


import it.uiip.digitalgarage.ebuonweekend.entity.Utente;

public interface UtenteDAO{
	
	boolean insert(Utente user);
	Utente selectByEmail(String email);
	boolean authentication(Utente u);
}