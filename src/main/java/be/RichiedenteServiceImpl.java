package be;

import entity.Richiedente;
import ibe.RichiedenteService;
import idao.RichiedenteDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gvasa on 23/02/2017.
 */
public class RichiedenteServiceImpl implements RichiedenteService {
    @Autowired
    RichiedenteDAO richiedenteDAO;

    @Override
    public boolean insert(Richiedente richiedente) {
        if (richiedenteDAO.selectByID(richiedente.getId()) != null) {
            System.out.println("Richiedente già esistente!");
            return false;
        } else {
            return richiedenteDAO.insert(richiedente);
        }
    }

    @Override
    public boolean update(Richiedente richiedente) {
            return richiedenteDAO.update(richiedente);


    }
    @Override
    public boolean delete(Integer id) {
        return richiedenteDAO.delete(id);
    }

    @Override
    public Richiedente selectByID(Integer id){ return richiedenteDAO.selectByID(id); }


}
