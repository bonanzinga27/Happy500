package dao;

import com.mysql.jdbc.Statement;
import entity.Richiedente;
import idao.RichiedenteDAO;
import org.springframework.stereotype.Component;
import utils.DateUtil;
import java.sql.SQLException;

import static dao.DBController.*;

/**
 * Created by gvasa on 23/02/2017.
 */
@Component
public class RichiedenteDAOImpl implements RichiedenteDAO {


        private static final String INSERT = "INSERT INTO richiedente (nome, cognome,codFisc, dataNascita, cittaNascita, provinciaNascita, telefono, cittaResidenza, provinciaResidenza,indirizzoResidenza,idUtente,emailRichiedente,cartaIdentitaPath,codFiscPath) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE richiedente SET nome=?, cognome=?, codFisc=? , dataNascita=?, cittaNascita=? ,provinciaNascita=?, telefono=?, cittaResidenza=?, provinciaResidenza=?, indirizzoResidenza=?, idUtente=?, emailRichiedente=?, cartaIdentitaPath=?, codFiscaPath=?, WHERE id=?";
    private static final String DELETE = "DELETE FROM richiedente WHERE id=?";
    private static final String SELECT_BY_ID = "SELECT * FROM richiedente WHERE id=?";


    @Override
    public boolean insert(Richiedente richiedente){

        try {

            if (!connectDB(INSERT)){
                return false;
            }
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, richiedente.getNome());
            stmt.setString(2, richiedente.getCognome());
            stmt.setString(3, richiedente.getCodFisc());
            //stmt.setString(3, user.getPassword());
            stmt.setString(4, DateUtil.format(richiedente.getDataNascita()));
            stmt.setString(5, richiedente.getCittaNascita());
            stmt.setString(6, richiedente.getProvinciaNascita());
            stmt.setString(7, richiedente.getTelefono());
            stmt.setString(8, richiedente.getCittaResidenza());
            stmt.setString(9, richiedente.getProvinciaResidenza());
            stmt.setString(10, richiedente.getIndirizzoResidenza());
            stmt.setInt(11, richiedente.getIdUtente());
            stmt.setString(12, richiedente.getEmailRichiedente());
            stmt.setString(13, richiedente.getCartaIdentitaPath());
            stmt.setString(14, richiedente.getCodFiscPath());

            int result = stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                richiedente.setId(rs.getInt(1));
            }

            disconnectDB();
            System.out.println("INSERT su richiedente eseguita!");
            return true;

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }

    }

    @Override
    public boolean update(Richiedente richiedente){
        try {
            if(!connectDB(UPDATE))
                return false;
            else {
                stmt.setString(1, richiedente.getNome());
                stmt.setString(2, richiedente.getCognome());
                stmt.setString(3, richiedente.getCodFisc());
                //stmt.setString(3, user.getPassword());
                stmt.setString(4, DateUtil.format(richiedente.getDataNascita()));
                stmt.setString(5, richiedente.getCittaNascita());
                stmt.setString(6, richiedente.getProvinciaNascita());
                stmt.setString(7, richiedente.getTelefono());
                stmt.setString(8, richiedente.getCittaResidenza());
                stmt.setString(9, richiedente.getProvinciaResidenza());
                stmt.setString(10, richiedente.getIndirizzoResidenza());
                stmt.setInt(11, richiedente.getIdUtente());
                stmt.setString(12, richiedente.getEmailRichiedente());
                stmt.setString(13, richiedente.getCartaIdentitaPath());
                stmt.setString(14, richiedente.getCodFiscPath());
                int rs = stmt.executeUpdate();
                if(rs == 0){
                    System.out.println("Richiedente non trovato!");
                    disconnectDB();
                    return false;
                }
                disconnectDB();
                return true;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
    }

    @Override
    public Richiedente selectByID(Integer id){
        Richiedente richiedente = null;
        try {

            if(connectDB(SELECT_BY_ID)) {
                stmt.setInt(1, id);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    richiedente = new Richiedente(id, rs.getString(1), rs.getString(2), rs.getString(3), DateUtil.parse(rs.getString(4)), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13),rs.getString(14));

                        disconnectDB();
                    return richiedente;
                } else {
                    disconnectDB();
                    return null;
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
        return richiedente;
    }
    @Override
    public boolean delete(Integer id){

        boolean returned = false;
        try {

            if (!connectDB(DELETE))
                return false;
            else {
                stmt.setInt(1, id);
                int rs = stmt.executeUpdate();
                if (rs == 0) {
                    System.out.println("ID not found!");
                    disconnectDB();
                    return false;
                } else {
                    System.out.println("Unregistered!");
                    returned = true;
                }
            }

        } catch(Exception e){
            System.out.println("Problema nella query unregister(): \n" + DELETE + "\n" + e);
            disconnectDB();
            return false;
        } finally{
            //chiusura connessione db
            disconnectDB();
        }
        return  returned;

    }

}
