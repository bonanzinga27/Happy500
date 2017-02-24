package it.uiip.digitalgarage.ebuonweekend.controller;

import it.uiip.digitalgarage.ebuonweekend.entity.GenericReturn;
import it.uiip.digitalgarage.ebuonweekend.entity.Pratica;
import it.uiip.digitalgarage.ebuonweekend.entity.TipoFinanziamento;
import it.uiip.digitalgarage.ebuonweekend.ibe.PraticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class PraticaController{

    @Autowired
    PraticaService praticaService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/insertPratica")
    public GenericReturn<Boolean> insertPratica(@RequestParam(value="tipo", defaultValue="null") String tipologia,
                                                @RequestParam(value="importo", defaultValue = "null") String importo,
                                                @RequestParam(value="completata", defaultValue = "0") String completata,
                                                @RequestParam(value="numDip", defaultValue = "null") String numDip,
                                                @RequestParam(value="durata", defaultValue = "null") String durata,
                                                @RequestParam(value="iban", defaultValue = "null") String iban,
                                                @RequestParam(value="descr", defaultValue = "null") String descr,
                                                @RequestParam(value="idRich", defaultValue = "null") String idRich,
                                                @RequestParam(value="idOrg", defaultValue = "null") String idOrg){

        Pratica p = new Pratica(0, tipologia, Double.parseDouble(importo), LocalDate.now(), Integer.parseInt(completata), Integer.parseInt(numDip), Integer.parseInt(durata), iban, descr, "null", Long.parseLong(idRich), Long.parseLong(idOrg));

        return new GenericReturn<>(praticaService.insert(p));

    }


    //API PER PRENDERE DAL DB TUTTI I TIPI DI FINANZIAMENTO POSSIBILI
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getFinanziamento")
    public GenericReturn<TipoFinanziamento[]> getFinanziamento(){

        return new GenericReturn<>(praticaService.getAllTipoFinanziamento());
    }




}