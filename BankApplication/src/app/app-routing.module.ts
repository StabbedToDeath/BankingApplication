import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApproveDisableComponent } from './approve-disable/approve-disable.component';
import { BeneficiaryApproveModifyComponent } from './beneficiary-approve-modify/beneficiary-approve-modify.component';
import { CustomerAccountComponent } from './customer-account/customer-account.component';
import { CustomerCreditDebitComponent } from './customer-credit-debit/customer-credit-debit.component';
import { CustomerEnableBlockComponent } from './customer-enable-block/customer-enable-block.component';
import { StaffComponent } from './Admin-createStaff/staff.component';
import { StaffheaderComponent } from './staffheader/staffheader.component';
import { StaffhomeComponent } from './staffhome/staffhome.component';;
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { EnableDisableComponent } from './Admin-enable-block/enable-disable.component';

const routes: Routes = [
  {
    path: "beneficiary",
    component: BeneficiaryApproveModifyComponent
  },
  {
    path: "customer-account" ,
    component: CustomerAccountComponent
  },
  {
    path: "customer-credit-debit",
    component: CustomerCreditDebitComponent
  },
  {
    path: "customer-enable-block",
    component: CustomerEnableBlockComponent
  },
  {
    path: "staffheader",
    component: StaffheaderComponent
  },
  {
    path: "staffhome",
    component: StaffhomeComponent
  },
  {
    path: "approve-disable",
    component: ApproveDisableComponent
  },
// *********************************************************************
// *********************************************************************
// *********************************************************************
// *********************************************************************
// *********************************************************************
// *********************************************************************  
  {
    path:'viewstaff',         //Get all Staff + enable disable
    component:EnableDisableComponent
  },
  {
    path:'createStaff',             //Create Staff
    component:StaffComponent
  },
  // {
  //   path:'',
  //   redirectTo:'staff',
  //   pathMatch:'full'
  // },
  {
    path: 'adminDashboard',           //ADMIN Home
    component:AdminDashboardComponent
  },
// *********************************************************************
// *********************************************************************
// *********************************************************************
// *********************************************************************
// *********************************************************************
// *********************************************************************
// *********************************************************************
// {
//   path:"customerWHOAMI",
//   component:CustomerWHOMIComponent
// },
// {
//   path:"CreateAccount",
//   component:CustomerCreateAccountComponent
// },
// {
//   path:"addBeneficiary",
//   component:CustomerAddBeneficiaryComponent


// },
// {
//   path:"removeBeneficiary",
//   component:CustomerRemoveBeneficiaryComponent

// },
// {
//   path:"transferMoney",
//   component:CustomerTransferMoneyComponent
// },
// {
//   path:"viewStatement",
//   component:CustomerViewStatementComponent
// },
// {
// path:"customerProfile",
// component:CustomerProfileComponent
// }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
