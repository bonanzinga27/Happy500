package it.uiip.digitalgarage.ebuonweekend.idao;

import it.uiip.digitalgarage.ebuonweekend.entity.Pratica;
import it.uiip.digitalgarage.ebuonweekend.entity.TipoFinanziamento;

public interface PraticaDAO{

    boolean insert(Pratica p);
    boolean update(Pratica p);

    TipoFinanziamento[] getAllTipoFinanziamento();

    boolean updatePathPratica(Long idPratica,String path);



}