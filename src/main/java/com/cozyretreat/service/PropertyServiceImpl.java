package com.cozyretreat.service;

import com.cozyretreat.entity.Property;
import com.cozyretreat.payload.PropertyDTO;
import com.cozyretreat.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService{

    private final PropertyRepository propertyRepository;
    @Override
    public List<Property> listPropertyByLocationOrCountry(String place) {
        return propertyRepository.listPropertyByLocationOrCountry(place);
    }

    @Override
    public Property addProperty(PropertyDTO propertyDTO) {
        Property property = mapToEntity(propertyDTO);
        return propertyRepository.save(property);
    }

    @Override
    public Property delProperty(long id) {
        Property property = findProperty(id);
        if (property != null) {
            propertyRepository.delete(property);
        }
        return property;
    }

    @Override
    public Property findProperty(long id) {
        Optional<Property> opt = propertyRepository.findById(id);
        if(opt.isPresent())
        {
            return opt.get();
        }
        return null;
    }

    @Override
    public Property updateProperty(long id, PropertyDTO dto) {
        if(propertyRepository.existsById(id))
        {
            Property property = mapToEntity(dto);
            property.setId(id);
            return propertyRepository.save(property);
        }
        return null;
    }

    private Property mapToEntity(PropertyDTO propertyDTO) {
        Property property = new Property();
        property.setLocation(propertyDTO.getLocation());
        property.setCountry(propertyDTO.getCountry());
        property.setPropertyName(propertyDTO.getPropertyName());
        property.setBedrooms(propertyDTO.getBedrooms());
        property.setBathrooms(propertyDTO.getBathrooms());
        property.setBeds(propertyDTO.getBeds());
        property.setGuests(propertyDTO.getGuests());
        property.setNightlyPrice(propertyDTO.getNightlyPrice());
        return property;
    }
}
