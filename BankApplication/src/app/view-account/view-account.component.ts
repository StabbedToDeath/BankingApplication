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

    this.route.paramMap.subscribe(res => {
      let id = res.get("aId");
      this.customerService.getAccountById(localStorage.getItem("cId"), id).subscribe(res => {
        this.users = res;
      })
    })
  }
}
