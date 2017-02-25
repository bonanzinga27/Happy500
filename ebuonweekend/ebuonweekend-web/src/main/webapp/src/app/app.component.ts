import { Component } from '@angular/core';
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  me = Cookie.get('email');
  public isLogged(){
    if (Cookie.get('email') != null){
      return true;
    }else{
      return false;
    }
  };

  logout(){
    Cookie.deleteAll();
  }
}
