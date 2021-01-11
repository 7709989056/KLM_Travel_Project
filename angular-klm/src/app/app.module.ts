import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TravelfareComponent } from './travelfare/travelfare.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TravelfareServiceService } from './travelfare-service.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DataTablesModule } from 'angular-datatables';

@NgModule({
  declarations: [
    AppComponent,
    TravelfareComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DataTablesModule
  ],
  providers: [TravelfareServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
