import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { ComiclysmService } from '../services/comiclysm.service';

@Component({
  selector: 'app-register-user-component',
  templateUrl: './register-user-component.component.html',
  styleUrls: ['./register-user-component.component.css']
})
export class RegisterUserComponentComponent implements OnInit {


  userName: string;
  userPassword: string;
  newUser: User;

  constructor(private service: ComiclysmService) { }

  ngOnInit() {
  }

  registerUser(userName: string, userPassword: string) {

    if (userName == null || userPassword == null) {
      alert('No username or password placed. Please try again');
      return;
    }

    this.newUser = new User();
    this.newUser.setUserName(userName);
    this.newUser.setUserPassword(userPassword);

    this.service.addUser(this.newUser).subscribe();
  }


}
