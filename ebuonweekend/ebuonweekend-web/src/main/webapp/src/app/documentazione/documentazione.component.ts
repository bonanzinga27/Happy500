import {Component, OnInit, Input} from '@angular/core';
import {TabsService} from "../tabs.service";

@Component({
  selector: 'app-documentazione',
  templateUrl: './documentazione.component.html',
  styleUrls: ['./documentazione.component.css']
})
export class DocumentazioneComponent implements OnInit {

  documenti = [
    {tipo: 'Carta identità'},
    {tipo: 'Codice fiscale'},
    {tipo: 'Non lo so',},
    {tipo: 'Forse è quello giusto'},
  ];

  public nextPage(){
    this.tabs.setTab(4);
  }
  constructor(private tabs:TabsService) { }

  ngOnInit() {
  }

}
