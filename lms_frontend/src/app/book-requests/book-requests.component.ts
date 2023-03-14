import { Component } from '@angular/core';
import { Observable, Subscribable } from 'rxjs';
import { RequestbookService } from 'src/services/requestbook.service';
import { requestbookdto } from '../req-book/reqbook';

@Component({
  selector: 'app-book-requests',
  templateUrl: './book-requests.component.html',
  styleUrls: ['./book-requests.component.scss']
})
export class BookRequestsComponent {
  requestBookdtos$!: Observable<requestbookdto[]>;
  resdata:any;
  requestId : any;  
  
  constructor(private requestBookService:RequestbookService){}

  public requestBook = {
    authorName: '',
    bookName: ''
  };

  ngOnInit(){
    console.log("hi")
    this.requestBookdtos$=this.requestBookService.getAllRequest();
    
    this.requestBookService.getAllRequest().subscribe((res)=>{
      console.log(res);
  })

  }

  acceptRequest(requestId:number,value:number)
  {
    console.log(requestId);
    console.log(value);
    this.requestBookService.updateRequest(requestId,value)
    .subscribe((n)=>{
      console.log(n);
    })
    window.location.href="/book-reqs"
  }

  rejectRequest(requestId:number,value:number){
    console.log(requestId);
    console.log(value);
    this.requestBookService.updateRequest(requestId,value)
    .subscribe((n)=>{
      console.log(n);
    })
    window.location.href="/book-reqs"
  }

  pendinpurchase(requestId:number,value:number){
    console.log(value);
    console.log(requestId);
    this.requestBookService.updateRequest(requestId,value)
    .subscribe((n)=>{
      console.log(n);
    });
    window.location.href="/book-reqs"
    
  }
}