import { Component, Input } from '@angular/core';
import { Publicacao } from '../shared/model/publicacao.model';

import { AtividadeService } from './atividade.service';

@Component({
  selector: 'app-atividades',
  templateUrl: './atividades.component.html',
  styleUrls: ['./atividades.component.css']
})
export class AtividadesComponent {
  panelOpenState = false;
  listaatividade: Publicacao[] = [];

  @Input() dataSource: any;
  @Input() atividade!:AtividadeService;
  dialog: any;
  sharedService: any;

  constructor(
    private atividadeService: AtividadeService,
    
  ){}

    ngOnInit():void{
      this.atividadeService.listarAtividades().subscribe({
        next: (res)  => {
          this.listaatividade = res;
          console.log(this.listaatividade);
        },
        error: (error) => {
          console.log(error);
        }
    });
  }
}
