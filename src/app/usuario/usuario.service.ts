import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Usuario } from '../shared/model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private usuarioUrl = "http://localhost:8080/usuarios";



  constructor(private http: HttpClient) { }

  public listarUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.usuarioUrl}`).pipe(
      res => res,
      error => error
    );
  }


  public excluir(codigo: number): Observable<Usuario> {
   
    return this.http.delete<Usuario>(`${this.usuarioUrl}/${codigo}`).pipe(
      res => res,
      error => error
    );
  }


  public pesquisarPorCodigo(codigo: number): Observable<Usuario> {
   

    return this.http.get<Usuario>(`${this.usuarioUrl}/${codigo}`).pipe(
      res => res,
      error => error
    );
  }

}
