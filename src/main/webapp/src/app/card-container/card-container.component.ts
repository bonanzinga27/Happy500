import { Component, OnInit } from '@angular/core';
import {TypesFundingService} from "../types-funding.service";

@Component({
  selector: 'app-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.css']
})
export class CardContainerComponent implements OnInit {

  constructor(private funding: TypesFundingService) { }

  ngOnInit() {
  }

}
