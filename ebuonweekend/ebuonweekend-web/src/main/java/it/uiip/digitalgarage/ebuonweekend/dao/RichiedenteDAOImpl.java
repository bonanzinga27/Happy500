package it.uiip.digitalgarage.ebuonweekend.dao;

import com.mysql.jdbc.Statement;

import it.uiip.digitalgarage.ebuonweekend.entity.Richiedente;
import it.uiip.digitalgarage.ebuonweekend.idao.RichiedenteDAO;
import it.uiip.digitalgarage.ebuonweekend.utils.DateUtil;
import org.springframework.stereotype.Component;

import static it.uiip.digitalgarage.ebuonweekend.dao.DBController.*;

import java.sql.SQLException;

@Component
public class RichiedenteDAOImpl implements RichiedenteDAO {


    private static final String INSERT = "INSERT INTO richiedente (nome, cognome,codFisc, dataNascita, cittaNascita, provNascita, telefono, cittaResidenza, provResidenza,indirizzoResidenza,emailRichiedente,cartaIdentitaPath,codFiscPath, sesso) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
    private static final String UPDATE = "UPDATE richiedente SET nome=?, cognome=?, codFisc=? , dataNascita=?, cittaNascita=? ,provinciaNascita=?, telefono=?, cittaResidenza=?, provinciaResidenza=?, indirizzoResidenza=?, emailRichiedente=?, cartaIdentitaPath=?, codFiscPath=? WHERE id=?";
    private static final String DELETE = "DELETE FROM richiedente WHERE id=?";
    private static final String SELECT_BY_ID = "SELECT * FROM richiedente WHERE id=?";


    @Override
    public boolean insert(Richiedente richiedente){

        //INSERT INTO richiedente (nome, cognome,codFisc, dataNascita, cittaNascita, provinciaNascita, telefono, cittaResidenza, provinciaResidenza,
        //                          indirizzoResidenza,emailRichiedente,cartaIdentitaPath,codFiscPath)
        // VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            if (!DBController.connectDB(INSERT)){
                return false;
            }
            DBController.stmt = DBController.conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            DBController.stmt.setString(1, richiedente.getNome());
            DBController.stmt.setString(2, richiedente.getCognome());
            DBController.stmt.setString(3, richiedente.getCodFisc());
            //stmt.setString(3, user.getPassword());
            DBController.stmt.setString(4, DateUtil.format(richiedente.getDataNascita()));
            DBController.stmt.setString(5, richiedente.getCittaNascita());
            DBController.stmt.setString(6, richiedente.getProvinciaNascita());
            DBController.stmt.setString(7, richiedente.getTelefono());
            DBController.stmt.setString(8, richiedente.getCittaResidenza());
            DBController.stmt.setString(9, richiedente.getProvinciaResidenza());
            DBController.stmt.setString(10, richiedente.getIndirizzoResidenza());
            DBController.stmt.setString(11, richiedente.getEmailRichiedente());
            DBController.stmt.setString(12, richiedente.getCartaIdentitaPath());
            DBController.stmt.setString(13, richiedente.getCodFiscPath());
            DBController.stmt.setString(14, richiedente.getSesso());

            int result = DBController.stmt.executeUpdate();
            DBController.rs = DBController.stmt.getGeneratedKeys();

            if (DBController.rs.next()) {
                richiedente.setId(DBController.rs.getLong(1));
            }

            DBController.disconnectDB();
            System.out.println("INSERT su richiedente eseguita!");
            return true;

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }

    }

    @Override
    public boolean update(Richiedente richiedente){

        //UPDATE richiedente SET nome=?, cognome=?, codFisc=? , dataNascita=?, cittaNascita=? ,provinciaNascita=?, telefono=?, cittaResidenza=?,
        //                       provinciaResidenza=?, indirizzoResidenza=?, emailRichiedente=?, cartaIdentitaPath=?, codFiscaPath=?
        // WHERE id=?"
        try {
            if(!DBController.connectDB(UPDATE))
                return false;
            else {
                DBController.stmt.setString(1, richiedente.getNome());
                DBController.stmt.setString(2, richiedente.getCognome());
                DBController.stmt.setString(3, richiedente.getCodFisc());
                //stmt.setString(3, user.getPassword());
                DBController.stmt.setString(4, DateUtil.format(richiedente.getDataNascita()));
                DBController.stmt.setString(5, richiedente.getCittaNascita());
                DBController.stmt.setString(6, richiedente.getProvinciaNascita());
                DBController.stmt.setString(7, richiedente.getTelefono());
                DBController.stmt.setString(8, richiedente.getCittaResidenza());
                DBController.stmt.setString(9, richiedente.getProvinciaResidenza());
                DBController.stmt.setString(10, richiedente.getIndirizzoResidenza());
                DBController.stmt.setString(11, richiedente.getEmailRichiedente());
                DBController.stmt.setString(12, richiedente.getCartaIdentitaPath());
                DBController.stmt.setString(13, richiedente.getCodFiscPath());
                DBController.stmt.setString(14, String.valueOf(richiedente.getId()));
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
    public Richiedente selectByID(Long id){
        Richiedente richiedente = null;
        try {

            if(DBController.connectDB(SELECT_BY_ID)) {
                DBController.stmt.setLong(1, id);
                DBController.rs = DBController.stmt.executeQuery();

                if (DBController.rs.next()) {
                    richiedente = new Richiedente(rs.getLong(1), DBController.rs.getString(2), DBController.rs.getString(3), DBController.rs.getString(4), DateUtil.parse(DBController.rs.getString(5)), DBController.rs.getString(6), DBController.rs.getString(7), DBController.rs.getString(8), DBController.rs.getString(9), DBController.rs.getString(10), DBController.rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));

                        DBController.disconnectDB();
                    return richiedente;
                } else {
                    DBController.disconnectDB();
                    return null;
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }
        return richiedente;
    }
    @Override
    public boolean delete(Long id){

        boolean returned = false;
        try {

            if (!DBController.connectDB(DELETE))
                return false;
            else {
                DBController.stmt.setLong(1, id);
                int rs = DBController.stmt.executeUpdate();
                if (rs == 0) {
                    System.out.println("ID not found!");
                    DBController.disconnectDB();
                    return false;
                } else {
                    System.out.println("Unregistered!");
                    returned = true;
                }
            }

        } catch(Exception e){
            System.out.println("Problema nella query unregister(): \n" + DELETE + "\n" + e);
            DBController.disconnectDB();
            return false;
        } finally{
            //chiusura connessione db
            DBController.disconnectDB();
        }
        return  returned;

    }

}
