package it.uiip.digitalgarage.ebuonweekend.be;


import it.uiip.digitalgarage.ebuonweekend.entity.Utente;
import it.uiip.digitalgarage.ebuonweekend.ibe.UtenteService;
import it.uiip.digitalgarage.ebuonweekend.idao.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	UtenteDAO utenteDAO;
	
	
	@Override
	public boolean insert(Utente u){
		if(utenteDAO.selectByEmail(u.getEmail()) != null){
			return false;
		}
		else{
			return utenteDAO.insert(u);
		}
	}
}