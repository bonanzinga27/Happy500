package it.uiip.digitalgarage.ebuonweekend.ibe;

import it.uiip.digitalgarage.ebuonweekend.entity.Pratica;
import it.uiip.digitalgarage.ebuonweekend.entity.TipoFinanziamento;

public interface PraticaService{

    boolean insert(Pratica p);
    boolean update(Pratica p);
    Pratica selectById(String id);
    Pratica[] selectAllCompleted(String email);
    Pratica[] selectAllUncompleted(String email);



    TipoFinanziamento[] getAllTipoFinanziamento();
    boolean updatePathPratica(Long idPratica,String path);

}