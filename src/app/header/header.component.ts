import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isProfilePage : boolean = false;
  constructor() { }

  ngOnInit(): void {
    if(localStorage.getItem('isProfilePage')== 'true'){
      this.isProfilePage  = true;
      localStorage.setItem('isProfilePage','false');
     
    }
  }

}
