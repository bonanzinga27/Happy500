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
}
