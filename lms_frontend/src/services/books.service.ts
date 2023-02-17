import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { bookdto } from 'src/app/books/booksinterface';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  constructor(private httpclient: HttpClient) {

   }

   
   getbookdetailssearch(according:string){
    console.log(localStorage.getItem("token"));
   const headers = new HttpHeaders()
    .set('Authorization',"Bearer "+localStorage.getItem("token"))

      console.log(headers.get("Authorization"));

    return  this.httpclient.get<bookdto[]>("http://localhost:8080/getbookdetails/"+according,{headers})
}

}
