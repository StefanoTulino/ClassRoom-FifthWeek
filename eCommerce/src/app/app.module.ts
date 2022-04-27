import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { OrderComponent } from './order/order.component';
import {MatListModule} from '@angular/material/list';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    OrderComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,
    AppRoutingModule,BrowserAnimationsModule,
    MaterialModule,
    MatIconModule,MatToolbarModule,MatCardModule, MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
