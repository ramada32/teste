import { CustomerForm } from './../model/customer-form';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

const URL = environment.URL_API + '/customer';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private http: HttpClient) {}

  findAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${URL}`);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${URL}/${id}`);
  }

  update(id: number, customerForm: CustomerForm): Observable<Customer> {
    return this.http.put<Customer>(`${URL}/${id}`, customerForm);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${URL}/${id}`);
  }
}
