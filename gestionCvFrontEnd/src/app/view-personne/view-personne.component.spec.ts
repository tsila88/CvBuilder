import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPersonneComponent } from './view-personne.component';

describe('ViewPersonneComponent', () => {
  let component: ViewPersonneComponent;
  let fixture: ComponentFixture<ViewPersonneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPersonneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
