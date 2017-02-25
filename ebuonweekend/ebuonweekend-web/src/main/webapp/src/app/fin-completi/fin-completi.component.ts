import { Component, OnInit } from '@angular/core';
import {GestionePraticheService} from "../gestione-pratiche.service";
import {Cookie} from "ng2-cookies";

@Component({
  selector: 'app-fin-completi',
  templateUrl: './fin-completi.component.html',
  styleUrls: ['./fin-completi.component.css']
})
export class FinCompletiComponent implements OnInit {

  campiFinCompleti = [];

  getPraticheCompletate(){
    this.gestionePratiche.getPraticheCompletate(Cookie.get('email'))
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.campiFinCompleti = JSON.parse(JSON.stringify(risposta.returnObject));
        }else{
          console.log("errore");
        }
      });
  }

  constructor(private gestionePratiche: GestionePraticheService) {
    this.getPraticheCompletate();
  }

  ngOnInit() {
  }

}
