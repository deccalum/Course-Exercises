package se.lexicon;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class OOP2 {
    public static void main(String[] args) {
        // Available services
        List<Service> services = new ArrayList<>();
        services.add(new WinterTireChange());
        services.add(new SummerTireChange());

        // A List to store completed transactions
        List<Booking> history = new ArrayList<>();

        // Simulate requests
        List<BookingRequest> incomingRequests = new ArrayList<>();
        // index 0/1 = WinterTireChange/SummerTireChange
        incomingRequests.add(new BookingRequest("Alice", services.get(0)));
        incomingRequests.add(new BookingRequest("Bob", services.get(1)));

        // Process each request
        boolean isMember = true;
        BookingProcessor processor = BookingProcessor.getProcessor(isMember);

        for (BookingRequest req : incomingRequests) {
            Booking result = processor.processBooking(req);
            history.add(result);}
            
        // Print history
        for (Booking b : history) {System.out.println(b);}
    }
}

class BookingRequest {
    public String customerName;
    public Service service;

    public BookingRequest(String customerName, Service service) {
        this.customerName = customerName;
        this.service = service;}
}

class Booking {
    public String info;
    public int price;

    public Booking(String info, int price) {
        this.info = info;
        this.price = price;}

    @Override
    public String toString() {return "Booking{" + "info='" + info + '\'' + ", price=" + price + "'";}
}

// removed 'public' to keep interface in the same file
interface BookingProcessor {
    Booking processBooking(BookingRequest request);

    static BookingProcessor getProcessor(boolean isMember) {
        return isMember ? new MemberBookingProcessor() : new NonMemberBookingProcessor();}
}

class MemberBookingProcessor implements BookingProcessor {
    @Override
    public Booking processBooking(BookingRequest request) {
        int price = request.service.calculatePrice(request.service.getBasePrice()) - 50; // Member discount
        return new Booking("Member booking for " + request.customerName, price);}
}

class NonMemberBookingProcessor implements BookingProcessor {
    @Override
    public Booking processBooking(BookingRequest request) {
        int price = request.service.calculatePrice(request.service.getBasePrice());
        return new Booking("Non-member booking for " + request.customerName, price);}
}

enum globalVar {
    INSTANCE; // this line does what exactly?
    public final LocalDateTime dt = LocalDateTime.now();

    public String getFormattedDate() {
        return String.format("%02d-%02d",
                dt.getDayOfMonth(),
                dt.getMonthValue());}
}

abstract class Service {
    private String id;
    private String name;
    private int basePrice;

    public Service(int basePrice) {
        this.id = generateID();
        this.name = generateName();
        this.basePrice = basePrice;}
    
    public abstract int calculatePrice(int basePrice);
    public String getId() {return id;}
    public String getName() {return name;}

    public int getBasePrice() {return basePrice;}
        
    abstract String generateID();
    abstract String generateName();
    void printServiceDetails() {
        System.out.println(String.format("%20s %20s %10s", id, name, calculatePrice(basePrice)));}
}

class WinterTireChange extends Service {
    private int storageFee = 200;

    public WinterTireChange() {super(500);}

    public int calculatePrice(int basePrice) {return basePrice + storageFee;}

    String generateID() {
        String uuidPart = UUID.randomUUID().toString().substring(0, 4);
        String date = globalVar.INSTANCE.getFormattedDate();
        return "WNT-" + uuidPart + "_" + date;}
    
    String generateName() {return this.getClass().getSimpleName();}
    }
    
class SummerTireChange extends Service {
    private int discount = 50;

    public SummerTireChange() {super(400);}

    public int calculatePrice(int basePrice) {
        return basePrice - discount;}

    String generateID() {
        String uuidPart = UUID.randomUUID().toString().substring(0, 4);
        String date = globalVar.INSTANCE.getFormattedDate();
        return "SMT-" + uuidPart + "_" + date;}
    
        String generateName() {return this.getClass().getSimpleName();}
    }