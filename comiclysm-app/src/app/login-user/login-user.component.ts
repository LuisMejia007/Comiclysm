import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { Inventory } from '../models/Inventory';
import { ComiclysmService } from '../services/comiclysm.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  constructor(private service: ComiclysmService, private router: Router) { }
  user: User = new User();
  userName: string;
  userPassword: string;
  loggedUser: User = new User();
  userInventories: Inventory[] = [];

  ngOnInit() {
  }

  userLogin(userName: string , userPassword: string) {

    this.user.setUserName(userName);
    this.user.setUserPassword(userPassword);
    console.log('Users: ' + this.user.getUserName() + ' ' + this.user.getUserPassword());

    this.service
    .userLogin(this.user)
    .subscribe(l_user => {
      if (l_user === null) {
          alert('User not found! Please make sure to type in correct User Name and/or Password.');
          this.router.navigate(['/login']);
      } else {
          console.log('Observable User: ' + l_user.userName + ' ' + l_user.userId);
          this.loggedUser.setUserName(l_user.userName);
          this.loggedUser.setUserId(l_user.userId);
          this.saveToLocalStorage();
          this.saveInventoryToLocalStorage();
      }
    });




  }

  saveInventoryToLocalStorage() {
    this.service
    .getMyInventoriesByUserId(this.loggedUser.userId)
    .subscribe(inventories => {
      this.userInventories = inventories;
      localStorage.setItem('LoggedUserInventories', JSON.stringify(this.userInventories));
      this.router.navigate(['/home']);
    });
  }


  saveToLocalStorage() {
    console.log('Logged User: ' + this.loggedUser.getUserName() + ' ' + this.loggedUser.getUserId());
    localStorage.setItem('LoggedUser', JSON.stringify(this.loggedUser));
  }
}
