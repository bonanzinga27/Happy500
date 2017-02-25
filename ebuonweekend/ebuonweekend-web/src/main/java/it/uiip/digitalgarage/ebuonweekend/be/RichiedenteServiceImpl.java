package it.uiip.digitalgarage.ebuonweekend.be;


import it.uiip.digitalgarage.ebuonweekend.entity.Organizzazione;
import it.uiip.digitalgarage.ebuonweekend.entity.Pratica;
import it.uiip.digitalgarage.ebuonweekend.entity.Richiedente;
import it.uiip.digitalgarage.ebuonweekend.ibe.RichiedenteService;
import it.uiip.digitalgarage.ebuonweekend.idao.RichiedenteDAO;
import it.uiip.digitalgarage.ebuonweekend.idao.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RichiedenteServiceImpl implements RichiedenteService {

    @Autowired
    RichiedenteDAO richiedenteDAO;


    @Override
    public boolean insert(Richiedente richiedente) {

        return richiedenteDAO.insert(richiedente);
    }

    @Override
    public boolean update(Richiedente richiedente) {
            return richiedenteDAO.update(richiedente);
    }
    @Override
    public boolean delete(Long id) {
        return richiedenteDAO.delete(id);
    }

    @Override
    public Richiedente selectByID(Long id){ return richiedenteDAO.selectByID(id); }


}
