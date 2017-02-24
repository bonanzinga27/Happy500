import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class RegisterService {

  constructor(
    private http: Http
  ) { }

  signup(user){
    /*return this.http.get('http://localhost:8080/register?email='+user.email+'&pass='+user.password)
      .map((res:Response) => res.json());*/
  }


}
