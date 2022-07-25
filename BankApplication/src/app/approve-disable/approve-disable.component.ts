import { Component, OnInit } from '@angular/core';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-approve-disable',
  templateUrl: './approve-disable.component.html',
  styleUrls: ['./approve-disable.component.css']
})
export class ApproveDisableComponent implements OnInit {

  constructor(private staffService:StaffService) { }

  displayedColumns:string[] = ['accountNumber', 'accountType', 'accountBalance', 'approved'];
  statement:any;
  accounts:any =[];
  transactions:any = [];

  ngOnInit(): void {
    this.getNotApprovedAccounts();
  }

  getNotApprovedAccounts()
  {
    this.staffService.getNotApprovedAccounts().subscribe(res=>
      {
        this.accounts = res;
      })
  }

  approveAccount(accountNumber:any)
  {
    const body = {
      "accountNumber": accountNumber, 
      "approved": "Yes"
    };

    this.staffService.approveAccount(body).subscribe(res=>
      {
        this.ngOnInit();
      });
  }
}