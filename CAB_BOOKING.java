package cab;

/* 
==online cab booking system code in java that cover below topic
->Basic concepts (i.e constructor, method overloading, super, this,  etc) of OOP
->Inheritance 
->Abstract Classes / Interface
->Package
->Exception Handling
*/



import java.util.*;

class BOOKING extends Exception{

    public BOOKING(String message) {
        super(message);
    }

}

interface CabBooking {

    void BookCab(String cabType);

}

class USER{

    String name;
    String mobile_number;

    USER(String Name,String Mobile_number){
        this.name=Name;
        this.mobile_number=Mobile_number;
    }
    
    void show(){
        System.out.println();
        System.out.println("SUCCESSFULLY LOGIN IN APP");
        System.out.println("WELCOME "+name);
        System.out.println();
    }
    
}

class LOCATION {

    String starting_location;
    String ending_location;
    Random random=new Random();
    int fairofdistance=random.nextInt(1,1000);
    
    LOCATION(String Starting_location,String Ending_location){
        this.starting_location=Starting_location;
        this.ending_location=Ending_location;
    }

    void show(){
        System.out.println();
        System.out.println("YOUR DRIVER WILL ARRIVE SOON...");
        System.out.println("YOUR FAIR_OF_DISTSNCE OR MINIMUM_FAIR IS "+fairofdistance);
        System.out.println();
    }

    public int getfairofdistance(){
        return fairofdistance;
    }

}

class VEHICLE implements CabBooking{

    public String vehicle_type;
    public int fairperdistance=0;
    public void BookCab(String cabType){
        this.vehicle_type=cabType;
    }
    

    public String getvehicletype(){
        return vehicle_type;
    }
    
}

class FINAL {

    int price=0;

    void confirm(int Fairofdistance,int Fairperdistance){
        this.price=Fairofdistance*Fairperdistance;
    }

    void confirm(){
        System.out.println();
        System.out.println("YOUR RIDE HAS ARRIVED FAIR IS "+price);
        System.out.println();
    }
    
}


class CAB_BOOKING{
    public static void main(String [] args ){

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER YOUR NAME");
        String NAME=sc.nextLine();
        System.out.println("ENTER YOUR MOBILE NUMBER");
        String MOBILE_NUMBER=sc.nextLine();
        
        try{
            if(MOBILE_NUMBER.length()!=10){
                throw new BOOKING("YOU ENTER WRONG MOBILE NUMBER");
            }
        }
        catch(BOOKING e){
            System.out.println("ENTER YOUR MOBILE NUMBER AGAIN");
            MOBILE_NUMBER=sc.nextLine();
        }
        
        USER U=new USER(NAME,MOBILE_NUMBER);
        U.show();

        System.out.println("ENTER STARTING LOCATION");
        String STARTING_LOCATION=sc.nextLine();
        System.out.println("ENTER ENDING LOCATION");
        String ENDING_LOCATION=sc.nextLine();

        LOCATION L=new LOCATION(STARTING_LOCATION,ENDING_LOCATION);
        L.show();

        System.out.println("ENTER YOUR VEHICLE TYPE = CAR,BIKE,AUTO");
        String vehicle=sc.nextLine();
        VEHICLE V=new VEHICLE();
        V.BookCab(vehicle);

        String s=V.getvehicletype();
        int x=L.getfairofdistance();
        int y=0;

        if(s.equals("CAR")){
            y=25;
        }
        if(s.equals("AUTO")){
            y=15;
        }
        if(s.equals("BIKE")){
            y=5;
        }
        
        FINAL F=new FINAL();
        F.confirm(x,y);
        F.confirm();

    }
}