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
    this.customerService.getBeneficiary(1).subscribe(res=>{
      alert("Im here!")
      this.beneficiary = res;
    })
    

  }
  
//add single like you did for whoami, try from there
  // getBeneficiary(cId:any){
  //   alert("hell")
  //   this.customerService.getBeneficiary(1).subscribe(res=>{
  //     alert("hell2")
  //     this.user = res;
  //   })
  // }
  deleteBeneficiary(cId:any, bId:any){
    this.customerService.deleteBeneficiary(cId, bId).subscribe(res=> {
      alert("Donkey")
      this.beneficiary = res;
      window.location.reload();
    })
  }

  //   deleteBeneficiary(){
  //   this.customerService.deleteBeneficiary().subscribe(res=> {
  //     this.beneficiary = res;
  //     window.location.reload();
  //   })
  // }

  // deleteBeneficiary(cId:any, bId:any){
  //   this.customerService.deleteBeneficiary(cId, bId).subscribe(res=>{
  //     this.product = res;
  //   })
  // }


}
