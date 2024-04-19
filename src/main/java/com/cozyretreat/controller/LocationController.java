package com.cozyretreat.controller;

import com.cozyretreat.entity.Location;
import com.cozyretreat.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/location")
public class LocationController {

    private final LocationService locationService;
    @PostMapping("/add")
    public ResponseEntity<Location> addLocation(@RequestBody String locationName) {
        Location location = locationService.addLocation(locationName);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    @PostMapping("/del")
    public ResponseEntity<?> deleteLocation(@RequestBody String locationName) {
        Location location = locationService.delLocation(locationName);
        if(location!=null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Record Not Found!",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/find")
    public ResponseEntity<?> findLocation(@RequestBody String locationName) {
        Location location = locationService.findLocation(locationName);
        if(location!=null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Record Not Found!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(@RequestParam int id, @RequestBody String newLocationName) {
        Location location = locationService.updateLocation(id, newLocationName);
        if(location!=null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Record Not Found!", HttpStatus.NOT_FOUND);
        }
    }
}
