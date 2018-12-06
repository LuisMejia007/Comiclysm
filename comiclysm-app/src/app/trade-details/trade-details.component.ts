import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ComiclysmService } from '../services/comiclysm.service';
import {Comic } from '../models/Comic';
import {User} from '../models/User';

@Component({
  selector: 'app-trade-details',
  templateUrl: './trade-details.component.html',
  styleUrls: ['./trade-details.component.css']
})
export class TradeDetailsComponent implements OnInit {

  constructor(private routeManager: ActivatedRoute, private service: ComiclysmService) { }

  comicForTradeInventoryId: number;
  comicForTradeId: number;
  comicForTrade: Comic;
  loggedUser: User;
  yourUserId: number;
  yourComics: Comic[] = [];
  ngOnInit() {
    this.getComicFromInventory();
    this.getComicsFromYourInventory();
  }

  getComicFromInventory() {
    this.comicForTradeInventoryId = parseInt(this.routeManager.snapshot.paramMap.get('comicInventoryId'), 10);

    this.comicForTradeId = parseInt(this.routeManager.snapshot.paramMap.get('comicId'), 10);

    this.service
    .getComicByInventoryId(this.comicForTradeInventoryId, this.comicForTradeId)
    .subscribe(comic => {
      console.log('Comic: '  + comic);
      this.comicForTrade = comic;
    });
  }


  getComicsFromYourInventory() {
    this.loggedUser = JSON.parse(localStorage.getItem('LoggedUser'));
    this.yourUserId = this.loggedUser.userId;
    this.service
    .getComicsFromYourInventories(this.yourUserId)
    .subscribe(comics => this.yourComics = comics);
  }
}
