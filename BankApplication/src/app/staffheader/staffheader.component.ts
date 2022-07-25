import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-staffheader',
  templateUrl: './staffheader.component.html',
  styleUrls: ['./staffheader.component.css']
})
export class StaffheaderComponent implements OnInit {

  constructor(public userService:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  staffLogin()
  {
    this.router.navigate([("/stafflogin")]);
  }

  adminLogin()
  {
    this.router.navigate([("/adminlogin")]);
  }

  logout()
  {
    this.userService.logout();
  }

}
