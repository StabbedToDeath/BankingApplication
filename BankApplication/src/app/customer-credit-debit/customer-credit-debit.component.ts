import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AnonymousSubject } from 'rxjs/internal/Subject';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-customer-credit-debit',
  templateUrl: './customer-credit-debit.component.html',
  styleUrls: ['./customer-credit-debit.component.css']
})
export class CustomerCreditDebitComponent implements OnInit {

  transaction:any;

  constructor(private staffService:StaffService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  transfer(form:any)
  {
    this.staffService.transfer(form).subscribe(res=>
      {
        console.log("nice");
      });
  }

  openSnackBar()
  {
    this._snackBar.open("Success!", "Dismiss");
  }

  
}
