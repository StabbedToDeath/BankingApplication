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
  accountType: string[] = ['CA', 'SB'];

  ngOnInit(): void {
  }
  createAccount(form:any){

    console.log(form);
    //  this.customerService.createAccount(localStorage.getItem("cId"), form).subscribe(res=>{
    //   this.product = res;
    //   window.location.reload();
    //  })

  }
  // this.customerService.createBeneficiary(localStorage.getItem("userId")).subscribe(res=>{
}


