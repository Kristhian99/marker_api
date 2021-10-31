package com.example.demo.market;

import com.example.demo.market.Kind;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Fruit {
    @Id
    private String id;
    @Indexed(unique = true)
    private Kind kind;
    private int paris;
    private int marsella;
    private int dijon;
    private int lila;
    private int niza;

    public Fruit(Kind kind, int paris, int marsella, int dijon, int lila, int niza) {
        this.kind = kind;
        this.paris = paris;
        this.marsella = marsella;
        this.dijon = dijon;
        this.lila = lila;
        this.niza = niza;
    }
}
