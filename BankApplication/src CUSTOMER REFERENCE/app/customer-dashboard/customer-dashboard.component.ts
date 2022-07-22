import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';



@Component({
  selector: 'app-customer-dashboard', 
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']

})
export class CustomerDashboardComponent implements OnInit {
  product:any;
  constructor(private router:Router, private customerService:CustomerService) { }

  ngOnInit(): void {
  }

  registerCustomer(){
    this.customerService.registerCustomer(customer).subscribe(res=>{
      this.product = res;
    })
  }

  getAllAccountByCustomerId(cId:any){
    this.customerService.getAllAccountByCustomerId(cId).subscribe(res=>{
      this.product = res;
    })
  }

  getCustomerById(cId:any){
    //Change the 1 to cId when you grow a pair
    this.customerService.getCustomerById(1).subscribe(res=>{
      this.product = res;
    })
  }

  updateCustomer(cId:any){
    this.customerService.updateCustomer(cId).subscribe(res=>{
      this.product = res;
    })

  }
  getAccountById(cId:any, aId:any){
    this.customerService.getAccountById(cId, aId).subscribe(res=>{
      this.product = res;
    })
  }
  createBeneficiary(cId:any, form:any){
    this.customerService.createBeneficiary(cId, form).subscribe(res=>{
      this.product = res;
    })
  }
  getBeneficiary(cId:any){
    this.customerService.getBeneficiary(cId).subscribe(res=>{
      this.product = res;
    })
  }
  deleteBeneficiary(cId:any, bId:any){
    this.customerService.deleteBeneficiary(cId, bId).subscribe(res=>{
      this.product = res;
    })
  }
  // deleteBeneficiary(){
  //   this.customerService.deleteBeneficiary().subscribe(res=>{
  //     this.product = res;
  //   })
  // }
  transfer(){
    this.customerService.transfer(transaction).subscribe(res=>{
      this.product = res;
    })
  }
  authenticate(){
    this.customerService.authenticate(customer).subscribe(res=>{
      this.product = res;
    })
  }
  approveAccount(cId:any, aId:any){
    this.customerService.approveAccount(cId, aId).subscribe(res=>{
      this.product = res
    })
  }
  updatePassword(uname:any){
    this.customerService.updatePassword(uname).subscribe(res=>{
      this.product = res;
    })
  }

}




export class SidenavDrawerOverviewExample {}

function customer(customer: any, any: any) {
  throw new Error('Function not implemented.');
}

function transaction(transaction: any) {
  throw new Error('Function not implemented.');
}

