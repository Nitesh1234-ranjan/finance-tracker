import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface User {
  id?: number;
  name: string;
  email: string;
  password?: string;
}

@Injectable({
  providedIn: 'root'
})
export class User {
  private baseUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}


  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrl, user);
  }


  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl);
  }


  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/${id}`);
  }


  updateUser(id: number, user: User): Observable<User> {
    return this.http.put<User>(`${this.baseUrl}/${id}`, user);
  }


  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
