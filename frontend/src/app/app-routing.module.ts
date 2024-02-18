import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TransferFormComponent } from './transfer/transfer-form/transfer-form.component';
import { TransferComponent } from './transfer/transfer.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: TransferComponent,
  },
  //{
  //  path: 'form',
  //  component: TransferFormComponent,
  // },
  {
    path: 'form',
    children: [
      { path: 'adicionar', component: TransferFormComponent },
      { path: 'editar/:id', component: TransferFormComponent },
    ], //pasteamento telas
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
