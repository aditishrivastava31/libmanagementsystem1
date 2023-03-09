import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ReviewservicesService } from 'src/services/reviewservices.service';

@Component({
  selector: 'app-reviewcomponent',
  templateUrl: './reviewcomponent.component.html',
  styleUrls: ['./reviewcomponent.component.scss']
})
export class ReviewcomponentComponent {

  bookreviewform!: FormGroup;

constructor(
  @Inject(MAT_DIALOG_DATA) public data: any,
  private fb: FormBuilder,
  private bookreviewservice: ReviewservicesService
) {
  this.bookreviewform = this.fb.group({
    star: ['', [Validators.min(1), Validators.required, Validators.max(5)]],
    comments: ['']
  });
}

addreview() {
  console.log(this.bookreviewform.getRawValue());
  this.bookreviewservice.addreview(this.data.bookid, this.bookreviewform.getRawValue()).subscribe((n) => {
    console.log(n);
  });
}



}

