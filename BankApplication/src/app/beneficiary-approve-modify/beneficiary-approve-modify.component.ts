import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-beneficiary-approve-modify',
  templateUrl: './beneficiary-approve-modify.component.html',
  styleUrls: ['./beneficiary-approve-modify.component.css']
})
export class BeneficiaryApproveModifyComponent implements OnInit {

  displayedColumns: string [] = ["Customer", "beneficiaryName+AcNo", "beneficiaryAddedDate", "approved" ];
  beneficaries:any = [];

  constructor(private _snackBar: MatSnackBar, private staffService:StaffService ) {}

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

  approveBeneficiary(beneficaryAcNo:any, beneficaryId:any)
  {
    const body = {
      "beneficaryAcNo": beneficaryAcNo,
      "beneficaryId": beneficaryId,
      "approved": "Yes"
    };

    console.log(body);

    this.staffService.approveBeneficiary(body).subscribe(res=>
      {
        this.ngOnInit();
      });

      
  }

  openSnackBar()
  {
    this._snackBar.open("Approved!", "Dismiss");
  }

}
