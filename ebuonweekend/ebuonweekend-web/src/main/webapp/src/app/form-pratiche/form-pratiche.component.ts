import { Component, OnInit } from '@angular/core';
import {TabsService} from "../tabs.service";
import {PraticaService} from "../pratica.service";
import {Cookie} from "ng2-cookies";

@Component({
  selector: 'app-form-pratiche',
  templateUrl: './form-pratiche.component.html',
  styleUrls: ['./form-pratiche.component.css']
})
export class FormPraticheComponent implements OnInit {

  public isSelected(id){
    if(id === this.tabs.currentPage){
      return true;
    }else{
      return false;
    }
  }

  datiPersonali = [];

  datiOrganizzazione = [];

  datiPratica = [];

  getDatiPersonali(){
    this.pratica.getRichiedente(Cookie.get('idRichiedente'))
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.datiPersonali = JSON.parse(JSON.stringify(risposta.returnObject));
          /*let dataCorretta =  risposta.returnObject.dataNascita.dayOfMonth + "/" +
                              risposta.returnObject.dataNascita.monthValue + "/" +
                              risposta.returnObject.dataNascita.year;
          this.datiPersonali.dataNascita = dataCorretta;*/
        }else{
          console.log("errore, login fallita");
          alert("Errore, ripeti la login");
        }
      });
  }

  getDatiOrganizzazione(){
    this.pratica.getOrganizzazione(Cookie.get('idOrganizzazione'))
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.datiOrganizzazione = JSON.parse(JSON.stringify(risposta.returnObject));
        }else{
          console.log("errore, login fallita");
          alert("Errore, ripeti la login");
        }
      });
  }

  getPratica(){
    this.pratica.getPratica(Cookie.get('idPratica'))
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.datiPratica = JSON.parse(JSON.stringify(risposta.returnObject));
          /*let dataCorretta =  risposta.returnObject.dataNascita.dayOfMonth + "/" +
           risposta.returnObject.dataNascita.monthValue + "/" +
           risposta.returnObject.dataNascita.year;
           this.datiPersonali.dataNascita = dataCorretta;*/
        }else{
          console.log("errore, login fallita");
          alert("Errore, ripeti la login");
        }
      });
  }

  constructor(
    private tabs:TabsService,
    private pratica:PraticaService
  ) {
    this.getDatiPersonali();
  }

  ngOnInit() {
  }


}
