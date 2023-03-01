import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { requestbookdto } from 'src/app/req-book/reqbook';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class RequestbookService {
  
  listData:any;
  constructor(private http:HttpClient) { 
    this.listData=[];
  }

  addRequestBookDetails(requestBook: any){
    console.log(localStorage.getItem("token"));
    const headers = new HttpHeaders().set('Authorization',"Bearer "+localStorage.getItem("token"))
    console.log(headers.get("Authorization"));
    let savedPerson = JSON.parse(localStorage.getItem("user") || '{}')
    console.log("user Id:"+savedPerson.userId);
    const usersUrl ='http://localhost:8080/requestbook/'+savedPerson.userId;
    return this.http.post(usersUrl , requestBook,{ headers, responseType: 'text' as 'json' });
  }

  getRequest(){
    console.log
    console.log(localStorage.getItem("token"));
    const headers = new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem("token"))
    console.log(headers.get("Authorization"));
    let savedPerson = JSON.parse(localStorage.getItem("user") || '{}')
    console.log("user Id:"+savedPerson.userId);
    const usersUrl ='http://localhost:8080/requestBookdto/'+savedPerson.userId;
     return this.http.get<requestbookdto[]>(usersUrl,{headers});

     

  }
}
