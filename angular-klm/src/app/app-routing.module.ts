import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TravelfareComponent } from './travelfare/travelfare.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  { path: 'travelfare', component: TravelfareComponent },
  { path: 'dashboard', component: DashboardComponent },

{
    path: '',
    redirectTo: '/travelfare',
    pathMatch: 'full'
},
{
    path: '**',
    redirectTo: '/travelfare',
    pathMatch: 'full'
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
