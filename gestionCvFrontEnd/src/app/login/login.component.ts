import { Component, OnInit, ElementRef, Input, OnDestroy } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit , OnDestroy {

mode: number = 0;

  constructor(private authenticationService: AuthenticationService, private router:Router) { 

  }

  ngOnInit(): void {
    this.mode = 0;    }

    // remove self from modal service when component is destroyed
    ngOnDestroy(): void {
       
    }


    onLogin(user){
        console.log(user);
        this.authenticationService.login(user).subscribe(

            resp => {
                let jwt = resp.headers.get('authorization');
                console.log(jwt);
                this.authenticationService.saveToken(jwt);
                this.router.navigateByUrl('/listPersonne');
            },
            error => {
                this.mode=1;
            }
        )
    }

}
