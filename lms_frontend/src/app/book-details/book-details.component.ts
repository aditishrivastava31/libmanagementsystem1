import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent {

  book = {
    title:"JAVA",
    authors:["author1","author2"],
    desc:"aasdfghjasfdghjasfdghjasfghja"
  };

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

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit() {
    const routeParams = this.route.snapshot.paramMap;
    const bookIdFromRoute = Number(routeParams.get('book_id'));
    console.log("book_id",bookIdFromRoute);
  }


}
