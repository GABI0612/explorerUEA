import { Component, Input } from '@angular/core';
import { ProjetoService } from './projeto.service';
import { Foto } from '../shared/model/foto.model';

@Component({
  selector: 'app-projetos',
  templateUrl: './projetos.component.html',
  styleUrls: ['./projetos.component.css']
})
export class ProjetosComponent {
  panelOpenState = false;
  listaprojetos: Foto[] = [];
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