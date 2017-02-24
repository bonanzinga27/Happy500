import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';


@Injectable()
export class TypesFundingService {

  constructor(
    private http: Http
  ) { }

  getList() {
    /*return this.http.get('http://localhost:8080/getFinanziamenti')
      .map((res:Response) => res.json());*/
    return [
        {nome: "Primo", descrizione: "Descrizioneeeeeeee"},
        {nome: "Secondo", descrizione: "Descrizioneeeeeeee"},
        {nome: "Terzo", descrizione: "Descrizioneeeeeeee"},
    ]
  }

}
