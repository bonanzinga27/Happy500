package controller;

import entity.GenericReturn;
import entity.Pratica;
import ibe.PraticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class PraticaController{

    @Autowired
    PraticaService praticaService;

    @RequestMapping("/insertPratica")
    public GenericReturn<Boolean> insertPratica(@RequestParam(value="tipo", defaultValue="null") String tipologia,
                                                @RequestParam(value="importo", defaultValue = "null") String importo,
                                                @RequestParam(value="completata", defaultValue = "0") String completata,
                                                @RequestParam(value="numDip", defaultValue = "null") String numDip,
                                                @RequestParam(value="durata", defaultValue = "null") String durata,
                                                @RequestParam(value="iban", defaultValue = "null") String iban,
                                                @RequestParam(value="descr", defaultValue = "nul") String descr){

        Pratica p = new Pratica(0, tipologia, Double.parseDouble(importo), LocalDate.now(), Integer.parseInt(completata), Integer.parseInt(numDip), Integer.parseInt(durata), iban, descr, "null", 0, 0);

        return new GenericReturn<>(praticaService.insert(p));



    }



}