package it.uiip.digitalgarage.ebuonweekend.be;

import it.uiip.digitalgarage.ebuonweekend.entity.Pratica;
import it.uiip.digitalgarage.ebuonweekend.entity.TipoFinanziamento;
import it.uiip.digitalgarage.ebuonweekend.ibe.PraticaService;
import it.uiip.digitalgarage.ebuonweekend.idao.PraticaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PraticaServiceImpl implements PraticaService {

    @Autowired
    PraticaDAO praticaDAO;

    @Override
    public boolean insert(Pratica p) {
        return praticaDAO.insert(p);
    }

    @Override
    public boolean update(Pratica p) {
        return praticaDAO.update(p);
    }

    @Override
    public  boolean updatePathPratica(Long idPratica,String path){
        return praticaDAO.updatePathPratica(idPratica,path);
    }

    @Override
    public TipoFinanziamento[] getAllTipoFinanziamento() {
        return praticaDAO.getAllTipoFinanziamento();
    }

    @Override
    public Pratica selectById(String id) {
        return praticaDAO.selectById(id);
    }

    @Override
    public Pratica[] selectAllCompleted(String email) {
        return praticaDAO.selectAllCompleted(email);
    }

    @Override
    public Pratica[] selectAllUncompleted(String email) {
        return praticaDAO.selectAllUncompleted(email);
    }
}