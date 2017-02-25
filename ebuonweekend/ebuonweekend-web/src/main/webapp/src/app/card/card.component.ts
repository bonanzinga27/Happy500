import {Component, OnInit, Input} from '@angular/core';
import {TypesFundingService} from "../types-funding.service";
import {Cookie} from "ng2-cookies";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input() servizio;

  constructor(
    private fundingService: TypesFundingService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  nuovaPratica(nomeFinanziamento){
    this.fundingService.nuovaPratica(nomeFinanziamento, Cookie.get('email'))
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.router.navigate(['../pratica']);
        }else{
          console.log("errore, nella creazione della nuova pratica");
        }
      });
  }

}
