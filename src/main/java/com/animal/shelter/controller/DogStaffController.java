package com.animal.shelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import com.animal.shelter.controller.model.DogStaffDto;
import com.animal.shelter.entity.DogStaff;

@Validated
@RequestMapping("/DogStaff")

public interface DogStaffController {

  // Reads a list of ALL Dogs and Staff in the shelter

//@formatter:off
 @Operation( 
     summary = "Returns a list of all the dogs and staff (past and present) in the shelter",
     description = "Returns the list of all the dogs and staff (past and present) in the shelter",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A list of Dogs and Staff gets returned",
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = DogStaff.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid",  
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No Dogs or Staff were found",  
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred.",  
             content = @Content(mediaType = "application/json")),
     }
 )
 @GetMapping("/allDogStaff")
 @ResponseStatus(code = HttpStatus.OK)
 List<DogStaff> fetchAllDogStaff();  
    
  //Reads a list of dogs with specified staff id
   
  
    @Operation(
        summary = "Returns a list of dogs cared for by specific staff member using staff id",
        description = "Returns a list of dogs cared for by specific staff member using staff id",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of Dogs is returned based on staff id.", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = DogStaff.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No Dogs were found with the input criteria.", 
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
                name = "staffId",
                allowEmptyValue = false,
                required = false,
                description = "The staff's id (i.e., '11')") 
       }
    )
    
    // Get method (read)
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<DogStaff> fetchDogsByStaffId(int staffId);

  //Update dogStaff table 
    
    @Operation(
        summary = "Updates a dog with a different staff member or a staff member with a different dog",
        description = "Returns updated information",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A dog/staff was updated!", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = DogStaff.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "Unable to update the dog/staff with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        
            parameters = {
                @Parameter(name = "dogId", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "The dog's id (i.e., '11')"),
                @Parameter(
                    name = "staffId",
                    allowEmptyValue = false,
                    required = false,
                    description = "The staff's id (i.e., '12')")  
        }
    )
    
    //Put method (update)
 
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    DogStaff updateDogStaff(@Valid @RequestBody DogStaffDto dogStaffDto); 
    // @formatter:on
}
