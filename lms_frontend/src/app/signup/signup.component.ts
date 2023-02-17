import { Component } from '@angular/core';
import { SidenavService } from 'src/services/sidenav.service';
import { UserService } from 'src/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent{
  constructor(private userService:UserService , public sidenav: SidenavService){}

  public user={
    userName:'',
    password:'',
    email:'',
    number:'',
    userAddress:'',
  }

  ngOnInit(){
    this.sidenav.hide();
  }

  formSubmit(){
    console.log(this.user);
    if(this.user.email == null || this.user.userName == null){
      alert('email and userName is required !!');
      return;
    }

    this.userService.addUser(this.user).subscribe(
      (data)=>{
        console.log(data);
        alert('success');
      },
    (error)=>{
      console.log(error);
      alert('something went wrong!');
    }
    )
  }

}
