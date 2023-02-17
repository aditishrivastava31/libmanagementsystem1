import { Component, OnInit } from '@angular/core';
import {MatCardModule} from '@angular/material/card';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  title="";

  constructor() { }

  ngOnInit(): void {
    this.all_books()
  }

  all_books(){
    this.title="All";
  }

  issued_books(){
    this.title="Issued";
  }

  returned_books(){
    this.title="Returned";
  }

  pending_books(){
    this.title="Pending";
  }

}
