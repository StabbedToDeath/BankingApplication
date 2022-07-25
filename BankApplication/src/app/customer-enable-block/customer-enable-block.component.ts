import { BooleanInput } from '@angular/cdk/coercion';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-customer-enable-block',
  templateUrl: './customer-enable-block.component.html',
  styleUrls: ['./customer-enable-block.component.css']
})
export class CustomerEnableBlockComponent implements OnInit {

  displayedColumns: string[] = ['Customer Name', 'Customer ID', 'Enable Disable'];
  statement:any;
  account:any = [];
  customers:any = [];
  customer:any;
  checked = false;
  disabled = false;
  onStart = true;

  constructor(private router: Router, private staffService:StaffService, ) { }

  ngOnInit(): void {
    this.staffService.getAllCustomer().subscribe(res=>
      {
        this.customers = res;
      })
  }

  changeStatus(activity:any, userId:any)
  {
    const body =
    {
      "userId": userId,
      "active": !activity
    }
    console.log(body);

    this.staffService.changeStatus(body).subscribe(res => {
      console.log(res);
      this.ngOnInit();
    })
  }


}
