import { Injectable } from '@angular/core';

@Injectable()
export class TabsService {

  tabList = [
    {title: 'Dati personali', path: "/",width:'25%'},
    {title: 'Dati organizzazione', path: "/",width:'25%'},
    {title: 'Business plan', path: "/",width:'25%'},
    {title: 'Documentazione', path: "/",width:'25%'},
    {title: 'Conferma', path: "/",width:'25%'}
  ];

  constructor() { }

}
