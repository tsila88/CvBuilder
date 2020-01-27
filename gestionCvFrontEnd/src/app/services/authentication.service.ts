import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AuthenticationService {

    private host:string="http://localhost:8080";
    private jwtToken = null;

    constructor(private http:HttpClient){

    }


    login(user){
        return this.http.post(this.host+"/login",user,{observe: 'response'});
    }

    saveToken(jwt:string){
        localStorage.setItem('token',jwt);
    }

    loadToken(){
        this.jwtToken=localStorage.getItem('token');
    }



}