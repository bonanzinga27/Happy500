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

import {TabsService} from "./tabs.service";
import {TypesFundingService} from "./types-funding.service";
import {RegisterService} from "./register.service";
import {LoginService} from "./login.service";
import { DatiPraticaComponent } from './dati-pratica/dati-pratica.component';
import { DocumentazioneComponent } from './documentazione/documentazione.component';
import { FormAccountComponent } from './form-account/form-account.component';
import { FinCompletiComponent } from './fin-completi/fin-completi.component';
import { FinIncompletiComponent } from './fin-incompleti/fin-incompleti.component';
import { FileUploaderComponent } from './file-uploader/file-uploader.component';
import {PraticaService} from "./pratica.service";

const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'pratica',   component: FormPraticheComponent },
  { path: 'home',   component: CardContainerComponent },
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
    FinIncompletiComponent
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
    PraticaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
