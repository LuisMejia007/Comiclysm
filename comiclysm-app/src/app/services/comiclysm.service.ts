
import {HttpHeaders,  HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Comic } from '../models/Comic';
import {Inventory} from '../models/Inventory';
import { Trade } from '../models/Trade';

const httpOptions = {
  headers: new HttpHeaders({'string-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ComiclysmService {

  base_url = 'http://localhost:8080/';
  ip_base_url = '10.35.46.112:/';

  constructor(private http: HttpClient) {
  }

  /*** User Login Services ****/
  addUser(newUser: User): Observable<User> {
      const url = 'http://localhost:8080/register/' + newUser.getUserName() + '_' + newUser.getUserPassword();
      console.log(url);
      return this.http.post<User>(url, newUser, httpOptions);
  }


  userLogin(returningUser: User): Observable<User> {
    const url = 'http://localhost:8080/login/' + returningUser.getUserName() + '_' + returningUser.getUserPassword();
    return this.http.get<User>(url, httpOptions);
  }


  /*** Comic Services (GET) ***/
  getFeaturedComics(): Observable<Comic[]> {
    const url = 'http://localhost:8080/getFeaturedComics';
    return this.http.get<Comic[]>(url, httpOptions);
  }

  getPageOfComics(pageNum: number) {
    return this.http.get(this.base_url + 'showComics/page=' + pageNum.toString());
  }

  getPageOfComicsByName(name: string, pageNum: number): Observable<any>   {
    name = name.replace(' ', '');
    return this.http.get(this.base_url + 'showComicsByName/' + name + '/page=' + pageNum.toString());
  }
  getPageOfComicsByWriter(writer: string, pageNum: number): Observable<any>  {
    writer = writer.replace(' ', '');
    return this.http.get(this.base_url + 'showComicsByWriter/' + writer + '/page=' + pageNum.toString());
  }

  getPageOfComicsByArtist(artist: string, pageNum: number): Observable<any>  {
    artist = artist.replace(' ', '');
    return this.http.get(this.base_url + 'showComicsByArtist/' + artist + '/page=' + pageNum.toString());
  }

  getPageOfComicsByDate(date: string, pageNum: number): Observable<any>  {
    date = date.replace(' ', '');
    return this.http.get(this.base_url + 'showComicsByDate/' + date + '/page=' + pageNum.toString());
  }

  getAComicByName(comicName: string): Observable<any> {
    comicName = comicName.replace(' ', '_');
    comicName = comicName.replace('#', '_');
    return this.http.get(this.base_url + 'comicDetails/' + comicName);
  }
  /*** Inventory Services ***/
  addInventoryService(inventory: Inventory): Observable<Inventory> {
    const url = 'addInventory/' + inventory.getInventoryName() + '_' + inventory.getInventoryUserId().toString();
    console.log('Called Service:' + inventory.getInventoryName() + ' ' + inventory.getInventoryUserId());
    return this.http.post<Inventory>(this.base_url + url, inventory, httpOptions);
  }

  getMyInventoriesByUserId(userId: number): Observable<Inventory[]> {
    const url = 'getMyInventories/' + userId.toString();
    return this.http.get<Inventory[]>(this.base_url + url, httpOptions);
  }


  addComicToInventory(comicId: number, userInventoryId: number): Observable<any> {
    const url = this.base_url + 'addComicToInventory/' + userInventoryId + '/' + comicId;
     return this.http.put(url, httpOptions);
  }


  getComicsFromInventory(inventoryId: number ): Observable<Comic[]> {
    const url = this.base_url + 'getComicsFromInventory/inventory=' + inventoryId;
    return this.http.get<Comic[]>(url, httpOptions);
  }

  getComicByInventoryId(inventoryId: number, comicName: number): Observable<any> {
    const url = this.base_url + 'getComicByInventoryId/inventory=' + inventoryId + '/comic=' + comicName;
    return this.http.get(url, httpOptions);
  }


  /*** Trade Services  ***/
  addComicToTrade(trade: Trade): Observable<Trade> {
    const url = this.base_url + 'addComicToTrade/' + trade.getTradeComicToTradeId();
    return this.http.post<Trade>(url, trade, httpOptions);
  }

  getComicsInTrade(userId: number): Observable<Comic[]> {
    const url = this.base_url + 'getComicsInTrade/' + userId;
    return this.http.get<Comic[]>(url, httpOptions);
  }

  getComicsFromYourInventories(userId: number): Observable<Comic[]> {
    const url = this.base_url + 'getComicsFromYourInventories/user=' + userId;
    return this.http.get<Comic[]>(url, httpOptions);
  }


  switchInventoryIds(oldInventoryId: number, newInventoryId: number, comicId: number) {
    const url = this.base_url + 'tradeComics/' + oldInventoryId + '/' + newInventoryId + '/' + comicId;
    return this.http.put(url, httpOptions);
  }

  removeComicFromTrade(comicId: number) {
    const url = this.base_url + 'removeFromTrade/' + comicId;
    return this.http.delete(url, httpOptions);
  }

}
