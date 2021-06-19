package com.codegym.api.admin;

import com.codegym.dto.NewDTO;
import com.codegym.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
    @Autowired
    private INewService newService;

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO){
        return newService.save(newDTO);
    }
    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO){

        return  newService.save(newDTO);
    }
    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody long[] ids){
        newService.delete(ids);
    }
}
