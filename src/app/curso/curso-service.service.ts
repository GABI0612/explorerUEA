import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../shared/model/curso.model';
import { Categoria } from '../shared/model/categoria.model';

@Injectable({
  providedIn: 'root'
})
export class CursoServiceService {
  
  private cursoUrl = "http://localhost:8080/cursos";
  private categoriaUrl = "http://localhost:8080/categorias";


  constructor(private http: HttpClient) { }

  public listarCursos(): Observable<Curso[]> {
    return this.http.get<Curso[]>(`${this.cursoUrl}`).pipe(
      res => res,
      error => error
    );
  }

  public listarCategorias(): Observable<Categoria[]> {

    return this.http.get<Categoria[]>(`${this.categoriaUrl}`).pipe(
      res => res,
      error => error
    );
  }
}
