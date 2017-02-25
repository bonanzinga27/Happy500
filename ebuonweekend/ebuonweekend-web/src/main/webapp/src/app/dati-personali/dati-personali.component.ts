import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl} from "@angular/forms";
import {PraticaService} from "../pratica.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dati-personali',
  templateUrl: './dati-personali.component.html',
  styleUrls: ['./dati-personali.component.css']
})
export class DatiPersonaliComponent implements OnInit {

  public datiPersonaliForm = new FormGroup({
    nome:             new FormControl("", Validators.required),
    cognome:          new FormControl("", Validators.required),
    codFisc:          new FormControl("", Validators.required),
    dataNascita:      new FormControl("", Validators.required),
    cittaNascita:     new FormControl("", Validators.required),
    provinciaNascita: new FormControl("", Validators.required),
    telefono:         new FormControl("", Validators.required),
    cittaResidenza:   new FormControl("", Validators.required),
    provinciaResidenza:new FormControl("", Validators.required),
    indirizzoResidenza:new FormControl("", Validators.required),
    emailUtente:      new FormControl("", Validators.required),
    emailRichiedente: new FormControl("", Validators.required),
    cartaIdentitaPath:new FormControl("", Validators.required),
    codiceFiscPath:   new FormControl("", Validators.required),
    sesso:            new FormControl("", Validators.required)

  });

  datiPersonali = {};

  constructor(
    private praticaService:PraticaService,
    private router:Router
  ) { }

  risp = {};

  salvaDatiPersonali(){
    console.log(this.datiPersonaliForm.value);
    this.praticaService.savePersonalData(this.datiPersonaliForm.value)
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          console.log("Dati Personali inviati correttamente");
        }else{
          console.log("Dati non inviati");
        }
      });
    console.log(this.risp);
  }

  generaCodFiscale(){
    this.praticaService.generaCodiceFiscale(this.datiPersonali)
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
