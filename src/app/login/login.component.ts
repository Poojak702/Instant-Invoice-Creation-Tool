import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup,Validators} from '@angular/forms'
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { UserModel } from '../user/details';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  public loginForm !: FormGroup
  userModelObj : UserModel = new UserModel();
  constructor(private formBuilder:FormBuilder,private userService:UserService,private http:HttpClient,private router:Router ) { }

  ngOnInit(): void {
    this.loginForm  = this.formBuilder.group({
      email:['',[Validators.required,Validators.email]],
      password:['',[Validators.required]]
    })
    localStorage.clear();
  }

  login(){

  this.userModelObj.email = this.loginForm.value.email;
  this.userModelObj.password = this.loginForm.value.password;

  this.userService.getUser(this.userModelObj)
  .subscribe((res:any)=>{
    console.log(res);
    this.userModelObj = res;
    localStorage.setItem('userId', res.id);
    const userId =localStorage.getItem('userId');
    console.log(userId);

    if(this.userModelObj.photoPath){
    localStorage.setItem('photoPath',this.userModelObj.photoPath);
    console.log("dfhghgfg" + localStorage.getItem('photoPath'));
    }else{
      
    }
    this.router.navigate(['home'])
  })
}
}