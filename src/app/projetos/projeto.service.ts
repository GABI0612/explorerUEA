import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Foto } from '../shared/model/foto.model';

@Injectable({
  providedIn: 'root'
})
export class ProjetoService {

  private projetoUrl = "http://localhost:8080/fotos";

  constructor(private http: HttpClient) { }

  public listarProjetos(): Observable<Foto[]> {

    return this.http.get<Foto[]>(`${this.projetoUrl}`).pipe(
      res => res,
      error => error
    );
  }
}
