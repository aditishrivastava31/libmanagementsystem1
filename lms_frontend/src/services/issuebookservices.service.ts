import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { issuebookdetails } from 'src/app/books/booksinterface';

@Injectable({
  providedIn: 'root'
})
export class IssuebookservicesService {

  constructor(private httpclient: HttpClient) {


   }

  getallIssuebookdetails(){
    console.log(localStorage.getItem("token"));
   const headers = new HttpHeaders()
    .set('Authorization',"Bearer "+localStorage.getItem("token"))
      console.log(headers.get("Authorization"));
      const usersUrl ='http://localhost:8080/totalBooks/'+2
    return  this.httpclient.get<any>(usersUrl,{headers});
  }


  getreadIssuebookdetails(){
    console.log(localStorage.getItem("token"));
    console.log("read issued book details is called")
   const headers = new HttpHeaders()
    .set('Authorization',"Bearer "+localStorage.getItem("token"))
      console.log(headers.get("Authorization"));
      const usersUrl ='http://localhost:8080/readBooks/'+2
    return  this.httpclient.get<any>(usersUrl,{headers});
  }

  getIssuedbookdetalis(){
    console.log(localStorage.getItem("token"));
    console.log("read issued book details is called")
   const headers = new HttpHeaders()
    .set('Authorization',"Bearer "+localStorage.getItem("token"))
      console.log(headers.get("Authorization"));
      const usersUrl ='http://localhost:8080/issuedBooks/'+2
    return  this.httpclient.get<any>(usersUrl,{headers});
  }


  getallpendingbookdetalis(){
    console.log(localStorage.getItem("token"));
    console.log("read issued book details is called")
   const headers = new HttpHeaders()
    .set('Authorization',"Bearer "+localStorage.getItem("token"))
      console.log(headers.get("Authorization"));
      const usersUrl ='http://localhost:8080/pendingBooks/'+2
    return  this.httpclient.get<any>(usersUrl,{headers});
  }








}
