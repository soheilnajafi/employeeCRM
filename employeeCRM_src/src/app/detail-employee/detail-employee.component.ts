import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrl: './detail-employee.component.css'
})
export class DetailEmployeeComponent {

  employee!: Employee;
  id!: number;

  constructor(private empservce: EmployeeService, private activeRout: ActivatedRoute, private router: Router) { }



  ngOnInit() {
    this.id = this.activeRout.snapshot.params['id'];
    this.employee = new Employee();

    this.empservce.getEmployeeById(this.id).subscribe(

      data => {
        this.employee = data;
      }
    )

  }


  updateEmployee(id: number){

    this.router.navigate(['/edit', id]);
  }



}
