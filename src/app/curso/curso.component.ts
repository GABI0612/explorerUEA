import { Component } from '@angular/core';

import { CursoServiceService } from './curso-service.service';
import { Curso } from '../shared/model/curso.model';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css'],
 
})
export class CursoComponent {
  panelOpenState = false;
  listacurso: Curso[] = [];

  constructor(
    private cursoService: CursoServiceService,
    
  ){}

  pesquisa(){
    this.cursoService.listarCursos().subscribe({
      next: (res)  => {
        this.listacurso = res;
        console.log(this.listacurso);
      },
      error: (error) => {
        console.log(error);
      }
  });
  }
}
