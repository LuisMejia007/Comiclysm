import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Router, Routes} from '@angular/router';
import { RegisterUserComponentComponent } from './register-user-component/register-user-component.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: RegisterUserComponentComponent},
  { path: 'home', component: HomeComponent}
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
