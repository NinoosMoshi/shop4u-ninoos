import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  constructor(private http:HttpClient) { }


   // http://localhost:8080/api/shop/products?page=0&size=5
   getProducts(page:number, size:number):Observable<GetResponseProduct> {
    return this.http.get<GetResponseProduct>(`${environment.apiUrl}/products?page=${page}&size=${size}`).pipe(
      map(response => response)
    )
  }




}

interface GetResponseProduct{
  content: Product[],
  totalPages: number,
  totalElements: number,
  size: number,
  number: number
}

