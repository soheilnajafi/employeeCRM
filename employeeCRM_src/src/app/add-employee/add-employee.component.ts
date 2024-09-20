import { Component } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { NgForm } from '@angular/forms';
 

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrl: './add-employee.component.css'
})
export class AddEmployeeComponent {
  employee = new Employee();


constructor(private empService: EmployeeService,  private router: Router){}



onSubmit(f: NgForm){
console.log(this.employee);
this.addEmployee();

f.reset();
}


addEmployee(){
   this.empService.addEmployeeDetails(this.employee).subscribe(
    data => {
      console.log(data)
      this.navigateToListEmployee();
      
    }
   )
}



navigateToListEmployee(){
  this.router.navigate(['/list-employee']);
}




}
