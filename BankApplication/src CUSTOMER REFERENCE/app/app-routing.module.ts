import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerAddBeneficiaryComponent } from './customer-add-beneficiary/customer-add-beneficiary.component';
import { CustomerCreateAccountComponent } from './customer-create-account/customer-create-account.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { CustomerRemoveBeneficiaryComponent } from './customer-remove-beneficiary/customer-remove-beneficiary.component';
import { CustomerTransferMoneyComponent } from './customer-transfer-money/customer-transfer-money.component';
import { CustomerViewStatementComponent } from './customer-view-statement/customer-view-statement.component';
import { CustomerWHOMIComponent } from './customer-whomi/customer-whomi.component';



const routes: Routes = [
  {
  path:"",
  component:CustomerDashboardComponent


},
{
  path:"customerWHOAMI",
  component:CustomerWHOMIComponent
},
{
  path:"CreateAccount",
  component:CustomerCreateAccountComponent
},
{
  path:"addBeneficiary",
  component:CustomerAddBeneficiaryComponent


},
{
  path:"removeBeneficiary",
  component:CustomerRemoveBeneficiaryComponent

},
{
  path:"transferMoney",
  component:CustomerTransferMoneyComponent
},
{
  path:"viewStatement",
  component:CustomerViewStatementComponent
},
{
path:"customerProfile",
component:CustomerProfileComponent
}

]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
