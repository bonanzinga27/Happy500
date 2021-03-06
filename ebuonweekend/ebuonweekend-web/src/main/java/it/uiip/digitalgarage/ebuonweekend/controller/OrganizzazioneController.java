package it.uiip.digitalgarage.ebuonweekend.controller;

import it.uiip.digitalgarage.ebuonweekend.entity.GenericReturn;
import it.uiip.digitalgarage.ebuonweekend.entity.Organizzazione;
import it.uiip.digitalgarage.ebuonweekend.ibe.OrganizzazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizzazioneController {

    @Autowired
    OrganizzazioneService organizzazioneService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/insertOrganizzazione")
    public GenericReturn<Organizzazione> insertOrganizzazione(@RequestParam(value = "denominazione", defaultValue = "null") String denom,
                                                              @RequestParam(value = "ragioneSociale", defaultValue = "null") String ragSoc,
                                                              @RequestParam(value = "piva", defaultValue = "null") String piva,
                                                              @RequestParam(value = "citta", defaultValue = "null") String citta,
                                                              @RequestParam(value = "indirizzo", defaultValue = "null") String ind,
                                                              @RequestParam(value = "provincia", defaultValue = "null") String prov,
                                                              @RequestParam(value = "cap", defaultValue = "null") String cap,
                                                              @RequestParam(value = "stato", defaultValue = "null") String stato,
                                                              @RequestParam(value = "email", defaultValue = "null") String email){


        Organizzazione o = new Organizzazione(0, denom, ragSoc, piva, citta, ind, prov, cap, stato, email);

        if(organizzazioneService.insert(o)){
            return new GenericReturn<>(o);
        }
        else{
            return new GenericReturn<>(null);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/editOrganizzazione")
    public GenericReturn<Boolean> editOrganizzazione(@RequestParam(value = "id", defaultValue = "null") String id,
                                                     @RequestParam(value = "denominazione", defaultValue = "null") String denom,
                                                     @RequestParam(value = "ragioneSociale", defaultValue = "null") String ragSoc,
                                                     @RequestParam(value = "piva", defaultValue = "null") String piva,
                                                     @RequestParam(value = "citta", defaultValue = "null") String citta,
                                                     @RequestParam(value = "indirizzo", defaultValue = "null") String ind,
                                                     @RequestParam(value = "provincia", defaultValue = "null") String prov,
                                                     @RequestParam(value = "cap", defaultValue = "null") String cap,
                                                     @RequestParam(value = "stato", defaultValue = "null") String stato,
                                                     @RequestParam(value = "email", defaultValue = "null") String email){

        Organizzazione o = new Organizzazione(Integer.valueOf(id), denom, ragSoc, piva, citta, ind, prov, cap, stato, email);

        return new GenericReturn<>(organizzazioneService.update(o));

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getOrganizzazione")
    public GenericReturn<Organizzazione> getOrganizzazione(@RequestParam(value = "id", defaultValue = "null") String id){
        if(!id.equals("null")){
            return new GenericReturn<>(organizzazioneService.selectById(id));
        }
        return new GenericReturn<>(null);
    }


}
