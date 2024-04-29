package org.example.service;


import org.example.model.Tyre;
import org.springframework.stereotype.Service;

@Service
public class TyreService {

    public Tyre generateTyre(String brand, int price) {
        return new Tyre(brand, price);
    }
}
