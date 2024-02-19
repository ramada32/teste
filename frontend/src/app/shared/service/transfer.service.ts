import { TransferForm } from '../model/transfer-form';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { Transfer } from '../model/transfer';

const URL = environment.URL_API + '/transfer';

@Injectable({
  providedIn: 'root',
})
export class TransferService {
  constructor(private http: HttpClient) {}

  findAll(): Observable<Transfer[]> {
    return this.http.get<Transfer[]>(`${URL}`);
  }

  findById(id: number): Observable<Transfer> {
    return this.http.get<Transfer>(`${URL}/${id}`);
  }

  findTransferCustomerAccountId(id: number): Observable<Transfer[]> {
    return this.http.get<Transfer[]>(`${URL}/${id}`);
  }

  save(transferForm: TransferForm): Observable<Transfer> {
    return this.http.post<Transfer>(`${URL}`, transferForm);
  }

  update(id: number, transferForm: TransferForm): Observable<Transfer> {
    return this.http.put<Transfer>(`${URL}/${id}`, transferForm);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${URL}/${id}`);
  }
}
