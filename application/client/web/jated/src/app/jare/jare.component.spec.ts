import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JareComponent } from './jare.component';
import { JareService } from './jare.service'
import { of, throwError } from 'rxjs';
import { SharedService } from 'src/shared/shared.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JareComponent } from './jare.component';


describe('JareComponent', () => {
  let component: JareComponent;
  let fixture: ComponentFixture<JareComponent>;
  let service: JareService;
  let sharedServiceMock = jasmine.createSpyObj('SharedService', ['methodName1', 'methodName2']);
  let httpClient: HttpClientTestingModule;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, 
        FormsModule, ReactiveFormsModule,
      ],
      declarations: [ JareComponent ],
      providers: [ JareService, 
        { provide: SharedService, useValue: sharedServiceMock},
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JareComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(JareService);
    httpClient = TestBed.inject(HttpClient);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // ngOnInit application onload
  it('should set the created_by property with the value from sessionStorage', () => {
    const mockEmail = 'test@example.com';
    spyOn(sessionStorage, 'getItem').and.returnValue(mockEmail);
    component.ngOnInit();

    expect(sessionStorage.getItem).toHaveBeenCalledWith('email');
    expect(component.name.created_by).toEqual(mockEmail);

  });
  

  // Create test case file
  it('should call Create and reset  properties', () => {

    // Create a spy for the Create method of the service
    spyOn(service, 'Create').and.returnValue(of({}));
    
    // Set values for name properties
    component.name.name = 'Test name';
    component.name.email = 'Test email';


    // Call the Create method
    component.Create();


    // Expect the Create method to have been called with the tickets object
    expect(service.Create).toHaveBeenCalledWith(component.name);

    // Expect the name properties to be reset
    expect(component.name.name).toBe('');
    expect(component.name.email).toBe('');
  });
  it('should log error on update Create failure', () => {
    const error = new Error('GpCreate failed');
    spyOn(service, 'Create').and.returnValue(throwError(() => {
      return error;
    }));
    spyOn(console, 'log');

    component.Create();

    expect(console.log).toHaveBeenCalledWith('Error', error);
  });









});