import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedComicsComponent } from './featured-comics.component';

describe('FeaturedComicsComponent', () => {
  let component: FeaturedComicsComponent;
  let fixture: ComponentFixture<FeaturedComicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedComicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedComicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
