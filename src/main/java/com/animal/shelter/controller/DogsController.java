package com.animal.shelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.animal.shelter.controller.model.DogsDto;
import com.animal.shelter.entity.Clients;
import com.animal.shelter.entity.Size;
import com.animal.shelter.entity.Dogs;
import com.animal.shelter.entity.Gender;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Dogs")
@OpenAPIDefinition(info = @Info(title = "Animal Shelter"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})

public interface DogsController {

  // Reads a list of ALL dogs

  //@formatter:off
    @Operation(
        summary = "Returns a list of all the dogs",
        description = "Returns the list of dogs",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of dogs is returned.", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Dogs.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No dogs were found with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json")),
       }
    )
    @GetMapping("/allDogs")
    @ResponseStatus(code = HttpStatus.OK)
    List<Dogs> fetchAllDogs(); 
    
  //Reads a list of ALL dogs with a specified size 
    
    @Operation(
        summary = "Returns a list of dogs based on size",
        description = "Returns a list of dogs given a dog's size",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of dogs is returned based on dog's size.", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Clients.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No dogs were found with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "size",
                allowEmptyValue = false,
                required = false,
                description = "The client's size (i.e., 'Toy')") 
       }
    )
    
    // Get method (read)
    @GetMapping("/dogsBySize")
    @ResponseStatus(code = HttpStatus.OK)
    List<Dogs> fetchDogsBySize(Size size);
    
    //Reads a list of ALL dogs with a specified gender
    
    @Operation(
        summary = "Returns a list of dogs based on gender",
        description = "Returns a list of dogs given a dog's gender",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of dogs is returned based on dog's gender.", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Clients.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No dogs were found with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "gender",
                allowEmptyValue = false,
                required = false,
                description = "The client's gender (i.e., 'Female')") 
       }
    )
    
    // Get method (read)
    @GetMapping("/dogsByGender")
    @ResponseStatus(code = HttpStatus.OK)
    List<Dogs> fetchDogsByGender(Gender gender);
    
  //Reads dog with specified dog id
    
    @Operation(
        summary = "Returns a dog based on dog id",
        description = "Returns dog given dog id",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A dog is returned based on dog id.", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Clients.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No dogs were found with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "dogId",
                allowEmptyValue = false,
                required = false,
                description = "The dog's id (i.e., '11')") 
       }
    )
    
    // Get method (read)
    @GetMapping("/dogsByDogId")
    @ResponseStatus(code = HttpStatus.OK)
    List<Dogs> fetchDogsByDogId(int dogId);
   
  //Create a new dog
    
    @Operation(
        summary = "Creates a dog",
        description = "Returns created dog",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A dog is created!", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Dogs.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "Unable to create dog with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        }
    )
    
    // Post method (Create)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Dogs createDogs(@Valid @RequestBody DogsDto dogsDto); 
    
    @Operation(
        summary = "Updates a dog",
        description = "Returns updated dog",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A dog is updated!", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Dogs.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "Unable to update dog with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        }
    )
    
    // Put method (Update)
   @PutMapping
   @ResponseStatus(code = HttpStatus.OK)
   Dogs updateDogs(@Valid @RequestBody DogsDto dogsDto); 
    
    //@formatter:on
}
