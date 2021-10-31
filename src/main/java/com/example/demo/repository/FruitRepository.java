package com.example.demo.repository;

import com.example.demo.market.Fruit;
import com.example.demo.market.Kind;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FruitRepository extends MongoRepository<Fruit,String> {

    Optional<Fruit> findFruitByKind(Kind s);
}
