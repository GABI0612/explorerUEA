import { Component, Input } from '@angular/core';
import { Usuario } from '../shared/model/usuario.model';
import { UsuarioService } from './usuario.service';


@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent {

  panelOpenState = false;
  listausuario: Usuario[] = [];

  @Input() dataSource: any;
  @Input() usuario!:UsuarioService;
  dialog: any;
  sharedService: any;

  constructor(
    private usuarioService: UsuarioService,
    
  ){}

    ngOnInit():void{
      this.usuarioService.listarUsuarios().subscribe({
        next: (res)  => {
          this.listausuario = res;
          console.log(this.listausuario);
        },
        error: (error) => {
          console.log(error);
        }
    });


    }
    public confirmarExclusao(usuario: Usuario, codigo: number): void {
      const dialogRef =this.dialog.open( {
        width: '600px',
        data: {
        }
      });
  
      dialogRef.afterClosed().subscribe((result: string) => {
        if(result==="confirmado"){
          this.excluir(codigo);
        }
      });
     }
  
  
    excluir(codigo: number) {
      console.log(codigo)
      this.usuarioService.excluir(codigo).subscribe({
        next: (res)  => {
        },
        error: (error) => {
          console.log(error);
        }
      });
    }
  


}

