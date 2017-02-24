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


@RestController
public class RichiedenteController {

    @Autowired
    RichiedenteService richiedenteService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getRichiedente")
    public GenericReturn<Richiedente> getUser(@RequestParam(value = "id", defaultValue = "@unregistered") Long id) {

        return new GenericReturn<>(richiedenteService.selectByID(id),null);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/editRichiedente")
    public GenericReturn<Boolean> editUser(@RequestParam(value = "nome", defaultValue = "undefined") String nome,
                                           @RequestParam(value = "cognome", defaultValue = "undefined") String cognome,
                                           @RequestParam(value = "codFisc", defaultValue = "undefined") String codFisc,
                                           @RequestParam(value = "email", defaultValue = "undefined") String email,
                                           @RequestParam(value = "dataNascita", defaultValue = "undefined") String dataNascita,
                                           @RequestParam(value = "cittaNascita", defaultValue = "undefined") String cittaNascita,
                                           @RequestParam(value = "provinciaNascita", defaultValue = "undefined") String provinciaNascita,
                                           @RequestParam(value = "telefono", defaultValue = "undefined") String telefono,
                                           @RequestParam(value = "cittaResidenza", defaultValue = "undefined") String cittaResidenza,
                                           @RequestParam(value = "provinciaResidenza", defaultValue = "undefined") String provinciaResidenza,
                                           @RequestParam(value = "indirizzoResidenza", defaultValue = "undefined") String indirizzoResidenza,
                                           @RequestParam(value = "idUtente", defaultValue = "undefined") Integer idUtente,
                                           @RequestParam(value = "emailRichiedente", defaultValue = "undefined") String emailRichiedente,
                                           @RequestParam(value = "cartaIdentitaPath", defaultValue = "undefined") String cartaIdentitaPath,
                                           @RequestParam(value = "codFiscPath", defaultValue = "undefined") String codFiscPath,
                                           @RequestParam(value = "sesso", defaultValue = "undefined") String sesso){

        ///ebuonweekend-web/editUser?nickName=leo&firstName=Leonardo&lastName=Galati&telephone=3483401922&statoUtente=montagna&profilePicture=C:/E-Buonweekend-Uploads/image_4.jpg


            Richiedente richiedente = new Richiedente(0l, nome, cognome, codFisc, DateUtil.parse(dataNascita), cittaNascita, provinciaNascita, telefono, cittaResidenza, provinciaResidenza, indirizzoResidenza, 0l, emailRichiedente,cartaIdentitaPath,codFiscPath, sesso);
            return new GenericReturn<Boolean>(richiedenteService.update(richiedente,email));


    }


}
