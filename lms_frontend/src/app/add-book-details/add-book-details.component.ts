import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BooksService } from 'src/services/books.service';
import { DialogmodalComponent } from '../dialogmodal/dialogmodal.component';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-add-book-details',
  templateUrl: './add-book-details.component.html',
  styleUrls: ['./add-book-details.component.scss']
})
export class AddBookDetailsComponent  implements OnInit {
 
  addbookform!:FormGroup;
  category!:FormGroup;
  bookadded!:string


  constructor(private fb:FormBuilder,private addbookservice:BooksService,public dialog:MatDialog){

  }
  
  ngOnInit(){
    this.addbookform=this.fb.group({
      bookName:['',[Validators.required]],
      quantity:['',[Validators.min(1),Validators.required]],
      category:this.fb.group({
        categoryName:['',[Validators.required]],
      }),
      authors:this.fb.array([this.fb.group({
    authorName:['',[Validators.required]],
  })]
  )
    })
    
  }

  get authorsArray(){
    return this.addbookform.get('authors') as FormArray;
}

addauthors(){
  console.log(this.authorsArray);
  this.authorsArray.push(this.fb.group({
    authorName:['',[Validators.required]],
  }))
}

removeperson(i : number){
  console.log(i);
  this.authorsArray.removeAt(i);
}

addtobase(){
  console.log(this.addbookform.getRawValue())
  this.addbookservice.addbookdetails(this.addbookform.getRawValue()).subscribe((n)=>{
          console.log(n);
          this.dialog.open(DialogmodalComponent,{
            data:{
              name:"Book was Added Successfully"
            }
          });
  },
  (error)=>{
    console.log(error);
    this.dialog.open(DialogmodalComponent,{
      data:{
        name:"Book was not Added Successfully"
      }
    });
  }
  )

}

reset(){
  this.addbookform.reset({
    bookName:[''],
    quantity:[''],
    category:{
      categoryName:[''],
    },
    authors:[]
  })

}

}
