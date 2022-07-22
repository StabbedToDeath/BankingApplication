import { Component, OnInit } from '@angular/core';
import { Form } from '@angular/forms';
import { Router } from '@angular/router';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-customer-account',
  templateUrl: './customer-account.component.html',
  styleUrls: ['./customer-account.component.css']
})
export class CustomerAccountComponent implements OnInit {

  constructor(private router: Router, private staffService:StaffService,) { }

  displayedColumns: string[] = ['Date', 'Reference', 'Amount', 'Cr/Db']
  statement:any;
  account:any = [];
  transactions:any = [];
  checked = false;
  disabled = false;
  onStart = true;

  ngOnInit(): void {
    
  }


  getStatement(form:any)
  {
    this.onStart = false;
    this.staffService.getStatement(form.accNo).subscribe(res => 
    {
      console.log(res);
       this.account = res;
       this.transactions = this.account.transactions;
       this.ngOnInit();
    
    });
  }

  // getAccountById(accNoForm:any)
  // {

  // }
}
