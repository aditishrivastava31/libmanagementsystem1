import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { BooksService } from 'src/services/books.service';
import { ReviewservicesService } from 'src/services/reviewservices.service';
import { bookdto } from '../books/booksinterface';
import { ReviewcomponentComponent } from '../reviewcomponent/reviewcomponent.component';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent {

  bookdetails!: bookdto;
  bookreviewform!: FormGroup;
  book_review!: [
    {
      username: "demouser1",
      comment: "demo comment...",
      star_rating: 4
    },
    {
      username: "demouser2",
      comment: "demo comment 2...",
      star_rating: 3
    }
  ];
  bookidroute!: number;
  
  constructor(
    public dialog: MatDialog,
    private route: ActivatedRoute,
    private bookservice: BooksService,
    private bookreviewservice: ReviewservicesService,
    private fb: FormBuilder,
    private router : Router
  ) {

  }
  
  openDialog(): void {
    this.dialog.open(ReviewcomponentComponent, {
      data: {
        bookid: this.bookidroute
      }
    });
  }
  
  ngOnInit() {
    const routeParams = this.route.snapshot.paramMap;
    const bookIdFromRoute = Number(routeParams.get('book_id'));
    console.log("book_id", bookIdFromRoute);
    this.bookidroute = bookIdFromRoute;
    this.bookservice.getbookbyid(bookIdFromRoute).subscribe((n) => {
      this.bookdetails = n;
      console.log(n.avg_rating / 10);
    })
    
    
  }
}
