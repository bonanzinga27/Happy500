package idao;


import entity.Utente;

public interface UtenteDAO{
	
	boolean insert(Utente user);
	Utente selectByEmail(String email);
}