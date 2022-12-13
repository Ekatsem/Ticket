package ru.netoljgy.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netoljgy.domain.repository.Repository;
import ru.netoljgy.domain.ticket.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);



    @Test
    public  void shouldSortTicket(){
        Ticket ticket1 = new Ticket(1, 500, "SVO", "LCA", 4);
        Ticket ticket2 = new Ticket(2, 300, "VVO", "BCN", 2);
        Ticket ticket3 = new Ticket(3, 800, "SVO", "LCA", 6);
        Ticket ticket4 = new Ticket(4, 400, "JFC", "HAV", 9);
        Ticket ticket5 = new Ticket(5, 600, "FRA", "MUC", 1);
        Ticket ticket6 = new Ticket(6, 800, "SVO", "LCA", 3);
        Ticket ticket7 = new Ticket(7, 200, "SVO", "LCA", 5);
        Ticket ticket8 = new Ticket(8, 900, "LCA", "SVO", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {ticket7, ticket1, ticket3, ticket6};
        Ticket[] actual = manager.findAll("SVO", "LCA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public  void shouldFindTicketIfOne(){
        Ticket ticket1 = new Ticket(1, 500, "SVO", "MUC", 4);
        Ticket ticket2 = new Ticket(2, 300, "VVO", "BCN", 2);
        Ticket ticket3 = new Ticket(3, 800, "SVO", "LAX", 6);
        Ticket ticket4 = new Ticket(4, 400, "JFC", "HAV", 9);
        Ticket ticket5 = new Ticket(5, 600, "FRA", "MUC", 1);
        Ticket ticket6 = new Ticket(6, 800, "SVO", "UFA", 3);
        Ticket ticket7 = new Ticket(7, 200, "SVO", "LCA", 5);
        Ticket ticket8 = new Ticket(8, 900, "LCA", "SVO", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.findAll("SVO", "LCA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public  void shouldSortTicketIfSamePrice(){
        Ticket ticket1 = new Ticket(1, 500, "SVO", "LCA", 4);
        Ticket ticket2 = new Ticket(2, 300, "VVO", "BCN", 2);
        Ticket ticket3 = new Ticket(3, 500, "SVO", "LCA", 6);
        Ticket ticket4 = new Ticket(4, 400, "JFC", "HAV", 9);
        Ticket ticket5 = new Ticket(5, 600, "FRA", "MUC", 1);
        Ticket ticket6 = new Ticket(6, 500, "SVO", "LCA", 3);
        Ticket ticket7 = new Ticket(7, 500, "SVO", "LCA", 5);
        Ticket ticket8 = new Ticket(8, 900, "LCA", "SVO", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {ticket1, ticket3, ticket6, ticket7};
        Ticket[] actual = manager.findAll("SVO", "LCA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public  void shouldSortTicketIfPriceDifferenceOne(){
        Ticket ticket1 = new Ticket(1, 502, "SVO", "LCA", 4);
        Ticket ticket2 = new Ticket(2, 300, "VVO", "BCN", 2);
        Ticket ticket3 = new Ticket(3, 503, "SVO", "LCA", 6);
        Ticket ticket4 = new Ticket(4, 400, "JFC", "HAV", 9);
        Ticket ticket5 = new Ticket(5, 600, "FRA", "MUC", 1);
        Ticket ticket6 = new Ticket(6, 501, "SVO", "LCA", 3);
        Ticket ticket7 = new Ticket(7, 500, "SVO", "LCA", 5);
        Ticket ticket8 = new Ticket(8, 900, "LCA", "SVO", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {ticket7, ticket6, ticket1, ticket3};
        Ticket[] actual = manager.findAll("SVO", "LCA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public  void shouldSortTicketIfSamePriceButOtherAirport(){

        Ticket ticket1 = new Ticket(1, 500, "SVO", "LCA", 4);
        Ticket ticket2 = new Ticket(2, 500, "VVO", "BCN", 2);
        Ticket ticket3 = new Ticket(3, 800, "SVO", "LCA", 6);
        Ticket ticket4 = new Ticket(4, 800, "JFC", "HAV", 9);
        Ticket ticket5 = new Ticket(5, 800, "FRA", "MUC", 1);
        Ticket ticket6 = new Ticket(6, 800, "SVO", "LCA", 3);
        Ticket ticket7 = new Ticket(7, 200, "SVO", "LCA", 5);
        Ticket ticket8 = new Ticket(8, 200, "LCA", "SVO", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {ticket7, ticket1, ticket3, ticket6};
        Ticket[] actual = manager.findAll("SVO", "LCA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public  void shouldNotSortTicketIfSwitchFromAndTo(){
        Ticket ticket1 = new Ticket(1, 500, "LCA", "SVO", 4);
        Ticket ticket2 = new Ticket(2, 300, "VVO", "BCN", 2);
        Ticket ticket3 = new Ticket(3, 500, "LCA", "SVO", 6);
        Ticket ticket4 = new Ticket(4, 400, "JFC", "HAV", 9);
        Ticket ticket5 = new Ticket(5, 600, "FRA", "MUC", 1);
        Ticket ticket6 = new Ticket(6, 500, "LCA", "SVO", 3);
        Ticket ticket7 = new Ticket(7, 500, "LCA", "SVO", 5);
        Ticket ticket8 = new Ticket(8, 900, "LCA", "SVO", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVO", "LCA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public  void shouldNotSortTicketIfSameFromButAnotherTo(){
        Ticket ticket1 = new Ticket(1, 500, "SVO", "Ufa", 4);
        Ticket ticket2 = new Ticket(2, 300, "VVO", "BCN", 2);
        Ticket ticket3 = new Ticket(3, 500, "SVO", "LED", 6);
        Ticket ticket4 = new Ticket(4, 400, "JFC", "HAV", 9);
        Ticket ticket5 = new Ticket(5, 600, "FRA", "MUC", 1);
        Ticket ticket6 = new Ticket(6, 500, "SVO", "FRU", 3);
        Ticket ticket7 = new Ticket(7, 500, "SVO", "FRA", 5);
        Ticket ticket8 = new Ticket(8, 900, "LCA", "SVO", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVO", "LCA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public  void shouldNotSortTicketIfSameToButAnotherFrom(){
        Ticket ticket1 = new Ticket(1, 500, "SVO", "Ufa", 4);
        Ticket ticket2 = new Ticket(2, 300, "VVO", "LCA", 2);
        Ticket ticket3 = new Ticket(3, 500, "SVO", "LED", 6);
        Ticket ticket4 = new Ticket(4, 400, "JFC", "LCA", 9);
        Ticket ticket5 = new Ticket(5, 600, "FRA", "LCA", 1);
        Ticket ticket6 = new Ticket(6, 500, "SVO", "FRU", 3);
        Ticket ticket7 = new Ticket(7, 500, "SVO", "FRA", 5);
        Ticket ticket8 = new Ticket(8, 900, "LCA", "SVO", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVO", "LCA");

        Assertions.assertArrayEquals(expected, actual);
    }




}