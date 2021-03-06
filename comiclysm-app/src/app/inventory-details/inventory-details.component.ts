import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { Comic } from '../models/Comic';
import { ComiclysmService } from '../services/comiclysm.service';
import { Trade } from '../models/Trade';

@Component({
  selector: 'app-inventory-details',
  templateUrl: './inventory-details.component.html',
  styleUrls: ['./inventory-details.component.css']
})
export class InventoryDetailsComponent implements OnInit {

  constructor(private service: ComiclysmService,
    private activatedRoute: ActivatedRoute,
    private route: Router) { }

  inventoryName: string;
  inventoryID: string;
  listOfComics: Comic[] = [];
  ngOnInit() {
    this.inventoryName = this.activatedRoute.snapshot.paramMap.get('inventoryName');
    this.inventoryID = this.activatedRoute.snapshot.paramMap.get('inventoryId');
    this.getComicsFromInventory(this.inventoryID);
  }


  getComicsFromInventory(inventoryId: string) {
        this.service
        .getComicsFromInventory(+inventoryId)
        .subscribe(comics => this.listOfComics = comics);
  }


  addComicToTrade(comic: Comic) {
    const trade = new Trade();
    trade.setTradeComicToTradeId(comic.comicId);
    this.service.addComicToTrade(trade).subscribe();
    this.route.navigate(['/inventory']);
  }

}
