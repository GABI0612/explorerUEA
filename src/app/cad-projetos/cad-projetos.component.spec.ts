import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadProjetosComponent } from './cad-projetos.component';

describe('CadProjetosComponent', () => {
  let component: CadProjetosComponent;
  let fixture: ComponentFixture<CadProjetosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadProjetosComponent]
    });
    fixture = TestBed.createComponent(CadProjetosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
