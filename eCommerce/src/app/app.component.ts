import { Component, Output } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eCommerce';

  products: any[]= [];
  productSelect: any[]=[];

  constructor(private httpClient: HttpClient, private router: Router){
    this.httpClient
    .get<any>('http://localhost:8080/api/products/getAll')
    .subscribe( (e)=> {
      console.log(e)
      this.products=e;
    });
  }


  addElement = (product:any)=> {
    this.productSelect.push(product);
    console.log("ciao"+ JSON.stringify(this.productSelect));
  }

  btnClick= ()=> {
    this.router.navigateByUrl('/order');
};

}
