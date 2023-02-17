import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url = "http://localhost:8080/authenticate"
  constructor(private http: HttpClient) { }

  // caling the server to generate token

  generateToken(credentials: any) {
    //toekn generate
    return this.http.post(this.url, credentials)
  }



  //for login user
  loginUser(token: any) {

    localStorage.setItem("token", token)
    console.log(token)
    return true;
  }
  // to check user is login
  isLoggedIn() 
  {
    let token = localStorage.getItem("token");
    console.log(token)
    if (token == undefined || token === '' || token == null) {
      return false;
    } else {
      return true;
    }
  }
  // get logout
  logout() {
    localStorage.removeItem('token');
    return true;
  }
  // get token
  getToken() {
    return localStorage.getItem("token");
  }
}
