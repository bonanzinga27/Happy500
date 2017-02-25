package it.uiip.digitalgarage.ebuonweekend.ibe;


import it.uiip.digitalgarage.ebuonweekend.entity.Organizzazione;

public interface OrganizzazioneService {

    boolean insert(Organizzazione o);
    boolean update(Organizzazione o);
    Organizzazione selectById(String id);

}
