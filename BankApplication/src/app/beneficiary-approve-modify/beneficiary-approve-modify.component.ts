import { Component, OnInit } from '@angular/core';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-beneficiary-approve-modify',
  templateUrl: './beneficiary-approve-modify.component.html',
  styleUrls: ['./beneficiary-approve-modify.component.css']
})
export class BeneficiaryApproveModifyComponent implements OnInit {

  displayedColumns: string [] = ["Customer", "beneficiaryName+AcNo", "beneficiaryAddedDate", "approved" ];
  beneficaries:any;

  constructor(private staffService:StaffService ) {}

  ngOnInit(): void {
    this.getNotApprovedBens();
  }

  getNotApprovedBens()
  {
    this.staffService.getNotApprovedBens().subscribe(res=>
      {
        this.beneficaries = res;
      })
  }

}
