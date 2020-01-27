import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class PersonneService {

    private host:string="http://localhost:8080";
    

    constructor(private http:HttpClient){

    }


    getAllPersonnes(){
        return this.http.get(this.host+"/personnes");
    }






}