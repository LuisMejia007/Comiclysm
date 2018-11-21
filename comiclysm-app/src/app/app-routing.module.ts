import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Router, Routes} from '@angular/router';
import { RegisterUserComponentComponent } from './register-user-component/register-user-component.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: RegisterUserComponentComponent}
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
