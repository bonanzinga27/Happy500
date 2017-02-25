package it.uiip.digitalgarage.ebuonweekend.ibe;

import it.uiip.digitalgarage.ebuonweekend.entity.Pratica;
import it.uiip.digitalgarage.ebuonweekend.entity.TipoFinanziamento;

public interface PraticaService{

    boolean insert(Pratica p);



    TipoFinanziamento[] getAllTipoFinanziamento();
    boolean updatePathPratica(Long idPratica,String path);

}