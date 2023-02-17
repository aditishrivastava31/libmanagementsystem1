import { Component, OnInit } from '@angular/core';
import { BooksService } from 'src/services/books.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {
  ngOnInit()
   {
    
  }

  constructor(private getbookdetailsservice:BooksService){
    
  }

  getdetails(){
    // this.getbookdetailsservice.getbookdetailssearch("java").subscribe((n)=>{
    //   console.log(n);
    // });
  }


}
