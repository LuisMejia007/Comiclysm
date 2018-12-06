import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ComiclysmService } from '../services/comiclysm.service';
import {Comic } from '../models/Comic';
import {User} from '../models/User';

@Component({
  selector: 'app-trade-details',
  templateUrl: './trade-details.component.html',
  styleUrls: ['./trade-details.component.css']
})
export class TradeDetailsComponent implements OnInit {

  constructor(
    private routeManager: ActivatedRoute,
    private service: ComiclysmService,
    private router: Router) { }

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


  completeTrade(yourComicInventoryId: number, yourComicId: number) {

    console.log('You wanna trade: ' + yourComicInventoryId + ' for: ' + this.comicForTradeId);
    const saveInvIdBeforeUpdate = this.comicForTradeInventoryId;
    // First Update Comic For Trade
    this.service.switchInventoryIds(this.comicForTradeInventoryId, yourComicInventoryId, this.comicForTradeId).subscribe();
    // Then Update The Comic You Offered
    this.service.switchInventoryIds(yourComicInventoryId, saveInvIdBeforeUpdate, yourComicId).subscribe();

    this.service.removeComicFromTrade(this.comicForTradeId);
    this.router.navigate(['/inventory']);

  }
}
