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
    this.getAllAccountByCustomerId(1);


    //  this.customerService.getAllAccountByCustomerId(1).subscribe(res=>{
    //   alert("no")
    //   alert()
    //   this.account= res;
      }
  
     //get all accounts by id
     
    
  
    getAllAccountByCustomerId(cId:any){
      this.customerService.getAllAccountByCustomerId(1).subscribe(res=>{
        
        this.account =res;
        console.log(this.account)
      })
    }
  
    moreDetails(cId:any, aId:any) {
      alert("inside moredetails() "+cId+`/account/`+aId);
  
      this.router.navigate([('/viewAccount/'+cId+`/account/`+aId)])
    }
  }

function cId(cId: any) {
  throw new Error('Function not implemented.');
}

