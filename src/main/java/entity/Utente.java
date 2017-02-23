package entity;

/**
 * Created by gvasa on 23/02/2017.
 */
public class Utente {

    private String nome;
    private String cognome;
    private String email;
    private String password;

    public Utente(String nome, String cognome, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void wrapperUpdater(Utente utente){
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);
        utente.setPassword(password);

    }
}
