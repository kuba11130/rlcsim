package as.rlcsim.components.table.model;

import java.io.Serializable;

public class ModelDanych implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nazwa;
	private Boolean usun;
	private Integer numer;
	private static Integer liczbaElementow = 2;
	/**
	 * @return the nazwa
	 */
	public String getNazwa() {
		return nazwa;
	}
	/**
	 * @param nazwa the nazwa to set
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	/**
	 * @return the usun
	 */
	public Boolean getUsun() {
		return usun;
	}
	/**
	 * @param usun the usun to set
	 */
	public void setUsun(Boolean usun) {
		this.usun = usun;
	}
	/**
	 * @return the numer
	 */
	public Integer getNumer() {
		return numer;
	}
	/**
	 * @param numer the numer to set
	 */
	public void setNumer(Integer numer) {
		this.numer = numer;
	}
	/**
	 * @return the liczbaElementow
	 */
	public static Integer getLiczbaElementow() {
		return liczbaElementow;
	}
	public void add(String str, Boolean rdb, Integer itg){
		this.nazwa = str;
		this.usun = rdb;
		this.numer=itg;
	}
	

}
