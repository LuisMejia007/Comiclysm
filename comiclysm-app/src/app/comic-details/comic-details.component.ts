import { Component, OnInit } from '@angular/core';
import { Comic } from '../models/Comic';
import { ActivatedRoute } from '@angular/router';
import { ComiclysmService } from '../services/comiclysm.service';
import { Inventory } from '../models/Inventory';

@Component({
  selector: 'app-comic-details',
  templateUrl: './comic-details.component.html',
  styleUrls: ['./comic-details.component.css']
})
export class ComicDetailsComponent implements OnInit {

  constructor(private service: ComiclysmService,
    private route: ActivatedRoute) { }
  comic: Comic;
  userInventories: Inventory[] = [];
  displayInventories = false;
  comicBookName = '';
  userInventoryId: number;

  ngOnInit() {
    this.getComicBook();
  }


  getComicBook() {
    const comicBookName = this.route.snapshot.paramMap.get('name');
    this.service.getAComicByName(comicBookName).subscribe(comicBook => this.comic = comicBook);
  }

  toggleInventoriesToDisplay() {
    this.displayInventories = !this.displayInventories;
    if (this.displayInventories === true) {
      this.displayUserInventories();
    }
  }

  displayUserInventories() {
     this.userInventories = JSON.parse(localStorage.getItem('LoggedUserInventories'));
  }

  addComicToInventory(inventoryId: number) {
    console.log('Add ' + this.comic.comicId + ' to ' + inventoryId);
    console.log('After Replacement:' + this.comicBookName);
    this.service.addComicToInventory(this.comic.comicId, inventoryId).subscribe( data => {
      if (data === false) {
        console.log('Failed To update inventory');
      }
    });
  }

}
