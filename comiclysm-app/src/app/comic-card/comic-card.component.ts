import { Component, OnInit, Input } from '@angular/core';
import {Comic} from '../models/Comic';

@Component({
  selector: 'app-comic-card',
  templateUrl: './comic-card.component.html',
  styleUrls: ['./comic-card.component.css']
})
export class ComicCardComponent implements OnInit {

 @Input() comic: Comic;
 comicName: string;
  constructor() { }

  ngOnInit() {
    this.comicName = this.comic.comicName.replace(' ', '_');
    this.comicName = this.comicName.replace('#', '_');
  }

}
