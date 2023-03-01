import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { map, Observable } from 'rxjs';
import { IssuebookservicesService } from 'src/services/issuebookservices.service';
import { LoginService } from 'src/services/login.service';
import { issuebookdetails } from '../books/booksinterface';
import { DialogmodalComponent } from '../dialogmodal/dialogmodal.component';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  title = "";
  show:number=0

  issuebookdetails$!: Observable<any>;
  allbookscount$!: Observable<number>;
  pendingsbookcount$!: Observable<number>;
  issuedbookcount$!: Observable<number>;
  returnedbookcount$!: Observable<number>;
  count: number = 0

  constructor(private issuebookservice: IssuebookservicesService ,private loginService:LoginService,public dialog:MatDialog) {



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
    if(this.loginService.tokenExpired(this.loginService.getToken())){
      this.loginService.logout();
      window.location.href="/login"
    }

    this.all_books()
  }

  all_books() {

    this.title = "All";
    this.show=1
    this.issuebookdetails$ = this.issuebookservice.getallIssuebookdetails();
    //console.log("check")



  }
  issued_books() {
    this.title = "Issued";
    this.show=0
    this.issuebookservice.getIssuedbookdetalis().subscribe((n) => {
      console.log(n);
    })
    this.issuebookdetails$ = this.issuebookservice.getIssuedbookdetalis();
  }

  returned_books() {
    this.title = "Returned";
    this.show=0
    this.issuebookservice.getreadIssuebookdetails().subscribe((n) => {
      console.log(n);
    })
    this.issuebookdetails$ = this.issuebookservice.getreadIssuebookdetails();
    console.log("asjdkfdaskjhajksafh",this.issuebookdetails$);
  }

  pending_books() {
    this.title = "Pending";
    this.show=0
    this.issuebookdetails$ = this.issuebookservice.getallpendingbookdetalis();
    // this.pendingsbookcount$ = this.issuebookservice.getallpendingbookdetalis().pipe(
    //   map((books) => {
    //     //this.count=books.length
    //     //console.log(this.count);
    //     return books.length
    //   }
    //   )
    // );
    console.log("asjdkfdaskjhajksafh",this.issuebookdetails$);
  }


returnbook(issueId:number){
      this.issuebookservice.returnbook(issueId).subscribe((n)=>{
        console.log(n);
      });
}

extenddatebook(issueId:number){
  this.issuebookservice.extenddatebook(issueId).subscribe((n)=>
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
 row_clicked()
 {
   alert("dsjk");
 }

  
}



 

