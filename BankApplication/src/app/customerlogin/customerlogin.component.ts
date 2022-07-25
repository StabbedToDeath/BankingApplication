import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent implements OnInit {

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
        localStorage.setItem("cId", generatedResponse.username);
        this.userService.isLoggedIn = true;
        this.router.navigate([("/customerDashboard")])
      } else {
        alert("Invalid credentials found! Please try again!")
      }
    })
  }

  register(){
    this.router.navigate([("/register")]);
  }
}
