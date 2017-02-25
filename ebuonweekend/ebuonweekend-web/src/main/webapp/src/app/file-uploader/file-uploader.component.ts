import { Component, OnInit ,ElementRef, Input, ViewChild} from '@angular/core';
import {Http, Response, RequestOptions, Headers} from '@angular/http';
import {Observable} from "rxjs";

const URL = 'http://localhost:8080/uploadFile?idPratica=1';

@Component({
  selector: 'app-file-uploader',
  template: '<input type="file" [multiple]="multiple" #fileInput>'
})
export class FileUploaderComponent implements OnInit {
  @Input() multiple: boolean = false;
  @ViewChild('fileInput') inputEl: ElementRef;

  constructor(private _http: Http) { }

  ngOnInit() {
  }

  private extractData(res: Response) {
    let body = res.json();
    return body.data || { };
  }

  private handleError (error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

  uploadFile() {
    console.log("hola");
    let inputEl: HTMLInputElement = this.inputEl.nativeElement;
    let fileCount: number = inputEl.files.length;
    let formData = new FormData();
    if (fileCount > 0) { // a file was selected
      for (let i = 0; i < fileCount; i++) {
        console.log(inputEl.files.item(i));

        formData.append('file', inputEl.files.item(i),inputEl.files.item(i).name);
        let headers = new Headers();
        headers.append('Content-Type', 'multipart/form-data');
        headers.append('Accept', 'application/json');
        let options = new RequestOptions({ headers: headers });
      }
      console.log(formData);
      this._http.post(URL, formData).map(res => res.json())
        .catch(error => Observable.throw(error))
        .subscribe(
          data => console.log('success'),
          error => console.log(error)
        )
    }
  }


}


