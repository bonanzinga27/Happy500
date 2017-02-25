import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fin-completi',
  templateUrl: './fin-completi.component.html',
  styleUrls: ['./fin-completi.component.css']
})
export class FinCompletiComponent implements OnInit {

  campiFinCompleti = [
    {tipologia: 'Agricola', richiedente: 'Andrea' ,organizzazione: 'Andrea srl', data: '27/09/1993', pdf: 'link download'},
    {tipologia: 'Privata', richiedente: 'Andrea1' ,organizzazione: 'Andrea1 srl', data: '27/09/1993', pdf: 'link1 download'},
    {tipologia: 'Industriale', richiedente: 'Andrea2' ,organizzazione: 'Andrea2 srl', data: '27/09/1993', pdf: 'link 2download'},
  ];
  constructor() { }

  ngOnInit() {
  }

}
