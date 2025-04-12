import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // 👈 IMPORTAR ESTO


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [RouterModule] 
})
export class AppComponent {
  title = 'library-app';
}
