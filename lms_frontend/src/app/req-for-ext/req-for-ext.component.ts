import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestextensiondateService } from 'src/services/requestextensiondate.service';
import { bookdto, extension } from '../books/booksinterface';

@Component({
  selector: 'app-req-for-ext',
  templateUrl: './req-for-ext.component.html',
  styleUrls: ['./req-for-ext.component.scss']
})
export class ReqForExtComponent implements OnInit {

  requestextension$!: Observable<extension[]>;


constructor(private requestextensionservice:RequestextensiondateService) {
  
}
  ngOnInit(): void {

    // this.requestextensionservice.getallextensionrequestiondates().subscribe((n)=>{
    //   console.log(n);
    // })

    this.requestextension$=this.requestextensionservice.getallextensionrequestiondates();


  }




}
