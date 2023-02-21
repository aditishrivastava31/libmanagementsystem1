import { Component } from '@angular/core';
import { SidenavService } from 'src/services/sidenav.service';
import { UserService } from 'src/services/user.service';
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent{

  countries : any;
  states : any;
  cities: any;


  constructor(private userService:UserService , public sidenav: SidenavService){}

  public userAddress={
    address:''
  }
  public user={
    userName:'',
    password:'',
    email:'',
    number:'',
  userAddress : {
    address:''
  }
  }

  ngOnInit(){
    this.sidenav.hide();
    this.userService.getcountry().subscribe(
      data => this.countries = data
    );
  }

  formSubmit(country:any, state : any , city:any){
    console.log(this.user);

    if(this.user.email == null || this.user.userName == null){
      alert('email and userName is required !!');
      return;
    }

    this.userService.addUser(this.user ,country , state , city
      ).subscribe(
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
  // getState(country:any){
  //   this.userService.getstate(country).subscribe(
  //     data =>{
  //       if(data){
  //         this.states = data;
  //         console.log(this.states);
  //         this.isLoaded = true;
  //       }
  //     }
  //   )
  // }
  onChangeCountry(country: String) {
    if (country) {
      console.log(this.states);
          console.log(this.countries);
      this.userService.getstate(country).subscribe(
        data => {
          this.states = data;
          // this.country = country;
          this.cities = null;
        }
      );
    } else {
      this.states = null;
      this.cities = null;
    }
  }
  onChangeState(state: any) {
    if (state) {
      this.userService.getcity(state).subscribe(
        data => this.cities = data
      );
    } else {
      this.cities = null;
    }
  }

}
