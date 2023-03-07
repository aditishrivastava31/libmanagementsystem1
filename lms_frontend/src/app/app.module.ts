import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BodyComponent } from './body/body.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { BooksComponent } from './books/books.component';
import { ReqBookComponent } from './req-book/req-book.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { MatCardModule } from '@angular/material/card';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { SignupComponent } from './signup/signup.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { DialogmodalComponent } from './dialogmodal/dialogmodal.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { ForgetpasswordComponent } from './forgetpassword/forgetpassword.component';
import { IssueBookDetailsComponent } from './issue-book-details/issue-book-details.component';
import { AddBookDetailsComponent } from './add-book-details/add-book-details.component';
import { BookRequestsComponent } from './book-requests/book-requests.component';
import { ReqForExtComponent } from './req-for-ext/req-for-ext.component';
import { ReactiveFormsModule } from '@angular/forms';
import {MatExpansionModule} from '@angular/material/expansion';


@NgModule({
  declarations: [
    AppComponent,
    BodyComponent,
    SidenavComponent,
    DashboardComponent,
    BooksComponent,
    ReqBookComponent,
    ContactUsComponent,
    AboutUsComponent,
    LoginComponent,
    SignupComponent,
    BookDetailsComponent,
    DialogmodalComponent,
    ForgetpasswordComponent,
    IssueBookDetailsComponent,
    AddBookDetailsComponent,
    BookRequestsComponent,
    ReqForExtComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    MatCardModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatButtonModule,
    MatTableModule,
    MatInputModule,
    MatFormFieldModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatExpansionModule
   ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
