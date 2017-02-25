import {Component, OnInit, Input} from '@angular/core';
import { FormGroup, Validators, FormControl} from "@angular/forms";
import {PraticaService} from "../pratica.service";
import {Router} from "@angular/router";
import {TabsService} from "../tabs.service";

@Component({
  selector: 'app-dati-organizzazione',
  templateUrl: './dati-organizzazione.component.html',
  styleUrls: ['./dati-organizzazione.component.css']
})
export class DatiOrganizzazioneComponent implements OnInit {

  @Input() dati;    //utilizzato per il two binding

  public organizzazioneForm = new FormGroup({
      id:             new FormControl(),
      denominazione:  new FormControl(),
      ragioneSociale: new FormControl(),
      piva:           new FormControl(),
      citta:          new FormControl(),
      indirizzo:      new FormControl(),
      provincia:      new FormControl(),
      cap:            new FormControl(),
      stato:          new FormControl(),
      email:          new FormControl()
  });

  constructor(
    private praticaService:PraticaService,
    private router:Router,
    private tabs:TabsService
  ) { }

  risp = {};

  editOrganizzazione(){
    console.log(this.organizzazioneForm.value);
    this.praticaService.editOrganizzazione(this.organizzazioneForm.value)
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.tabs.setTab(2); /* Next tab is 2 */
          console.log("Dati Organizzazione inviati correttamente");
        }else{
          console.log("Dati non inviati");
        }
      });
    console.log(this.risp);
  }

  ngOnInit() {
  }


}
