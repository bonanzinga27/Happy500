package it.uiip.digitalgarage.ebuonweekend.be;

import it.uiip.digitalgarage.ebuonweekend.entity.Organizzazione;
import it.uiip.digitalgarage.ebuonweekend.ibe.OrganizzazioneService;
import it.uiip.digitalgarage.ebuonweekend.idao.OrganizzazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizzazioneServiceImpl implements OrganizzazioneService {

    @Autowired
    OrganizzazioneDAO organizzazioneDAO;

    @Override
    public boolean insert(Organizzazione o) {
        return organizzazioneDAO.insert(o);
    }

    @Override
    public boolean update(Organizzazione o) {
        return organizzazioneDAO.update(o);
    }

    @Override
    public Organizzazione selectById(String id) {
        return organizzazioneDAO.selectById(id);
    }
}
