package com.animal.shelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.animal.shelter.controller.model.StaffDto;
import com.animal.shelter.entity.Staff;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/staff")

public interface StaffController {

  // Reads a list of ALL staff

//@formatter:off
 @Operation( 
     summary = "Returns a list of all the staff",
     description = "Returns a list of all the staff",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A list of staff gets returned",
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Staff.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid",  
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No staff were found",  
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred.",  
             content = @Content(mediaType = "application/json")),
     }
 )
 @GetMapping("/allStaff")
 @ResponseStatus(code = HttpStatus.OK)
 List<Staff> fetchAllStaff();  
  
//Reads a list of ALL staff with a specified last name 
 
  
    @Operation(
        summary = "Returns a list of staff based on last name given",
        description = "Returns a list of staff given staff last names",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of staff is returned based on last names.", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Staff.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No staff were found with the input criteria.", 
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
                name = "staffLastName",
                allowEmptyValue = false,
                required = false,
                description = "The staff's last name (i.e., 'Smith')") 
       }
    )
    
    // Get method (read)
    @GetMapping("/StaffByLastName")
    @ResponseStatus(code = HttpStatus.OK)
    List<Staff> fetchStaffByLastName(String staffLastName);
    
  //Reads Staff with specified staff id
   
  
    @Operation(
        summary = "Returns a list of all staff based on id given",
        description = "Returns a list of all staff given staff id",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of staff is returned based on staff id.", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Staff.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No Staff were found with the input criteria.", 
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
    @GetMapping("/StaffByStaffId")
    @ResponseStatus(code = HttpStatus.OK)
    List<Staff> fetchStaffByStaffId(Integer staffId);
    
  //Create a new Staff

    @Operation(
        summary = "Creates a staff member",
        description = "Returns the created staff member",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A staff member was created!", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Staff.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "Unable to create a staff member with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        }
    )
   
    // Post method (create)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Staff createStaff(@Valid @RequestBody StaffDto staffDto);

  //Update an existing Staff
  
    @Operation(
        summary = "Updates a staff member",
        description = "Returns updated staff member",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A staff member was updated!", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = Staff.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "Unable to update the staff member with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json")) 
        }
    )
    
    //Put method (update)
 
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    Staff updateStaff(@Valid @RequestBody StaffDto staffDto); 
    // @formatter:on

  // Delete an existing Staff

  @Operation(summary = "Deletes a staff member",
      description = "Delete a staff member given a required staff id",
      responses = {
          @ApiResponse(responseCode = "200", description = "A staff member was deleted.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = Staff.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
              description = "No staff member was found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))})

  // Delete method (Delete)
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  void deleteStaff(@Valid @RequestBody StaffDto staffDto);

  //@formatter:on
}

