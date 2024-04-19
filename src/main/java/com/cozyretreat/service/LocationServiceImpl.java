package com.cozyretreat.service;

import com.cozyretreat.entity.Location;
import com.cozyretreat.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    
    private final LocationRepository locationRepository;
    @Override
    public Location addLocation(String locationName) {
        Location location = new Location();
        location.setLocationName(locationName);
        return locationRepository.save(location);
    }

    @Override
    public Location delLocation(String locationName) {
        Location location = this.findLocation(locationName);
        if(location != null)
        {
            locationRepository.delete(location);
        }
        return location;
    }

    @Override
    public Location findLocation(String locationName) {
        Optional<Location> opt = locationRepository.findByLocationName(locationName);
        if(opt.isPresent())
        {
            return opt.get();
        }
        return null;
    }

    @Override
    public Location updateLocation(int id, String newLocationName) {
        Optional<Location> opt = locationRepository.findById(Long.valueOf(id));
        if(opt.isPresent())
        {
            Location location = opt.get();
            location.setLocationName(newLocationName);
            locationRepository.save(location);
            return location;
        }
        return null;
    }
}
