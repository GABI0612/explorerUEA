import { Component, Input, OnInit } from '@angular/core';

import { CursoServiceService } from './curso-service.service';
import { Curso } from '../shared/model/curso.model';
import { Categoria } from '../shared/model/categoria.model';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css'],
 
})
export class CursoComponent {
  panelOpenState = false;
  listacurso: Curso[] = [];
  listacategoria: Categoria[] = [];


  constructor(
    private cursoService: CursoServiceService,
    
  ){}

    ngOnInit():void{
      this.cursoService.listarCursos().subscribe({
        next: (res)  => {
          this.listacurso = res;
          console.log(this.listacurso);
        },
        error: (error) => {
          console.log(error);
        }
    });
this.cursoService.listarCategorias().subscribe({
  next: (res)  => {
    this.listacategoria = res;
    console.log(this.listacategoria);
  },
  error: (error) => {
    console.log(error);
  }
});


    }


}
