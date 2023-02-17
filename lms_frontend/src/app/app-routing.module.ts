import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BooksComponent } from './books/books.component';
import { ReqBookComponent } from './req-book/req-book.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from 'src/services/auth.guard';
import { SidenavComponent } from './sidenav/sidenav.component';

const routes: Routes = [
  {path: '', component:LoginComponent, pathMatch: 'full'},
  {path: 'dashboard', component: DashboardComponent,  canActivate:[AuthGuard]},
  {path: 'books', component: BooksComponent,  canActivate:[AuthGuard]
},
  {path: 'req-book', component: ReqBookComponent,  canActivate:[AuthGuard]
},
  {path: 'about-us', component: AboutUsComponent,  canActivate:[AuthGuard]
},
  {path: 'contact-us', component: ContactUsComponent,  canActivate:[AuthGuard]

},
{
  path:'sidenav',component:SidenavComponent
},
  {path:"login",component:LoginComponent,pathMatch:"full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
