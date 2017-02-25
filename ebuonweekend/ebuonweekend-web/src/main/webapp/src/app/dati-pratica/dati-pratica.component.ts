import {Component, OnInit, Input} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {PraticaService} from "../pratica.service";
import {TabsService} from "../tabs.service";


@Component({
  selector: 'app-dati-pratica',
  templateUrl: './dati-pratica.component.html',
  styleUrls: ['./dati-pratica.component.css']
})
export class DatiPraticaComponent implements OnInit {

  @Input() dati;    //utilizzato per il two binding

  public praticaForm = new FormGroup({
    descrizione: new FormControl(),
    importo:     new FormControl(),
    dipendenti:  new FormControl(),
    durata:      new FormControl()
  });

  constructor(
    private pratica:PraticaService,
    private tabs: TabsService
  ) { }

  public editPratica(){
    console.log(this.praticaForm.value);
    this.pratica.editOrganizzazione(this.praticaForm.value)
      .subscribe(risposta => {
        if (risposta.returnObject != null){
          this.tabs.setTab(4); /* Next tab is 1 */
          console.log("Documentazione inviati correttamente");
        }else{
          console.log("Dati non inviati");
        }
      });
  }

  ngOnInit() {
  }

}
