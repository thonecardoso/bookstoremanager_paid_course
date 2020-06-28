package com.rodrigopeleias.bookstoremanager.publishers.controller.docs;

import com.rodrigopeleias.bookstoremanager.publishers.dto.PublisherDTO;
import com.rodrigopeleias.bookstoremanager.publishers.exception.PublisherAlreadyExistsException;
import com.rodrigopeleias.bookstoremanager.publishers.exception.PublisherNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api("Publishers management")
public interface PublisherControllerDocs {

    @ApiOperation(value = "Publisher creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success publisher creation"),
            @ApiResponse(code = 400, message = "Missing required fileds, wrong field range value or user already registered on system")
    })
    PublisherDTO create(@RequestBody @Valid PublisherDTO publisherDTO) throws PublisherAlreadyExistsException;

    @ApiOperation(value = "List all registered publishers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all registered publishers")
    })
    List<PublisherDTO> findAll();

    @ApiOperation(value = "Find publisher by id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success publisher found"),
            @ApiResponse(code = 404, message = "Publisher not found error code")
    })
    PublisherDTO findById(@PathVariable Long id) throws PublisherNotFoundException;

    @ApiOperation(value = "Delete publisher by id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success publisher deleted"),
            @ApiResponse(code = 404, message = "Publisher not found error code")
    })
    void delete(@PathVariable Long id) throws PublisherNotFoundException;
}
