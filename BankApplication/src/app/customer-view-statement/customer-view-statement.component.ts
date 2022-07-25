import { transition } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-view-statement',
  templateUrl: './customer-view-statement.component.html',
  styleUrls: ['./customer-view-statement.component.css']
})
export class CustomerViewStatementComponent implements OnInit {
  statement:any = [];
  account:any= [];
  transactions:any
  displayedColumns: string[] = ['Date', 'Reference', 'Amount', 'Cr/Db']

  constructor(private customerService:CustomerService ) { }

  ngOnInit(): void {
  }

    //view statment
    getAccountByCustomerId(form:any){
      console.log(form);
      this.customerService.getAccountById(localStorage.getItem("cId"), form.accNo).subscribe(res=>{
        this.account = res;
       this.transactions = this.account.transactions;
       console.log(this.transactions)
       this.ngOnInit();
      })
}

}
