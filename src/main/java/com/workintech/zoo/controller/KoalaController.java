//package com.workintech.zoo.controller;
//
//import com.workintech.zoo.entity.Koala;
//import com.workintech.zoo.exceptions.ZooException;
//import jakarta.annotation.PostConstruct;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/koalas")
//public class KoalaController {
//    private Map<Integer, Koala> koalas;
//    @PostConstruct
//    public void init()
//    {
//        this.koalas = new HashMap<>();
//    }
//
//    @GetMapping("/")
//    public List<Koala> getAllKoalas()
//    {
//        return this.koalas.values().stream().toList();
//    }
//
//    @GetMapping("/{id}")
//    public Koala getKoalaById(@PathVariable int id)
//    {
//        if(id <= 0)
//        {
//            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
//        }
//        if(!this.koalas.containsKey(id))
//        {
//            throw new ZooException("There are no koalas with Id such that: " + id, HttpStatus.NOT_FOUND);
//        }
//        return this.koalas.get(id);
//    }
//
//    @PostMapping("/")
//    public Koala addKoala(@RequestBody Koala koala)
//    {
//        Koala newKoala = new Koala(koala.getId(), koala.getName(), koala.getWeight(), koala.getSleepHour(), koala.getGender());
//        this.koalas.put(koala.getId(), newKoala);
//        return newKoala;
//    }
//
//    @PutMapping("/{id}")
//    public Koala updateKoala(@PathVariable int id, @RequestBody Koala koala)
//    {
//        if(id <= 0)
//        {
//            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
//        }
//        if(!this.koalas.containsKey(id))
//        {
//            throw new ZooException("There are no koalas with Id such that: " + id, HttpStatus.NOT_FOUND);
//        }
//        Koala newKoala = new Koala(id, koala.getName(), koala.getWeight(), koala.getSleepHour(), koala.getGender());
//        this.koalas.put(id, newKoala);
//        return newKoala;
//    }
//
//    @DeleteMapping("/{id}")
//    public Koala deleteKoalaById(@PathVariable int id)
//    {
//        if(id <= 0)
//        {
//            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
//        }
//        if(!this.koalas.containsKey(id))
//        {
//            throw new ZooException("There are no koalas with Id such that: " + id, HttpStatus.NOT_FOUND);
//        }
//
//        return this.koalas.remove(id);
//
//    }
//
//
//
//}
