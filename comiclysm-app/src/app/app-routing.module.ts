import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Router, Routes} from '@angular/router';
import { RegisterUserComponentComponent } from './register-user-component/register-user-component.component';
import { HomeComponent } from './home/home.component';
import { FeaturedHeroesComponent } from './featured-heroes/featured-heroes.component';
import {MainComicListComponent} from './main-comic-list/main-comic-list.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: RegisterUserComponentComponent},
  { path: 'home', component: HomeComponent},
  { path: 'seeAllFeaturedHeroes', component: FeaturedHeroesComponent},
  { path: 'showComics', component: MainComicListComponent}
];
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
