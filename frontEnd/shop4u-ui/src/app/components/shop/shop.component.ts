import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product } from 'src/app/model/product';
import { ShopService } from 'src/app/services/shop.service';

@Component({
  selector: 'app-shop',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent {

  products:Product[] = [];

  thePageNumber: number = 1;
  thePageSize: number = 10;
  theTotalElements: number = 0;

  constructor(private shopService:ShopService){}

  ngOnInit(){
    this.handleListProducts();
  }


  handleListProducts(){
     this.shopService.getProducts(this.thePageNumber - 1, this.thePageSize).subscribe({
      next:response =>{
        this.products = response.content;
      },
      error:error =>{
        console.log(error)
      }
     })
  }



}
