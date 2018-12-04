import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Router, Routes} from '@angular/router';
import { RegisterUserComponentComponent } from './register-user-component/register-user-component.component';
import { HomeComponent } from './home/home.component';
import { FeaturedHeroesComponent } from './featured-heroes/featured-heroes.component';
import {MainComicListComponent} from './main-comic-list/main-comic-list.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { UserInventoryComponent } from './user-inventory/user-inventory.component';
import { TradeComponent } from './trade/trade.component';
import { ComicDetailsComponent } from './comic-details/comic-details.component';
import { InventoryDetailsComponent } from './inventory-details/inventory-details.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: LoginUserComponent},
  { path: 'register', component: RegisterUserComponentComponent},
  { path: 'home', component: HomeComponent},
  { path: 'inventory', component: UserInventoryComponent},
  { path: 'trade', component: TradeComponent},
  { path: 'seeAllFeaturedHeroes', component: FeaturedHeroesComponent},
  { path: 'showComics', component: MainComicListComponent},
  { path: 'comic/:name', component: ComicDetailsComponent},
  { path: 'inventoryDetails/:inventoryName/:inventoryId', component: InventoryDetailsComponent}
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
