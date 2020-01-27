import { Component, OnInit } from '@angular/core';
import { PersonneService } from '../services/personne.service';

@Component({
  selector: 'app-list-personne',
  templateUrl: './list-personne.component.html',
  styleUrls: ['./list-personne.component.css']
})
export class ListPersonneComponent implements OnInit {

  private personne: any[];

  constructor(private personneService:PersonneService) { }

  ngOnInit() {
      this.personneService.getAllPersonnes().subscribe(
        data => {
          this.personne = data;
        }
      )
  
  }

}
