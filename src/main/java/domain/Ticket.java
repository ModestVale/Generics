package domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    public int compareTo(Ticket secondTicket) {
        if (this.price < secondTicket.price)
            return -1;
        if (this.price > secondTicket.price)
            return 1;

        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public Ticket(int id, int price, String arrivalAirport, String departureAirport, int travelTime)
    {
        this.id = id;
        this.price = price;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.travelTime = travelTime;
    }
}
