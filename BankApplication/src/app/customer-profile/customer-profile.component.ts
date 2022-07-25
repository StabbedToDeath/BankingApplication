import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
interface  Questions{
  question: string;

}

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})

export class CustomerProfileComponent implements OnInit {
  product:any;
  user:any;
  custId:any = localStorage.getItem('cId');
  constructor(private customerService:CustomerService, private router:Router, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.customerService.getCustomerById(localStorage.getItem("cId")).subscribe(res=>{
      this.user = res;
     })
  }

  updateCustomer(form:any){
    this.customerService.updateCustomer(localStorage.getItem('cId'), form).subscribe(res=>{
      this.product = res;
    })

  }

  openSnackBar()
  {
    this._snackBar.open("Updated!", "Dismiss");
  }

  questions: Questions[] = [
  {question: 'First Pet'},
  {question: 'Favorite Dish'},
  {question: 'Favorite Song'},
  {question: 'Killer Technique'},

];
}

