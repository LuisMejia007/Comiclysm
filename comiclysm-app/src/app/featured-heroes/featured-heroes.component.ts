import { Component, OnInit } from '@angular/core';
import {HEROES } from '../models/FeaturedHeroes';
import { Hero } from '../models/Hero';
@Component({
  selector: 'app-featured-heroes',
  templateUrl: './featured-heroes.component.html',
  styleUrls: ['./featured-heroes.component.css']
})
export class FeaturedHeroesComponent implements OnInit {


  featuredHeroes: Hero[];

  constructor() { }

  ngOnInit() {
    this.featuredHeroes = HEROES;
  }

}
