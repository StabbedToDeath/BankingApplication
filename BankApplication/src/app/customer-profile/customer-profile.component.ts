import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
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
  constructor(private customerService:CustomerService, private router:Router) { }

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

  questions: Questions[] = [
  {question: 'First Pet'},
  {question: 'Favorite Dish'},
  {question: 'Favorite Song'},
  {question: 'Killer Technique'},

];
}

