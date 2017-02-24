package idao;

import entity.Richiedente;

/**
 * Created by gvasa on 23/02/2017.
 */
public interface RichiedenteDAO {

    boolean insert(Richiedente user);
    boolean update(Richiedente user);
    boolean delete(Integer id);
    Richiedente selectByID(Integer id);


}
