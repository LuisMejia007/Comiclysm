import { Component, OnInit } from '@angular/core';
import {Inventory} from '../models/Inventory';
import {User} from '../models/User';
import { ComiclysmService } from '../services/comiclysm.service';

@Component({
  selector: 'app-user-inventory',
  templateUrl: './user-inventory.component.html',
  styleUrls: ['./user-inventory.component.css']
})
export class UserInventoryComponent implements OnInit {

  constructor(private service: ComiclysmService) { }

  inventoryList: Inventory[] = [];
  newInventory: Inventory = new Inventory();
  addAnInventory = false;
  newInventoryName: string;
  inventoryOwner: User;
  inventoryOwnerName: string;
  inventoryUserId: number;

  ngOnInit() {
    this.inventoryOwner = JSON.parse(localStorage.getItem('LoggedUser'));
    this.inventoryOwnerName = this.inventoryOwner.userName;
    this.inventoryUserId = this.inventoryOwner.userId;
  }

  addInventory(inventoryName: string) {
    this.newInventory.setInventoryName(inventoryName);
    this.newInventory.setInventoryUserId(this.inventoryUserId);
    this.service.addInventoryService(this.newInventory).subscribe();
    this.addAnInventory = false;
  }
}
