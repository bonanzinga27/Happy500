package it.uiip.digitalgarage.ebuonweekend.ibe;


import it.uiip.digitalgarage.ebuonweekend.entity.Richiedente;

public interface RichiedenteService {

    boolean insert(Richiedente user);
    boolean update(Richiedente user, String email);
    boolean delete(Long id);
    Richiedente selectByID(Long id);

}
