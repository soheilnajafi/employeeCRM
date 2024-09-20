import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';
 

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrl: './list-employee.component.css',
})
export class ListEmployeeComponent {
  constructor(private empservce: EmployeeService, private router: Router ) {}

  ngOnInit() {
    this.getEmployees();
  }

  public employee: Employee[] = [];

  searchKey: string = '';

  p: number = 1;
  key: any = 'id';
  revers: boolean = false;

  sortEmployees(employeeKey: any) {
    this.key = employeeKey;
    this.revers = !this.revers;
  }

  getEmployees(): void {
    this.empservce
      .getEmployeeList()
      .subscribe((data) => (this.employee = data));
  }

  deleteEmployee(id: number) {
    this.empservce.deleteEmp(id).subscribe((data) => {
      console.log(data);
      this.getEmployees();
    });
  }


  detailEmployee(id: number){
this.router.navigate( ['detail', id]);


  }


updateEmployee(id: number){

  this.router.navigate(['/edit', id ])

}




}
