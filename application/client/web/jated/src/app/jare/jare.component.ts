import { Component, OnInit, ViewChild } from '@angular/core';
import { JareService } from './jare.service';





@Component({
  selector: 'app-jare',
  templateUrl: './jare.component.html',
  styleUrls: ['./jare.component.scss'],
})

export class JareComponent implements OnInit {
    public name:any = {
        created_date: '',
        created_by: '',
        last_modified_by: '',
        last_modified_date: '',
        name: '',
        email: '',
    }




    constructor (
        private jareService: JareService,
    ) { }

    ngOnInit() {
        this.name.created_by = sessionStorage.getItem('email') || ''; 
        


    
    }
    Create() {
        this.jareService.Create(this.test).subscribe((data:any) => {
            
        },
        (error:Error) => {
            console.log('Error', error);
        });
    }


}