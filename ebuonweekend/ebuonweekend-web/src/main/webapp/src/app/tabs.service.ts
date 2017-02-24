import { Injectable } from '@angular/core';

@Injectable()
export class TabsService {
  currentPage = 0;
  tabList = [
    {id:0, title: 'Dati personali', path: "/pratica/datipersonali",width:'25%'},
    {id:1, title: 'Dati organizzazione', path: "/pratica/datiorganizzazione",width:'25%'},
    {id:2, title: 'Business plan', path: "/pratica/businessplan",width:'25%'},
    {id:3, title: 'Documentazione', path: "/pratica/documentazione",width:'25%'},
    {id:4, title: 'Conferma', path: "/pratica/conferma",width:'25%'}
  ];

  constructor() { }

}
