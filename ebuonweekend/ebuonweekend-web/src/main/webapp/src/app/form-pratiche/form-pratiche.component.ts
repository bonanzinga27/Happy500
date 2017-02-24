import { Component, OnInit } from '@angular/core';
import {TabsService} from "../tabs.service";

@Component({
  selector: 'app-form-pratiche',
  templateUrl: './form-pratiche.component.html',
  styleUrls: ['./form-pratiche.component.css']
})
export class FormPraticheComponent implements OnInit {

  isSelected(id){
    if(id === this.tabs.currentPage){
      return true;
    }else{
      return false;
    }
  }

  constructor(private tabs:TabsService) { }

  ngOnInit() {
  }

}
