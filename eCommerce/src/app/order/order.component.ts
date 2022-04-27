import { Component, Input, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { Articolo } from '../model/Articolo';


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders: Articolo[]=  [
    { id: '1', name: 'Messaggio 1', details: 'Questo è un messaggio di testo' },
    { id: '2', name: 'Messaggio 2', details: 'Questo è un messaggio di testo' },
    { id: '3', name: 'Messaggio 3', details: 'Questo è un messaggio di testo' }
   ];


   @Input() myProducts: any[]= [];

  constructor() {

   }

  ngOnInit(): void {
  }

}
