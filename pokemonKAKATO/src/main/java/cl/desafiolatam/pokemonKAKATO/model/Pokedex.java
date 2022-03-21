package cl.desafiolatam.pokemonKAKATO.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pokedex {

	private int idPokedex;
	private int id_Pokemon;
	private Date date ;
	private String lugar;
	private String huevo;
	private float peso;
	private float estatura;
	public int getIdPokedex() {
		return idPokedex;
	}
	public void setIdPokedex(int idPokedex) {
		this.idPokedex = idPokedex;
	}
	public int getId_Pokemon() {
		return id_Pokemon;
	}
	public void setId_Pokemon(int id_Pokemon) {
		this.id_Pokemon = id_Pokemon;
	}		
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getHuevo() {
		return huevo;
	}
	public void setHuevo(String huevo) {
		this.huevo = huevo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
