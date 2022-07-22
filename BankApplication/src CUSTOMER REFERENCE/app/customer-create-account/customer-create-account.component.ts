import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-create-account',
  templateUrl: './customer-create-account.component.html',
  styleUrls: ['./customer-create-account.component.css']
})
export class CustomerCreateAccountComponent implements OnInit {
product:any;
customer:any;

  constructor(private customerService:CustomerService) { }

  ngOnInit(): void {
  }
  createAccount(form:any){
    alert("FUCK")

    // this.customerService.createAccount(localStorage.getItem("userId"), form).subscribe(res=>{
    //   if(res){
    //     alert("well done")
    //   }

    //change cId in localStorage.getItem() to login token and it should work
     this.customerService.createAccount(1, form).subscribe(res=>{
      this.product = res;
     }
    )
    
  }
  // this.customerService.createBeneficiary(localStorage.getItem("userId")).subscribe(res=>{
}


