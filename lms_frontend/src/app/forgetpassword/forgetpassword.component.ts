import { Component, OnInit } from '@angular/core';
import { SidenavService } from 'src/services/sidenav.service';


@Component({
  selector: 'app-forgetpassword',
  templateUrl: './forgetpassword.component.html',
  styleUrls: ['./forgetpassword.component.scss']
})
export class ForgetpasswordComponent implements OnInit {
  constructor(public sidenav: SidenavService){}
  ngOnInit(): void {
    this.sidenav.hide();
  }

}
