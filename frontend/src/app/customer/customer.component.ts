import { Customer } from '../shared/model/customer';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../shared/service/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})


  export class CustomerComponent implements OnInit {
    customers: Customer[] = [];

    constructor(
      public customerService: CustomerService,
      private router: Router
    ) {}

    ngOnInit(): void {
      this.findAll();
    }

    findAll() {
      this.customerService.findAll().subscribe((result: Customer[]) => {
        this.customers = result ? result : [];
      });
    }

    edit(id: number) {
      this.router.navigateByUrl(`/customer/editar/${id}`);
   }


  }
