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
import { CustomerWHOMIComponent } from './customer-whomi/customer-whomi.component';
import { CustomerCreateAccountComponent } from './customer-create-account/customer-create-account.component';
import { CustomerAddBeneficiaryComponent } from './customer-add-beneficiary/customer-add-beneficiary.component';
import { CustomerRemoveBeneficiaryComponent } from './customer-remove-beneficiary/customer-remove-beneficiary.component';
import { CustomerTransferMoneyComponent } from './customer-transfer-money/customer-transfer-money.component';
import { CustomerViewStatementComponent } from './customer-view-statement/customer-view-statement.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { StaffloginComponent } from './stafflogin/stafflogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { LoginComponent } from './login/login.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { RegisterCustomerComponent } from './register-customer/register-customer.component';
import { ViewAccountComponent } from './view-account/view-account.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {
    path: "beneficiary",
    component: BeneficiaryApproveModifyComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "customer-account" ,
    component: CustomerAccountComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "customer-credit-debit",
    component: CustomerCreditDebitComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "customer-enable-block",
    component: CustomerEnableBlockComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "staffheader",
    component: StaffheaderComponent
  },
  {
    path: "staffhome",
    component: StaffhomeComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "approve-disable",
    component: ApproveDisableComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'viewstaff',         //Get all Staff + enable disable
    component:EnableDisableComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'createStaff',             //Create Staff
    component:StaffComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'',
    redirectTo:'customerlogin',
    pathMatch:'full'
  },
  {
    path: 'adminDashboard',           //ADMIN Home
    component:AdminDashboardComponent,
    canActivate: [AuthGuard]
  },
  {
    path:"customerDashboard",
    component:CustomerDashboardComponent,
    canActivate: [AuthGuard]
  },
{
  path:"customerWHOAMI",
  component:CustomerWHOMIComponent,
    canActivate: [AuthGuard]
},
{
  path:"CreateAccount",
  component:CustomerCreateAccountComponent,
    canActivate: [AuthGuard]

},
{
  path:"addBeneficiary",
  component:CustomerAddBeneficiaryComponent,
    canActivate: [AuthGuard]
},
{
  path:"removeBeneficiary",
  component:CustomerRemoveBeneficiaryComponent,
    canActivate: [AuthGuard]

},
{
  path:"transferMoney",
  component:CustomerTransferMoneyComponent,
    canActivate: [AuthGuard]
},
{
  path:"viewStatement",
  component:CustomerViewStatementComponent,
    canActivate: [AuthGuard]
},
{
path:"customerProfile",
component:CustomerProfileComponent,
    canActivate: [AuthGuard]
},
{
  path: "stafflogin",
  component:StaffloginComponent
},
{
  path: "adminlogin",
  component:AdminloginComponent
},
{
  path:"customerlogin",
  component:CustomerloginComponent
},
{
  path: "register",
  component: RegisterCustomerComponent
},
{
  path:"viewAccount/:cId/account/:aId",
  component:ViewAccountComponent,
    canActivate: [AuthGuard]
}, {
  path:'',
  component:CustomerloginComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
