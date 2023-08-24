import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';




@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {
  public salvar (form: NgForm){
    console.log(form.value);
  }
  public tipoPessoas = [
    { label: 'ADM', value: 1 },
    { label: 'PROFESSOR', value: 2 },
    { label: 'SECRETARIO', value: 3 }
  ];
}
