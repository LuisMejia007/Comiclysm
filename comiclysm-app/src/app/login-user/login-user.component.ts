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

  user: User = new User();
  userName: string;
  userPassword: string;
  loginSuccessful: boolean;

  constructor(private service: ComiclysmService, private router: Router) { }

  ngOnInit() {
  }

  userLogin(userName: string , userPassword: string) {

    this.user.setUserName(userName); this.user.setUserPassword(userPassword);
    console.log('USers: ' + this.user.getUserName() + ' ' + this.user.getUserPassword());
    this.service.userLogin(this.user).subscribe(data => {
      console.log('Value Returned by REST:' + data);
      this.loginSuccessful = data;
      console.log('Login: ' + this.loginSuccessful);
    });

    if (this.loginSuccessful === false) {
      alert('User not found! Please make sure to type in correct User Name and/or Password.');
      this.router.navigate(['/login']);
    } else {
      this.router.navigate(['/home']);
    }
  }

}
