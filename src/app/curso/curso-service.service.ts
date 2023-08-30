import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../shared/model/curso.model';

@Injectable({
  providedIn: 'root'
})
export class CursoServiceService {
  private cursoUrl = "http://localhost:8080/cursos";

  constructor(private http: HttpClient) { }

  public listarCursos(): Observable<Curso[]> {
    return this.http.get<Curso[]>(`${this.cursoUrl}`).pipe(
      res => res,
      error => error
    );
  }
}
