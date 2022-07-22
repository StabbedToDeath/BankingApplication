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

  ngOnInit(): void {
  }

  createStaff(staff:any)
  {
    this.adminService.createStaff(staff).subscribe(res=>
      {
        console.log("nice");
        this.reloadComponent();
      });
  }

  openSnackBar(message:any)
  {
    this._snackBar.open(message);
  }

  //Created By ErrorRectified
  reloadComponent()
  {
    let currentUrl = this.router.url;
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = "reload";
    this.router.navigate([currentUrl]);
  }

}
