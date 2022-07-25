import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-whomi',
  templateUrl: './customer-whomi.component.html',
  styleUrls: ['./customer-whomi.component.css']
})
export class CustomerWHOMIComponent implements OnInit {
  user:any;
  account:any;

  constructor(private customerService:CustomerService, private route:ActivatedRoute, private router:Router) { }


  ngOnInit(): void {
    this.getAllAccountByCustomerId();


    //  this.customerService.getAllAccountByCustomerId(1).subscribe(res=>{
    //   alert("no")
    //   alert()
    //   this.account= res;
      }

     //get all accounts by id



    getAllAccountByCustomerId(){
      this.customerService.getAllAccountByCustomerId(localStorage.getItem("cId")).subscribe(res=>{

        this.account =res;
        console.log(this.account)
        console.log(localStorage);
      })
    }

    moreDetails(aId:any) {
      alert("inside moredetails() "+localStorage.getItem("cId")+`/account/`+aId);

      this.router.navigate([('/viewAccount/'+localStorage.getItem("cId")+`/account/`+aId)])
    }
  }


