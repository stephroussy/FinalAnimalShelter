package com.animal.shelter.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.animal.shelter.entity.Clients;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/clients")

public interface ClientsController {

  // Reads a list of ALL clients

//@formatter:off
 @Operation( 
     summary = "Returns a list of all the clients",
     description = "Returns the list of clients",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A list of clients gets returned",
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Clients.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid",  
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No clients were found",  
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred.",  
             content = @Content(mediaType = "application/json")),
     }
 )
 @GetMapping("/allClients")
 @ResponseStatus(code = HttpStatus.OK)
 List<Clients> fetchAllClients();  
  
//Reads a list of ALL clients with the specified last name 
 
  
    @Operation(
        summary = "Returns a list of clients based on last names",
        description = "Returns a list of clients given client last names",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of clients is returned based on last names.", 
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
                description = "No clients were found with the input criteria.", 
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
                name = "clientLastName",
                allowEmptyValue = false,
                required = false,
                description = "The client's last name (i.e., 'Smith')") 
       }
    )
    
    // Get method (read)
    @GetMapping("/ClientsByLastName")
    @ResponseStatus(code = HttpStatus.OK)
    List<Clients> fetchClientsByLastName(
        String clientLastName);
    
  //Reads client with specified client id
   
  
    @Operation(
        summary = "Returns a list of clients based on client id",
        description = "Returns a list of clients given client id",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of clients is returned based on client id.", 
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
                description = "No clients were found with the input criteria.", 
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
                name = "clientId",
                allowEmptyValue = false,
                required = false,
                description = "The client's id (i.e., '11')") 
       }
    )
    
    // Get method (read)
    @GetMapping("/ClientsByClientId")
    @ResponseStatus(code = HttpStatus.OK)
    List<Clients> fetchClientsByClientId(
        Integer clientId);
    
  //Create a new client

    @Operation(
        summary = "Creates a client",
        description = "Returns the created client",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A client was created!", 
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
                description = "Unable to create a client with the input criteria.", 
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
                name = "clientFirstName",
                allowEmptyValue = false,
                required = false,
                description = "The client's first name (i.e., 'John')"),
            @Parameter(
                name = "clientLastName",
                allowEmptyValue = false,
                required = false,
                description = "The client's last name (i.e., 'Smith')"),
            @Parameter(
                name = "address",
                allowEmptyValue = false,
                required = false,
                description = "The client's address (i.e., '53627 Tiger Street')")  
        }
    )
   
    // Post method (create)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Clients createClients(
        String clientFirstName,
        String clientLastName,
        String address);

  //Update an existing client
  
    @Operation(
        summary = "Updates a client",
        description = "Returns updated client",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A client was updated!", 
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
                description = "Unable to update the client with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        
            parameters = {
                @Parameter(name = "clientId", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "The client's id (i.e., '11')"),
                @Parameter(
                    name = "clientFirstName",
                    allowEmptyValue = false,
                    required = false,
                    description = "The client's first name (i.e., 'John')"),
                @Parameter(
                    name = "clientLastName",
                    allowEmptyValue = false,
                    required = false,
                    description = "The client's last name (i.e., 'Smith')"),
                @Parameter(
                    name = "address",
                    allowEmptyValue = false,
                    required = false,
                    description = "The client's address (i.e., '53627 Tiger Street')")  
        }
    )
    
    //Put method (update)
 
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    Clients updateClients(Integer clientId, String clientFirstName, 
        String clientLastName, String address); 
    // @formatter:on
}
