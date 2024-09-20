import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  constructor(private http: HttpClient) {}

  private backenEndpoint = 'http://localhost:8090/employee/emp';

  getEmployeeList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.backenEndpoint}`);
  }

  deleteEmp(id: number): Observable<Object> {
    return this.http.delete(`${this.backenEndpoint}/${id}`);
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.backenEndpoint}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object> {
    return this.http.put(`${this.backenEndpoint}/${id}`, employee);
  }



  addEmployeeDetails(employee: Employee): Observable<any>{

    return this.http.post(`${this.backenEndpoint}`, employee);

  }





}
