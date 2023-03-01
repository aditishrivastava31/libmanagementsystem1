import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestbookService } from 'src/services/requestbook.service';
import { requestbookdto } from './reqbook';
import { DialogmodalComponent } from '../dialogmodal/dialogmodal.component';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-req-book',
  templateUrl: './req-book.component.html',
  styleUrls: ['./req-book.component.scss']
})

export class ReqBookComponent {
  requestbookdetails$!: Observable<requestbookdto[]>;
  accordingto!: string
  bookdetailscount$!: Observable<number>;
  count!: number
  requestbookdto?:requestbookdto[];

  authorName: any;
  bookName: any;
  requestBookdtos$! : Observable<requestbookdto[]>;

  constructor(private requestBookService:RequestbookService,public dialog:MatDialog){}

  public requestBook = {
    authorName: '',
    bookName: ''
  };

  ngOnInit() {
    
  this.requestBookdtos$=this.requestBookService.getRequest();
    
  }


  formSubmit(){
    console.log(this.requestBook);
    //adding request
    this.requestBookService.addRequestBookDetails(this.requestBook).subscribe
    ((n) => 
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
          name:"request was not made"
        }
      });
    }
    )
   }
      
  }

 

