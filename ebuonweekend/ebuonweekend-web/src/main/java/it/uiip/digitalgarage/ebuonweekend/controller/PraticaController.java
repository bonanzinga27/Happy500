package it.uiip.digitalgarage.ebuonweekend.controller;

import it.uiip.digitalgarage.ebuonweekend.entity.*;
import it.uiip.digitalgarage.ebuonweekend.ibe.OrganizzazioneService;
import it.uiip.digitalgarage.ebuonweekend.ibe.PraticaService;
import it.uiip.digitalgarage.ebuonweekend.ibe.RichiedenteService;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.Pdf;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.page.PageType;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

            Pratica p = new Pratica(0, tipo, 0, LocalDate.now(), 0, 0, 0, "",  r.getId(), o.getId(),"", "", email);

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

        Pratica p = new Pratica(Long.valueOf(id),
                tipo,
                Double.parseDouble(importo),
                LocalDate.now(),
                Integer.parseInt(completata),
                Integer.parseInt(numDip),
                Integer.parseInt(durata),
                iban,
                0,
                0,
                descr,
                "" ,
                "");

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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getPraticheComplete")
    public GenericReturn<Pratica[]> getPraticheComplete(@RequestParam(value = "email", defaultValue = "null") String email){
        if(!email.equals("null")){
            return new GenericReturn<>(praticaService.selectAllCompleted(email));

        }
        else return new GenericReturn<>(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getPraticheNonComplete")
    public GenericReturn<Pratica[]> getPraticheNonComplete(@RequestParam(value = "email", defaultValue = "null") String email){
        if(!email.equals("null")){
            return new GenericReturn<>(praticaService.selectAllUncompleted(email));

        }
        else return new GenericReturn<>(null);
    }







    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/generaPDF")
    public GenericReturn<Boolean> generaPDF(@RequestParam(value="id", defaultValue = "null") Long id,
                                            @RequestParam(value="descrizione", defaultValue = "null") String descrizione,
                                            @RequestParam(value="importo", defaultValue = "null") String importo,
                                            @RequestParam(value="dipendenti", defaultValue = "0") String dipendenti,
                                            @RequestParam(value="durata", defaultValue = "0") String durata,
                                            @RequestParam(value="nome", defaultValue = "0") String nome,
                                            @RequestParam(value="cognome", defaultValue = "null") String cognome,
                                            @RequestParam(value="sesso", defaultValue = "null") String sesso,
                                            @RequestParam(value="provNascita", defaultValue = "null") String provNascita,
                                            @RequestParam(value="cittaNascita", defaultValue = "null") String cittaNascita,
                                            @RequestParam(value="emailRichiedente", defaultValue = "null") String emailRichiedente,
                                            @RequestParam(value="dataNascita", defaultValue = "null") String dataNascita,
                                            @RequestParam(value="codFisc", defaultValue = "null") String codFisc,
                                            @RequestParam(value="indirizzoResidenza", defaultValue = "null") String indirizzoResidenza,
                                            @RequestParam(value="provinciaResidenza", defaultValue = "null") String provinciaResidenza,
                                            @RequestParam(value="cittaResidenza", defaultValue = "null") String cittaResidenza,
                                            @RequestParam(value="telefono", defaultValue = "null") String telefono,
                                            @RequestParam(value="denominazione", defaultValue = "null") String denominazione,
                                            @RequestParam(value="ragioneSociale", defaultValue = "null") String ragioneSociale,
                                            @RequestParam(value="societaCapitali", defaultValue = "null") String societaCapitali,
                                            @RequestParam(value="piva", defaultValue = "null") String piva,
                                            @RequestParam(value="capitale", defaultValue = "null") String capitale,
                                            @RequestParam(value="email", defaultValue = "null") String email,
                                            @RequestParam(value="stato", defaultValue = "null") String stato,
                                            @RequestParam(value="citta", defaultValue = "null") String citta,
                                            @RequestParam(value="provincia", defaultValue = "null") String provincia,
                                            @RequestParam(value="indirizzo", defaultValue = "null") String indirizzo){
            //    http://localhost:8080/generaPDF?id=1&descrizione=descrizione&importo=2345345634&dipendenti=44&durata=12345&nome=nome&cognome=cognome&sesso=M&provNascita=NA&cittaNascita=cittaNascita&emailRichiedente=emailRichiedente&dataNascita=12-12-2020&codFisc=FDFG2342DF234DR&indirizzoResidenza=indirizzoResidenza&provinciaResidenza=NA&cittaResidenza=cittaResidenza&telefono=1231242424&denominazione=sdaba&ragioneSociale=SpA&societaCapitali=Srl&piva=pivaaaaa&capitale=255555&email=email&stato=italia&citta=citta&provincia=NA&indirizzo=vajsjsj

        try {
            String head = "<head>\n" +
                            "<style>\n";

            //head+= Pdf.readFile(PraticaController.class.getResource("bootstrap.min.css").getPath(), StandardCharsets.UTF_8);
            head+="\n</style>\n" +
                    "</head>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"jumbotron\">\n" +
                    "  <form>\n" +
                    "    <legend>Business plan</legend>\n" +
                    "    <div class=\"form-group descrizione-inline\">\n" +
                    "      <label for=\"descrizione\">Descrizione del progetto da finanziare</label>\n" +
                    "      <textarea class=\"form-control\" id=\"descrizione\" value="+descrizione+"></textarea>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group importo-inline\">\n" +
                    "      <label for=\"importo\">Importo richiesto</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"importo\"value="+importo+">\n" +
                    "      <small id=\"importoHelp\" class=\"form-text text-muted\">Importo espresso in euro</small>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group dipendenti-inline\">\n" +
                    "      <label for=\"dipendenti\">Numero dipendenti</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"dipendenti\"value="+dipendenti+">\n" +
                    "      <small id=\"dipendentiHelp\" class=\"form-text text-muted\">Dipendenti organizzazione</small>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group durata-inline\">\n" +
                    "      <label for=\"durata\">Durata finanziamento</label>\n" +
                    "      <select class=\"form-control\" id=\"durata\">\n" +
                    "        <option>"+durata+"</option>\n" +
                    "      </select>\n" +
                    "      <small id=\"durataHelp\" class=\"form-text text-muted\">Durata in mesi</small>\n" +
                    "    </div>\n" +
                    "  </form>\n" +
                    "</div>\n" +
                    "\n" +
                    "<div class=\"jumbotron\">\n" +
                    "  <form>\n" +
                    "    <legend>Dati anagrafici</legend>\n" +
                    "    <div class=\"form-group nome-cognome-inline\">\n" +
                    "      <label for=\"nome\">Nome richiedente</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" name=\"nome\" id=\"nome\" value="+nome+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group nome-cognome-inline\">\n" +
                    "      <label for=\"cognome\">Cognome richiedente</label>\n" +
                    "      <input type=\"text\" class=\"form-control\"  name=\"cognome\" id=\"cognome\" value="+cognome+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group sesso-inline\">\n" +
                    "      <label for=\"sesso\">Sesso:</label>\n" +
                    "      <select>\n" +
                    "        <option>"+sesso+"</option>\n" +
                    "      </select>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group prov-inline\">\n" +
                    "      <label for=\"provinciaNascita\">Provincia di nascita</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" name=\"provinciaNascita\" id=\"provinciaNascita\"value="+provNascita+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group citta-inline\">\n" +
                    "      <label for=\"cittaNascita\">Citta' di nascita</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" name=\"cittaNascita\" id=\"cittaNascita\"value="+cittaNascita+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group email-inline\">\n" +
                    "      <label for=\"emailRichiedente\">Email richiedente</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"emailRichiedente\"value="+emailRichiedente+">\n" +
                    "      <br>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group nascita-inline\">\n" +
                    "      <label for=\"dataNascita\">Data di nascita</label>\n" +
                    "      <input type=\"date\" class=\"form-control\" name=\"dataNascita\" id=\"dataNascita\" value="+dataNascita+">\n" +
                    "      <small id=\"nascitaHelp\" class=\"form-text text-muted\">Formato gg/mm/aaaa</small>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group\">\n" +
                    "      <label for=\"codFisc\">Codice fiscale</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" name=\"codFis\" id=\"codFisc\"value="+codFisc+">\n" +
                    "    </div>\n" +
                    "    <br>\n" +
                    "    <legend>Dati personali</legend>\n" +
                    "    <div class=\"form-group\">\n" +
                    "      <label for=\"indirizzoResidenza\">Indirizzo di residenza</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" name=\"indirizzoResidenza\" id=\"indirizzoResidenza\" value="+indirizzoResidenza+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group prov-inline\">\n" +
                    "      <label for=\"provinciaResidenza\">Provincia</label>\n" +
                    "      <input type=\"text\" class=\"form-control\"  name=\"provinciaResidenza\" id=\"provinciaResidenza\" aria-describedby=\"provinciaHelp\"value="+provinciaResidenza+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group citta-inline\">\n" +
                    "      <label for=\"cittaResidenza\">Citta'</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" name=\"cittaResidenza\" id=\"cittaResidenza\"value="+cittaResidenza+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group\">\n" +
                    "      <label for=\"telefono\">Recapito telefonico</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" name=\"telefono\" id=\"telefono\" value="+telefono+">\n" +
                    "    </div>\n" +
                    "    <br>\n" +
                    "  </form>\n" +
                    "</div>\n" +
                    "<div class=\"jumbotron\">\n" +
                    "  <form>\n" +
                    "    <legend>Dati organizzazione</legend>\n" +
                    "    <div class=\"form-group denominazione-inline\">\n" +
                    "      <label for=\"denominazione\">Denominazione sociale</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"denominazione\" value="+denominazione+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group ragione-inline\">\n" +
                    "      <label for=\"ragioneSociale\">Ragione sociale</label>\n" +
                    "      <select class=\"form-control\" id=\"ragioneSociale\">\n" +
                    "        <optgroup label=\"Società di persone\">\n" +
                    "          <option>"+ragioneSociale+"</option>\n" +
                    "        </optgroup>\n" +
                    "        <optgroup label=\"Società di capitali\">\n" +
                    "          <option>"+societaCapitali+"</option>\n" +
                    "        </optgroup>\n" +
                    "      </select>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group piva-inline\">\n" +
                    "      <label for=\"piva\">Partita IVA</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"piva\"value="+piva+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group capitale-inline\">\n" +
                    "      <label for=\"piva\">Capitale</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"capitale\"value="+capitale+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group\">\n" +
                    "      <label for=\"email\">Email aziendale</label>\n" +
                    "      <input type=\"email\" class=\"form-control\" id=\"email\"value="+email+">\n" +
                    "    </div>\n" +
                    "    <br>\n" +
                    "    <!-- Sede legale -->\n" +
                    "    <legend>Sede legale</legend>\n" +
                    "    <div class=\"form-group stato-inline\">\n" +
                    "      <label for=\"stato\">Stato</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"stato\" value="+stato+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group citta-inline\">\n" +
                    "      <label for=\"citta\">Citta</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"citta\"value="+citta+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group prov-inline\">\n" +
                    "      <label for=\"provincia\">Provincia</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"provincia\"value="+provincia+">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group indirizzo-inline\">\n" +
                    "      <label for=\"indirizzo \">Indirizzo</label>\n" +
                    "      <input type=\"text\" class=\"form-control\" id=\"indirizzo \"value="+indirizzo+">\n" +
                    "    </div>\n" +
                    "    <br>\n" +
                    "  </form>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "</body>";



            String home = System.getProperty("user.home");
            String globalURL=home+File.separator+"Desktop"+File.separator+"happy500"+File.separator+"pratiche";

            Path dbFolder = Paths.get(globalURL);

            String error = "";

            Boolean created = true;
            if (Files.notExists(dbFolder)) {

                System.out.println(" path doesn't exist");
                System.out.println(globalURL);
                created = new File(globalURL).mkdirs();
                if (created)
                    System.out.println("path created!");
                else
                    System.out.println(error+="error creating path");
            }
            if (created) {
                String fileName= "pratica_" + (Files.list(Paths.get(globalURL)).count() + 1);

                Pdf pdf = new Pdf();
                pdf.addPage(head, PageType.htmlAsString);
                // pdf.addToc();
                pdf.saveAs(globalURL+fileName+ ".pdf");

                praticaService.updatePathPratica(id,globalURL+File.separator+fileName+ ".pdf");

            }

        } catch ( IOException | InterruptedException e) {
        e.printStackTrace();
        }

        return new GenericReturn<>(true);

    }


    //API PER PRENDERE DAL DB TUTTI I TIPI DI FINANZIAMENTO POSSIBILI
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getFinanziamenti")
    public GenericReturn<TipoFinanziamento[]> getFinanziamento(){

        return new GenericReturn<>(praticaService.getAllTipoFinanziamento());
    }







}