import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient, private router:Router, private _snackBar: MatSnackBar) { }

   public isLoggedIn = false;
  baseUrl:string = "http://localhost:8080/";


  authenticate(form:any)  //FIELDS
  {
    return this.http.post(`${this.baseUrl}authenticate`, form).pipe(
      catchError(err => this.catchAuthError(err)),
    );
  }



  generateToken(form:any) {
    return this.http.post(`${this.baseUrl}`+"authenticate", form);
  }

  validateToken(token:any) {
    if (token == null || token == '' || token == undefined) {
      return false;
    } else {
      return true;
    }
  }

  logout() {
    localStorage.removeItem('token');
    if(localStorage.getItem('role') == "Staff") {
      alert("Youve been logged out!!")
      this.router.navigate([("/stafflogin")])
    } else if (localStorage.getItem('role') == "Admin") {
      this.router.navigate([("/adminlogin")])
      alert("Youve been logged out!!")
    } else if (localStorage.getItem('role') == "Customer"){
      this.router.navigate([("/customerlogin")])
      localStorage.removeItem("cId");
    }
    localStorage.removeItem('role');
    this.isLoggedIn = false;
    this._snackBar.open("Logged Out", "Dismiss");
  }

  catchAuthError(error:any) {
    if (error && error.error && error.error.message) {
      //client side error
      alert("Client side error");
    } else if (error && error.error) {
      //server side error
      alert("Server side error");
    } else {
      alert("Wrong Credentials Entered! If you believe this is an error, please contact the bank authorities to resolve this issue");
    }

    return throwError(error);
  }

  register(form:any) {
    return this.http.post(`${this.baseUrl}api/customer/register`, form);
  }
}