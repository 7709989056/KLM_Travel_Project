import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators'
import { throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class TravelfareServiceService {
  private baseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  getFareResult(fareObj: Object): Observable<Object> {
    console.log(fareObj);
    return this.http.post(`${this.baseUrl}`+'/fares',fareObj).pipe(
      catchError(this.handleError)
      );
  ;
  }
  handleError(error: HttpErrorResponse){
    
    console.log(error.message);
    console.log(error.status);
    return throwError(error);
    }

  
  getAirportList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'/airports');
  }
}
