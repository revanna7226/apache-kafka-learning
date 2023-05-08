import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
import { Message } from './_models/message';

@Injectable({
  providedIn: 'root'
})
export class PublishMessageService {

  publishUrl: string = "http://localhost:8080/api/v1/messages/publish";

  constructor(private http: HttpClient) {}

  publishMessage(message: Message): Observable<Message> {
    return this.http.post<Message>(this.publishUrl, {message: message.payload})
    .pipe(
      tap(
      {
        next: (data) => {
          console.log(data);
          
        },
        error: (error) => {
          console.warn(error);
        }
      }
      )
    );
  }

}
