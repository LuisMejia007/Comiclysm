import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterUserComponentComponent } from './register-user-component/register-user-component.component';
import { AppRoutingModule } from './/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import { ComiclysmService } from './services/comiclysm.service';
import { HomeComponent } from './home/home.component';
import { FeaturedHeroesComponent } from './featured-heroes/featured-heroes.component';
import { FeaturedVolumesComponent } from './featured-volumes/featured-volumes.component';
import { FeaturedComicsComponent } from './featured-comics/featured-comics.component';
import { SideNavigationComponent } from './side-navigation/side-navigation.component';
import { FeaturedHeroesHomeComponent } from './featured-heroes-home/featured-heroes-home.component';
import { FeaturedVolumesHomeComponent } from './featured-volumes-home/featured-volumes-home.component';
import { FeaturedComicsHomeComponent } from './featured-comics-home/featured-comics-home.component';
import { ComicCardComponent } from './comic-card/comic-card.component';
import { MainComicListComponent } from './main-comic-list/main-comic-list.component';
import { SideBarFilterComponent } from './side-bar-filter/side-bar-filter.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { UserInventoryComponent } from './user-inventory/user-inventory.component';
import { TradeComponent } from './trade/trade.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterUserComponentComponent,
    HomeComponent,
    FeaturedHeroesComponent,
    FeaturedVolumesComponent,
    FeaturedComicsComponent,
    SideNavigationComponent,
    FeaturedHeroesHomeComponent,
    FeaturedVolumesHomeComponent,
    FeaturedComicsHomeComponent,
    ComicCardComponent,
    MainComicListComponent,
    SideBarFilterComponent,
    NavBarComponent,
    LoginUserComponent,
    UserInventoryComponent,
    TradeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule,
    FormsModule
  ],
  providers: [ ComiclysmService],
  bootstrap: [AppComponent]
})
export class AppModule { }
