package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.BootcampStateService;
import com.bootcamp.com.bootcamp.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.entities.BootcampState;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bootcampstates")
@AllArgsConstructor
public class BootcampStatesController extends BaseController{
    @Autowired
    private BootcampStateService bootcampStateService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateBootcampStateRequest request){
        return handleDataResult(bootcampStateService.create(request));
    }
    @GetMapping("getallBootcampStates")
    public ResponseEntity<?> getAll(){
        return handleDataResult(bootcampStateService.getAll());
    }
    @PutMapping("/updateBootcampState/{id}")
    public ResponseEntity<?> updateBootcampState(@RequestBody BootcampState bootcampState, @PathVariable("id") int id) {
        return handleDataResult(bootcampStateService.updateBootcampState(bootcampState, id));
    }
    @DeleteMapping("/deleteBootcampStateById/{id}")
    public ResponseEntity<?>  deleteBootcampStateById(@PathVariable("id") int id){
        return handleDataResult(bootcampStateService.deleteBootcampStateById(id));
    }
    @GetMapping("sort")
    public ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(bootcampStateService.getAllPage(pageDto));
    }
}
