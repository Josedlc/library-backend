import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { AppRoutingModule } from './app-routing.module';  // Importa el módulo de rutas

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule  // Asegúrate de agregar el módulo de rutas aquí
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }