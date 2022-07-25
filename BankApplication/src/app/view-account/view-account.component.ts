import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-view-account',
  templateUrl: './view-account.component.html',
  styleUrls: ['./view-account.component.css']
})
export class ViewAccountComponent implements OnInit {
  users:any;

  constructor(private route:ActivatedRoute, private customerService:CustomerService, private router:Router) { }

  ngOnInit(): void {
    // this.getAccountById
    this.route.paramMap.subscribe(res=>{
      var id = res.get("id")
      this.customerService.getAccountById(1, 1).subscribe(res=>{
        alert("no")
        this.users= res;
  
    })

  })

  
    }
    // getAccountById(form:any){
    //   this.customerService.getAccountById(1, form).subscribe(res=>{
    //     this.users=res;
    //   })
    // }
  
    goHome(){
      this.router.navigate([('customerWHOAMI')])
    }
}