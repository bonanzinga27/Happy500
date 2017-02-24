package it.uiip.digitalgarage.ebuonweekend.entity;

import java.time.LocalDate;


public class Richiedente {
    private Long id;
    private String nome;
    private String cognome;
    private String codFisc;
    private LocalDate dataNascita;
    private String cittaNascita;
    private String provinciaNascita;
    private String telefono;
    private String cittaResidenza;
    private String provinciaResidenza;
    private String indirizzoResidenza;
    private Long idUtente;
    private String emailRichiedente;
    private String cartaIdentitaPath;
    private String codFiscPath;
    private String sesso;

    public Richiedente(Long id, String nome, String cognome, String codFisc, LocalDate dataNascita, String cittaNascita, String provinciaNascita, String telefono, String cittaResidenza, String provinciaResidenza, String indirizzoResidenza, Long idUtente, String emailRichiedente, String cartaIdentitaPath, String codFiscPath, String sesso) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.codFisc = codFisc;
        this.dataNascita = dataNascita;
        this.cittaNascita = cittaNascita;
        this.provinciaNascita = provinciaNascita;
        this.telefono = telefono;
        this.cittaResidenza = cittaResidenza;
        this.provinciaResidenza = provinciaResidenza;
        this.indirizzoResidenza = indirizzoResidenza;
        this.idUtente = idUtente;
        this.emailRichiedente = emailRichiedente;
        this.cartaIdentitaPath = cartaIdentitaPath;
        this.codFiscPath = codFiscPath;
        this.sesso = sesso;
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

    public String getCodFisc() {
        return codFisc;
    }

    public void setCodFisc(String codFisc) {
        this.codFisc = codFisc;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCittaNascita() {
        return cittaNascita;
    }

    public void setCittaNascita(String cittaNascita) {
        this.cittaNascita = cittaNascita;
    }

    public String getProvinciaNascita() {
        return provinciaNascita;
    }

    public void setProvinciaNascita(String provinciaNascita) {
        this.provinciaNascita = provinciaNascita;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCittaResidenza() {
        return cittaResidenza;
    }

    public void setCittaResidenza(String cittaResidenza) {
        this.cittaResidenza = cittaResidenza;
    }

    public String getProvinciaResidenza() {
        return provinciaResidenza;
    }

    public void setProvinciaResidenza(String provinciaResidenza) {
        this.provinciaResidenza = provinciaResidenza;
    }

    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    public void setIndirizzoResidenza(String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public String getEmailRichiedente() {
        return emailRichiedente;
    }

    public void setEmailRichiedente(String emailRichiedente) {
        this.emailRichiedente = emailRichiedente;
    }

    public String getCartaIdentitaPath() {
        return cartaIdentitaPath;
    }

    public void setCartaIdentitaPath(String cartaIdentitaPath) {
        this.cartaIdentitaPath = cartaIdentitaPath;
    }

    public String getCodFiscPath() {
        return codFiscPath;
    }

    public void setCodFiscPath(String codFiscPath) {
        this.codFiscPath = codFiscPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
}
