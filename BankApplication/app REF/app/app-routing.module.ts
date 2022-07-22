import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StaffComponent } from './staff/staff.component';
import { VeiwstaffComponent } from './veiwstaff/veiwstaff.component';

const routes: Routes = [
  {path:'viewstaff',component:VeiwstaffComponent
  },
  {path:'staff',component:StaffComponent
  },
  {
    path:'',redirectTo:'staff',pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
