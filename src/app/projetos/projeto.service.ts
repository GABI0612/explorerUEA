import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Atividade } from '../shared/model/atividade.model';

@Injectable({
  providedIn: 'root'
})
export class ProjetoService {

  private projetoUrl = "http://localhost:8080/atividades";

  constructor(private http: HttpClient) { }

  public listarProjetos(): Observable<Atividade[]> {

    return this.http.get<Atividade[]>(`${this.projetoUrl}`).pipe(
      res => res,
      error => error
    );
  }}
