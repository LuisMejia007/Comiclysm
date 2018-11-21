import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedVolumesComponent } from './featured-volumes.component';

describe('FeaturedVolumesComponent', () => {
  let component: FeaturedVolumesComponent;
  let fixture: ComponentFixture<FeaturedVolumesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedVolumesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedVolumesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
