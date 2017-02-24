package it.uiip.digitalgarage.ebuonweekend.be;

import it.uiip.digitalgarage.ebuonweekend.entity.Organizzazione;
import it.uiip.digitalgarage.ebuonweekend.ibe.OrganizzazioneService;
import org.springframework.stereotype.Service;

@Service
public class OrganizzazioneServiceImpl implements OrganizzazioneService {

    @Override
    public boolean insert(Organizzazione o) {
        return false;
    }
}
