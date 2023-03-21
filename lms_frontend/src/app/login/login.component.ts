import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from 'src/services/login.service';
import { SidenavService } from 'src/services/sidenav.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials = {
    email: '',
    password: ''
  }
  constructor(private loginService: LoginService, public sidenav: SidenavService, private router: Router) {

  }
  ngOnInit(): void {
    this.sidenav.hide();
    console.log("---------------",this.router.url);
    if(this.router.url!=="/login")
    {
      this.loginService.logout();
      window.location.href = "/login"
      
    }
  }

  onSubmit() {
    console.log("submit")
    console.log(this.credentials)

    if ((this.credentials.email !== ''
      && this.credentials.password !== '')
      && (this.credentials.password !== null
        && this.credentials.email !== null)) {
      this.loginService.generateToken(this.credentials).subscribe((res: any) => {
        console.log(res.token);
        this.loginService.loginUser(res.token)
        this.loginService.loginUserObject(res.userDetails)
        this.loginService.setRoles(res.userDetails.role)
        console.log(res.userDetails.role)
        const role = res.userDetails.role[0].roleName;
        console.log(role);
        if (role === 'USER') {
          this.loginService.isadmin();

          console.log("hahah");

          window.location.href = "/dashboard"
        }
        else if (role === "ADMIN") {
          this.loginService.isadmin();
          window.location.href = "/issue-book-details"
        }
        else {
          alert("Enter Your Correct email and password")
        }
      },
        error => {
          alert("Enter Your Correct email and password")
          console.warn(error);
        }
      )
    }
    else {
      // alert("Please Enter Your email and password")
      console.log("empty")
    }
  }
}
