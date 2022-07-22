import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-staffhome',
  templateUrl: './staffhome.component.html',
  styleUrls: ['./staffhome.component.css']
})
export class StaffhomeComponent implements OnInit {

  links = ['customer-account', 'beneficiary', 'customer-enable-block'];
  activeLink = this.links[0];

  constructor() { }

  ngOnInit(): void {
  }

}
