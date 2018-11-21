import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterUserComponentComponent } from './register-user-component/register-user-component.component';
import { AppRoutingModule } from './/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import { ComiclysmService } from './services/comiclysm.service';

@NgModule({
  declarations: [
    AppComponent,
    RegisterUserComponentComponent
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
