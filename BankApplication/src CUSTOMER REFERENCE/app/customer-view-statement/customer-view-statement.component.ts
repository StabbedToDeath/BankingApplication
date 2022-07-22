import { transition } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-view-statement',
  templateUrl: './customer-view-statement.component.html',
  styleUrls: ['./customer-view-statement.component.css']
})
export class CustomerViewStatementComponent implements OnInit {
  product:any;
  statement:any = [];
  account:any= [];
  transaction:any
  displayedColumns: string[] = ['Date', 'Reference', 'Amount', 'Cr,Db']

  constructor(private customerService:CustomerService ) { }

  ngOnInit(): void {
    this.customerService.getCustomerById(1).subscribe(res=>{
      alert("no")
      this.product = res;})

  
}
transfer(form:any)
{
  this.customerService.transfer(form.accNo).subscribe(res=>
    {
      console.log("nice");

      this.account = res;
      this.statement = this.account.statement;
      this.ngOnInit
    });
}

    //view statment
    getAllAccountByCustomerId(cId:any){
      //hard coding cId to one
      this.customerService.getAllAccountByCustomerId(1).subscribe(res=>{
        this.statement = res;
      })
}

}
function transfer() {
  throw new Error('Function not implemented.');
}
