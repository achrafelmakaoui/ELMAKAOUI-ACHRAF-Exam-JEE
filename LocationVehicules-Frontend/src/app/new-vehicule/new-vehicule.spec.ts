import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewVehicule } from './new-vehicule';

describe('NewVehicule', () => {
  let component: NewVehicule;
  let fixture: ComponentFixture<NewVehicule>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewVehicule],
    }).compileComponents();

    fixture = TestBed.createComponent(NewVehicule);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
