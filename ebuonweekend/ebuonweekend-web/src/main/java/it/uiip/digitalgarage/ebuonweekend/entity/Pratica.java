package it.uiip.digitalgarage.ebuonweekend.entity;

import java.time.LocalDate;

public class Pratica{
	
	private long id;
	private String tipologia;
	private double importo;
	private LocalDate dataRichiesta;
	private int completata;
	private int numDipendenti;
	private int durata;
	private String iban;
	private String descrizioneProgetto;
	private String pdfPath;
	private long idRichiedente;
	private long idOrganizzazione;


	public Pratica(long id,
				   String tipologia,
				   double importo,
				   LocalDate dataRichiesta,
				   int completata,
				   int numDipendenti,
				   int durata,
				   String iban,
				   String descrizioneProgetto,
				   String pdfPath,
				   long idRichiedente,
				   long idOrganizzazione) {

		this.id = id;
		this.tipologia = tipologia;
		this.importo = importo;
		this.dataRichiesta = dataRichiesta;
		this.completata = completata;
		this.numDipendenti = numDipendenti;
		this.durata = durata;
		this.iban = iban;
		this.descrizioneProgetto = descrizioneProgetto;
		this.pdfPath = pdfPath;
		this.idRichiedente = idRichiedente;
		this.idOrganizzazione = idOrganizzazione;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public LocalDate getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(LocalDate dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public int getCompletata() {
		return completata;
	}

	public void setCompletata(int completata) {
		this.completata = completata;
	}

	public int getNumDipendenti() {
		return numDipendenti;
	}

	public void setNumDipendenti(int numDipendenti) {
		this.numDipendenti = numDipendenti;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getDescrizioneProgetto() {
		return descrizioneProgetto;
	}

	public void setDescrizioneProgetto(String descrizioneProgetto) {
		this.descrizioneProgetto = descrizioneProgetto;
	}

	public long getIdRichiedente() {
		return idRichiedente;
	}

	public void setIdRichiedente(long idRichiedente) {
		this.idRichiedente = idRichiedente;
	}

	public long getIdOrganizzazione() {
		return idOrganizzazione;
	}

	public void setIdOrganizzazione(long idOrganizzazione) {
		this.idOrganizzazione = idOrganizzazione;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}
}