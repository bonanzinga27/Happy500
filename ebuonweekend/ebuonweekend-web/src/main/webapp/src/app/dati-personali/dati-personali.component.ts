import {Component, OnInit, Input} from '@angular/core';
import { FormGroup, Validators, FormControl} from "@angular/forms";
import {PraticaService} from "../pratica.service";
import {Router} from "@angular/router";
import {TabsService} from "../tabs.service";

@Component({
  selector: 'app-dati-personali',
  templateUrl: './dati-personali.component.html',
  styleUrls: ['./dati-personali.component.css']
})
export class DatiPersonaliComponent implements OnInit {

  @Input() dati;    //utilizzato per il two binding

  public datiPersonaliForm = new FormGroup({
    nome:             new FormControl(),
    cognome:          new FormControl(),
    codFisc:          new FormControl(),
    dataNascita:      new FormControl(),
    cittaNascita:     new FormControl(),
    provinciaNascita: new FormControl(),
    telefono:         new FormControl() ,
    cittaResidenza:   new FormControl(),
    provinciaResidenza:new FormControl(),
    indirizzoResidenza:new FormControl(),
    emailRichiedente: new FormControl(),
    cartaIdentitaPath:new FormControl(),
    codiceFiscPath:   new FormControl(),
    sesso:            new FormControl()
  });

  constructor(
    private praticaService:PraticaService,
    private router:Router,
    private tabs:TabsService
  ) { }

  risp = {};

  editRichiedente(){
    console.log(this.datiPersonaliForm.value);
    this.praticaService.editRichiedente(this.datiPersonaliForm.value)
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.tabs.setTab(1); /* Next tab is 1 */
          console.log("Dati Personali inviati correttamente");
        }else{
          console.log("Dati non inviati");
        }
      });
    console.log(this.risp);
  }

  generaCodFiscale(){
    this.praticaService.generaCodiceFiscale(this.dati)
      .subscribe(risposta => {
        if (risposta != null){
            //prelevare
          console.log(risposta);

        }else{
          console.log("Dati non inviati");
        }
      });
    console.log(this.risp);
  }


  ngOnInit() {
  }

}
