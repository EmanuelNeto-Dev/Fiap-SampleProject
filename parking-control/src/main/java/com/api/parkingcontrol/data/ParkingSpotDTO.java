package com.api.parkingcontrol.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDTO {
	
	@NotBlank
	private String number;
	
	@NotBlank
	@Size(max = 7)
	private String carLicensePlate;
	
	@NotBlank
	private String carBrand;
	
	@NotBlank
	private String carModel;
	
	@NotBlank
	private String carColor;
	
	@NotBlank
	private String responsibleName;
	
	@NotBlank
	private String responsibleApartment;
	
	@NotBlank
	private String responsibleBlock;

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
