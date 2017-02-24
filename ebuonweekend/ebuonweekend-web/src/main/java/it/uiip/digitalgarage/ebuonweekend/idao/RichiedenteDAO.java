package it.uiip.digitalgarage.ebuonweekend.idao;


import it.uiip.digitalgarage.ebuonweekend.entity.Richiedente;


public interface RichiedenteDAO {

    boolean insert(Richiedente user);
    boolean update(Richiedente user);
    boolean delete(Long id);
    Richiedente selectByID(Long id);


}
