package model;

import java.util.Objects;

public class Ikastetxea {
	
    private int ccen;
    private String nom;
    private String nome;
    private String dgenrc;
    private String dgenre;
    private String genr;
    private int muni;
    private String dmunic;
    private String dmunie;
    private String dterrc;
    private String dterre;
    private int depe;
    private String dtituc;
    private String dtitue;
    private String domi;
    private int cpos;
    private long tel1;
    private long tfax;
    private String email;
    private String pagina;
    private String coorX;
    private String coorY;
    private double latitud;
    private double longitud;
    
    
	public Ikastetxea() {}

	public Ikastetxea(int ccen, String nom, String nome, String dgenrc, String dgenre, String genr, int muni,
			String dmunic, String dmunie, String dterrc, String dterre, int depe, String dtituc, String dtitue,
			String domi, int cpos, long tel1, long tfax, String email, String pagina, String coorX, String coorY,
			double latitud, double longitud) {
		this.ccen = ccen;
		this.nom = nom;
		this.nome = nome;
		this.dgenrc = dgenrc;
		this.dgenre = dgenre;
		this.genr = genr;
		this.muni = muni;
		this.dmunic = dmunic;
		this.dmunie = dmunie;
		this.dterrc = dterrc;
		this.dterre = dterre;
		this.depe = depe;
		this.dtituc = dtituc;
		this.dtitue = dtitue;
		this.domi = domi;
		this.cpos = cpos;
		this.tel1 = tel1;
		this.tfax = tfax;
		this.email = email;
		this.pagina = pagina;
		this.coorX = coorX;
		this.coorY = coorY;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Ikastetxea [ccen=" + ccen + ", nom=" + nom + ", nome=" + nome + ", dgenrc=" + dgenrc + ", dgenre="
				+ dgenre + ", genr=" + genr + ", muni=" + muni + ", dmunic=" + dmunic + ", dmunie=" + dmunie
				+ ", dterrc=" + dterrc + ", dterre=" + dterre + ", depe=" + depe + ", dtituc=" + dtituc + ", dtitue="
				+ dtitue + ", domi=" + domi + ", cpos=" + cpos + ", tel1=" + tel1 + ", tfax=" + tfax + ", email="
				+ email + ", pagina=" + pagina + ", coorX=" + coorX + ", coorY=" + coorY + ", latitud=" + latitud
				+ ", longitud=" + longitud + "]";
	}

	public int getCcen() {
		return ccen;
	}

	public void setCcen(int ccen) {
		this.ccen = ccen;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDgenrc() {
		return dgenrc;
	}

	public void setDgenrc(String dgenrc) {
		this.dgenrc = dgenrc;
	}

	public String getDgenre() {
		return dgenre;
	}

	public void setDgenre(String dgenre) {
		this.dgenre = dgenre;
	}

	public String getGenr() {
		return genr;
	}

	public void setGenr(String genr) {
		this.genr = genr;
	}

	public int getMuni() {
		return muni;
	}

	public void setMuni(int muni) {
		this.muni = muni;
	}

	public String getDmunic() {
		return dmunic;
	}

	public void setDmunic(String dmunic) {
		this.dmunic = dmunic;
	}

	public String getDmunie() {
		return dmunie;
	}

	public void setDmunie(String dmunie) {
		this.dmunie = dmunie;
	}

	public String getDterrc() {
		return dterrc;
	}

	public void setDterrc(String dterrc) {
		this.dterrc = dterrc;
	}

	public String getDterre() {
		return dterre;
	}

	public void setDterre(String dterre) {
		this.dterre = dterre;
	}

	public int getDepe() {
		return depe;
	}

	public void setDepe(int depe) {
		this.depe = depe;
	}

	public String getDtituc() {
		return dtituc;
	}

	public void setDtituc(String dtituc) {
		this.dtituc = dtituc;
	}

	public String getDtitue() {
		return dtitue;
	}

	public void setDtitue(String dtitue) {
		this.dtitue = dtitue;
	}

	public String getDomi() {
		return domi;
	}

	public void setDomi(String domi) {
		this.domi = domi;
	}

	public int getCpos() {
		return cpos;
	}

	public void setCpos(int cpos) {
		this.cpos = cpos;
	}

	public long getTel1() {
		return tel1;
	}

	public void setTel1(long tel1) {
		this.tel1 = tel1;
	}

	public long getTfax() {
		return tfax;
	}

	public void setTfax(long tfax) {
		this.tfax = tfax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getCoorX() {
		return coorX;
	}

	public void setCoorX(String coorX) {
		this.coorX = coorX;
	}

	public String getCoorY() {
		return coorY;
	}

	public void setCoorY(String coorY) {
		this.coorY = coorY;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ccen, coorX, coorY, cpos, depe, dgenrc, dgenre, dmunic, dmunie, domi, dterrc, dterre,
				dtituc, dtitue, email, genr, latitud, longitud, muni, nom, nome, pagina, tel1, tfax);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ikastetxea other = (Ikastetxea) obj;
		return ccen == other.ccen && Objects.equals(coorX, other.coorX) && Objects.equals(coorY, other.coorY)
				&& cpos == other.cpos && depe == other.depe && Objects.equals(dgenrc, other.dgenrc)
				&& Objects.equals(dgenre, other.dgenre) && Objects.equals(dmunic, other.dmunic)
				&& Objects.equals(dmunie, other.dmunie) && Objects.equals(domi, other.domi)
				&& Objects.equals(dterrc, other.dterrc) && Objects.equals(dterre, other.dterre)
				&& Objects.equals(dtituc, other.dtituc) && Objects.equals(dtitue, other.dtitue)
				&& Objects.equals(email, other.email) && Objects.equals(genr, other.genr)
				&& Double.doubleToLongBits(latitud) == Double.doubleToLongBits(other.latitud)
				&& Double.doubleToLongBits(longitud) == Double.doubleToLongBits(other.longitud) && muni == other.muni
				&& Objects.equals(nom, other.nom) && Objects.equals(nome, other.nome)
				&& Objects.equals(pagina, other.pagina) && tel1 == other.tel1 && tfax == other.tfax;
	}

}
