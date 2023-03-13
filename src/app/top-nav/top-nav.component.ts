import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-top-nav',
  templateUrl: './top-nav.component.html',
  styleUrls: ['./top-nav.component.css']
})
export class TopNavComponent implements OnInit , OnChanges {
  @Input() userModelObj :any;
  userImage: any;
  userId :any;


  constructor() { }

  ngOnChanges(changes: SimpleChanges): void {
    this.userId =localStorage.getItem('userId');
    console.log(JSON.stringify(changes)+" In ng changes");
    console.log(this.userId);
    this.userImage = null;
      this.userImage = localStorage.getItem('photoPath');
      console.log("usr imah" + this.userImage);
  this.ngOnInit();
  }

  ngOnInit(): void {
    this.userId =localStorage.getItem('userId');
    console.log(this.userId);
    this.userImage = null;
      this.userImage = localStorage.getItem('photoPath');
      console.log("usr imah" + this.userImage);

    
  }


  logOut(){
    localStorage.removeItem('userId');
    localStorage.clear();
    this.userId = null;
  }
  
}
