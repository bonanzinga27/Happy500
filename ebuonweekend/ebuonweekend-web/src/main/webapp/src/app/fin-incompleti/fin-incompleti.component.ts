import { Component, OnInit } from '@angular/core';
import {GestionePraticheService} from "../gestione-pratiche.service";
import {Cookie} from "ng2-cookies";
import {Router} from "@angular/router";

@Component({
  selector: 'app-fin-incompleti',
  templateUrl: './fin-incompleti.component.html',
  styleUrls: ['./fin-incompleti.component.css']
})
export class FinIncompletiComponent implements OnInit {

  campiFinInSospeso = [];

  getPraticheNonCompletate(){
    this.gestionePratiche.getPraticheNonCompletate(Cookie.get('email'))
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.campiFinInSospeso = JSON.parse(JSON.stringify(risposta.returnObject));
        }else{
          console.log("errore");
        }
      });
  }


  goToModify(campi){
    alert("prova");
    Cookie.set('idPratica', campi.idPratica);
    Cookie.set('idRichiedente', campi.idRichiedente);
    Cookie.set('idOrganizzazione', campi.idOrganizzazione);
    this.router.navigate(['../pratica']);

  }


  constructor(private gestionePratiche: GestionePraticheService, private router:Router) {
    this.getPraticheNonCompletate();
  }

  ngOnInit() {
  }

}
