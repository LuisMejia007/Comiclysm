import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Comic } from '../models/Comic';
import { ComiclysmService } from '../services/comiclysm.service';

@Component({
  selector: 'app-inventory-details',
  templateUrl: './inventory-details.component.html',
  styleUrls: ['./inventory-details.component.css']
})
export class InventoryDetailsComponent implements OnInit {

  constructor(private service: ComiclysmService, private activatedRoute: ActivatedRoute) { }

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

}
