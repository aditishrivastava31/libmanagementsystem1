import { Component, OnInit } from '@angular/core';
import { map, Observable } from 'rxjs';
import { BooksService } from 'src/services/books.service';
import { bookdto } from './booksinterface';
import { Router } from '@angular/router';
import { BookDetailsComponent } from '../book-details/book-details.component';
import { DialogmodalComponent } from '../dialogmodal/dialogmodal.component';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';


@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {
  demo_id = 11234;
  demo_book = {
    id: 101,
    title: "demo title",
    authors: ["auth1", "auth2"],
    quantity: 2,
    review: 3,
    category: "education"
  }
  bookdetails$!: Observable<bookdto[]>;
  accordingto!: string
  bookdetailscount$!: Observable<number>;
  count!: number
  router!: Router

  ngOnInit() {

    this.bookdetails$ = this.getbookdetailsservice.geteverybookdetails();

  }

  constructor(private getbookdetailsservice: BooksService,public dialog:MatDialog) {
    //this.bookdetails$=this.getbookdetailsservice.geteverybookdetails();
  }

  getdetails() {
    this.bookdetails$ = this.getbookdetailsservice.getbookdetailssearch(this.accordingto);
    //  this.bookdetailscount$=this.bookdetails$.pipe(
    //   map((books)=>{
    //     return books.length
    //   }
    //     )
    //    );

  }


  getBookDetails() {
    console.log("clicked");

    this.router.navigateByUrl('/book-details');
    // this.router.navigate([BookDetailsComponent])
  }

  fun() {
    alert("ashg");
  }

  lendbook(book_id: number) { 
    console.log(book_id); 
    this.getbookdetailsservice.lendbook(book_id).subscribe((n) => 
    { 
      console.log(n);
      this.dialog.open(DialogmodalComponent,{
        data:{
          name:n
        }
      });
    },
    error => {
      this.dialog.open(DialogmodalComponent,{
        data:{
          name:"you can't lend the book"
        }
      });
    }
    )
   }
}
