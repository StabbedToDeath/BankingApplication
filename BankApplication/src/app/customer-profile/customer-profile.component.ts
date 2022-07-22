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
  constructor(private customerService:CustomerService, private router:Router) { }


  // onFileChanged(event) {
  //   const file = event.target.files[0]
  // }

  ngOnInit(): void {
    this.customerService.getCustomerById(1).subscribe(res=>{
      alert("no")
      this.user = res;
     })

    // this.customerService.updateCustomer(1).subscribe(res=>{
    //   alert("sus")
    // })
  }

  updateCustomer(form:any){
    alert("imposter")
    // changing cId, change it to back to cId you dumb fuck
    this.customerService.updateCustomer(form).subscribe(res=>{
      alert("amongus")
      this.product = res;
      
      //include updateForm
    })

}
  questions: Questions[] = [
  {question: 'First Pet'},
  {question: 'Favorite Dish'},
  {question: 'Favorite Song'},
  {question: 'Killer Technique'},

];
onUpload() {
  
}

}



function customer(arg0: number, customer: any) {
  throw new Error('Function not implemented.');
}

