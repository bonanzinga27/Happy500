package it.uiip.digitalgarage.ebuonweekend.dao;


import it.uiip.digitalgarage.ebuonweekend.entity.Utente;
import it.uiip.digitalgarage.ebuonweekend.idao.UtenteDAO;
import org.springframework.stereotype.Component;
import it.uiip.digitalgarage.ebuonweekend.utils.Sha256Util;

import static it.uiip.digitalgarage.ebuonweekend.dao.DBController.*;

import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UtenteDAOImpl implements UtenteDAO {
	
	private static final String INSERT = "INSERT INTO utente (email, password) VALUES(?, ?)";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM utente WHERE email=?";
	private static final String SELECT_BY_EMAIL_PASS="SELECT * FROM utente WHERE nickName=? AND password=?";
	
	
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
	public boolean authentication(Utente u) {
		String email = u.getEmail();
		String pass = Sha256Util.sha256(u.getPassword());

		try{
			if(connectDB(SELECT_BY_EMAIL_PASS)){
				stmt.setString(1, email);
				stmt.setString(2, pass);
				rs = stmt.executeQuery();

				if(rs.next()){
					u.setId(rs.getInt(1));
					u.setEmail(rs.getString(2));
					u.setPassword(rs.getString(3));

					disconnectDB();
					return true;
				}
			}
		}catch (SQLException e) {
			// e.printStackTrace();
			disconnectDB();
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