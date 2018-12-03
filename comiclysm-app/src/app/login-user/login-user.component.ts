import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
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
      }

    });
  }


  saveToLocalStorage() {
    console.log('Logged User: ' + this.loggedUser.getUserName() + ' ' + this.loggedUser.getUserId());
    localStorage.setItem('LoggedUser', JSON.stringify(this.loggedUser));
    this.router.navigate(['/home']);
  }
}
