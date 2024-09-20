import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { EditEmployeeComponent } from './edit-employee/edit-employee.component';
import { DetailEmployeeComponent } from './detail-employee/detail-employee.component';

const routes: Routes = [

// Routing rout Configuration reference variable is empty
{path: '',  component: LoginComponent},
{path: 'list-employee',  component: ListEmployeeComponent},
{path: 'abc',  component: RegistrationComponent},
{path: 'login',  component: LoginComponent},
{path: 'dashboard',  component: DashboardComponent},
{path: 'dashboard/logout',  component: LoginComponent},
{path: 'register',  component: RegistrationComponent},
{path: 'add-employee',  component: AddEmployeeComponent},

{path: 'edit/:id',  component: EditEmployeeComponent},
{path: 'detail/:id',  component: DetailEmployeeComponent},
 



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
