import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-enable-disable',
  templateUrl: './enable-disable.component.html',
  styleUrls: ['./enable-disable.component.css']
})

export class EnableDisableComponent implements OnInit {

  constructor(private staffService:StaffService, private adminService:AdminService) { }

  
  displayedColumns:string[] = ['staffName', 'staffUser','approved'];
  staffs:any = [];
  checked = false;

  
  ngOnInit(): void {
    //this.ngOnInit();
    this.getAllStaff();
  }

  getAllStaff()
  {
    this.adminService.getAllStaff().subscribe(res=>
      {
        console.log(res);
        this.staffs = res
      });
  }

  changeStatus(activity:any, userId:any)
  {
    const body = {
      "userId": userId, 
      "active": !activity
    }

    console.log(body);

    this.adminService.changeStatus(body).subscribe(res=>

      {
        this.ngOnInit();
      })
  }

  
}
