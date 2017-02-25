import {Component, OnInit, Input} from '@angular/core';
import {AccountServiceService} from "../account-service.service";

@Component({
  selector: 'app-form-account',
  templateUrl: './form-account.component.html',
  styleUrls: ['./form-account.component.css']
})
export class FormAccountComponent implements OnInit {

  public isSelected(id){
    if(id === this.tabs.currentPage){
      return true;
    }else{
      return false;
    }
  }
  constructor(private tabs:AccountServiceService) { }

  ngOnInit() {
  }

}
