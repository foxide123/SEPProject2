package main.server.server;
//import org.apache.commons.dbutils.DbUtils;

import main.shared.model.*;

import java.sql.*;
import java.util.ArrayList;

public class Database{


    private static String dataUrl = "jdbc:postgresql://abul.db.elephantsql.com:5432/kxbpghuf";
    private static String dataPassword = "yn6B1EMc4s4pB9QgbbpCzH-tNxFxTSTF";
    private static String dataUser = "kxbpghuf";

    public Database() {

    }

    /*
    public void close(ResultSet rs, Statement statement, Connection connection) {
        if (rs != null) {
            DbUtils.closeQuietly(rs);
        }
        DbUtils.closeQuietly(statement);
        DbUtils.closeQuietly(connection);
    }

     */

    //updates job status, checks every 10 minutes

    public Handyman loginHandyman(int CVR, String password)
            throws Exception {
        Handyman tmpHandyman = new Handyman(0, null, null, null, null,null,null,0,null,null);
        String SQL = "SELECT * FROM handyman WHERE cvr=? AND password=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement( SQL );
            pstm.setInt(1, CVR);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, tmpHandyman);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }/* finally {
            close(rs, pstm, conn);
        }*/
        if (tmpHandyman.getCVR()==0) {
            throw new Exception("Account not found");
        } else
            return tmpHandyman;

    }


    public Client loginClient(int CPR, String password)
            throws Exception {
        Client tmpClient = new Client(0, null, null, null,null,null);

        String SQL = "SELECT * FROM client WHERE cpr=? AND password=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, CPR);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, tmpClient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            close(rs, pstm, conn);
        }*/
        if (tmpClient.getCPR() == 0) {
            throw new Exception("Account not found");
        } else
            return tmpClient;
    }

    public void createClientAccount(Client client,
                                      String password) throws Exception {
//        new Thread(() -> {
        System.out.println("Inside database - createClientAccount");

        String SQL =
                "INSERT INTO client(cpr,password,email,firstName,lastName,address,description)"

                        + "VALUES(?,?,?,?,?,?,?)";
        PreparedStatement posted = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setLong(1, client.getCPR());
            posted.setString(2, password);
            posted.setString(3, client.getEmail());
            posted.setString(4, client.getFirstName());
            posted.setString(5, client.getLastName());
            posted.setInt(6, insertAddress(client.getAddress()));
            posted.setString(7, client.getDescription());
            posted.executeUpdate();

        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                throw new Exception("Account already exists!");
        }

//        }).start();
    }

    public void createHandymanAccount(Handyman handyman, String password) throws Exception {
//        new Thread(() -> {

        String SQL =
                "INSERT INTO handyman(cvr,password,firstname,lastname,email,phone,description,address,hourlyRate, rating)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement posted = null;
        Connection conn = null;
        try {


            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setLong(1, handyman.getCVR());
            posted.setString(2, password);
            posted.setString(3, handyman.getFirstName());
            posted.setString(4, handyman.getLastName());
            posted.setString(5, handyman.getEmail());
            posted.setString(6, handyman.getPhone());
            posted.setString(7, handyman.getDescription());
            posted.setInt(8, insertAddress(handyman.getAddress()));
            posted.setInt(9, handyman.getHourlyRate());
            posted.setString(10, handyman.getRating());

            posted.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("duplicate key value"))
                throw new Exception("Account already exists!");
        }

