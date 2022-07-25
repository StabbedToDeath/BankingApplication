import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-customer-add-beneficiary',
  templateUrl: './customer-add-beneficiary.component.html',
  styleUrls: ['./customer-add-beneficiary.component.css']
})
export class CustomerAddBeneficiaryComponent implements OnInit {

  product:any;
  user:any;
  accountType: string[] = ['CA', 'SB'];
  constructor(private http: HttpClient, private customerService:CustomerService, private router:Router) { }

  ngOnInit(): void {
  }
  createBeneficiary(form:any){
    //alert("FUCK")
    this.customerService.createBeneficiary(localStorage.getItem("cId"), form).subscribe(res=>{
      if(res){
        alert("well done")
      }
    })
  }


  // getAccountById(cId:any, aId:any){
  //   this.customerService.getAccountById(cId, aId).subscribe(res=>{
  //     this.product = res;
  //   })
  // }
}
