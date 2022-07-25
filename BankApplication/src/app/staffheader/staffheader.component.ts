import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-staffheader',
  templateUrl: './staffheader.component.html',
  styleUrls: ['./staffheader.component.css']
})
export class StaffheaderComponent implements OnInit {

  constructor(public userService:UserService) { }

  ngOnInit(): void {
  }

  stafflogin()
  {

  }

  stafflogout()
  {
    this.userService.logout();
  }
}
