package com.cozyretreat.controller;

import com.cozyretreat.entity.Property;
import com.cozyretreat.payload.PropertyDTO;
import com.cozyretreat.repository.PropertyRepository;
import com.cozyretreat.service.PropertyService;
import com.cozyretreat.service.PropertyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app/property")
public class PropertyController {

    private final PropertyService propertyService;
    @GetMapping("/listings/{location}")
    public ResponseEntity<?> getPropertyListings(@PathVariable("location") String location_name) {
        List<Property> propertiesList = propertyService.listPropertyByLocationOrCountry(location_name);
        if(!propertiesList.isEmpty())
        {
            return new ResponseEntity<>(propertiesList, HttpStatus.OK);
        }
        return new ResponseEntity<>("No Properties Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Property> addProperty(@RequestBody PropertyDTO propertyDTO)
    {
        Property property = propertyService.addProperty(propertyDTO);
        return new ResponseEntity<>(property, HttpStatus.CREATED);
    }

    @PostMapping("/del")
    public ResponseEntity<?> delProperty(@RequestParam long id)
    {
        Property property = propertyService.delProperty(id);
        if(property != null)
        {
            return new ResponseEntity<>(property, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Property Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/find")
    public ResponseEntity<?> findProperty(@RequestParam long id)
    {
        Property property = propertyService.findProperty(id);
        if (property != null)
        {
            return new ResponseEntity<>(property, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Property Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/update")
    public ResponseEntity<Property> updateProperty(@RequestParam long id, @RequestBody PropertyDTO dto)
    {
        Property property = propertyService.updateProperty(id, dto);
        return new ResponseEntity<>(property, HttpStatus.CREATED);
    }

}
