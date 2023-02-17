import { Component, OnInit } from '@angular/core';
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
  constructor(private loginService: LoginService , public sidenav: SidenavService) { }
  ngOnInit(): void {
    this.sidenav.hide();
  }
  onSubmit() {
    console.log("submit")
    console.log(this.credentials)

    if ((this.credentials.email !== ''
      && this.credentials.password !== '')
      && (this.credentials.password !== null
        && this.credentials.email !== null)) {
      this.loginService.generateToken(this.credentials).subscribe((res:any) => {
        console.log(res.token);
        this.loginService.loginUser(res.token)
        window.location.href= "/dashboard"
      },
        error => {
          console.log("hifbd")
          alert("Enter Your Correct email and password")
          console.log(error);
        }
      )
    }
    else {
      // alert("Please Enter Your email and password")
      console.log("empty")
    }
  }
}
