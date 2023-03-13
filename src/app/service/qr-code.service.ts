import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { QrCode } from '../user/qr-code';

@Injectable({
  providedIn: 'root'
})
export class QrCodeService {

  constructor(private http: HttpClient) { }

  postShopName(data: QrCode): Observable<string> {
    return this.http.post<string>("http://localhost:8080/invoiceCreation/webapi/qrCode", data)
      .pipe(map((res: any) => {
        console.log(res);
        return res;
      }))
  }

  postPath(data:QrCode):Observable<any>{
    return this.http.post<any>("http://localhost:8080/invoiceCreation/webapi/qrCode/shopQrCodePath",data)
    .pipe(map((res:any)=>{
      console.log(res + "service layer");
      return res;
    }))
  }
}
