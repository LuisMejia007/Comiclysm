import { Component, OnInit } from '@angular/core';
import { ComiclysmService } from '../services/comiclysm.service';

@Component({
  selector: 'app-main-comic-list',
  templateUrl: './main-comic-list.component.html',
  styleUrls: ['./main-comic-list.component.css']
})
export class MainComicListComponent implements OnInit {

  private pageNum = 0;
  private comics: Array<any>;
  private pages: Array<number>;
  private filterType = 'none';

  constructor(private service: ComiclysmService) { }

  ngOnInit() {

    console.log('Filter: ' + this.filterType);
    if (this.filterType === 'none') {
      console.log('Get Comics');
      this.getComics();
    } else {
      console.log('Get MORE Comics');
      this.getMoreComics();
    }
  }


  setPage(pageNum: number, event: any ) {
    event.preventDefault();
    this.pageNum = pageNum;
      this.getComics();
  }

  getMoreComics() {
    console.log('GET MORE COMICS!');
    this.comics.forEach(function(comic) {
      console.log('comic:' + comic);
    });

    return this.comics;
  }

  getComics() {
    this.filterType = 'none';
    this.service.getPageOfComics(this.pageNum).subscribe(
      data => {
        this.comics = data['content'];
        this.pages = new Array (data['totalPages']);
      }, (error) => {
          console.log(error.error.message);
      }
    );
  
  }


  getComicsByName(event: any) {
    console.log('GET MORE COMICS! ' + event);
    this.service.getPageOfComicsByName(event, this.pageNum).subscribe(
      data => {
        this.filterType = 'name';
        this.comics = data['content'];
        this.pages = new Array (data['totalPages']);
      }, (error) => {
          console.log(error.error.message);
      }
    );
    console.log('Len: ' + this.comics.length + ' Pages: ' + this.pages.length);
  }

  getComicsByWriter(event: any) {
    console.log('GET MORE COMICS! ' + event);
    this.service.getPageOfComicsByWriter(event, this.pageNum).subscribe(
      data => {
        this.comics = data['content'];
        this.pages = new Array (data['totalPages']);
        this.filterType = 'writer';
      }, (error) => {
          console.log(error.error.message);
      }
    );
    console.log('Len: ' + this.comics.length + ' Pages: ' + this.pages.length);
  }

  getComicsByArtist(event: any) {
    console.log('GET MORE COMICS! ' + event);
    this.service.getPageOfComicsByArtist(event, this.pageNum).subscribe(
      data => {
        this.comics = data['content'];
        this.pages = new Array (data['totalPages']);
        this.filterType = 'artist';
      }, (error) => {
          console.log(error.error.message);
      }
    );
    console.log('Len: ' + this.comics.length + ' Pages: ' + this.pages.length);
  }

  getComicsByYear(event: any) {
    console.log('GET MORE COMICS! ' + event);
    this.service.getPageOfComicsByDate(event, this.pageNum).subscribe(
      data => {
        this.comics = data['content'];
        this.pages = new Array (data['totalPages']);
        this.filterType = 'year';
      }, (error) => {
          console.log(error.error.message);
      }
    );
    console.log('Len: ' + this.comics.length + ' Pages: ' + this.pages.length);
  }
}
