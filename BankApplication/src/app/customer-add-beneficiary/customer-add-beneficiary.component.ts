import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-customer-add-beneficiary',
  templateUrl: './customer-add-beneficiary.component.html',
  styleUrls: ['./customer-add-beneficiary.component.css']
})
export class CustomerAddBeneficiaryComponent implements OnInit {

  product:any;
  user:any;
  accountType: string[] = ['CA', 'SB'];
  constructor(private _snackBar: MatSnackBar, private http: HttpClient, private customerService:CustomerService, private router:Router) { }

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

  openSnackBar()
  {
    this._snackBar.open("Waiting for Approval", "Dismiss");
  }


  // getAccountById(cId:any, aId:any){
  //   this.customerService.getAccountById(cId, aId).subscribe(res=>{
  //     this.product = res;
  //   })
  // }
}
