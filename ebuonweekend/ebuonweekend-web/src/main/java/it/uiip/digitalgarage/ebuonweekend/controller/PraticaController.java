package it.uiip.digitalgarage.ebuonweekend.controller;

import it.uiip.digitalgarage.ebuonweekend.entity.*;
import it.uiip.digitalgarage.ebuonweekend.ibe.OrganizzazioneService;
import it.uiip.digitalgarage.ebuonweekend.ibe.PraticaService;
import it.uiip.digitalgarage.ebuonweekend.ibe.RichiedenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class PraticaController{

    @Autowired
    PraticaService praticaService;

    @Autowired
    RichiedenteService richiedenteService;

    @Autowired
    OrganizzazioneService organizzazioneService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/insertPratica")
    public GenericReturn<Pratica> insertPratica(@RequestParam(value="tipo", defaultValue="null") String tipo,
                                                @RequestParam(value="email", defaultValue = "null") String email){

        //ALL'INIZIO CREO NUOVA PRATICA CON NUOVO RICHIEDENTE E NUOVA ORGANIZZAZIONE
        Richiedente r = new Richiedente(0l, "", "", "", LocalDate.parse("1900-01-01"), "","", "", "", "", "", "", "", "", "");
        Organizzazione o = new Organizzazione(0, "", "", "", "", "", "", "", "", "");

        if(richiedenteService.insert(r) && organizzazioneService.insert(o)){

            Pratica p = new Pratica(0, tipo, 0, LocalDate.now(), 0, 0, 0, "", "", "null", r.getId(), o.getId(), email);

            if(praticaService.insert(p)){
                return new GenericReturn<>(p);
            }
            return new GenericReturn<>(null);

        }
        return new GenericReturn<>(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/editPratica")
    public GenericReturn<Boolean> editPratica(@RequestParam(value="id", defaultValue = "null") String id,
                                              @RequestParam(value="tipologia", defaultValue = "null") String tipo,
                                              @RequestParam(value="importo", defaultValue = "0") String importo,
                                              @RequestParam(value="completata", defaultValue = "0") String completata,
                                              @RequestParam(value="numDipendenti", defaultValue = "0") String numDip,
                                              @RequestParam(value="durata", defaultValue = "0") String durata,
                                              @RequestParam(value="iban", defaultValue = "null") String iban,
                                              @RequestParam(value="descrizioneProgetto", defaultValue = "null") String descr){

        Pratica p = new Pratica(Long.valueOf(id),tipo, Double.parseDouble(importo), LocalDate.now(), Integer.parseInt(completata), Integer.parseInt(numDip), Integer.parseInt(durata), iban, descr,"", 0, 0, "" );

        return new GenericReturn<>(praticaService.update(p));

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getPratica")
    public GenericReturn<Pratica> getPratica(@RequestParam(value = "id", defaultValue = "null") String id){
        if(!id.equals("null")){
            return new GenericReturn<>(praticaService.selectById(id));
        }
        return new GenericReturn<>(null);
    }





    //API PER PRENDERE DAL DB TUTTI I TIPI DI FINANZIAMENTO POSSIBILI
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getFinanziamenti")
    public GenericReturn<TipoFinanziamento[]> getFinanziamento(){

        return new GenericReturn<>(praticaService.getAllTipoFinanziamento());
    }




}