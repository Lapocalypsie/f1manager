package com.f1manager.demo.Personnel.Mecanicien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MecanicienService {

    @Autowired
    MecanicienRepository mecanicienRepository;


}
