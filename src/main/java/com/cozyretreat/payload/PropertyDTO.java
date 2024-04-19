package com.cozyretreat.payload;

import com.cozyretreat.entity.Country;
import com.cozyretreat.entity.Location;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PropertyDTO {

    private Location location;

    private Country country;

    private String propertyName;

    private Integer bedrooms;

    private Integer bathrooms;

    private Integer beds;

    private Integer guests;

    private Integer nightlyPrice;
}
