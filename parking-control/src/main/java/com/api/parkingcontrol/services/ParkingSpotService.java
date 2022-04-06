package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

//TODO: Implementar uma Interface e fazer com esta classe implemente ela.

@Service
public class ParkingSpotService {
	
	final ParkingSpotRepository repository;
	
	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.repository = parkingSpotRepository;
	}

	@Transactional
	public ParkingSpot save(ParkingSpot model) {
		return repository.save(model);
	}

	public boolean existsByLicensePlaceCar(String carLicensePlate) {
		return repository.existsByCarLicensePlate(carLicensePlate);
	}

	public boolean existsBySpotNumber(String number) {
		return repository.existsByNumber(number);
	}
	
	public List<ParkingSpot> findAll() {
		return repository.findAll();
	}
	
	public Optional<ParkingSpot> findById(UUID id) {
		return repository.findById(id);
	}
	
	
	
}
 