package it.uiip.digitalgarage.ebuonweekend.dao;



import it.uiip.digitalgarage.ebuonweekend.entity.Utente;
import it.uiip.digitalgarage.ebuonweekend.idao.UtenteDAO;
import it.uiip.digitalgarage.ebuonweekend.utils.Sha256Util;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UtenteDAOImpl implements UtenteDAO {
	
	private static final String INSERT = "INSERT INTO utente (email, password) VALUES(?, ?)";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM utente WHERE email=?";
	
	
	@Override
	public boolean insert(Utente user){
		
		try{
			if(!DBController.connectDB(INSERT)){
				return false;
			}
			DBController.stmt = DBController.conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			DBController.stmt.setString(1, user.getEmail());
			String pw = Sha256Util.sha256(user.getPassword());
			DBController.stmt.setString(2, pw);
			
			int result = DBController.stmt.executeUpdate();
			DBController.rs = DBController.stmt.getGeneratedKeys();
			
			if(DBController.rs.next()){
				user.setId(DBController.rs.getInt(1));
				user.setPassword(pw);
				
				DBController.disconnectDB();
				System.out.println("INSERT su utenti eseguita!");
				return true;
			}
			
		}catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }
		
		return false;			
			
	}
	
	@Override
	public Utente selectByEmail(String email){
		
		Utente u = null;
		try{
			if(DBController.connectDB(SELECT_BY_EMAIL)){
				DBController.stmt.setString(1, email);
				DBController.rs = DBController.stmt.executeQuery();
				
				if(DBController.rs.next()){
					u = new Utente(DBController.rs.getInt(1), DBController.rs.getString(2), DBController.rs.getString(3));
					DBController.disconnectDB();
					return u;
				}
				else{
					DBController.disconnectDB();
					return null;
				}
			}		
		}catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBController.disconnectDB();
        }
        return u;
		
		
	}
}