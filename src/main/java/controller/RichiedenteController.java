package controller;

/**
 * Created by gvasa on 23/02/2017.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import entity.GenericReturn;
import entity.Richiedente;
import ibe.RichiedenteService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utils.DateUtil;

import javax.servlet.http.HttpServletResponse;
public class RichiedenteController {
    @Autowired
    RichiedenteService richiedenteService;

    //METODO PER RITORNARE UN UTENTE
    @RequestMapping("/getRichiedente")
    public GenericReturn<Richiedente> getUser(@RequestParam(value = "id", defaultValue = "@unregistered") Integer id) {

        return new GenericReturn<>(richiedenteService.selectByID(id),null);
    }

    @RequestMapping("/editRichiedente")
    public GenericReturn<Boolean> editUser(@RequestParam(value = "nome", defaultValue = "undefined") String nome,
                                           @RequestParam(value = "cognome", defaultValue = "undefined") String cognome,
                                           @RequestParam(value = "codFisc", defaultValue = "undefined") String codFisc,
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
                                           @RequestParam(value = "codFiscPath", defaultValue = "undefined") String codFiscPath
                                           ){

        ///ebuonweekend-web/editUser?nickName=leo&firstName=Leonardo&lastName=Galati&telephone=3483401922&statoUtente=montagna&profilePicture=C:/E-Buonweekend-Uploads/image_4.jpg


            Richiedente richiedente = new Richiedente(0, nome, cognome, codFisc, DateUtil.parse(dataNascita), cittaNascita, provinciaNascita, telefono, cittaResidenza, provinciaResidenza, indirizzoResidenza, idUtente, emailRichiedente,cartaIdentitaPath,codFiscPath);
            return new GenericReturn<Boolean>(richiedenteService.update(richiedente));


    }


}
