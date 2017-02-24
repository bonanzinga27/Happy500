import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Cookie } from 'ng2-cookies/ng2-cookies';


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

  doLogin(){
    console.log(this.loginForm.value);
    this.loginService.login(this.loginForm.value)
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          console.log(risposta.returnObject.email);
          Cookie.set('email', risposta.returnObject.email, 1 /*days from now*/);
          /*Cookie.set('password', this.loginForm.password.value, 1 );*/
        }else{
          console.log("errore, login fallita");
        }
      });
    console.log(this.risp);
  }

  ngOnInit() {
  }

}
