import { Component, OnInit } from '@angular/core';
import { BookService } from '../../services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
})
export class BookListComponent implements OnInit {
  books: any[] = [];
  message: string = '';

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    // Llamamos a la función getAllBooks correctamente
    this.bookService.getAllBooks().subscribe({
      next: (data) => {
        this.books = data;  // Asumiendo que el backend devuelve una lista de libros
      },
      error: (err) => {
        this.message = 'No se pudo obtener la lista de libros';
        console.error(err);
      },
    });
  }
}