import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedVolumesHomeComponent } from './featured-volumes-home.component';

describe('FeaturedVolumesHomeComponent', () => {
  let component: FeaturedVolumesHomeComponent;
  let fixture: ComponentFixture<FeaturedVolumesHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedVolumesHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedVolumesHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
