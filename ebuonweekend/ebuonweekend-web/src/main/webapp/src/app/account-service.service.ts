import { Injectable } from '@angular/core';

@Injectable()
export class AccountServiceService {
  currentPage = 0;

  public setTab(id){
    this.currentPage = id;
  }
  public getTab(){
    return this.currentPage;
  }

  tabAccount = [
    {id:0, title: 'Pratiche completate', path: "/account/completate"},
    {id:1, title: 'Pratiche in sospeso', path: "/account/sospese"}
    ];

  constructor() { }

}
