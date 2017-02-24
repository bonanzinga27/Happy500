package it.uiip.digitalgarage.ebuonweekend.controller;


import it.uiip.digitalgarage.ebuonweekend.entity.GenericReturn;
import it.uiip.digitalgarage.ebuonweekend.entity.Richiedente;
import it.uiip.digitalgarage.ebuonweekend.ibe.RichiedenteService;
import it.uiip.digitalgarage.ebuonweekend.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
public class RichiedenteController {

    @Autowired
    RichiedenteService richiedenteService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/insertRichiedente")
    public GenericReturn<Richiedente> insertRichiedente(@RequestParam(value = "nome", defaultValue = "null") String nome,
                                                        @RequestParam(value = "cognome", defaultValue = "null") String cognome,
                                                        @RequestParam(value = "codFisc", defaultValue = "null") String codFisc,
                                                        @RequestParam(value = "dataNascita", defaultValue = "1901-01-01") String dataNascita,
                                                        @RequestParam(value = "cittaNascita", defaultValue = "null") String cittaNascita,
                                                        @RequestParam(value = "provinciaNascita", defaultValue = "null") String provNascita,
                                                        @RequestParam(value = "telefono", defaultValue = "null") String tel,
                                                        @RequestParam(value = "cittaResidenza", defaultValue = "null") String cittaRes,
                                                        @RequestParam(value = "provinciaResidenza", defaultValue = "null") String provRes,
                                                        @RequestParam(value = "indirizzoResidenza", defaultValue = "null") String indRes,
                                                        @RequestParam(value = "emailRichiedente", defaultValue = "null") String email,
                                                        @RequestParam(value = "cartaIdentitaPath", defaultValue = "null") String CIPath,
                                                        @RequestParam(value = "codFiscPath", defaultValue = "null") String codFiscPath,
                                                        @RequestParam(value = "sesso", defaultValue = "null") String sesso,
                                                        @RequestParam(value = "emailUtente", defaultValue = "null") String emailUtente){

        if(!emailUtente.equals("null")){
            Richiedente r = new Richiedente(0l, nome, cognome, codFisc, LocalDate.parse(dataNascita), cittaNascita, provNascita, tel, cittaRes, provRes, indRes, emailUtente, email, CIPath, codFiscPath, sesso );
            if(richiedenteService.insert(r)){
                return new GenericReturn<>(r);
            }
            else return new GenericReturn<>(null);

        }
        else return new GenericReturn<>(null);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getRichiedente")
    public GenericReturn<Richiedente> getUser(@RequestParam(value = "id", defaultValue = "@unregistered") Long id) {

        return new GenericReturn<>(richiedenteService.selectByID(id),null);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/editRichiedente")
    public GenericReturn<Boolean> editUser(@RequestParam(value = "id", defaultValue = "undefined") String id,
                                           @RequestParam(value = "nome", defaultValue = "undefined") String nome,
                                           @RequestParam(value = "cognome", defaultValue = "undefined") String cognome,
                                           @RequestParam(value = "codFisc", defaultValue = "undefined") String codFisc,
                                           @RequestParam(value = "dataNascita", defaultValue = "undefined") String dataNascita,
                                           @RequestParam(value = "cittaNascita", defaultValue = "undefined") String cittaNascita,
                                           @RequestParam(value = "provinciaNascita", defaultValue = "undefined") String provinciaNascita,
                                           @RequestParam(value = "telefono", defaultValue = "undefined") String telefono,
                                           @RequestParam(value = "cittaResidenza", defaultValue = "undefined") String cittaResidenza,
                                           @RequestParam(value = "provinciaResidenza", defaultValue = "undefined") String provinciaResidenza,
                                           @RequestParam(value = "indirizzoResidenza", defaultValue = "undefined") String indirizzoResidenza,
                                           @RequestParam(value = "emailRichiedente", defaultValue = "undefined") String emailRichiedente,
                                           @RequestParam(value = "cartaIdentitaPath", defaultValue = "undefined") String cartaIdentitaPath,
                                           @RequestParam(value = "codFiscPath", defaultValue = "undefined") String codFiscPath,
                                           @RequestParam(value = "sesso", defaultValue = "undefined") String sesso){

        ///ebuonweekend-web/editUser?nickName=leo&firstName=Leonardo&lastName=Galati&telephone=3483401922&statoUtente=montagna&profilePicture=C:/E-Buonweekend-Uploads/image_4.jpg


            Richiedente richiedente = new Richiedente(Long.valueOf(id), nome, cognome, codFisc, DateUtil.parse(dataNascita), cittaNascita, provinciaNascita, telefono, cittaResidenza, provinciaResidenza, indirizzoResidenza, "", emailRichiedente,cartaIdentitaPath,codFiscPath, sesso);
            return new GenericReturn<Boolean>(richiedenteService.update(richiedente));


    }


}
