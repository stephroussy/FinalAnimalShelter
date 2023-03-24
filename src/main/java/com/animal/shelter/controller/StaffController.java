package com.animal.shelter.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.animal.shelter.entity.Staff;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Staff")
@OpenAPIDefinition(info = @Info(title = "Staff"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})

public interface StaffController {

  // Reads a list of ALL Staff

//@formatter:off
 @Operation( 
     summary = "Returns a list of all the staff",
     description = "Returns the list of staff",
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
 @GetMapping("/all")
 @ResponseStatus(code = HttpStatus.OK)
 List<Staff> fetchAllStaff();  
  
//Reads a list of ALL staff with a specified last name 
 
  
    @Operation(
        summary = "Returns a list of staff based on last names",
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
                required = true,
                description = "The staff's last name (i.e., 'Smith')") 
       }
    )
    
    // Get method (read)
    @GetMapping("/staffbylastname")
    @ResponseStatus(code = HttpStatus.OK)
    List<Staff> fetchStaffByLastName(
        @RequestParam(required = false)
        String staffLastName);
    
  //Reads Staff with specified staff id
   
  
    @Operation(
        summary = "Returns a list of Staff based on staff id",
        description = "Returns a list of Staff given staff id",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of Staff is returned based on staff id.", 
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
    @GetMapping("/staffbystaffid")
    @ResponseStatus(code = HttpStatus.OK)
    List<Staff> fetchStaffByStaffId(
        @RequestParam(required = false)
        int staffId);
    
  //Create a new Staff

    @Operation(
        summary = "Creates a Staff member",
        description = "Returns the created Staff member",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A Staff member was created!", 
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
                description = "Unable to create a Staff member with the input criteria.", 
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
                name = "staffFirstName",
                allowEmptyValue = false,
                required = false,
                description = "The Staff's first name (i.e., 'John')"),
            @Parameter(
                name = "staffLastName",
                allowEmptyValue = false,
                required = false,
                description = "The Staff's last name (i.e., 'Smith')")
        }
    )
   
    // Post method (create)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Staff createStaff(
        @RequestParam(required = false)
        String staffFirstName,
        @RequestParam(required = false)
        String staffLastName);

  //Update an existing Staff
  
    
    @Operation(
        summary = "Updates a Staff member",
        description = "Returns updated Staff member",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A Staff member was updated!", 
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
                description = "Unable to update the Staff member with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        
            parameters = {
                @Parameter(name = "staffId", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "The Staff's id (i.e., '11')"),
                @Parameter(
                    name = "staffFirstName",
                    allowEmptyValue = false,
                    required = false,
                    description = "The Staff's first name (i.e., 'John')"),
                @Parameter(
                    name = "staffLastName",
                    allowEmptyValue = false,
                    required = false,
                    description = "The Staff's last name (i.e., 'Smith')")  
        }
    )
    
    //Put method (update)
 
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    Staff updateStaff(int staffId, String staffFirstName, String staffLastName); 
    // @formatter:on

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
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "staffId", allowEmptyValue = false, required = false,
          description = "The staff id (i.e., '11')")})
  // Delete method (Delete)
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  void deleteStaff(@RequestParam(required = false) int staffId);

  //@formatter:on
}

