import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StaffService } from '../staff.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-stafflogin',
  templateUrl: './stafflogin.component.html',
  styleUrls: ['./stafflogin.component.css']
})
export class StaffloginComponent implements OnInit {
  hide = true;
  constructor(private router:Router, private userService:UserService) { }

  ngOnInit(): void {
  }

  login(form:any) {
    this.userService.authenticate(form).subscribe(res => {
      console.log(res)
      var generatedResponse:any = res;

      if(this.userService.validateToken(generatedResponse.token)) {
        localStorage.setItem('token', generatedResponse.token);
        localStorage.setItem('role', generatedResponse.role);
        this.userService.isLoggedIn = true;
        this.router.navigate([("/staffhome")])
      } else {
        alert("Invalid credentials found! Please try again!")
      }
    })
  }

}
