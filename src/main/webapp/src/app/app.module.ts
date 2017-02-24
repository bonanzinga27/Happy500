import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FormPraticheComponent } from './form-pratiche/form-pratiche.component';
import { CardContainerComponent } from './card-container/card-container.component';
import { CardComponent } from './card/card.component';


import { ItemListComponent } from './item-list/item-list.component';
import {TabsService} from "./tabs.service";
import {TypesFundingService} from "./types-funding.service";

const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'pratica',   component: FormPraticheComponent },
  { path: 'home',   component: CardContainerComponent },
  { path: '**', redirectTo: '/login' },
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    FormPraticheComponent,
    CardContainerComponent,
    CardComponent,
    ItemListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    TypesFundingService,
    TabsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
