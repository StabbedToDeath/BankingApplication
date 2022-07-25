import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-remove-beneficiary',
  templateUrl: './customer-remove-beneficiary.component.html',
  styleUrls: ['./customer-remove-beneficiary.component.css']
})
export class CustomerRemoveBeneficiaryComponent implements OnInit {

  displayedColumns: string[] = ['accountNumber', 'customerId', 'delete']
  user:any= [];
  beneficiary:any;
  constructor(private customerService:CustomerService, private router:Router) { }

  ngOnInit(): void {
    this.customerService.getBeneficiary(localStorage.getItem("cId")).subscribe(res=>{
      console.log(res);
      this.beneficiary = res;
    })


  }

  deleteBeneficiary(bId:any){
    this.customerService.deleteBeneficiary(localStorage.getItem("cId"), bId).subscribe(res=> {
      this.beneficiary = res;
      alert("Beneficiary deleted")
      window.location.reload();
    })
  }


}
