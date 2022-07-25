import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-customer-transfer-money',
  templateUrl: './customer-transfer-money.component.html',
  styleUrls: ['./customer-transfer-money.component.css']
})
export class CustomerTransferMoneyComponent implements OnInit {
displayedColumns: string[] = ['Ac No', 'Balance', 'Ac Type', 'Select']

account:any =[];
user:any;
transaction:any;
  constructor(private customerService:CustomerService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.customerService.getCustomerById(localStorage.getItem("cId")).subscribe(res=>{
      this.user = res;
     })
  }


transfer(form:any){
  this.customerService.transfer(form).subscribe(res=>{
    this.user = res;
    alert("Funds transferred!!")
    window.location.reload();
  })
}


openSnackBar(){
  this._snackBar.open("Success!", "Dismiss");
}


}
function transaction(transaction: any) {
  throw new Error('Function not implemented.');
}

