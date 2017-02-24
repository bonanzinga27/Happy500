import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm = new FormGroup({
    email: new FormControl("", Validators.required),
    password: new FormControl("", Validators.required)
  });

  constructor(
    private loginService:LoginService
  ) { }

  risp = {};



public static tokenizerScript() {
  let hashParams = window.location.hash.substr(1).split('&'); // substr(1) to remove the `#`
  for (let i = 0; i < hashParams.length; i++) {
    let p = hashParams[i].split('=');
    (<HTMLInputElement>document.getElementById(p[0])).value = decodeURIComponent(p[1]);
  }
  console.log("ciaoooooo");
}



doLogin(){
    console.log(this.loginForm.value);
    this.loginService.login(this.loginForm.value)
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          console.log(risposta.returnObject.email);
        }else{
          console.log("errore, login fallita");
        }
      });
    console.log(this.risp);
  }

  ngOnInit() {
  }

}
