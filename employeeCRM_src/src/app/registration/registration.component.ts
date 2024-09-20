import { Component } from '@angular/core';
import { User } from '../model/user';
import { NgForm } from '@angular/forms';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {

user = new User();
message = " ";

constructor(private service: UserService){

}


ngOnInite(){}




registerUser(form: NgForm){

 this.service.RegisUser(this.user).subscribe(
  data =>{
console.log("user Registered successfully");
this.message = "you have successfully registered, please navigate to login page";
form.resetForm();


  },

error =>{

  console.log("some exception occured");
  this.message = error.error;
}


 )
}






}
