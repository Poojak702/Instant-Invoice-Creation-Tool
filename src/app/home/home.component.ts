import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public sellerForm!:FormGroup
  constructor(private router:Router ) { }

  ngOnInit(): void {
  }

  seller(){
    this.router.navigate(['qrcode'])
  }

  buyer(){
    this.router.navigate(['invoice'])
  }

}
