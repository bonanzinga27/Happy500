package be;

import entity.Utente;
import ibe.UtenteService;
import idao.UtenteDAO;
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