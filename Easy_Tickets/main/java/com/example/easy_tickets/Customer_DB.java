package com.example.easy_tickets;


import android.content.Context;
import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class Customer_DB implements CustomerDB {
    private Connection connection = null;

    @Override
    public int SignUp(Customer obj, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        if (connection != null) {
            CallableStatement cs = null;
            CallableStatement cstmt = connection.prepareCall("{call Customer_SignUp(?, ? ,? ,?, ?)}");
            cstmt.setString(1, obj.getEmail());
            cstmt.setString(2, obj.getPassword());
            cstmt.setString(3, obj.getFirst_name());
            cstmt.setString(4, obj.getLast_name());
            cstmt.registerOutParameter(5, Types.INTEGER);
            cstmt.executeUpdate();
            int result = cstmt.getInt(5);
            String str = String.valueOf(result);
            return result;
        } else {
            Log.i("hhhhh", "lllll");
        }
        return 0;
    }

    @Override
    public int Login(String email, String password, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        if (connection != null) {
            CallableStatement cs = null;
            CallableStatement cstmt = connection.prepareCall("{call Customer_LOGIN(?, ? ,?)}");
            cstmt.setString(1, email);
            cstmt.setString(2, password);
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.executeUpdate();
            int result = cstmt.getInt(3);
            String str = String.valueOf(result);
            return result;
        } else {

        }
        return 0;
    }

    @Override
    public int AdminLogin(String email, String password, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        if (connection != null) {
            Log.i("hhh","jjjj");
            CallableStatement cs = null;
            CallableStatement cstmt = connection.prepareCall("{call ADMIN_LOGIN(?, ? ,?)}");
            cstmt.setString(1, email);
            cstmt.setString(2, password);
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.executeUpdate();
            int result = cstmt.getInt(3);
            String str = String.valueOf(result);
            return result;
        } else {

        }
        return 0;
    }

    @Override
    public Customer GetProfile(String email, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        if (connection != null) {

            CallableStatement cstmt = connection.prepareCall("{call Get_Customer_profile(?, ? ,?,?, ? ,?,?)}");
            cstmt.setString(1, email);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.VARCHAR);
            cstmt.registerOutParameter(4, Types.VARCHAR);
            cstmt.registerOutParameter(5, Types.VARCHAR);
            cstmt.registerOutParameter(6, Types.INTEGER);
            cstmt.registerOutParameter(7, Types.INTEGER);
            cstmt.executeUpdate();
            String Password = cstmt.getString(2);
            String name = cstmt.getString(3);
            String phone = cstmt.getString(4);
            String address = cstmt.getString(5);
            int balance = cstmt.getInt(6);
            int result = cstmt.getInt(7);
            Customer obj = new Customer(name, email, Password, phone, address, balance);
            return obj;
        }
        return null;
    }

    @Override
    public int UpdateProfile(Customer obj, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        if (connection != null) {
            CallableStatement cs = null;
            CallableStatement cstmt = connection.prepareCall("{call UPDATE_Customer_Profile(?, ? ,?,?, ? ,?,?)}");
            cstmt.setString(1, obj.getEmail());
            cstmt.setString(2, obj.getPassword());
            cstmt.setString(3, obj.getName());
            cstmt.setString(4, obj.getPhone());
            cstmt.setInt(5, obj.getBalance());
            cstmt.setString(6, obj.getAddress());
            cstmt.registerOutParameter(7, Types.INTEGER);
            cstmt.executeUpdate();
            int result = cstmt.getInt(7);
            String str = String.valueOf(result);
            return result;
        } else {

        }
        return 0;
    }

    @Override
    public Customer GetAdminProfile(String email, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        if (connection != null) {

            CallableStatement cstmt = connection.prepareCall("{call Get_Admin_profile(?, ? ,?,?, ? ,?,?)}");
            cstmt.setString(1, email);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.VARCHAR);
            cstmt.registerOutParameter(4, Types.VARCHAR);
            cstmt.registerOutParameter(5, Types.VARCHAR);
            cstmt.registerOutParameter(6, Types.INTEGER);
            cstmt.registerOutParameter(7, Types.INTEGER);
            cstmt.executeUpdate();
            String Password = cstmt.getString(2);
            String name = cstmt.getString(3);
            String phone = cstmt.getString(4);
            String address = cstmt.getString(5);
            int balance = cstmt.getInt(6);
            int result = cstmt.getInt(7);
            Customer obj = new Customer(name, email, Password, phone, address, balance);
            return obj;
        }
        return null;
    }

    @Override
    public int UpdateAdminProfile(Customer obj, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        if (connection != null) {
            CallableStatement cs = null;
            CallableStatement cstmt = connection.prepareCall("{call UPDATE_Admin_Profile(?, ? ,?,?, ? ,?)}");
            cstmt.setString(1, obj.getEmail());
            cstmt.setString(2, obj.getPassword());
            cstmt.setString(3, obj.getName());
            cstmt.setString(4, obj.getPhone());
            cstmt.setString(5, obj.getAddress());
            cstmt.registerOutParameter(6, Types.INTEGER);
            cstmt.executeUpdate();
            int result = cstmt.getInt(6);
            String str = String.valueOf(result);
            return result;
        } else {

        }
        return 0;
    }



    @Override
    public ArrayList<Agency> GetAgencies(Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        ArrayList<Agency> arr = new ArrayList<>();
        ;
        if (connection != null) {
            String query = "SELECT * from Agency";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("Agency_id");
                    String name = rs.getString("Agencie_name");
                    String email = rs.getString("email");
                    String password = rs.getString("Password");
                    String address = rs.getString("Address");
                    String status = rs.getString("Status");
                    String helpline = rs.getString("Helpline");
                    Agency obj = new Agency(id, name, email, password, address, status, helpline);
                    arr.add(obj);
                }
                return arr;
            } catch (SQLException e) {

            }
            return arr;
        }
        return null;
    }

    @Override
    public ArrayList<BusTripItem> GetBusTrips(Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        ArrayList<BusTripItem> arr = new ArrayList<>();
        if (connection != null) {
            String query = "SELECT * from Bus_Trip";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Log.i("hhh","jjj");
                    int id = rs.getInt("B_Trip_id");
                    String source = rs.getString("starting_location");
                    String dest = rs.getString("destiantion");
                    String departure_time = rs.getString("Departure_time");
                    String Arrival_time = rs.getString("Arrival_time");
                    String date = rs.getString("Trip_Date");
                    int fare = rs.getInt("Fare");
                    int total_seats = rs.getInt("Total_seats");
                    int Seats_Occupied = rs.getInt("Seats_Occupied");
                    String class_status = rs.getString("Class_status");
                    int bus_id = rs.getInt("Bus_id");
                    BusTripItem obj = new BusTripItem(id, source, dest, date, departure_time, Arrival_time, fare, total_seats, bus_id);
                    arr.add(obj);
                }
                return arr;
            } catch (SQLException e) {

            }
            return arr;
        }
        return arr;
    }

    @Override
    public ArrayList<BusItem> GetBus(Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        ArrayList<BusItem> arr = new ArrayList<>();
        ;
        if (connection != null) {
            String query = "SELECT * from Bus";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("Bus_id");
                    String reg_no = rs.getString("Reg_No");
                    int Agency_id = rs.getInt("Agency_id");
                    BusItem obj = new BusItem(id, reg_no, Agency_id);
                    arr.add(obj);
                }
                return arr;
            } catch (SQLException e) {

            }

        }
        return arr;
    }

    @Override
    public int GetCustid(String email, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        CallableStatement cs = null;
        CallableStatement cstmt = connection.prepareCall("{call GetCustId(?, ? ,?)}");
        cstmt.setString(1, email);
        cstmt.registerOutParameter(2, Types.INTEGER);
        cstmt.registerOutParameter(3, Types.INTEGER);
        cstmt.executeUpdate();
        int id = cstmt.getInt(2);
        return id;
    }

    @Override
    public int BookBusTrip(int Custid, int B_trip_id, int seats, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        CallableStatement cs = null;
        CallableStatement cstmt = connection.prepareCall("{call Book_Bus_Ticket(?, ? ,?,?)}");
        cstmt.setInt(1, B_trip_id);
        cstmt.setInt(2, Custid);
        cstmt.setInt(3, seats);
        cstmt.registerOutParameter(4, Types.INTEGER);
        cstmt.executeUpdate();
        int result = cstmt.getInt(4);
        return result;
    }


    @Override
    public ArrayList<TrainTripItem> GetTrainTrips(Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        ArrayList<TrainTripItem> arr = new ArrayList<>();
        if (connection != null) {
            String query = "SELECT * from Bus_trip";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("T_Trip_id");
                    String source = rs.getString("starting_location");
                    String dest = rs.getString("destiantion");
                    String departure_time = rs.getString("Departure_time");
                    String Arrival_time = rs.getString("Arrival_time");
                    String date = rs.getString("Trip_Date");
                    int fare = rs.getInt("Fare");
                    int total_seats = rs.getInt("Total_seats");
                    int Seats_Occupied = rs.getInt("Seats_Occupied");
                    String class_status = rs.getString("Class_status");
                    int bus_id = rs.getInt("Bus_id");
                    TrainTripItem obj = new TrainTripItem(id, source, dest, date, departure_time, Arrival_time, fare, total_seats, bus_id);
                    arr.add(obj);
                }
                return arr;
            } catch (SQLException e) {

            }
            return arr;
        }
        return arr;

    }

    @Override
    public ArrayList<TrainItem> GetTrain(Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        ArrayList<TrainItem> arr = new ArrayList<>();
        ;
        if (connection != null) {
            String query = "SELECT * from Train";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("Train_id");
                    String reg_no = rs.getString("Reg_No");
                    int Agency_id = rs.getInt("Agency_id");
                    TrainItem obj = new TrainItem(id, reg_no, Agency_id);
                    arr.add(obj);
                }
                return arr;
            } catch (SQLException e) {

            }
        }
        return arr;
    }

    @Override
    public int BookTrainTrip(int Custid, int B_trip_id, int seats, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        CallableStatement cs = null;
        CallableStatement cstmt = connection.prepareCall("{call Book_Train_Ticket(?, ? ,?,?)}");
        cstmt.setInt(1, B_trip_id);
        cstmt.setInt(2, Custid);
        cstmt.setInt(3, seats);
        cstmt.registerOutParameter(4, Types.INTEGER);
        cstmt.executeUpdate();
        int result = cstmt.getInt(4);
        return result;
    }

    @Override
    public ArrayList<BusTicketItem> GetBusTicket(Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        ArrayList<BusTicketItem> arr = new ArrayList<>();
        ;
        if (connection != null) {
            String query = "SELECT * from Bus_Ticket";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int ticket_id = rs.getInt("Bus_Ticket_id");
                    int trip_id = rs.getInt("Trip_id");
                    int Cust_id = rs.getInt("Cust_id");
                    int seats= rs.getInt("Seats");
                    String date_time = rs.getString("Date_Time");
                    int total_fair = rs.getInt("total_fair");
                    String status = rs.getString("status");
                    BusTicketItem obj = new BusTicketItem(trip_id,Cust_id,ticket_id,date_time,status,seats,total_fair);
                    arr.add(obj);
                }
                return arr;
            } catch (SQLException e) {

            }
        }
        return arr;
    }
    @Override
    public int CancelBookTrip(int Custid, int B_trip_id,int ticketid, Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        CallableStatement cs = null;
        CallableStatement cstmt = connection.prepareCall("{call Cancel_Bus_Ticket(?, ? ,?,?)}");
        cstmt.setInt(1, B_trip_id);
        cstmt.setInt(2, Custid);
        cstmt.setInt(3, ticketid);
        cstmt.registerOutParameter(4, Types.INTEGER);
        cstmt.executeUpdate();
        int result = cstmt.getInt(4);
        return result;
    }
    @Override
    public ArrayList<CustomerProfile_ItemA> GetCustomers(Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        ArrayList<CustomerProfile_ItemA> arr = new ArrayList<>();
        ;
        if (connection != null) {
            String query = "SELECT * from Customer";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("Cust_id");
                    String email = rs.getString("email");
                    String password = rs.getString("Password");
                    String name = rs.getString("First_Name");
                    String address = rs.getString("Address");
                    String helpline = rs.getString("Phone");
                    CustomerProfile_ItemA obj = new CustomerProfile_ItemA(R.drawable.ic_baseline_person_24,name,email,helpline);
                    arr.add(obj);
                }
                return arr;
            } catch (SQLException e) {

            }
            return arr;
        }
        return null;
    }

    @Override
    public ArrayList<AgencyProfile_ItemA> GetAgencies1(Context c) throws SQLException {
        DB_Connection db = new DB_Connection(c);
        db.makeconnection();
        connection = DB_Connection.connection;
        ArrayList<AgencyProfile_ItemA> arr = new ArrayList<>();
        ;
        if (connection != null) {
            String query = "SELECT * from Agency";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("Agency_id");
                    String name = rs.getString("Agencie_name");
                    String email = rs.getString("email");
                    String password = rs.getString("Password");
                    String address = rs.getString("Address");
                    String status = rs.getString("Status");
                    String helpline = rs.getString("Helpline");
                    AgencyProfile_ItemA obj = new AgencyProfile_ItemA(R.drawable.ic_baseline_bus_alert_24,name,email,helpline);
                    arr.add(obj);
                }
                return arr;
            } catch (SQLException e) {

            }
            return arr;
        }
        return null;
    }
}



