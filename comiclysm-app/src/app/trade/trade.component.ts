import { Component, OnInit } from '@angular/core';
import { ComiclysmService } from '../services/comiclysm.service';
import { Comic } from '../models/Comic';
import { Router } from '@angular/router';
import { User } from '../models/User';

@Component({
  selector: 'app-trade',
  templateUrl: './trade.component.html',
  styleUrls: ['./trade.component.css']
})
export class TradeComponent implements OnInit {

  constructor(private service: ComiclysmService, private router: Router) { }

  comicsInTrade: Comic[] = [];
  loggedUser: User;
  ngOnInit() {
    this.getComicsInTrade();
  }

  getComicsInTrade() {
    this.loggedUser = JSON.parse(localStorage.getItem('LoggedUser'));
    const userId = this.loggedUser.userId;
    this.service.getComicsInTrade(userId).subscribe( comics => this.comicsInTrade = comics);
  }

  goToTradeDetails(inventoryId: number, comicId: number) {
    this.router.navigate(['tradeDetails/' + inventoryId + '/' + comicId]);
  }
}
