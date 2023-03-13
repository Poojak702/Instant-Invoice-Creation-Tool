import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import{ FormGroup,FormBuilder,Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { CustomValidators } from '../custom-validators';
import { LoginComponent } from '../login/login.component';
import { UserService } from '../service/user.service';
import { UserModel } from '../user/details';


@Component({
  selector: 'app-signup',
  templateUrl:'./signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public signupForm !: FormGroup;
  userModelObj : UserModel = new UserModel();

  constructor(private formBuilder :FormBuilder,private userService:UserService,private router:Router){ }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      firstName :['',Validators.required],
      lastName:['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      password:['',Validators.required],
      confirmPassword:['',Validators.required]
    })
    CustomValidators.mustMatch('password', 'confirmPassword'); 
  }
  postUser(){
    this.userModelObj.firstName = this.signupForm.value.firstName;
    this.userModelObj.lastName = this.signupForm.value.lastName;
    this.userModelObj.email = this.signupForm.value.email;
    this.userModelObj.password = this.signupForm.value.password;
    this.userModelObj.confirmPassword = this.signupForm.value.confirmPassword;

    this.userService.postUser(this.userModelObj)
    .subscribe((res: any)=>{
      console.log(res);
      alert("Employee Added Successfully");
      this.signupForm.reset();
      this.router.navigate(['login'])
    },(err: any)=>{
      alert("Something went wrong");
    })

  }

 
}
