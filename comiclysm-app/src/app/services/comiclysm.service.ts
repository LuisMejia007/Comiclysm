
import {HttpHeaders,  HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({'string-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ComiclysmService {

  constructor(private http: HttpClient) {
  }

  addUser(newUser: User): Observable<User> {
      const url = 'http://localhost:8080/login/' + newUser.getUserName() + '_' + newUser.getUserPassword();
      console.log(url);
      return this.http.post<User>(url, newUser, httpOptions);
  }
}
