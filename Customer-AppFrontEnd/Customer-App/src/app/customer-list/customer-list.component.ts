import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustServiceService } from '../service/cust-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];
  

  constructor(private customerService: CustServiceService, 
    private router: Router) { }

  ngOnInit(): void {
    this.getCustomers();
   
  }

  private getCustomers() {
    this.customerService.getAllCustomers().subscribe((data: Customer[]) => {
      this.customers = data;
      
    });
  }

  customerDetails(id: number) {
    this.router.navigate(['customer-details', id]);
  }

  updateCustomer(id: number) {
    this.router.navigate(['update-customer', id]);
  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(data => {
      console.log(data);
      this.getCustomers();
    });
  }

}
