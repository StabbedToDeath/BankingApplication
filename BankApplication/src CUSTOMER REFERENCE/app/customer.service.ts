import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  baseurl:string = "http://localhost:8080/api/customer/";
  constructor(private http:HttpClient) { }


  //CHECK PROPER ID, SOME MAY BE INCORRECT OR IN NEED OF ADDIDTIONAL INFORMATION
  /*
  CUSTOMER = cId
  ACCOUNT = aId
  BENIFICIARY = bId
  USERNAME = uname

  */
  // createAccount(cId:any, form:any){
  //   return this.http.post(`${this.baseurl}`+cId+`/account`, form);
  // }
  createAccount(cId:any, form:any){
    return this.http.post(`${this.baseurl}account`, form);
  }

  registerCustomer(customer:any){
    return this.http.post(`${this.baseurl}register`, customer);

  }
  getAllAccountByCustomerId(cId:any){
    return this.http.get(`${this.baseurl}`+cId+`/account`);

  }
// cust - cId, accoun aId
  getCustomerById(cId:any){
    return this.http.get(`${this.baseurl}`+cId);
  }
  updateCustomer(cId:any){
    return this.http.put(`${this.baseurl}1`, cId);
  }

  getAccountById(cId:any, aId:any){
    return this.http.get(`${this.baseurl}`+cId+`/account/`+aId);
  }
  createBeneficiary(cId:any, form:any){
    return this.http.post(`${this.baseurl}`+cId+`/beneficiary`, form);
  }
  getBeneficiary(cId:any){
return this.http.post(`${this.baseurl}`,cId+`/beneficiary`);

  }
  deleteBeneficiary(cId:any, bId:any){
    return this.http.delete(`${this.baseurl}`+cId+`/beneficiary/`+bId);
  }
  // deleteBeneficiary(){
  //   return this.http.delete(`${this.baseurl}beneficiary/`);
  // }
  transfer(transaction:any){
    return this.http.put(`${this.baseurl}transfer"`, transaction);
  }
  authenticate(customer:any){
    return this.http.post(`${this.baseurl}authenticate`, customer);
  }
  approveAccount(cId:any, aId:any){
    return this.http.put(`${this.baseurl}`,cId+`/account/`+aId);
  }
  updatePassword(uname:any){
    return this.http.put(`${this.baseurl}`,uname+`/forgot`);
  }



  






}
