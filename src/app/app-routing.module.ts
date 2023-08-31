import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LoginComponent } from './login/login.component';
import { CursoComponent } from './curso/curso.component';
import { ProjetosComponent } from './projetos/projetos.component';
import { AtividadesComponent } from './atividades/atividades.component';
import { CadProjetosComponent } from './cad-projetos/cad-projetos.component';
import { CadAtividadeComponent } from './cad-atividade/cad-atividade.component';
import { UsuarioComponent } from './usuario/usuario.component';

const routes: Routes = [
  {path: "", component:HomeComponent},
  {path: "cadastro", component:CadastroComponent},
  {path: "login", component:LoginComponent},
  {path: "curso", component:CursoComponent},
  {path: "projetos", component:ProjetosComponent},
  {path: "projetos/novo", component:CadProjetosComponent},
  {path: "atividade", component:AtividadesComponent},
  {path: "atividade/novo", component:CadAtividadeComponent},
  {path: "usuarios", component:UsuarioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
