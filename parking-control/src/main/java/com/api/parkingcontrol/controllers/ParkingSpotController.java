package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.data.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
	
	final ParkingSpotService service;
	
	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.service = parkingSpotService;
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO dto) {
		
		if(service.existsByLicensePlaceCar(dto.getCarLicensePlate())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflict: License Plate Car is already in use");
		}
		
		if(service.existsBySpotNumber(dto.getNumber())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflict: Parking Spot is already in use");
		}
		
		var model = new ParkingSpot();
		BeanUtils.copyProperties(dto, model);
		model.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.save(model));
	}
	
	@GetMapping(value = "/findAllSpots")
	public ResponseEntity<List<ParkingSpot>> getAllParkingSpots() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.findAll());
	}
	
	@GetMapping("/findById/")
	public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id) {
		Optional<ParkingSpot> parkingSpotModelOptional = service.findById(id);
		if(!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Parking Spot not found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
	}

	
}
