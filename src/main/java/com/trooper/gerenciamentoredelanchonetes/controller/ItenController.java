package com.trooper.gerenciamentoredelanchonetes.controller;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import com.trooper.gerenciamentoredelanchonetes.service.ItenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/itens")//pre-path
public class ItenController {

    @Autowired
    private ItenServiceImpl itenService;

    @PostMapping
    public void saveIten(@RequestBody Iten iten){itenService.saveIten(iten);}

    @GetMapping("{id}")
    public Optional<Iten> findItenById(@PathVariable Long id){return itenService.findItenById(id);}

    @GetMapping("{name}")
    public Iten findItenByName(@PathVariable String name){return itenService.findItenByName(name);}

    @GetMapping
    public List<Iten> findAll(){return itenService.findAllItens();}

    @DeleteMapping("{id}")
    public void deleteItenById(@PathVariable Long id){itenService.deleteById(id);}

    @PutMapping("sell/{id}/{quantity}")
    public void sellIten(@PathVariable Long id, int quantity){itenService.updateItenById(id,-quantity);}

    @PutMapping("add/{id}/{quantity}")
    public void addIten(@PathVariable Long id, int quantity){itenService.updateItenById(id,quantity);}

}
