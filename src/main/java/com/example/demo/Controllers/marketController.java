package com.example.demo.Controllers;

import com.example.demo.market.Fruit;
import com.example.demo.market.Kind;
import com.example.demo.services.FruitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/marker")
@AllArgsConstructor
public class marketController {

    private FruitService fruitService;

    @GetMapping
    public List<Fruit> fetchAllMarket(){
        return fruitService.getAllMark();
    }

    @GetMapping("/fruit")
    public Fruit getFruit(@RequestParam(value="kind") Kind kind){

        return fruitService.getFruit(kind);
    }

    @PutMapping("/admin")
    public String transfer(@RequestParam(value = "kind")Kind kind,
                           @RequestParam(value ="delivery_city")String Dcity,
                           @RequestParam(value = "pickUpCity")String Pcity,
                           @RequestParam(value = "mount")int mount){

        return fruitService.transferFruit(kind,Dcity,Pcity,mount);
    }


}
