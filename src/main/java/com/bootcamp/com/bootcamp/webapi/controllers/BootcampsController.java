package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.BootcampService;
import com.bootcamp.com.bootcamp.business.requests.create.bootcamp.CreateBootcampRequest;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.entities.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampsController extends BaseController{
    @Autowired
    private BootcampService bootcampService;
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateBootcampRequest request){
        return handleDataResult(bootcampService.create(request));
    }
    @GetMapping("getallBootcamps")
    public ResponseEntity<?> getAll(){
        return handleDataResult(bootcampService.getAll());
    }
    @PutMapping("/updateBootcamp/{id}")
    public ResponseEntity<?> updateBootcamp(@RequestBody Bootcamp bootcamp, @PathVariable("id") int id) {
        return handleDataResult(bootcampService.updateBootcamp(bootcamp, id));
    }
    @DeleteMapping("/deleteBootcampById/{id}")
    public ResponseEntity<?>  deleteBootcampById(@PathVariable("id") int id){
        return handleDataResult(bootcampService.deleteBootcampById(id));
    }
    @GetMapping("sort")
    public ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(bootcampService.getAllPage(pageDto));
    }
}
