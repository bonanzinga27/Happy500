package it.uiip.digitalgarage.ebuonweekend.dao;

import com.mysql.jdbc.Statement;
import it.uiip.digitalgarage.ebuonweekend.entity.Pratica;
import it.uiip.digitalgarage.ebuonweekend.entity.TipoFinanziamento;
import it.uiip.digitalgarage.ebuonweekend.idao.PraticaDAO;
import it.uiip.digitalgarage.ebuonweekend.utils.DateUtil;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

import static it.uiip.digitalgarage.ebuonweekend.dao.DBController.*;

@Component
public class PraticaDAOImpl implements PraticaDAO{

    private final String INSERT = "INSERT INTO pratica (tipologia, importo, dataRichiesta, completata, numDipendenti, durata, iban, idRichiedente, idOrganizzazione, descrizioneProgetto, pdfPath, emailUtente) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE pratica SET importo=?, completata=?, numDipendenti=?, durata=?, iban=?, descrizioneProgetto=? WHERE id=?";
    private final String SELECT_BY_ID = "SELECT * FROM pratica WHERE id =?";
    private final String SELECT_ALL_FINANZIAMENTO = "SELECT * FROM tipofinanziamento";
    private static final String UPDATE_PATH = "UPDATE pratica SET pdfPath=? WHERE id=?";


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
                stmt.setString(12, p.getEmailUtente());

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

    @Override
    public boolean update(Pratica p) {
        //UPDATE pratica SET importo=?, completata=?, numDipendenti=?, durata=?, iban=?, descrizioneProgetto=? WHERE id=?
        try{
            if(connectDB(UPDATE)){
                stmt.setDouble(1, p.getImporto());
                stmt.setInt(2, p.getCompletata());
                stmt.setInt(3, p.getNumDipendenti());
                stmt.setInt(4, p.getNumDipendenti());
                stmt.setString(5, p.getIban());
                stmt.setString(6, p.getDescrizioneProgetto());
                stmt.setLong(7, p.getId());
                int rs = stmt.executeUpdate();
                if(rs == 0){
                    System.out.println("Pratica non trovata!");
                    DBController.disconnectDB();
                    return false;
                }
                DBController.disconnectDB();
                return true;
            }
        }catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }
        return false;

    }

    @Override
    public  boolean updatePathPratica(Long idPratica,String path){
        try {
            if(!DBController.connectDB(UPDATE_PATH))
                return false;
            else {
                DBController.stmt.setString(1, path);
                DBController.stmt.setLong(2, idPratica);
                int rs = DBController.stmt.executeUpdate();
                if(rs == 0){
                    System.out.println("Richiedente non trovato!");
                    DBController.disconnectDB();
                    return false;
                }
                DBController.disconnectDB();
                return true;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }
    }

    @Override
    public Pratica selectById(String id) {

        Pratica p = null;
        try {

            if(DBController.connectDB(SELECT_BY_ID)) {
                DBController.stmt.setString(1, id);
                DBController.rs = DBController.stmt.executeQuery();

                if (DBController.rs.next()) {
                    p = new Pratica(rs.getInt(1), rs.getString(2), rs.getDouble(3), DateUtil.parse(rs.getString(4)), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13));
                    DBController.disconnectDB();
                    return p;
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
        return p;

    }

    @Override
    public TipoFinanziamento[] getAllTipoFinanziamento() {
        TipoFinanziamento t[] = null;
        int i = 0;

        try{
            if(connectDB(SELECT_ALL_FINANZIAMENTO)){
                rs = stmt.executeQuery();

                if(rs.next()){
                    rs.last();
                    t = new TipoFinanziamento[rs.getRow()];
                    rs.first();
                    do{
                        t[i] = new TipoFinanziamento(rs.getInt(1), rs.getString(2), rs.getString(3));
                        rs.next();
                        i++;
                    }while(i<t.length);

                    disconnectDB();
                    return t;
                }
            }

        }catch (SQLException e) {
            // e.printStackTrace();
            disconnectDB();
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
        return t;
    }
}