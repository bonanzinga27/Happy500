package it.uiip.digitalgarage.ebuonweekend.dao;

import com.mysql.jdbc.Statement;
import it.uiip.digitalgarage.ebuonweekend.entity.Pratica;
import it.uiip.digitalgarage.ebuonweekend.idao.PraticaDAO;
import it.uiip.digitalgarage.ebuonweekend.utils.DateUtil;

import java.sql.SQLException;

import static it.uiip.digitalgarage.ebuonweekend.dao.DBController.*;

public class PraticaDAOImpl implements PraticaDAO{

    private final String INSERT = "INSERT INTO pratica (tipologia, importo, dataRichiesta, completata, numDipendenti, durata, iban, idRichiedente, idOrganizzazione, descrizioneProgetto, pdfPath) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public boolean insert(Pratica p) {
        try{

            if(connectDB(INSERT)) {
                stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, p.getTipologia());
                stmt.setString(2, String.valueOf(p.getImporto()));
                stmt.setString(3, DateUtil.format(p.getDataRichiesta()));
                stmt.setString(4, String.valueOf(p.getCompletata()));
                stmt.setString(5, String.valueOf(p.getNumDipendenti()));
                stmt.setString(6, String.valueOf(p.getDurata()));
                stmt.setString(7, p.getIban());
                stmt.setString(8, String.valueOf(p.getIdRichiedente()));
                stmt.setString(9, String.valueOf(p.getIdOrganizzazione()));
                stmt.setString(10, p.getDescrizioneProgetto());
                stmt.setString(11, p.getPdfPath());

                int result = stmt.executeUpdate();
                rs = stmt.getGeneratedKeys();

                if(rs.next()){
                    p.setId(rs.getInt(1));
                    disconnectDB();
                    return true;
                }
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            disconnectDB();
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }

        return false;


    }
}