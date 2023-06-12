package com.trooper.gerenciamentoredelanchonetes.controller;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import com.trooper.gerenciamentoredelanchonetes.service.ItenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/itens")
public class ItenController {

    @Autowired
    private ItenServiceImpl itenService;

    @PostMapping
    public void saveIten(@RequestBody Iten iten){itenService.saveIten(iten);}

    @GetMapping("/id/{id}")
    public Optional<Iten> findItenById(@PathVariable Long id){return itenService.findItenById(id);}

    @GetMapping("/name/{name}")
    public Iten findItenByName(@PathVariable String name){return itenService.findItenByName(name);}

    @GetMapping
    public List<Iten> findAll(){return itenService.findAllItens();}

    @DeleteMapping("{id}")
    public void deleteItenById (@PathVariable Long id) throws Exception{itenService.deleteById(id);}

    @PutMapping("add/{id}/{quantity}")
    public void addIten(@PathVariable Long id,@PathVariable Integer quantity){
        Integer newQuantity = itenService.findItenById(id).get().getQuantity() + quantity;
       if(itenService.findItenById(id).isEmpty()){
           ResponseEntity.notFound();
       } else {
           itenService.updateItenById(id,
                    newQuantity,
                   LocalDateTime.now());
       }
    }
}
