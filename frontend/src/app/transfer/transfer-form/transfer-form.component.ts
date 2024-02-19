import { HttpClient } from '@angular/common/http';
import { Component, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Transfer } from '../../shared/model/transfer';
import { TransferService } from '../../shared/service/transfer.service';

@Component({
  selector: 'app-transfer-form',
  templateUrl: './transfer-form.component.html',
  styleUrl: './transfer-form.component.css',
})
export class TransferFormComponent {
  transferForm!: FormGroup;
  transferId?: number;
  btnLabel: string = 'salvar';
searchText: any;
id: any;
  activatedRoute: any;


  constructor(
    private fb: FormBuilder,
    private transferService: TransferService,
    private router: Router,
    private actived: ActivatedRoute,
    private route: ActivatedRoute,
    private messageService: MessageService
  ) {
    this.createForm();
    this.transferId = this.actived.snapshot.params['clientId'];
    if (this.transferId) {
      this.btnLabel = 'atualizar';
    }
  }

  createForm(): void {
    this.transferForm = this.fb.group({
      dateFinal: ['', [Validators.required]],
      numberAccount: [this.actived.snapshot.params['clientId'], [Validators.required, Validators.min(1)]],
      numberAccountDestiny: ['', [Validators.required, Validators.min(1)]],
      valueTransfer: ['', [Validators.required, Validators.min(1)]],
    });
  }

  saveUpdate(): void {
    console.log(this.transferForm.value)
    if(this.transferForm.valid){
      if(this.transferId){
        this.save()
      }
    }
  }

  save(): void {

      this.transferService.save(this.transferForm.value).subscribe(() => {
        this.messageService.add({
          severity: 'success',
          summary: 'Sucesso',
          detail: 'Transferencia salvo com sucesso',
        });
        this.router.navigateByUrl('/');
      }, err =>{
        this.messageService.add({
          severity: 'error',
            summary: 'ERRO',
            detail: 'PREENCHIMENTO INCORRETO DE UM OU MAIS CAMPOS'});
      })

  }

  update() {

    this.transferService.update(this.transferId!, this.transferForm.value).subscribe(() => {
      this.messageService.add({
        severity: 'success',
        summary: 'Sucesso',
        detail: 'Transferencia editada com sucesso',
      });
      this.router.navigateByUrl('/');
    });
  }



  loadTransfer() {
    this.transferService
      .findById(this.transferId!)
      .subscribe((result: Transfer) => {
        this.transferForm.get('numberAccount')?.setValue(result.numberAccount);
        this.transferForm.get('numberAccountDestiny')?.setValue(result.numberAccountDestiny);
        this.transferForm.get('dateInitial')?.setValue(new Date(result.dateInitial!));
        this.transferForm.get('dateFinal')?.setValue(new Date(result.dateFinal!));
        this.transferForm.get('rateTransfer')?.setValue(result.rateTransfer);
        this.transferForm.get('valueTransfer')?.setValue(result.valueTransfer);
        this.transferForm.get('freeValue')?.setValue(result.freeValue);
        console.log(this.transferForm.value)
      });
  }
}
