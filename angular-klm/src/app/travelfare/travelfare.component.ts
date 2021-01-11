import { Component, OnInit,OnDestroy, ViewChild} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Fares } from '../fares';
import { Observable,Subject } from 'rxjs';
import { TravelfareServiceService } from '../travelfare-service.service';
import { DataTableDirective } from 'angular-datatables';

@Component({
  selector: 'app-travelfare',
  templateUrl: './travelfare.component.html',
  styleUrls: ['./travelfare.component.css']
})
export class TravelfareComponent implements OnInit {
  users$: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();


  fares: Observable<any>;
  isDisable = false;
  fareArr : Fares;
  airportList : Fares[];
  
  fareObj: Fares = new Fares();
  travelfareForm: FormGroup;
  submitted = false;
  currency_values: any = ["USD", "EUR"];
  constructor(private formBuilder: FormBuilder, 
    private travelfareServiceService: TravelfareServiceService) { }
  selectedVal:any='';
  errorMessage:any='';

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      processing: true
    };
    this.travelfareForm = this.formBuilder.group({
      origin:'',
      destination: '',
      currency:''
  });
  
  this.isDisable = true;
 this.getAirportList();

 //this.getdata(this.fareObj);
  }

  get f() { return this.travelfareForm.controls; }

  onSubmit() {
    this.isDisable = false;
    if(this.selectedVal ==''){
      this.selectedVal ='EUR'
    }
      this.submitted = true;
      if (this.travelfareForm.invalid) {
          return;
      }
      this.fareObj.origin = this.travelfareForm.controls.origin.value;
      this.fareObj.destination = this.travelfareForm.controls.destination.value;
      this.fareObj.currency = this.selectedVal;
     
      this.getdata(this.fareObj);
 
  }
  selectChange() {
    this.selectedVal = this.travelfareForm.controls.currency.value;
  }

  seterrormessage(str:string){
  this.errorMessage = str;
  
  }
  getdata(fareObj:Object) {
    this.travelfareServiceService.getFareResult(fareObj)
      .subscribe((
        data:Fares) => {
         this.fareArr = data;
         console.log(data);
         this.seterrormessage('');
        
        },
        error => {
          if(error.error.message == 'undefined'){
            this.seterrormessage("Looks like server is down"); 
          }else{
            this.seterrormessage(error.error.message)
          }
        }
       // this.errorMessage=error.error.message
        
      );
    
  }


 getAirportList(){
  this.travelfareServiceService.getAirportList()
      .subscribe((
        data:Fares[]) => {
         this.airportList = data;
         console.log(data);
         this.users$ = data;
         this.dtTrigger.next();
        },
        error => { 
          if(error.statusText == 'Unknown Error'){
          this.seterrormessage("Looks like server is down"); 
        }else{
          this.seterrormessage(error.error.message)
        }
      
      }); 
 }
 ngOnDestroy(): void {
  this.dtTrigger.unsubscribe();
}

}
