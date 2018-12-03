import { Component, OnInit } from '@angular/core';
import { Hero } from '../models/Hero';
import { Router } from '@angular/router';
import {HEROES} from '../models/FeaturedHeroes';

@Component({
  selector: 'app-featured-heroes-home',
  templateUrl: './featured-heroes-home.component.html',
  styleUrls: ['./featured-heroes-home.component.css']
})
export class FeaturedHeroesHomeComponent implements OnInit {

  featuredHeroes: Hero[] = [];
  constructor(
    private router: Router
  ) { }

  ngOnInit() {
    this.featuredHeroes[0] = HEROES[0];
    this.featuredHeroes[2] = HEROES[2];
    this.featuredHeroes[1] = HEROES[1];
    this.featuredHeroes[3] = HEROES[3];
    this.featuredHeroes[4] = HEROES[4];
  }

}
