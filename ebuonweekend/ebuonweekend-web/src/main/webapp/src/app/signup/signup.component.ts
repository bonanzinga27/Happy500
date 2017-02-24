import { Component, OnInit } from '@angular/core';
import {RegisterService} from '../register.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public signUpForm = new FormGroup({
    email: new FormControl("email", Validators.required),
    password: new FormControl("password", Validators.required),
    password_c: new FormControl("password_c", Validators.required)

  });

  constructor(private registerService:RegisterService) { }

  doSignup(event){
    this.registerService.signup(event);
  }

  ngOnInit() {
  }

}
