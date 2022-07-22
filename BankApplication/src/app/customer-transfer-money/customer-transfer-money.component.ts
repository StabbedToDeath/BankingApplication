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
  constructor(private customerService:CustomerService) { }

  ngOnInit(): void {
    this.customerService.getCustomerById(1).subscribe(res=>{
      alert("no")
      this.user = res;
     })
  }

//   getAllAccountByCustomerId(cId:any){
//     this.customerService.getAllAccountByCustomerId(cId).subscribe(res=>{
//       this.account = res;
//     })
//   }
//   getAccountById(cId:any, aId:any){
//     this.customerService.getAccountById(cId, aId).subscribe(res=>{
//       this.user = res;
//     })
//   }
//   transfer(form:any, account:any){

// const trans= {
//   "amount": form.amount,
//   "type": form.transactionType,
//   "toAcc": form.toAccountNo,
//   "fromAcc": account,
//   "reason": form.reason,
//   "executedBy": "customer"
// }


//     this.customerService.transfer(trans).subscribe(res=>{
//       if(res){
//         console.log(res)
//       }
//     })
//   }


//Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; nested exception is java.lang.NumberFormatException: For input string: "transfer":"

transfer(form:any){
  alert("ayo")
  this.customerService.transfer(form).subscribe(res=>{
    alert("fuck")
    this.user = res;
  })
}


// openSnackBar(message:any){
//   this._snackBar.open(message);
// }
 

}
function transaction(transaction: any) {
  throw new Error('Function not implemented.');
}

