import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UserService {

 
  constructor(private http:HttpClient) { }

    postUser(data:any){
      return this.http.post<any>("http://localhost:8080/invoiceCreation/webapi/user",data)
      .pipe(map((res:any)=>{
        return res;
      }))
    }

    getUser(data:any){
      return this.http.post<any>("http://localhost:8080/invoiceCreation/webapi/user/login",data)
      .pipe(map((res:any)=>{
        return res;
      }))
    }

    getUserById(userId:any){
      // const userId = Number(data);
      // console.log("number check :"+isNaN(userId));
      return this.http.get<any>("http://localhost:8080/invoiceCreation/webapi/user/"+userId);
    }

    uploadImagePath(data:any){
      return this.http.put<any>("http://localhost:8080/invoiceCreation/webapi/user/imagePath",data)
    .pipe(map((res:any)=>{
      console.log(res + "service layer");
      return res;
    }))
    }

    updateProfile(data:any){
      return this.http.put<any>("http://localhost:8080/invoiceCreation/webapi/user/edit",data)
      .pipe(map((res:any)=>{
        return res;
      }))
    }

    getBillPathByUserId(userId:number){
      return this.http.get<any>("http://localhost:8080/invoiceCreation/webapi/items/userId/"+userId);
    }

    getItemsByBillId(billId:number){
      return this.http.get<any>("http://localhost:8080/invoiceCreation/webapi/items/billId/"+billId)
    }
 
}
