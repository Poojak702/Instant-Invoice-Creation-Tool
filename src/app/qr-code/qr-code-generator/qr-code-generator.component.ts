import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { QrCodeService } from 'src/app/service/qr-code.service';
import { QrCode } from 'src/app/user/qr-code';

@Component({
  selector: 'app-qr-code-generator',
  templateUrl: './qr-code-generator.component.html',
  styleUrls: ['./qr-code-generator.component.css']
})
export class QrCodeGeneratorComponent implements OnInit {
  public qrcodeForm!:FormGroup
  QrCodeobj: QrCode = new QrCode();
  public qrCodePath: string;
  showImage :boolean = false;
  constructor(private formBuilder:FormBuilder,private qrcodeService:QrCodeService ,private http:HttpClient,private router:Router) {
    console.log("this is qrcode gen page");
   }
   
  ngOnInit(): void {
    this.qrcodeForm = this.formBuilder.group({
      shopName :['']
    })
  }

  qrCodeGenerator(qrCodeDetails:QrCode){
  console.log("qrcode gen method");
  
    this.qrcodeService.postShopName(qrCodeDetails)
    .subscribe((res:any)=>{
      console.log(res.shopQrCodePath);
       this.qrCodePath = res.shopQrCodePath;
      this.QrCodeobj=res.shopQrCodePath;
      console.log(this.QrCodeobj);
      console.log("response:"+this.QrCodeobj);
    })
  }

  submit(){
    this.showImage = true;
  }
}
