import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestbookService } from 'src/services/requestbook.service';
import { requestbookdto } from './reqbook';


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

  constructor(private requestBookService:RequestbookService){}

  public requestBook = {
    authorName: '',
    bookName: ''
  };

  ngOnInit() {
    
  this.requestBookdtos$=this.requestBookService.getRequest();
    
  }


  formSubmit(){
    alert("Request Submitted");
    console.log(this.requestBook);


    //adding request
    this.requestBookService.addRequestBookDetails(this.requestBook).subscribe(
      (data)=>{
        console.log(data);
        alert("Success");
      },
      (error)=>{
        console.log(error);
        alert("Something Went Wrong");
      }
      )
  }

 
}
