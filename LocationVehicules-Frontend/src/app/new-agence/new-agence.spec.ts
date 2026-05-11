import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAgence } from './new-agence';

describe('NewAgence', () => {
  let component: NewAgence;
  let fixture: ComponentFixture<NewAgence>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewAgence],
    }).compileComponents();

    fixture = TestBed.createComponent(NewAgence);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
