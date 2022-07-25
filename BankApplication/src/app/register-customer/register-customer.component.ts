import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register-customer',
  templateUrl: './register-customer.component.html',
  styleUrls: ['./register-customer.component.css']
})
export class RegisterCustomerComponent implements OnInit {

  hide = true;

  constructor(private _snackBar: MatSnackBar, private router:Router, private userService:UserService) { }

  ngOnInit(): void {
  }

  register(form:any) {
    this.userService.register(form).subscribe(res => {
      this.router.navigate([("/customerlogin")]);
    })
  }

  openSnackBar()
  {
    this._snackBar.open("Registered!", "Dismiss");
  }
}
