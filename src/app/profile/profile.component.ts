import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { UserModel } from '../user/details';
import { Invoice } from '../user/invoice';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userId : number;
  invoices : Invoice[] = [];
  invoiceItems : Invoice[] = [];

  userModelObj :UserModel = new UserModel();
  public editForm !: FormGroup;
  image :File;
  email: any;
  constructor(private formBuilder:FormBuilder,
              private router:Router,
              private userService:UserService) {

   }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      firstName : new FormControl(this.userModelObj.firstName),
      lastName : new FormControl(this.userModelObj.lastName),
      email : new FormControl(this.userModelObj.email),
      state:['',Validators.required],
      city:['',Validators.required],
      address:['',Validators.required],
      pinCode:['',Validators.required]
      
    })
    this.userId = Number(localStorage.getItem('userId'));
    console.log("in profile page"+this.userId);
    this.userService.getUserById(this.userId).subscribe(
      response =>{
      console.log(JSON.stringify(response));
      this.userModelObj = response;
      this.email = this.userModelObj.email;
    },(err: any)=>{
      alert("Something went wrong");
  })
  this.getBillPathByUserId();
  localStorage.setItem('isProfilePage','true');
}
editProfile(){
  
}

 editUser(){
   console.log('firstName:'+this.editForm.value.firstName);
   console.log('lastName:'+this.editForm.value.lastName);
   console.log('email:'+this.editForm.value.email);
   console.log('address:'+this.editForm.value.address);
   console.log('city:'+this.editForm.value.city);
   console.log('state:'+this.editForm.value.state);
   console.log('pinCode:'+this.editForm.value.pinCode);

  if(this.editForm.value.firstName != null){
    this.userModelObj.firstName = this.editForm.value.firstName;
  } 
  if(this.editForm.value.lastName != null){
    this.userModelObj.lastName = this.editForm.value.lastName;
  }
  if(this.editForm.value.address != null){
      this.userModelObj.address = this.editForm.value.address;
  }
  if(this.editForm.value.city != null){
    this.userModelObj.city = this.editForm.value.city;
  }
  if(this.editForm.value.state != null){
    this.userModelObj.state = this.editForm.value.state;
  }
  if(this.editForm.value.pinCode != null){
    this.userModelObj.pinCode = this.editForm.value.pinCode;
  }
    this.userModelObj.id = this.userId;
    this.userModelObj.email = this.email;

  console.log(this.userModelObj+"userModel obj");
    this.userService.updateProfile(this.userModelObj)
    .subscribe((res: any)=>{
      console.log(res);
      alert("Details Added Successfully");
    },(err: any)=>{
      alert("Something went wrong");
    })
 }

 onFileSelected(event: any){
  if (event.target.files && event.target.files.length > 0) {

    this.image = event.target.files[0];

    this.userModelObj.id = Number(localStorage.getItem('userId'));
    this.userModelObj.photoPath = "assets/"+this.image.name;
    console.log(this.userModelObj.photoPath +"On File Selected.");
  }
  
}

uploadImage(event:any){
  if(this.image){
    const imageUploading = this.userService.uploadImagePath(this.userModelObj).subscribe(
      response => { 
        console.log("response 123 "+ JSON.stringify(response));
        this.userModelObj = response;
        localStorage.setItem('photoPath', this.userModelObj.photoPath);
        console.log("message on upload image method "+this.userModelObj);
  });
  }
}

getBillPathByUserId(){
  const billPath = this.userService.getBillPathByUserId(this.userId).subscribe(
    response =>{
      console.log("response bill path   : " + JSON.stringify(response));
      this.invoices = response;
    }
  )
}

getItems(billId:number){
  const itemsList = this.userService.getItemsByBillId(billId).subscribe(
    response => {
      console.log("response items of bill :" +JSON.stringify(response));
      this.invoiceItems = response;
    }
  )
}




}


