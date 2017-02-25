package it.uiip.digitalgarage.ebuonweekend.idao;


import it.uiip.digitalgarage.ebuonweekend.entity.Organizzazione;

public interface OrganizzazioneDAO {

    boolean insert(Organizzazione o);
    boolean update(Organizzazione o);
    Organizzazione selectById(String id);

}
