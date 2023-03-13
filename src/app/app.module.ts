import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './signup/signup.component';
import { RouterModule } from '@angular/router';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { UserService } from './service/user.service';
import { HomeComponent } from './home/home.component';
import { QrCodeComponent } from './qr-code/qr-code.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { QrCodeGeneratorComponent } from './qr-code/qr-code-generator/qr-code-generator.component';
import { QrCodeScannerComponent } from './qr-code/qr-code-scanner/qr-code-scanner.component';
import { ProfileComponent } from './profile/profile.component';
import { HeaderComponent } from './header/header.component';
import { TopNavComponent } from './top-nav/top-nav.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    QrCodeComponent,
    InvoiceComponent,
    QrCodeGeneratorComponent,
    QrCodeScannerComponent,
    ProfileComponent,
    HeaderComponent,
    TopNavComponent
  


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path:'',redirectTo:'login',pathMatch:'full'},
      {path:'login',redirectTo:'login',pathMatch:'full'},
      {path:'login',component:LoginComponent},
      {path:'signup',component:SignupComponent},
      {path :'home',component:HomeComponent},
      {path:'qrcode',component:QrCodeComponent},
      {path:'invoice',component:InvoiceComponent},
      {path:'qrcodeGenerator', component:QrCodeGeneratorComponent},
      {path:'qrcodeScanner' ,component:QrCodeScannerComponent},
      {path:'profile',component:ProfileComponent},
      {path:'header',component:HeaderComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA,
    NO_ERRORS_SCHEMA
  ]
})
export class AppModule { }
