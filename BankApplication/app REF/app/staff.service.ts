import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Staff } from './staff/Staff';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  constructor(private myHttp: HttpClient) { }
  
 getAllStaffService(): Observable<Staff[]>{
  console.log('getAllStaffService is invoke..')
  
  return this.myHttp.get<Staff[]>("http://localhost:8080/api/admin/getAllStaff");
