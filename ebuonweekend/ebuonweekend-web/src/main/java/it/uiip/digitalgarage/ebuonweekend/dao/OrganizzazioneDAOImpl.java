package it.uiip.digitalgarage.ebuonweekend.dao;

import it.uiip.digitalgarage.ebuonweekend.entity.Organizzazione;
import it.uiip.digitalgarage.ebuonweekend.idao.OrganizzazioneDAO;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.Statement;

import static it.uiip.digitalgarage.ebuonweekend.dao.DBController.*;

@Component
public class OrganizzazioneDAOImpl implements OrganizzazioneDAO {

    private final String INSERT = "INSERT INTO organizzazione (denominazione, ragioneSociale, piva, cittaSede, indirizzoSede, provinciaSede, capSede, statoSede, emailOrganizzazione) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE organizzazione SET denominazione=?, ragioneSociale=?, piva=? , cittaSede=?, indirizzoSede=? ,provinciaSede=?, capSede=?, statoSede=?, emailOrganizzazione=? WHERE id=?";
    private final String SELECT_BY_ID = "SELECT * FROM organizzazione WHERE id=?";

    @Override
    public boolean insert(Organizzazione o) {

        try{
            if(connectDB(INSERT)){
                stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, o.getDenominazione());
                stmt.setString(2, o.getRagioneSociale());
                stmt.setString(3, o.getPiva());
                stmt.setString(4, o.getCittaSede());
                stmt.setString(5, o.getIndirizzoSede());
                stmt.setString(6, o.getProvinciaSede());
                stmt.setString(7, o.getCapSede());
                stmt.setString(8, o.getStatoSede());
                stmt.setString(9, o.getEmailOrganizzazione());

                int result  = stmt.executeUpdate();
                rs = stmt.getGeneratedKeys();
                if(rs.next()) {
                    o.setId(rs.getInt(1));
                    disconnectDB();
                    return true;
                }

            }

        }catch (SQLException e) {
            // e.printStackTrace();
            disconnectDB();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }
        return false;
    }

    @Override
    public boolean update(Organizzazione o) {

        try{
            if(connectDB(UPDATE)){
                stmt.setString(1, o.getDenominazione());
                stmt.setString(2, o.getRagioneSociale());
                stmt.setString(3, o.getPiva());
                stmt.setString(4, o.getCittaSede());
                stmt.setString(5, o.getIndirizzoSede());
                stmt.setString(6, o.getProvinciaSede());
                stmt.setString(7, o.getCapSede());
                stmt.setString(8, o.getStatoSede());
                stmt.setString(9, o.getEmailOrganizzazione());
                stmt.setInt(10, o.getId());
                int rs = stmt.executeUpdate();

                if(rs == 0){
                    System.out.println("Organizzazione non trovata!");
                    DBController.disconnectDB();
                    return false;
                }
                DBController.disconnectDB();
                return true;
            }

        }catch (SQLException e) {
            // e.printStackTrace();
            disconnectDB();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }
        return false;

    }

    @Override
    public Organizzazione selectById(String id) {

        Organizzazione o = null;
        try {

            if(DBController.connectDB(SELECT_BY_ID)) {
                DBController.stmt.setString(1, id);
                DBController.rs = DBController.stmt.executeQuery();

                if (DBController.rs.next()) {
                    o = new Organizzazione(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                    DBController.disconnectDB();
                    return o;
                } else {
                    DBController.disconnectDB();
                    return null;
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            disconnectDB();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }
        return o;

    }
}
