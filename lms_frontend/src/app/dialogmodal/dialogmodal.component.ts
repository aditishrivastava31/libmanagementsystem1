import { Component,Inject } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
@Component({
  selector: 'app-dialogmodal',
  templateUrl: './dialogmodal.component.html',
  styleUrls: ['./dialogmodal.component.scss']
})

export class DialogmodalComponent {

  constructor( @Inject(MAT_DIALOG_DATA) public data:any){

  }

}
