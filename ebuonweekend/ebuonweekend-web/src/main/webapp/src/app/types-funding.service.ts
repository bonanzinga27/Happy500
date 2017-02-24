import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';


@Injectable()
export class TypesFundingService {

  constructor(
    private http: Http
  ) { }

  getList() {
    return this.http.get('http://localhost:8080/register?email=passerotto&pass=coglione')
      .map((res:Response) => res.json());
  }

}
