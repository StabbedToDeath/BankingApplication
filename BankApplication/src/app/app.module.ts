import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerAccountComponent } from './customer-account/customer-account.component';
import { CustomerEnableBlockComponent } from './customer-enable-block/customer-enable-block.component';
import { CustomerCreditDebitComponent } from './customer-credit-debit/customer-credit-debit.component';
import { BeneficiaryApproveModifyComponent } from './beneficiary-approve-modify/beneficiary-approve-modify.component';
import { StaffheaderComponent } from './staffheader/staffheader.component';
import { StaffhomeComponent } from './staffhome/staffhome.component';
import {MatTabsModule} from '@angular/material/tabs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatHeaderRow, MatRow, MatTableModule} from '@angular/material/table';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
import { ApproveDisableComponent } from './approve-disable/approve-disable.component';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { StaffComponent } from './Admin-createStaff/staff.component';
import { EnableDisableComponent } from './Admin-enable-block/enable-disable.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { MatMenuModule } from '@angular/material/menu';
import { MatDividerModule } from '@angular/material/divider';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { CustomerAddBeneficiaryComponent } from './customer-add-beneficiary/customer-add-beneficiary.component';
import { CustomerCreateAccountComponent } from './customer-create-account/customer-create-account.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { CustomerTransferMoneyComponent } from './customer-transfer-money/customer-transfer-money.component';
import { CustomerViewStatementComponent } from './customer-view-statement/customer-view-statement.component';
import { CustomerheaderComponent } from './customerheader/customerheader.component';
import { CustomerRemoveBeneficiaryComponent } from './customer-remove-beneficiary/customer-remove-beneficiary.component';
import { CustomerWHOMIComponent } from './customer-whomi/customer-whomi.component';
import { ViewAccountComponent } from './view-account/view-account.component';
import { StaffloginComponent } from './stafflogin/stafflogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';



@NgModule({
  declarations: [
    AppComponent,
    CustomerAccountComponent,
    CustomerEnableBlockComponent,
    CustomerCreditDebitComponent,
    BeneficiaryApproveModifyComponent,
    StaffheaderComponent,
    StaffhomeComponent,
    ApproveDisableComponent,
    AppComponent,
    StaffComponent,
    EnableDisableComponent,
    AdminDashboardComponent,
    CustomerAddBeneficiaryComponent,
    CustomerCreateAccountComponent,
    CustomerDashboardComponent,
    CustomerProfileComponent,
    CustomerTransferMoneyComponent,
    CustomerViewStatementComponent,
    CustomerheaderComponent,
    CustomerRemoveBeneficiaryComponent,
    CustomerWHOMIComponent,
    ViewAccountComponent,
    StaffloginComponent,
    AdminloginComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTabsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    MatCardModule,
    MatIconModule,
    FormsModule,
    MatTableModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatPaginatorModule,
    MatMenuModule,
    MatCardModule,
    MatDividerModule,
    MatSidenavModule,
    MatRadioModule,
    MatSelectModule,



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
