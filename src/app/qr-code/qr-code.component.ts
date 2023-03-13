import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QrCode } from '../user/qr-code';

@Component({
  selector: 'app-qr-code',
  templateUrl: './qr-code.component.html',
  styleUrls: ['./qr-code.component.css']
})
export class QrCodeComponent implements OnInit {
   
  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit(): void {
  }
  qrCodeGenerator(){
    console.log("this is qrcode page")
    this.router.navigate(['/qrcodeGenerator']);
  }

  qrCodeScanner(){
    console.log("this is qrcode page")
    this.router.navigate(['/qrcodeScanner']);
  }
}
