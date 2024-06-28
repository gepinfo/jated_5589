package com.geppetto.jated.controller;

import com.geppetto.jated.dto.NameDto;
import com.geppetto.jated.service.NameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;


@RestController
@RequestMapping("/name")
public class NameController {

   private final NameService nameService;

   public NameController(NameService nameService) {
      this.nameService = nameService;
   }

    @PostMapping
    public ResponseEntity<NameDto> create(@RequestBody NameDto nameDto) {
      return ResponseEntity.status(HttpStatus.OK).body(nameService.create(nameDto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<NameDto> getEntityById(@PathVariable String id) {
       return ResponseEntity.ok(nameService.getEntityById(id));
    }


    @GetMapping
     public ResponseEntity<List<NameDto>> getAllValues() {
       return ResponseEntity.ok(nameService.getAllValues());
     }


    @PutMapping
    public ResponseEntity<NameDto> update(@RequestBody NameDto nameDto) {
       return ResponseEntity.ok(nameService.update(nameDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
       return ResponseEntity.ok(nameService.delete(id));
    }


    @GetMapping("/search")
    public ResponseEntity<List<NameDto>> search(@RequestParam Map<String, String> allParams) {
       return ResponseEntity.ok(nameService.search(allParams));
    }
    

    @GetMapping("/searchUpdate")
    public ResponseEntity<NameDto> searchForUpdate(@RequestBody NameDto nameDto) {
       return ResponseEntity.ok(nameService.update(nameDto));
    }

}