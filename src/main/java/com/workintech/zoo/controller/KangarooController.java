package com.workintech.zoo.controller;


import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init()
    {
        this.kangaroos = new HashMap<>();
    }

    @GetMapping("/")
    public List<Kangaroo> getAllKangaroos()
    {
        return this.kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable int id)
    {
        if(id <= 0)
        {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if(!this.kangaroos.containsKey(id))
        {
            throw new ZooException("There are no kangaroos with Id such that: " + id, HttpStatus.NOT_FOUND);
        }
        return this.kangaroos.get(id);
    }

    @PostMapping("/")
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo)
    {
        Kangaroo toAdd = new Kangaroo(kangaroo.getId(), kangaroo.getName(), kangaroo.getHeight(), kangaroo.getWeight(), kangaroo.getGender(), kangaroo.isAggressive());
        this.kangaroos.put(kangaroo.getId(), toAdd);
        return toAdd;
    }

    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable int id, @RequestBody Kangaroo kangaroo)
    {
        if(id <= 0)
        {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if(!this.kangaroos.containsKey(id)) {
            throw new ZooException("There are no kangaroos with Id such that: " + id, HttpStatus.NOT_FOUND);
        }
        Kangaroo newKangaroo = new Kangaroo(id, kangaroo.getName(), kangaroo.getHeight(), kangaroo.getWeight(), kangaroo.getGender(), kangaroo.isAggressive());
        this.kangaroos.put(id, newKangaroo);
        return newKangaroo;

    }



    @DeleteMapping("/{id}")
    public Kangaroo deleteKangarooById(@PathVariable int id)
    {
        if(id <= 0)
        {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if(!this.kangaroos.containsKey(id)) {
            throw new ZooException("There are no kangaroos with Id such that: " + id, HttpStatus.NOT_FOUND);
        }
        Kangaroo toDelete = this.kangaroos.remove(id);
        return toDelete;
    }

}
