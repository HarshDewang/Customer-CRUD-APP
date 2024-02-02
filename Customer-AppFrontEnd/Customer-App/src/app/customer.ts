export class Customer{
    id:number;
    first_name:string;
    last_name:string;
    street:string;
    address:string;
    city:string;
    state:string;
    email:string;
    phone:String;

    constructor(){
        this.id=0;
        this.first_name='';
        this.last_name='';
        this.street='';
        this.address='';
        this.city='';
        this.state='';
        this.email='';
        this.phone='';
    }
}