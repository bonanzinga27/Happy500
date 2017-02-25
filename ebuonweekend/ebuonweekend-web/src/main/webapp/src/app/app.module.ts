import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes} from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { Cookie } from 'ng2-cookies/ng2-cookies';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FormPraticheComponent } from './form-pratiche/form-pratiche.component';
import { CardContainerComponent } from './card-container/card-container.component';
import { CardComponent } from './card/card.component';


import { DatiPraticaComponent } from './dati-pratica/dati-pratica.component';
import { DocumentazioneComponent } from './documentazione/documentazione.component';
import { ItemListComponent } from './item-list/item-list.component';
import { DatiPersonaliComponent } from './dati-personali/dati-personali.component';
import { DatiOrganizzazioneComponent } from './dati-organizzazione/dati-organizzazione.component';
import { FormAccountComponent } from './form-account/form-account.component';
import { FinCompletiComponent } from './fin-completi/fin-completi.component';
import { FinIncompletiComponent } from './fin-incompleti/fin-incompleti.component';
import { FileUploaderComponent } from './file-uploader/file-uploader.component';

import {TabsService} from "./tabs.service";
import {TypesFundingService} from "./types-funding.service";
import {RegisterService} from "./register.service";
import {LoginService} from "./login.service";
import {AccountServiceService} from "./account-service.service";

import {PraticaService} from "./pratica.service";
import { AccountListComponent } from './account-list/account-list.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'pratica',   component: FormPraticheComponent },
  { path: 'home',   component: CardContainerComponent },
  { path: 'account',   component: FormAccountComponent },
  { path: 'account',   component: FinCompletiComponent },
  { path: 'account',   component: FinIncompletiComponent },
  { path: '**', redirectTo: '/login' },
  { path: 'upload',   component: FileUploaderComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    FormPraticheComponent,
    CardContainerComponent,
    CardComponent,
    ItemListComponent,
    DatiPersonaliComponent,
    DatiOrganizzazioneComponent,
    FileUploaderComponent,
    DatiPraticaComponent,
    DocumentazioneComponent,
    FormAccountComponent,
    FinCompletiComponent,
    FinIncompletiComponent,
    AccountListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule
  ],
  providers: [
    TypesFundingService,
    TabsService,
    RegisterService,
    LoginService,
    Cookie,
    PraticaService,
    AccountServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
