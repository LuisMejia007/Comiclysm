import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedComicsHomeComponent } from './featured-comics-home.component';

describe('FeaturedComicsHomeComponent', () => {
  let component: FeaturedComicsHomeComponent;
  let fixture: ComponentFixture<FeaturedComicsHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedComicsHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedComicsHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
