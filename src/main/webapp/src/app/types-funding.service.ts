import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';


@Injectable()
export class TypesFundingService {

  list = [
    {name: "Nome1"},
    {name: "Nome2"}
  ];

  constructor(private http: Http) { }

  getFundingList() {
    return this.http.get('http://138.68.133.189/ebuonweekend-web/search?city=roma')
      .map(response => response.json());
  }

}
