import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './components/book-list/book-list.component'; // Asegúrate de importar el componente

const routes: Routes = [
  { path: 'libros', component: BookListComponent }, // Ruta a los libros
  { path: '', redirectTo: '/libros', pathMatch: 'full' } // Redirección predeterminada
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }