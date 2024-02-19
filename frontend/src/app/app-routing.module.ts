import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TransferFormComponent } from './transfer/transfer-form/transfer-form.component';
import { TransferComponent } from './transfer/transfer.component';
import { CustomerComponent } from './customer/customer.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: CustomerComponent,
  },
  {
    path: 'transfer',
    children: [
      { path: ':clientId', component: TransferComponent },
      { path: 'adicionar/:clientId', component: TransferFormComponent },
      { path: 'editar/:id', component: TransferFormComponent },
    ], //pasteamento telas
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
