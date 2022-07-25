import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  hide = true;

  constructor(private http:HttpClient, private router:Router, private userService:UserService) { }

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
        this.router.navigate([("/adminDashboard")])
      } else {
        alert("Invalid credentials found! Please try again!")
      }
    })
  }
}
