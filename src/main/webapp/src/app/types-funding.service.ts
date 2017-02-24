import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';


@Injectable()
export class TypesFundingService {

  constructor(
    private http: Http
  ) { }

  getList() {
    return this.http.get('http://138.68.133.189/ebuonweekend-web/search?city=roma')
      .map((res:Response) => res.json());
  }

}
