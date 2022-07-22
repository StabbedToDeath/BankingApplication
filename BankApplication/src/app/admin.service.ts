import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseurl:string = "http://localhost:8080/api/admin/";

  constructor(private http:HttpClient) { }

  createStaff(staff:any)
  {
    return this.http.post(`${this.baseurl}staff`, staff);
  }

  getAllStaff()
  {
    return this.http.get(`${this.baseurl}staff`);
  }

  changeStatus(body:any)
  {
    return this.http.put(`${this.baseurl}staff`, body, {responseType: "text"});
  }

}
