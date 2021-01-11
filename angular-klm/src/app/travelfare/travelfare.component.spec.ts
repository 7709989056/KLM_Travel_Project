import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelfareComponent } from './travelfare.component';

describe('TravelfareComponent', () => {
  let component: TravelfareComponent;
  let fixture: ComponentFixture<TravelfareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelfareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelfareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
