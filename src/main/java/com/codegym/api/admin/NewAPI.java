package com.codegym.api.admin;

import com.codegym.dto.NewDTO;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO){
        return newDTO;
    }
    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO){

        return newDTO;
    }
    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody long[] ids){
        System.out.println("oke");
    }
}
