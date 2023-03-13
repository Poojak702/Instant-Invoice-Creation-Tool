import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { QrCodeGeneratorComponent } from './qr-code/qr-code-generator/qr-code-generator.component';
import { QrCodeScannerComponent } from './qr-code/qr-code-scanner/qr-code-scanner.component';
import { QrCodeComponent } from './qr-code/qr-code.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'home',component:HomeComponent},
  {path:'qrcode',component:QrCodeComponent},
  {path:'invoice',component:InvoiceComponent},
  {path:'qrcodeGenerator', component:QrCodeGeneratorComponent},
  {path:'qrcodeScanner' ,component:QrCodeScannerComponent},
  {path:'profile',component:ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
