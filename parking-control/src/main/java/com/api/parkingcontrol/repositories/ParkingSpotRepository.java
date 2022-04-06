package com.api.parkingcontrol.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parkingcontrol.models.ParkingSpot;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {
	
	boolean existsByCarLicensePlate(String carLicensePlate);
	
	boolean existsByNumber(String number);
	
	List<ParkingSpot> findAll();
	
	Optional<ParkingSpot> findById(UUID id);
	
}
