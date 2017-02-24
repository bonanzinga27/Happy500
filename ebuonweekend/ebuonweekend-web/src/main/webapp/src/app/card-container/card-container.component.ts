import { Component, OnInit } from '@angular/core';
import {TypesFundingService} from "../types-funding.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.css']
})
export class CardContainerComponent implements OnInit {

  list = [];

  constructor(private fundingService: TypesFundingService) {
    this.getFundingList();
  }

  getFundingList() {

    this.fundingService.getList()
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          console.log(risposta.returnObject.email);
          this.list = risposta.returnObject;
        }else{
          console.log("errore, caricamento tipologie finanziamenti");
        }
      });
  }

  ngOnInit() {
  }

}
