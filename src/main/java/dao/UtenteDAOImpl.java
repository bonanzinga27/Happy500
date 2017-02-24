package dao;


import entity.Utente;
import idao.UtenteDAO;
import org.springframework.stereotype.Component;
import utils.Sha256Util;

import static dao.DBController.*;

import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UtenteDAOImpl implements UtenteDAO {
	
	private static final String INSERT = "INSERT INTO utenti (email, password) VALUES(?, ?)";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM utenti WHERE email=?";
	
	
	@Override
	public boolean insert(Utente user){
		
		try{
			if(!connectDB(INSERT)){
				return false;
			}
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getEmail());
			String pw = Sha256Util.sha256(user.getPassword());
			stmt.setString(2, pw);
			
			int result = stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setPassword(pw);
				
				disconnectDB();
				System.out.println("INSERT su utenti eseguita!");
				return true;
			}
			
		}catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
		
		return false;			
			
	}
	
	@Override
	public Utente selectByEmail(String email){
		
		Utente u = null;
		try{
			if(connectDB(SELECT_BY_EMAIL)){
				stmt.setString(1, email);
				rs = stmt.executeQuery();
				
				if(rs.next()){
					u = new Utente(rs.getInt(1), rs.getString(2), rs.getString(3));
					disconnectDB();
					return u;
				}
				else{
					disconnectDB();
					return null;
				}
			}		
		}catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
        return u;
		
		
	}
}