import { Component } from '@angular/core';
import { EmployeeService } from '../service/employee.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { error } from 'console';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrl: './edit-employee.component.css',
})
export class EditEmployeeComponent {
  id: any;
  employee: Employee = new Employee();

  constructor(
    private empservice: EmployeeService,
    private router: Router,
    private activateRout: ActivatedRoute
  ) {}

  ngOnInit() {
    this.id = this.activateRout.snapshot.params['id'];
    this.empservice.getEmployeeById(this.id).subscribe((data) => {
      this.employee = data;
    });
  }

  onSumit() {
    this.empservice.updateEmployee(this.id, this.employee).subscribe(
      (data) => {
        this.employeeList();
      },

      (error) => console.log(error)
    );
  }

  employeeList() {
    this.router.navigate(['/list-employee']);
  }
}
