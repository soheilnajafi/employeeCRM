import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  public RegisUser(user: User): Observable<any> {
    return this.http.post<any>('http://localhost:8090/all/users', user);
  }

  public login(user: User): Observable<any> {
    return this.http.post<any>('http://localhost:8090/all/userLogin', user);
  }
}
