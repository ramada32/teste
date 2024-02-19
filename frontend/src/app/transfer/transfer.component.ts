import { Transfer } from './../shared/model/transfer';
import { Component, OnInit } from '@angular/core';
import { TransferService } from '../shared/service/transfer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrl: './transfer.component.css',
})
export class TransferComponent implements OnInit {
  transfers: Transfer[] = [];

  constructor(
    public transferService: TransferService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.transferService.findAll().subscribe((result: Transfer[]) => {
      this.transfers = result ? result : [];
    });

  }

  edit(id: number) {
    this.router.navigateByUrl(`/form/editar/${id}`);
  }
}
