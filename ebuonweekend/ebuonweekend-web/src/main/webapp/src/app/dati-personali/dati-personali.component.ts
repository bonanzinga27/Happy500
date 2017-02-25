import { Component, OnInit } from '@angular/core';
import {FormGroup, Validators, FormControl} from "@angular/forms";

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
    provNascita:      new FormControl("", Validators.required),
    telefono:         new FormControl("", Validators.required),
    cittaResidenza:   new FormControl("", Validators.required),
    provResidenza:    new FormControl("", Validators.required),
    indirizzoResidenza:new FormControl("", Validators.required),
    emailUtente:      new FormControl("", Validators.required),
    emailRichiedente: new FormControl("", Validators.required),
    cartaIdentitaPath:new FormControl("", Validators.required),
    codiceFiscPath:   new FormControl("", Validators.required),
    sesso:            new FormControl("", Validators.required)

  });

  constructor() { }

  ngOnInit() {
  }

}
