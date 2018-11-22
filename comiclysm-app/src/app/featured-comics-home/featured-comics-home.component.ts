import { Component, OnInit } from '@angular/core';
import { Comic } from '../models/Comic';
import { ComiclysmService } from '../services/comiclysm.service';

@Component({
  selector: 'app-featured-comics-home',
  templateUrl: './featured-comics-home.component.html',
  styleUrls: ['./featured-comics-home.component.css']
})
export class FeaturedComicsHomeComponent implements OnInit {


  featuredComics: Comic[];
  constructor(private service: ComiclysmService) { }

  ngOnInit() {
  this.service.getFeaturedComics().subscribe(comics => this.featuredComics = comics);
  }

}
