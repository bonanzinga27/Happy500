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

  constructor(private funding: TypesFundingService) {
    this.getFundingList();
  }

  getFundingList() {
    /*this.funding.getList().subscribe(data => this.list = data);
    this.funding.getList().subscribe(
      data => {
        // refresh the list
        this.list = data;
        return true;
      },
      error => {
        console.error("Errore nella getList dei tipi di finanziamento!");
        return Observable.throw(error);
      }
    );*/
    this.list = this.funding.getList();
  }

  ngOnInit() {
  }

}
