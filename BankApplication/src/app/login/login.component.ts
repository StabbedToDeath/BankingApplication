import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide = true;

  constructor(private userService:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  login(form:any) {
    this.userService.generateToken(form).subscribe(res => {
      let generatedToken:any = res;
      console.log(generatedToken);
      if (this.userService.validateToken(generatedToken.token)){
        localStorage.setItem('token', generatedToken.token);
        this.userService.isLoggedIn = true;

        if(generatedToken.role.matches("Customer")){
          console.log("customer");
          this.router.navigate([('')]);
        } else if (generatedToken.role.matches("Staff")){
          console.log("staff");
          this.router.navigate([("/staffhome")]);
        } else if (generatedToken.role.matches("Admin")){
          console.log("Admin");
          this.router.navigate([('/adminDashboard')])
        }
      } else {
        alert("Incorrect details submitted! Please try again");
      }
    });
  }

}
