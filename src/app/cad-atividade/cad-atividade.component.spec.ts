import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadAtividadeComponent } from './cad-atividade.component';

describe('CadAtividadeComponent', () => {
  let component: CadAtividadeComponent;
  let fixture: ComponentFixture<CadAtividadeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadAtividadeComponent]
    });
    fixture = TestBed.createComponent(CadAtividadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
