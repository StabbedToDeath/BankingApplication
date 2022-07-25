import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {

  constructor(private adminService:AdminService, private staffService:StaffService, private _snackBar: MatSnackBar, private router:Router) { }

  message:any;
  durationInSeconds = 3;

  ngOnInit(): void {
  }

  createStaff(staff:any)
  {
    this.adminService.createStaff(staff).subscribe(res=>
      {
        console.log("nice");
        window.location.reload();
      });
  }

  openSnackBar()
  {
    this.message = "Staff Creation Successful"
    this._snackBar.open(this.message, "Dismiss");
  }

}
