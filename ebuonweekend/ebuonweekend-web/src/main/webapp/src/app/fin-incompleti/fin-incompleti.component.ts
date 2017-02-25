import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fin-incompleti',
  templateUrl: './fin-incompleti.component.html',
  styleUrls: ['./fin-incompleti.component.css']
})
export class FinIncompletiComponent implements OnInit {

  campiFinInSospeso = [
    {tipologia: 'Agricola', redirect: 'path1'},
    {tipologia: 'Privata', redirect: 'path2'},
    {tipologia: 'Industriale', redirect: 'path3'}
  ];
  constructor() { }

  ngOnInit() {
  }

}
