import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public isLoggedIn = false;
  baseUrl:string = "http://localhost:8080/";

  constructor(private http:HttpClient) { }

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
}