//        }).start();
    }



    public void insertSkills(Handyman handyman) {

            String SQL =
                "INSERT INTO skills(CVR, skill)" + "VALUES(?,?)";
            PreparedStatement posted = null;
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
                posted = conn.prepareStatement(SQL);
                for(int i=0; i<handyman.getSkillsList().size(); i++)
                {
                    posted.setLong(1, handyman.getCVR());
                    posted.setString(2, handyman.getSkillsList().get(i));
                    posted.execute();
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }
    }


    public ArrayList<String> getSkills(long cvr) {

        Skills skills = new Skills(false,false,false,false);
        String SQL = "SELECT skill FROM skills WHERE cvr=?";
        ArrayList<String> skillsArrayList = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, cvr);
            rs = pstm.executeQuery();
            while (rs.next()) {
                skillsArrayList.add(rs.getString("skill"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        skills.setSkills(skillsArrayList);
        return skillsArrayList;
    }




    public int insertAddress(Address address) {
        //(!getAllAddress().contains(address))
        if (!getAllAddress().contains(address)) {
            String SQL =
                "INSERT INTO address(city,zip)" + "VALUES(?,?)";
            PreparedStatement posted = null;
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
                posted = conn.prepareStatement(SQL);
                posted.setString(1, address.getCity());
                posted.setString(2, address.getZip());
                posted.execute();

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return getAddressID(address);
    }

    private int getAddressID(Address address) {
        String SQL = "SELECT addressID from address WHERE  city=? AND zip=?"/*+"VALUES(?,?,?,?)"*/;
        int id = 0;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getZip());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("addressID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public Address getAddressByID(int id) {
        Address tmpAddress = new Address(null, null);
        String SQL = "SELECT * FROM address WHERE addressID=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, tmpAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpAddress;
    }

    public ArrayList<Address> getAllAddress() {
        ArrayList<Address> addresses = new ArrayList<>();
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            stmt = conn.createStatement();
            String SQL = "Select * FROM address";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Address tmpAddress = new Address(null, null);
                process(rs, tmpAddress);
                addresses.add(tmpAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int i=0; i<addresses.size(); i++){
            System.out.println(addresses.get(i).getCity() + addresses.get(i).getZip());
        }
        return addresses;
    }


    public void updateHandyman(Handyman handyman){
            Connection conn = null;
            /*
            * cvr,password,firstname,lastname,email,phone,
            * description,address,hourlyRate, rating*/
            String SQL = "UPDATE handyman SET "
                + "firstName=?"
                + "lastName=?"
                + "email=?"
                + "phone=?"
                + "description=?"
                + "address=?"
                + "hourlyRate=?"
                + "rating=?"
                + " WHERE cvr=?";
            PreparedStatement posted = null;
            try {
                conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
                posted = conn.prepareStatement(SQL);
                posted.setString(1, handyman.getFirstName());
                posted.setString(2, handyman.getLastName());
                posted.setString(3, handyman.getEmail());
                posted.setString(4, handyman.getPhone());
                posted.setString(5, handyman.getDescription());
                posted.setInt(6, insertAddress(handyman.getAddress()));
                posted.setInt(7, handyman.getHourlyRate());
                posted.setString(8, handyman.getRating());
                posted.setLong(9, handyman.getCVR());

                posted.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public ArrayList<Handyman> findHandyman(Address address, Skills skills, int hourlyRate){
            ArrayList<Handyman> tmpHandymanList = new ArrayList<>();


            String SQL = "SELECT * from handyman WHERE address=? AND  hourlyRate<=?";
            ResultSet rs = null;
            PreparedStatement preparedStatement = null;
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
                preparedStatement = conn.prepareStatement(SQL);
                preparedStatement.setInt(1, getAddressID(address));
                preparedStatement.setInt(2, hourlyRate);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Handyman tmpHandyman = new Handyman(0, null, null, null, null, null, null, 0, null, null);
                    process(rs, tmpHandyman);
                    tmpHandymanList.add(tmpHandyman);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return findHandymanWithSkills(tmpHandymanList,skills);
    }

    public ArrayList<Handyman> findHandymanWithSkills(ArrayList<Handyman> tmpHandymanList, Skills skills){
        ArrayList<Handyman> handymanList = new ArrayList<>();
        for(int i=0; i<tmpHandymanList.size(); i++){
            if(skills.equalsAtLeastOne(getSkills(tmpHandymanList.get(i).getCVR()))){
                handymanList.add(tmpHandymanList.get(i));
            }
            /*
            if(skills.equalsAtLeastOne(getSkills(tmpHandymanList.get(i).getCVR()))){
                handymanList.add(tmpHandymanList.get(i));
            }
             */
        }

        return handymanList;
    }


    public void updateClient(Client client){
        Connection conn = null;
        /*
         * cvr,password,firstname,lastname,email,phone,
         * description,address,hourlyRate, rating*/
        String SQL = "UPDATE client SET "
            + "firstName=?"
            + "lastName=?"
            + "email=?"
            + "description=?"
            + "address=?"
            + " WHERE cpr=?";
        PreparedStatement posted = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setString(1, client.getFirstName());
            posted.setString(2, client.getLastName());
            posted.setString(3, client.getEmail());
            posted.setString(4, client.getDescription());
            posted.setInt(5, insertAddress(client.getAddress()));
            posted.setLong(6, client.getCPR());

            posted.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteHandyman(int cvr){
        String SQL = "DELETE FROM handyman WHERE cvr=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, cvr);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createJob(JobOffer job) {
        Connection conn = null;
        String SQL =
            "INSERT INTO job_offer(jobTitle,description,budget,address)"
                + "VALUES(?,?,?,?)";
        PreparedStatement posted = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setString(1, job.getJobTitle());
            posted.setString(2, job.getJobDescription());
            posted.setString(3, job.getJobBudget());
            posted.setInt(4, insertAddress(job.getLocation()));
            posted.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private void process(ResultSet rs, Address address) throws SQLException {
        address.setCity(rs.getString("city"));
        address.setZip(rs.getString("zip"));

    }

    private void process(ResultSet rs, Handyman handyman) throws SQLException {
        handyman.setCVR(rs.getInt("cvr"));
        handyman.setFirstName(rs.getString("firstName"));
        handyman.setLastName(rs.getString("lastName"));
        handyman.setEmail(rs.getString("email"));
        handyman.setPhone(rs.getString("phone"));
        handyman.setDescription(rs.getString("description"));
        handyman.setAddress(getAddressByID(rs.getInt("address")));
        handyman.setHourlyRate(rs.getInt("hourlyRate"));
        handyman.setRating(rs.getString("rating"));
        handyman.setSkills(getSkills(rs.getInt("cvr")));
    }



    private void process(ResultSet rs, Client client) throws SQLException {
        client.setCPR(rs.getInt("cpr"));
        client.setEmail(rs.getString("email"));
        client.setFirstName(rs.getString("firstName"));
        client.setLastName(rs.getString("lastName"));
        client.setAddress(getAddressByID(rs.getInt("address")));
        client.setDescription(rs.getString("description"));
    }



}
