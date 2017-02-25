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

  editRichiedente(user){
    let api = 'http://localhost:8080/editRichiedente?'+
                          'id='+ Cookie.get('idRichiedente') +
                          '&nome='+user.nome+
                          '&cognome='+user.cognome+
                          '&codFisc='+user.codFisc+
                          '&dataNascita='+user.dataNascita+
                          '&cittaNascita='+user.cittaNascita+
                          '&provinciaNascita='+user.provinciaNascita+
                          '&telefono='+user.telefono+
                          '&cittaResidenza='+user.cittaResidenza+
                          '&provinciaResidenza='+user.provinciaResidenza+
                          '&indirizzoResidenza='+user.indirizzoResidenza+
                          '&emailRichiedente='+user.emailRichiedente+
                          '&cartaIdentitaPath='+user.cartaIdentitaPath+
                          '&codFiscPath='+user.codiceFiscPath+
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

  getRichiedente(id) {
    return this.http.get('http://localhost:8080/getRichiedente?id=' + id)
      .map((res:Response) => res.json());
  }

  editOrganizzazione(user){
    let api = 'http://localhost:8080/editOrganizzazione?'+
      'id='+ Cookie.get('idOrganizzazione') +
      '&denominazione='+user.denominazione+
      '&ragioneSociale='+user.ragioneSociale+
      '&piva='+user.piva+
      '&citta='+user.citta+
      '&indirizzo='+user.indirizzo+
      '&provincia='+user.provincia+
      '&cap='+user.cap+
      '&stato='+user.stato+
      '&email='+user.email;

    let bodyString = JSON.stringify(user); // Stringify payload
    let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
    let options = new RequestOptions({ headers: headers }); // Create a request option

    return this.http.post(api, bodyString, options) // ...using post request
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  }

  editPratica(user){
    let api = 'http://localhost:8080/editPratica?'+
      'id='+ Cookie.get('idRichiedente') +
      '&tipologia='+user.nome+
      '&importo='+user.importo+
      '&completata='+'1'+
      '&numDipendenti='+user.dipendenti+
      '&durata='+user.durata+
      '&iban='+'1000'+
      '&descrizioneProgetto='+user.descrizione;

    let bodyString = JSON.stringify(user); // Stringify payload
    let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
    let options = new RequestOptions({ headers: headers }); // Create a request option

    return this.http.post(api, bodyString, options) // ...using post request
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  }

}
