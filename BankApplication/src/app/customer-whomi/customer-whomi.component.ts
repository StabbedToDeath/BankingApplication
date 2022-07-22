import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-whomi',
  templateUrl: './customer-whomi.component.html',
  styleUrls: ['./customer-whomi.component.css']
})
export class CustomerWHOMIComponent implements OnInit {
  user:any;
  product:any;

  constructor(private customerService:CustomerService, private route:ActivatedRoute) { }


  ngOnInit(): void {


    // this.route.paramMap.subscribe(res=> {
    //   alert("huh"+res.get("userId"))
    //   var cId = res.get("cId");
    //   this.customerService.getCustomerById(1).subscribe(res =>{
    //     this.product = res;
    //   })
    // })
   this.customerService.getCustomerById(1).subscribe(res=>{
    alert("no")
    this.user = res;
   })

   //get all accounts by id
   
  }
  // getCustomerById(cId:any){
  //   this.customerService.getCustomerById(1).subscribe(res=>{
  //     this.accounts = res;
  //     this.ngOnInit

  //   })
  }


function cId(cId: any) {
  throw new Error('Function not implemented.');
}

