import { HttpClient, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/internal/operators/tap';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  private apiUrl = 'https://qa.sunbasedata.com/sunbase/portal/api';

  constructor(private http: HttpClient) {}

  authenticate(loginId: string, password: string): Observable<any> {
    const body = { login_id: loginId, password: password };
    return this.http.post(`${this.apiUrl}/assignment_auth.jsp`, body);
  }

  // You can store the token in local storage or a more secure storage based on your needs
  storeToken(token: string): void {
    localStorage.setItem('token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  isAuthenticated(): boolean {
    // Check if the token is present and not expired (you can add more validation as needed)
    const token = this.getToken();
    return token !== null && token !== undefined;
  }
}
