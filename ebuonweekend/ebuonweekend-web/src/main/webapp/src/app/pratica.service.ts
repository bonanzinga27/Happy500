import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Injectable()
export class PraticaService {

  constructor(
    private http: Http
  ) { }

  savePersonalData(user){
    let api = 'http://localhost:8080/insertRichiedente?'+
                          'nome='+user.nome+
                          '&cognome='+user.cognome+
                          '&codFisc='+user.codFisc+
                          '&dataNascita='+user.dataNascita+
                          '&cittaNascita='+user.cittaNascita+
                          '&provNascita='+user.provNascita+
                          '&telefono='+user.telefono+
                          '&cittaResidenza='+user.cittaResidenza+
                          '&provResidenza='+user.provResidenza+
                          '&indirizzoResidenza='+user.indirizzoResidenza+
                          '&emailUtente='+Cookie.get('email')+
                          '&emailRichiedente='+user.emailRichiedente+
                          '&cartaIdentitaPath='+user.cartaIdentitaPath+
                          '&codiceFiscPath='+user.codiceFiscPath+
                          '&sesso='+user.sesso;

    let bodyString = JSON.stringify(user); // Stringify payload
    let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
    let options = new RequestOptions({ headers: headers }); // Create a request option

    return this.http.post(api, bodyString, options) // ...using post request
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  }



  generaCodiceFiscale(user){

    let data = user.dataNascita.split("-");

    return this.http.get('http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?'+
                    'Nome='+user.nome+
                    '&Cognome='+user.cognome+
                    '&ComuneNascita='+user.cittaNascita+
                    '&DataNascita='+data[2]+"/"+data[1]+"/"+data[0]+
                    '&Sesso='+user.sesso)
              .map((res:Response) => res);
  }

}
