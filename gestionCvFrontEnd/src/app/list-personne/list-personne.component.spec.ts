import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPersonneComponent } from './list-personne.component';

describe('ListPersonneComponent', () => {
  let component: ListPersonneComponent;
  let fixture: ComponentFixture<ListPersonneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListPersonneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
