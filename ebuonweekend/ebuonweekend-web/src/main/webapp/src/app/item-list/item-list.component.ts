import { Component, OnInit } from '@angular/core';
import {TabsService} from "../tabs.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  private setTab(currentTab){
    this.tabs.currentPage = currentTab;
  }
  private isSelected(id){
    return this.tabs.currentPage === id;
  };
  constructor(private tabs:TabsService, private router:Router) { }

  ngOnInit() {
  }
}
