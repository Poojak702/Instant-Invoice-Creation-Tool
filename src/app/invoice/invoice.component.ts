import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { InvoiceService } from '../service/invoice.service';
import { Invoice } from '../user/invoice';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {
  // PageTitle : string = 'Invoice';
  invoiceObj : Invoice = new Invoice();
  image: File;
  invoices: Invoice[] =[]; 

  
  isDisable: boolean = false;

  constructor(private http:HttpClient ,private invoiceService : InvoiceService) { }

  ngOnInit(): void {
  }

   onFileSelected(event: any){
     if (event.target.files && event.target.files.length > 0) {

       this.image = event.target.files[0];
       this.invoiceObj.billPath = "assets/"+this.image.name;
       this.invoiceObj.userId = Number(localStorage.getItem('userId'));
       console.log(this.invoiceObj);

       this.isDisable = true;
     }
    
   }

   uploadImage(event:any){

    let sum: number =0;
     if(this.image){
       const imageUpload = this.invoiceService.invoiceImageUpload(this.invoiceObj).subscribe(
         response => { 
           console.log("response 123 "+ JSON.stringify(response));
           this.invoices = response;
           console.log("message "+this.invoices);
           for(let i=0;i<this.invoices.length;i++){
              sum = sum + this.invoices[i].itemPrice;
           }
           console.log("invoice length : " +this.invoices.length);
           console.log("sum : " + sum);
           this.invoices.push({
             itemName : 'Total Cost',
             itemPrice : sum,
             userId :Number(localStorage.getItem('userId')) ,
             billId : 4,
             billPath : ''
           })
           console.log("invoicessssss  : " + JSON.stringify(this.invoices));
     });
     }
   }

}



