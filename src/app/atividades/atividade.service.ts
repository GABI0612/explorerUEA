import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Publicacao } from '../shared/model/publicacao.model';

@Injectable({
  providedIn: 'root'
})
export class AtividadeService {

  private atividadeUrl = "http://localhost:8080/publicacoes";



  constructor(private http: HttpClient) { }

  public listarAtividades(): Observable<Publicacao[]> {
    return this.http.get<Publicacao[]>(`${this.atividadeUrl}`).pipe(
      res => res,
      error => error
    );
  }

}
