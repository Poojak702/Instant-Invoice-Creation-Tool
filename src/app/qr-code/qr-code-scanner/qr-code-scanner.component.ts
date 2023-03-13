import { HttpClient ,HttpEventType} from '@angular/common/http';
import { R3TargetBinder } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { QrCodeService } from 'src/app/service/qr-code.service';
import { QrCode } from 'src/app/user/qr-code';

@Component({
  selector: 'app-qr-code-scanner',
  templateUrl: './qr-code-scanner.component.html',
  styleUrls: ['./qr-code-scanner.component.css']
})
export class QrCodeScannerComponent implements OnInit {

  shopName:string;
  file:File ;
  QrCodeobj: QrCode = new QrCode();
  isDisable: boolean = false;
  
  constructor(private http:HttpClient,private qrcodeService:QrCodeService) { 
    // this.file = event.target.files[0];
  }

  ngOnInit(): void {
  }

  onFileSelected(event: any){
    if (event.target.files && event.target.files.length > 0) {

      this.file = event.target.files[0];

      this.QrCodeobj.shopQrCodePath = "assets/"+this.file.name;
      console.log(this.QrCodeobj);
      this.isDisable = true;
    }
    
  }

  uploadImage(event:any){
    if(this.file){
      const imageUploading = this.qrcodeService.postPath(this.QrCodeobj).subscribe(
        response => { 
          console.log("response 123 "+ JSON.stringify(response));
          this.shopName = response.msg;
          console.log("message "+this.shopName);
    });
    }
  }

}

