import { Component } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  user = new User();
  message = '';

  constructor(private service: UserService, private router: Router) {}

  loginUser() {
    this.service.login(this.user).subscribe(
      (data) => {
        console.log('you have been logedin successfulluy');
        this.message = 'loged in successfully';
        this.router.navigate(['/dashboard']);
      },

      (error) => {
        console.log('exception occured');
        this.message = 'invalide email or password';
      }
    );
  }
}
