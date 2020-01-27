import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { MenuComponent } from "./menu/menu.component";
import { LoginComponent } from "./login/login.component";
import { RegistrationComponent } from "./registration/registration.component";
import { CurriculumVitaeComponent } from "./curriculum-vitae/curriculum-vitae.component";
import { ActiviteComponent } from "./activite/activite.component";
import { Routes, RouterModule } from "@angular/router";
import { ViewPersonneComponent } from "./view-personne/view-personne.component";
import { ListPersonneComponent } from "./list-personne/list-personne.component";
import { HomeComponent } from "./home/home.component";
import { HttpClientModule } from "@angular/common/http";
import { AuthenticationService } from './services/authentication.service';

const appRoutes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "register", component: RegistrationComponent },
  { path: "curriculum", component: CurriculumVitaeComponent },
  { path: "viewPersonne", component: ViewPersonneComponent },
  { path: "listPersonne", component: ListPersonneComponent }
  // {path:"",redirectTo:'/login',pathMatch:'full'}
];
@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    RegistrationComponent,
    CurriculumVitaeComponent,
    ActiviteComponent,
    ViewPersonneComponent,
    ListPersonneComponent,
    HomeComponent
  ],
  //Les imports doivent se faire dans le tableau ci-dessous
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    AppRoutingModule,
    HttpClientModule
  ],
  //Toujours déclarer les services dans le tableau des providers, sinon on ne pourra pas l'injecter ailleurs
  providers: [AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule {}
