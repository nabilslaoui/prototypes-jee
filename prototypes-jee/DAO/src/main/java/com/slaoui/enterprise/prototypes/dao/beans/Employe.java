package com.slaoui.enterprise.prototypes.dao.beans;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class Employe {

	private int id;
	private String login;
	private String password;
	private String prenom;
	private String nom;
	private String email;
	private String role;

	/**
	 * 
	 */
	public Employe() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param login
	 * @param password
	 * @param prenom
	 * @param nom
	 * @param email
	 * @param role
	 */
	public Employe(int id, String login, String password, String prenom, String nom, String email, String role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// first day of Ramadan, 9th month
		final HijrahDate ramadan = HijrahDate.now().with(ChronoField.DAY_OF_MONTH, 1).with(ChronoField.MONTH_OF_YEAR,
				9);
		System.out.println("HijrahDate : " + ramadan);

		// HijrahDate -> LocalDate
		System.out.println("\n--- Ramandan 2016 ---");
		System.out.println("Start : " + LocalDate.from(ramadan));

		// until the end of the month
		System.out.println("End : " + LocalDate.from(ramadan.with(TemporalAdjusters.lastDayOfMonth())));

	}

}
