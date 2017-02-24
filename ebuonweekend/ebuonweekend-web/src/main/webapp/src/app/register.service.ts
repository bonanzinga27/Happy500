import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';

@Injectable()
export class RegisterService {

  constructor(
    private http: Http
  ) { }

  signup(user){
    let api = 'http://localhost:8080/register?email='+user.email+'&pass='+user.password;
    /*return this.http.get('http://localhost:8080/register?email='+user.email+'&pass='+user.password)
      .map((res:Response) => res.json());*/

    let bodyString = JSON.stringify(user); // Stringify payload
    let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
    let options = new RequestOptions({ headers: headers }); // Create a request option

    return this.http.post(api, bodyString, options) // ...using post request
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  }


}
