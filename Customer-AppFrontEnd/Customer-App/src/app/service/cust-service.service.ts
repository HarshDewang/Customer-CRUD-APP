import { Injectable } from '@angular/core';
import { Customer } from '../customer';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthServiceService } from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class CustServiceService {

  
  private baseURL = "http://localhost:8080/api/customer";

  constructor(private httpClient:HttpClient) { }


  createCustomer(customer:Customer): Observable<object>{

    return this.httpClient.post(`${this.baseURL}`,customer)
  }

  updateCustomer(id: number,customer:Customer):Observable<object>{

    return this.httpClient.put(`${this.baseURL}/${id}`, customer);
  }
  
  getAllCustomers():Observable<Customer[]>{

    return this.httpClient.get<Customer[]>(`${this.baseURL}`);
  }
  

  getCustomerById(id:number):Observable<Customer>{

    return this.httpClient.get<Customer>(`${this.baseURL}/${id}`);
  }

  deleteCustomer(id:number):Observable<object>{

    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
