import { Component, OnInit } from '@angular/core';
import { TravelfareServiceService } from '../travelfare-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private travelfareServiceService: TravelfareServiceService) { }

  ngOnInit() {
   // this.getdashboard();
  }
}
