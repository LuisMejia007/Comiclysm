import { Component, OnInit } from '@angular/core';
import { Comic } from '../models/Comic';
import { ActivatedRoute } from '@angular/router';
import { ComiclysmService } from '../services/comiclysm.service';

@Component({
  selector: 'app-comic-details',
  templateUrl: './comic-details.component.html',
  styleUrls: ['./comic-details.component.css']
})
export class ComicDetailsComponent implements OnInit {

  constructor(private service: ComiclysmService,
    private route: ActivatedRoute) { }
  comic: Comic;
  ngOnInit() {
    this.getComicBook();
  }


  getComicBook() {
    const comicBookName = this.route.snapshot.paramMap.get('name');
    this.service.getAComicByName(comicBookName).subscribe(comicBook => this.comic = comicBook);
  }

}
