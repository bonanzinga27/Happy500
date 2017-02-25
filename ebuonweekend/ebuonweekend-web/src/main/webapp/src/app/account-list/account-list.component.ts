import { Component, OnInit } from '@angular/core';
import { AccountServiceService} from '../account-service.service'

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {

  private setTab(currentTab){
    this.tabs.currentPage = currentTab;
  }
  private isSelected(id){
    return this.tabs.currentPage === id;
  };

  constructor(private tabs:AccountServiceService) { }

  ngOnInit() {
  }

}
