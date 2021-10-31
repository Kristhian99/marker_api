package com.example.demo.services;

import com.example.demo.market.Fruit;
import com.example.demo.market.Kind;
import com.example.demo.repository.FruitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FruitService {

    private FruitRepository repository;

    public List<Fruit> getAllMark() {
        return  repository.findAll();

    }

    public Fruit getFruit(Kind kind){
        Fruit fruit = repository.findFruitByKind(kind).orElse(null);
        return fruit;
    }

    public String transferFruit(Kind K,String Dcity,String Pcity,int mount){
        Fruit fruit = repository.findFruitByKind(K).orElse(null);
        if (fruit==null){return "___";}
        else {
            if(CheckCapacity(fruit,Dcity,mount)){
                transaction(fruit,Dcity,-mount);
                transaction(fruit,Pcity,mount);
                updateFruit(fruit);
                return "Succefully operation";
            }
            else {
                return "not enough fruits";
            }
        }
    }


    private void updateFruit(Fruit fruit) {
        repository.save(fruit);

    }

    private void transaction(Fruit fruit, String dcity, int mount) {
        if(dcity.equals("paris")){
            transferparis(fruit,mount);
        }
        if(dcity.equals("niza"))
            transferniza(fruit,mount);

        if(dcity.equals("marsella"))
            transfermarsella(fruit,mount);
        if(dcity.equals("dijon"))
            transferdijon(fruit,mount);
        if(dcity.equals("lila"))
            transferlila(fruit,mount);

    }

    private void transferdijon(Fruit fruit, int mount) {
        fruit.setDijon(fruit.getDijon()+mount);
    }

    private void transfermarsella(Fruit fruit, int mount) {
        fruit.setMarsella(fruit.getMarsella()+mount);
    }

    private void transferniza(Fruit fruit, int mount) {
        fruit.setNiza(fruit.getNiza()+mount);
    }
    private void transferlila(Fruit fruit, int mount) {
        fruit.setLila(fruit.getLila()+mount);
    }

    private void transferparis(Fruit fruit, int mount) {
        fruit.setParis(fruit.getParis()+mount);
    }

    private boolean CheckCapacity(Fruit fruit,String Dcity,int mount) {
        boolean flag=false;
        if(Dcity.equals("paris"))
            flag=mount>fruit.getParis()?false:true;
        if(Dcity.equals("niza"))
            flag=mount>fruit.getNiza()?false:true;
        if(Dcity.equals("marsella"))
            flag=mount>fruit.getMarsella()?false:true;
        if(Dcity.equals("dijon"))
            flag=mount>fruit.getDijon()?false:true;
        if(Dcity.equals("lila"))
            flag=mount>fruit.getLila()?false:true;

        return flag;
    }


}
