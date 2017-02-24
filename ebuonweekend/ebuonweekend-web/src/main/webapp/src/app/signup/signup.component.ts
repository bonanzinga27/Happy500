import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {

  public signUpForm = new FormGroup({
    email: new FormControl("", Validators.required),
    password: new FormControl("", Validators.required),
    confirmPassword: new FormControl("", Validators.required)
  });

  constructor(
    private registerService:RegisterService,
    private router:Router
  ) { }

  risp = {};

  doSignup(){
    console.log(this.signUpForm.value);
    this.registerService.signup(this.signUpForm.value)
      .subscribe(risposta => {
          if (risposta.returnObject != null){
            console.log(risposta.returnObject.email);
            Cookie.set('email', risposta.returnObject.email, 1 /*days from now*/);
            Cookie.set('password', this.signUpForm.value.password, 1 );
            alert("Registrazione Effettuata");
            this.router.navigate(['../home']);
          }else{
            console.log("errore, signup fallita");
            alert("Errore, ripeti la registrazione");
          }
      });
    console.log(this.risp);
  }

  ngOnInit() {
  }

}
