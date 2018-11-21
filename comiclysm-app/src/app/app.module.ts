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
    FeaturedComicsHomeComponent
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
