import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StaffService {


  baseurl:string = "http://localhost:8080/api/staff/";

  constructor(private http:HttpClient) { }

  getAllCustomer()
  {
    return this.http.get(`${this.baseurl}customer`);
  }

  changeStatus(body:any)  //FIELDS
  {
    return this.http.put(`${this.baseurl}customer`, body  );
  }

  getCustomer(id:any)
  {
    return this.http.get(`${this.baseurl}customer/` + id);
  }

  getStatement(accNo:any)
  {
    return this.http.get(`${this.baseurl}account/` + accNo);
  }

  getNotApprovedBens()
  {
    return this.http.get(`${this.baseurl}beneficiary`);
  }

  approveBeneficiary(body:any)  //FIELDS
  {
    return this.http.put(`${this.baseurl}beneficiary/approve`, body);
  }

  getNotApprovedAccounts()
  {
    return this.http.get(`${this.baseurl}accounts/approve`);
  }

  approveAccount(account:any)  //Fields
  {

    return this.http.put(`${this.baseurl}accounts/approve`, account);
  }

  transfer(transaction:any)  //FIELDS
  {
    return this.http.put(`${this.baseurl}transfer`, transaction, {responseType: "text"});
  }


  // getAllStaffService(): Observable<Staff[]>{
  //   console.log('getAllStaffService is invoke..')

  //   return this.http.get<Staff[]>("http://localhost:8080/api/admin/getAllStaff");
  // }
}


