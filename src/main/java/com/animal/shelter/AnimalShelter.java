package com.animal.shelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.animal.ComponentScanMarker;

//SpringBootApplication makes it all work
//Turns on auto-configuration allowing open API as a dependency
//Allows Spring to load code
@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class AnimalShelter {

  public static void main(String[] args) {
    SpringApplication.run(AnimalShelter.class, args);

  }

}

