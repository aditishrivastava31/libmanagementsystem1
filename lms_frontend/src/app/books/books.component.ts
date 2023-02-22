import { Component, OnInit } from '@angular/core';
import { map, Observable } from 'rxjs';
import { BooksService } from 'src/services/books.service';
import { bookdto } from './booksinterface';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {

  bookdetails$!: Observable<bookdto[]>;
  accordingto!: string
  bookdetailscount$!: Observable<number>;
  count!: number

  ngOnInit()
   {
    
    this.bookdetails$=this.getbookdetailsservice.geteverybookdetails();

  }

  constructor(private getbookdetailsservice:BooksService){
    //this.bookdetails$=this.getbookdetailsservice.geteverybookdetails();
  }

  getdetails(){
   this. bookdetails$=this.getbookdetailsservice.getbookdetailssearch(this.accordingto);
  //  this.bookdetailscount$=this.bookdetails$.pipe(
  //   map((books)=>{
  //     return books.length
  //   }
  //     )
  //    );

  }
}
