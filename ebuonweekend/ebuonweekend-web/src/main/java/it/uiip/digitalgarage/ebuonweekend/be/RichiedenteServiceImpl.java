package it.uiip.digitalgarage.ebuonweekend.be;


import it.uiip.digitalgarage.ebuonweekend.entity.Richiedente;
import it.uiip.digitalgarage.ebuonweekend.ibe.RichiedenteService;
import it.uiip.digitalgarage.ebuonweekend.idao.RichiedenteDAO;
import it.uiip.digitalgarage.ebuonweekend.idao.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gvasa on 23/02/2017.
 */
public class RichiedenteServiceImpl implements RichiedenteService {
    @Autowired
    RichiedenteDAO richiedenteDAO;
    UtenteDAO utenteDAO;

    @Override
    public boolean insert(Richiedente richiedente) {
        if (richiedenteDAO.selectByID(richiedente.getId()) != null) {
            System.out.println("Richiedente già esistente!");
            return false;
        } else {
            return richiedenteDAO.insert(richiedente);
        }
    }

    @Override
    public boolean update(Richiedente richiedente,String email) {
        richiedente.setIdUtente(new Long(utenteDAO.selectByEmail(email).getId()));
            return richiedenteDAO.update(richiedente);


    }
    @Override
    public boolean delete(Long id) {
        return richiedenteDAO.delete(id);
    }

    @Override
    public Richiedente selectByID(Long id){ return richiedenteDAO.selectByID(id); }


}
