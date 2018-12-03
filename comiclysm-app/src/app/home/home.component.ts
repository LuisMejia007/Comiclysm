import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }
  user: string;
  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('LoggedUser'));
  }

}
