import { Component, OnInit } from '@angular/core';
import {RegisterService} from '../register.service';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public signUpform = this.fb.group({
    email:["", Validators.required],
    password:["", Validators.required]
  });


  constructor(public fb: FormBuilder, private registerService:RegisterService) { }

  doSignup(event){
    this.registerService.signup(event);
  }

  ngOnInit() {
  }

}
