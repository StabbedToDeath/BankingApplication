import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-view-account',
  templateUrl: './view-account.component.html',
  styleUrls: ['./view-account.component.css']
})
export class ViewAccountComponent implements OnInit {
  account:any;

  constructor(private route:ActivatedRoute, private customerService:CustomerService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(res=>{
      var cId = res.get("userId");
      var aId = res.get("accountNumber");

      this.customerService.getAccountById(cId, aId).subscribe(res=>{
        this.account = res;

      })
    })
  }
}