package com.matejko.model.standard;

import java.util.List;

import lombok.Value;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@Value
public class Profile {
	Materials materials;
	List<Planet> planets;
}
