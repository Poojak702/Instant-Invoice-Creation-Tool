import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'InvoiceCreation';
  loggedIn:boolean=false;
  inputdata={
    firstName : "string",
      lastName:"string",
      email:"string",
      password:"string",
      confirmPassword:"string"
  }

  constructor(private router:Router){

  }
  ngOnInit(): void {
      this.router.navigate(['login']);
  }


}
