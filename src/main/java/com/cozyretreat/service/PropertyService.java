package com.cozyretreat.service;

import com.cozyretreat.entity.Property;
import com.cozyretreat.payload.PropertyDTO;

import java.util.List;

public interface PropertyService {
    List<Property> listPropertyByLocationOrCountry(String place);

    Property addProperty(PropertyDTO propertyDTO);

    Property delProperty(long id);

    Property findProperty(long id);

    Property updateProperty(long id, PropertyDTO dto);
}
