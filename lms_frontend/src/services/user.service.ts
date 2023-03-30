import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  public addUser(user: any, country: any, state: any, city: any) {
    return this.http.post('http://localhost:8080/user/signUp', user, {
      params: {
        countryname: country,
        statename: state,
        cityname: city,
      },
    });
  }

  public getcountry() {
    return this.http.get('http://localhost:8080/country');
  }

  public getstate(country: any) {
    return this.http.get('http://localhost:8080/state', {
      params: {
        countryname: country,
      },
    });
  }

  public getcity(state: any) {
    return this.http.get('http://localhost:8080/city', {
      params: {
        statename: state,
      },
    });
  }
  getAllUser() {
    return this.http.get(
      'http://localhost:8080/users',
    );
  }

  duplicateEmail(users : any , userEmail: any){
    for (var v in users) {
      if (users[v].email === userEmail) {
        return true;
      }
    }
    return false;

  }
  duplicatePhone(users : any , userPhone: any){
    let val1d = parseInt(userPhone)
    for (var v in users) {
      if (val1d === users[v].number) {
        return true;
      }
    }
    return false;
  }
}
