import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import {MatSidenavModule} from '@angular/material/sidenav'; 
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';
import { HttpClientModule } from '@angular/common/http';
import { CustomerheaderComponent } from './customerheader/customerheader.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { FormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import {MatRadioModule} from '@angular/material/radio';
import {MatPaginatorModule} from '@angular/material/paginator';
import { CustomerAddBeneficiaryComponent } from './customer-add-beneficiary/customer-add-beneficiary.component';
import { CustomerCreateAccountComponent } from './customer-create-account/customer-create-account.component';
import { CustomerRemoveBeneficiaryComponent } from './customer-remove-beneficiary/customer-remove-beneficiary.component';
import { CustomerTransferMoneyComponent } from './customer-transfer-money/customer-transfer-money.component';
import { CustomerViewStatementComponent } from './customer-view-statement/customer-view-statement.component';
import {MatHeaderRow, MatRow, MatTableModule} from '@angular/material/table';
import {MatMenuModule} from '@angular/material/menu';
import { ViewAccountComponent } from './view-account/view-account.component';
import {MatTabsModule} from '@angular/material/tabs';
import { CustomerWHOMIComponent } from './customer-whomi/customer-whomi.component';
import {MatToolbarModule} from '@angular/material/toolbar';



@NgModule({
  declarations: [
    AppComponent,
    CustomerDashboardComponent,
    CustomerheaderComponent,
    CustomerProfileComponent,
    CustomerAddBeneficiaryComponent,
    CustomerCreateAccountComponent,
    CustomerRemoveBeneficiaryComponent,
    CustomerTransferMoneyComponent,
    CustomerViewStatementComponent,
    ViewAccountComponent,
    CustomerWHOMIComponent
  ],
  imports: [
    BrowserModule,
    MatTableModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatSidenavModule,
    MatCardModule,
    MatDividerModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatRadioModule,
    MatPaginatorModule,
    MatMenuModule,
    MatTabsModule,
    MatToolbarModule
   
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
