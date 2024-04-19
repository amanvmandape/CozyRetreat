package com.cozyretreat.service;

import com.cozyretreat.entity.Location;

public interface LocationService {
    Location addLocation(String locationName);
    Location delLocation(String locationName);
    Location findLocation(String locationName);
    Location updateLocation(int id, String newLocationName);
}
