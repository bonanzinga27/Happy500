import { Component } from '@angular/core';
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public isLogged(){
    if (Cookie.get('email') != null){
      console.log(Cookie.get('email'));
      console.log(Cookie.get('password'));
      return true;
    }else{
      return false;
    }
  };
  title = 'app works!';
}
