import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Invoice } from '../user/invoice';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  constructor(private http: HttpClient) { }

  invoiceImageUpload(data:Invoice):Observable<any>{
    return this.http.post<any>("http://localhost:8080/invoiceCreation/webapi/items",data)
    .pipe(map((res:any)=>{
      console.log(res + "service layer");
      return res;
    }))
  }
}
