import { Injectable } from '@angular/core';

@Injectable()
export class TabsService {

  tabList = [
    {id:0, title: 'Dati personali', path: "/",width:'25%'},
    {id:1, title: 'Dati organizzazione', path: "/",width:'25%'},
    {id:2, title: 'Business plan', path: "/",width:'25%'},
    {id:3, title: 'Documentazione', path: "/",width:'25%'},
    {id:4, title: 'Conferma', path: "/",width:'25%'}
  ];

  constructor() { }

}
