package it.uiip.digitalgarage.ebuonweekend.entity;


public class Organizzazione {
    private int id;
    private String denominazione;
    private String ragioneSociale;
    private String piva;
    private String cittaSede;
    private String indirizzoSede;
    private String provinciaSede;
    private String capSede;
    private String statoSede;
    private String emailOrganizzazione;

    public Organizzazione(int id, String denominazione, String ragioneSociale, String piva, String cittaSede, String indirizzoSede, String provinciaSede, String capSede, String statoSede, String emailOrganizzazione) {
        this.id = id;
        this.denominazione = denominazione;
        this.ragioneSociale = ragioneSociale;
        this.piva = piva;
        this.cittaSede = cittaSede;
        this.indirizzoSede = indirizzoSede;
        this.provinciaSede = provinciaSede;
        this.capSede = capSede;
        this.statoSede = statoSede;
        this.emailOrganizzazione = emailOrganizzazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getCittaSede() {
        return cittaSede;
    }

    public void setCittaSede(String cittaSede) {
        this.cittaSede = cittaSede;
    }

    public String getIndirizzoSede() {
        return indirizzoSede;
    }

    public void setIndirizzoSede(String indirizzoSede) {
        this.indirizzoSede = indirizzoSede;
    }

    public String getProvinciaSede() {
        return provinciaSede;
    }

    public void setProvinciaSede(String provinciaSede) {
        this.provinciaSede = provinciaSede;
    }

    public String getCapSede() {
        return capSede;
    }

    public void setCapSede(String capSede) {
        this.capSede = capSede;
    }

    public String getStatoSede() {
        return statoSede;
    }

    public void setStatoSede(String statoSede) {
        this.statoSede = statoSede;
    }

    public String getEmailOrganizzazione() {
        return emailOrganizzazione;
    }

    public void setEmailOrganizzazione(String emailOrganizzazione) {
        this.emailOrganizzazione = emailOrganizzazione;
    }
}
