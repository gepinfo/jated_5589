import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { JareService } from './jare.service';
import { SharedService } from '../../shared/shared.service';

describe('jareService', () => {
  let service: JareService;
  let httpMock: HttpTestingController;
  let sharedServiceMock = jasmine.createSpyObj('SharedService', ['methodName1', 'methodName2']);
  let sharedService: SharedService;


  beforeEach(() => {
    TestBed.configureTestingModule({});
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [],
      providers: [ JareService, { provide: SharedService, useValue: sharedServiceMock } ]
    });
    service = TestBed.inject(JareService);
    sharedService = TestBed.inject(SharedService);
    httpMock = TestBed.inject(HttpTestingController);


  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  afterEach(() => {
    httpMock.verify();
  });


  // test case gp create
  it('should send a POST request to the server', () => {
    const name = { 
    name: 'name 1'
    email: 'email 1'
    }
    const jwtToken = '123Hsdf_23234fdsjk';
    
    // Make the API call
    service.Create(name).subscribe(response => {
      expect(response).toEqual(name)
    });

    // Expect a POST request to the specified endpoint with the provided data
    const req = httpMock.expectOne(`${sharedService.WEB_API}/test?jwt_token=${jwtToken}`);
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual(name);

    // Flush the mocked response
    req.flush(name);
  });



  
});
