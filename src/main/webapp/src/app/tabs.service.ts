import { Injectable } from '@angular/core';

@Injectable()
export class TabsService {

  myList = [
    {title: 'Item title1'},
    {title: 'Item title2'},
    {title: 'Item title3'},
    {title: 'Item title4'},
  ];

  constructor() { }

}
