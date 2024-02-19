import { Transfer } from './../shared/model/transfer';
import { Component, OnInit } from '@angular/core';
import { TransferService } from '../shared/service/transfer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrl: './transfer.component.css',
})
export class TransferComponent implements OnInit {
  transferForm!: FormGroup;
  transferId?: number;
  btnLabel: string = 'salvar';
searchText: any;
id: any;
  activatedRoute: any;
  actived: any;
loadTransfer() {
throw new Error('Method not implemented.');
}
  transfers: Transfer[] = [];

  constructor(
    public transferService: TransferService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.obterPorId(this.route.snapshot.params['clientId']);
  }

  findAll() {
    this.transferService.findAll().subscribe((result: Transfer[]) => {
      this.transfers = result ? result : [];
    });

  }

  obterPorId(id: number){
    this.transferService.findTransferCustomerAccountId(id).subscribe((result: Transfer[]) => {
      this.transfers = result ? result : [];
  });
}

  edit(id: number) {
    this.router.navigateByUrl(`/form/editar/${id}`);
  }
}
