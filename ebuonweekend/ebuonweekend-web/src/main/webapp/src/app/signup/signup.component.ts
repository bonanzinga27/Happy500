import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

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
    private registerService:RegisterService
  ) { }

  risp = {};

  doSignup(){
    console.log(this.signUpForm.value);
    this.registerService.signup(this.signUpForm.value)
      .subscribe(risposta => {
          if (risposta.returnObject != null){
            console.log(risposta.returnObject.email);
          }else{
            console.log("errore, registrazione fallita");
          }
      });
    console.log(this.risp);
  }

  ngOnInit() {
  }

}
