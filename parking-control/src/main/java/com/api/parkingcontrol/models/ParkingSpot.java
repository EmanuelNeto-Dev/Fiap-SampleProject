package com.api.parkingcontrol.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpot implements Serializable {
	
	private static final long serialVersionUID =  1L;
	
	/* ATTRIBUTES */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, unique = true, length = 10)
	private String number;
	
	@Column(nullable = false, unique = true, length = 7)
	private String carLicensePlate;
	
	@Column(nullable = false, length = 70)
	private String carBrand;
	
	@Column(nullable = false, length = 70)
	private String carModel;
	
	@Column(nullable = false, length = 70)
	private String carColor;
	
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	
	@Column(nullable = false, length = 130)
	private String responsibleName;
	
	@Column(nullable = false, length = 30)
	private String responsibleApartment;
	
	@Column(nullable = false, length = 30)
	private String responsibleBlock;

	
	/* GETTERS AND SETTERS */
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getResponsibleApartment() {
		return responsibleApartment;
	}

	public void setResponsibleApartment(String responsibleApartment) {
		this.responsibleApartment = responsibleApartment;
	}

	public String getResponsibleBlock() {
		return responsibleBlock;
	}

	public void setResponsibleBlock(String responsibleBlock) {
		this.responsibleBlock = responsibleBlock;
	}
	
	
}
