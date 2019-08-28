package it.dstech.model;

public class Transazioni {

	private String data;
	private String descrizione;
	private String categoria;
	private double importo;

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Transazioni [data=" + data + ", descrizione=" + descrizione + ", categoria=" + categoria + ", importo="
				+ importo + "]";
	}

}
