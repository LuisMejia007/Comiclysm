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

  constructor(private service: ComiclysmService) { }

  ngOnInit() {
    this.getComics();
  }


  setPage(pageNum: number, event: any ) {
    event.preventDefault();
    this.pageNum = pageNum;
    this.getComics();
  }

  getComics() {
    this.service.getPageOfComics(this.pageNum).subscribe(
      data => {
        this.comics = data['content'];
        this.pages = new Array (data['totalPages']);
      }, (error) => {
          console.log(error.error.message);
      }
    );
  }

}
