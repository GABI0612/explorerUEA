import { Component, Input } from '@angular/core';
import { Atividade } from '../shared/model/atividade.model';
import { ProjetoService } from './projeto.service';

@Component({
  selector: 'app-projetos',
  templateUrl: './projetos.component.html',
  styleUrls: ['./projetos.component.css']
})
export class ProjetosComponent {
  panelOpenState = false;
  listaprojetos: Atividade[] = [];
  @Input() dataSource: any;
  @Input() projeto!:ProjetoService;

  constructor(
    private projetoService: ProjetoService,
    
  ){}

    ngOnInit():void{
      this.projetoService.listarProjetos().subscribe({
        next: (res)  => {
          this.listaprojetos = res;
          console.log(this.listaprojetos);
        },
        error: (error) => {
          console.log(error);
        }
    });
}
}