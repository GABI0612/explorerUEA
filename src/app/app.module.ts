import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { HomeComponent } from './home/home.component';
import { CursoComponent } from './curso/curso.component';
import { ProjetosComponent } from './projetos/projetos.component';
import { AtividadesComponent } from './atividades/atividades.component';

import {MatInputModule} from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatSelectModule} from '@angular/material/select';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatExpansionModule} from '@angular/material/expansion';
import {NgFor, NgIf} from '@angular/common';
import {MatTableModule} from '@angular/material/table';
import {CdkAccordionModule} from '@angular/cdk/accordion';


import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CadastroComponent,
    HomeComponent,
    CursoComponent,
    ProjetosComponent,
    AtividadesComponent,
    LoginComponent,
    FooterComponent
  ],
  

  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,

    CdkAccordionModule,
    MatMenuModule,
    MatToolbarModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
    MatGridListModule,
    MatCardModule,
    MatTableModule,
    NgFor,  
    NgIf,
    MatExpansionModule, 

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  panelOpenState = false;
}
