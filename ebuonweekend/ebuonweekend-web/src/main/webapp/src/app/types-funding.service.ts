import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from "rxjs";


@Injectable()
export class TypesFundingService {

  constructor(
    private http: Http
  ) { }

  getList() {
    return this.http.get('http://localhost:8080/getFinanziamenti')
      .map((res:Response) => res.json());
  }

  nuovaPratica(nomeFinanz, myEmail) {

    let api = 'http://localhost:8080/insertPratica?email='+myEmail+'&tipo='+nomeFinanz;

    let tmp = [
      { email: myEmail },
      { tipo: nomeFinanz }
    ];

    let bodyString = JSON.stringify(tmp); // Stringify payload
    let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
    let options = new RequestOptions({ headers: headers }); // Create a request option

    return this.http.post(api, bodyString, options) // ...using post request
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  }

}
