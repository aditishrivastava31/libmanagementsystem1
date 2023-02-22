import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { map, Observable } from 'rxjs';
import { IssuebookservicesService } from 'src/services/issuebookservices.service';
import { issuebookdetails } from '../books/booksinterface';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  title = "";

  issuebookdetails$!: Observable<any>;
  allbookscount$!: Observable<number>;
  pendingsbookcount$!: Observable<number>;
  issuedbookcount$!: Observable<number>;
  returnedbookcount$!: Observable<number>;
  count: number = 0

  constructor(private issuebookservice: IssuebookservicesService) {



  }

  ngOnInit(): void {
    this.pendingsbookcount$ = this.issuebookservice.getallpendingbookdetalis().pipe(
      map((books) => {
        return books.length
      }
      )
    );

    this.allbookscount$ = this.issuebookservice.getallIssuebookdetails().pipe(
      map((books) => {
        return books.length
      }
      )
    );

    this.issuedbookcount$ = this.issuebookservice.getIssuedbookdetalis().pipe(
      map((books) => {
        return books.length
      }
      )
    );

      
    this.returnedbookcount$ = this.issuebookservice.getreadIssuebookdetails().pipe(
      map((books) => {
        return books.length
      }
      )
    );









    this.all_books()
  }

  all_books() {

    this.title = "All";
    this.issuebookdetails$ = this.issuebookservice.getallIssuebookdetails();
    //console.log("check")



  }
  issued_books() {
    this.title = "Issued";
    this.issuebookservice.getIssuedbookdetalis().subscribe((n) => {
      console.log(n);
    })
    this.issuebookdetails$ = this.issuebookservice.getIssuedbookdetalis();
  }

  returned_books() {
    this.title = "Returned";
    this.issuebookservice.getreadIssuebookdetails().subscribe((n) => {
      console.log(n);
    })
    this.issuebookdetails$ = this.issuebookservice.getreadIssuebookdetails();
  }

  pending_books() {
    this.title = "Pending";

    this.issuebookdetails$ = this.issuebookservice.getallpendingbookdetalis();
    // this.pendingsbookcount$ = this.issuebookservice.getallpendingbookdetalis().pipe(
    //   map((books) => {
    //     //this.count=books.length
    //     //console.log(this.count);
    //     return books.length
    //   }
    //   )
    // );
  }

  row_clicked(){
    alert("dsjk");
  }
}
