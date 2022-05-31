package main.server.server;
//import org.apache.commons.dbutils.DbUtils;

import main.shared.model.*;

import java.sql.*;
import java.util.ArrayList;

public class Database{


    private static String dataUrl = "jdbc:postgresql://abul.db.elephantsql.com:5432/kxbpghuf";
    private static String dataPassword = "yn6B1EMc4s4pB9QgbbpCzH-tNxFxTSTF";
    private static String dataUser = "kxbpghuf";

    private Connection conn;
    public Database()
    {
        try
        {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
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
        Handyman tmpHandyman = new Handyman(0, null, null, null, null,null,null,0,null,null, null);
        String SQL = "SELECT * FROM handyman WHERE cvr=? AND password=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Connection conn = null;
        try {
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement( SQL );
            pstm.setLong(1, CVR);
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
        //Connection conn = null;
        try {
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, CPR);
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
        //Connection conn = null;
        try {
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
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
                "INSERT INTO handyman(cvr,password,firstname,lastname,email,phone,description,address,hourlyRate, rating, contact)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement posted = null;
        //Connection conn = null;
        try {


            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
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
            posted.setString(11,handyman.getContactVisibility());

            posted.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("duplicate key value"))
                throw new Exception("Account already exists!");
        }

//        }).start();
    }


    public Handyman getHandyman(long CVR) throws Exception
    {
        Handyman tmpHandyman = new Handyman(0, null, null, null,null,null,null,0,null,null,null);

        String SQL = "SELECT * FROM handyman WHERE cvr=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Connection conn = null;
        try {
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, CVR);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, tmpHandyman);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            close(rs, pstm, conn);
        }*/
        if (tmpHandyman.getCVR() == 0) {
            throw new Exception("Account not found");
        } else
            return tmpHandyman;
    }

    public void insertSkills(Handyman handyman) {

            String SQL =
                "INSERT INTO skills(CVR, skill)" + "VALUES(?,?)";
            PreparedStatement posted = null;
            //Connection conn = null;
            try {
                //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
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


    public Skills getSkills(long cvr) {

        Skills skills = new Skills(false,false,false,false);
        String SQL = "SELECT skill FROM skills WHERE cvr=?";
        ArrayList<String> skillsArrayList = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Connection conn = null;
        try {
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, cvr);
            rs = pstm.executeQuery();

            while (rs.next()) {
                process(rs, skills);
            }
            /*
            while (rs.next()) {
                skillsArrayList.add(rs.getString("skill"));
            }

             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }




    public int insertAddress(Address address) {
        if (!getAllAddress().contains(address)) {
            String SQL =
                "INSERT INTO address(city,zip)" + "VALUES(?,?)";
            PreparedStatement posted = null;
            //Connection conn = null;
            try {
               // conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
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

    public int getAddressID(Address address) {
        String SQL = "SELECT addressid from address WHERE  city=? AND zip=?"/*+"VALUES(?,?,?,?)"*/;
        int id = 0;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        try {
           // conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getZip());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("addressid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public Address getAddressByID(int id) {
        Address tmpAddress = new Address(null, null);
        String SQL = "SELECT * FROM address WHERE addressid=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Connection conn = null;
        try {
          //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
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
        //Connection conn = null;
        try {
          //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
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
        return addresses;
    }


    public void updateHandyman(Handyman handyman, String password){
        if(password.isEmpty())
        {
            String SQL = "UPDATE handyman SET firstName=?, lastName=?, email=?, phone=?, description=?, address=?, hourlyRate=?, rating=?, contact=? WHERE cvr=?";
            PreparedStatement posted = null;
            try {
                //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
                posted = conn.prepareStatement(SQL);
                posted.setString(1, handyman.getFirstName());
                posted.setString(2, handyman.getLastName());
                posted.setString(3, handyman.getEmail());
                posted.setString(4, handyman.getPhone());
                posted.setString(5, handyman.getDescription());
                posted.setInt(6, insertAddress(handyman.getAddress()));
                posted.setInt(7, handyman.getHourlyRate());
                posted.setString(8, handyman.getRating());
                posted.setString(9,handyman.getContactVisibility());
                posted.setLong(10, handyman.getCVR());

                posted.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            String SQL = "UPDATE handyman SET firstName=?, lastName=?, email=?, phone=?, description=?, address=?, hourlyRate=?, rating=?, contact=?, password=? WHERE cvr=?";
            PreparedStatement posted = null;
            try {
                //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
                posted = conn.prepareStatement(SQL);
                posted.setString(1, handyman.getFirstName());
                posted.setString(2, handyman.getLastName());
                posted.setString(3, handyman.getEmail());
                posted.setString(4, handyman.getPhone());
                posted.setString(5, handyman.getDescription());
                posted.setInt(6, insertAddress(handyman.getAddress()));
                posted.setInt(7, handyman.getHourlyRate());
                posted.setString(8, handyman.getRating());
                posted.setString(9,handyman.getContactVisibility());
                posted.setString(10, password);
                posted.setLong(11, handyman.getCVR());

                posted.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public ArrayList<Handyman> findHandyman(Address address, Skills skills, int hourlyRate){
            ArrayList<Handyman> tmpHandymanList = new ArrayList<>();
            System.out.println("a");

            String SQL = "SELECT * from handyman WHERE address=? AND  hourlyRate<=?";
            ResultSet rs = null;
            PreparedStatement preparedStatement = null;
            //Connection conn = null;
            try {
              //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
                preparedStatement = conn.prepareStatement(SQL);
                preparedStatement.setInt(1, getAddressID(address));
                preparedStatement.setInt(2, hourlyRate);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Handyman tmpHandyman = new Handyman(0, null, null, null, null, null, null, 0, null, null, null);
                    process(rs, tmpHandyman);
                    tmpHandymanList.add(tmpHandyman);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return findHandymanWithSkills(tmpHandymanList,skills);
    }

    public ArrayList<Handyman> findAllHandyman(){
        ArrayList<Handyman> tmpHandymanList = new ArrayList<>();
        ArrayList<Handyman> AllHandymanList = new ArrayList<>();
        //String SQL = "SELECT handyman.cvr, client.cpr from handyman, client";
        //System.out.println("a");
        String SQL = "SELECT * from handyman";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        //System.out.println("a2");
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Handyman tmpHandyman = new Handyman(0, null, null, null, null, null, null, 0, null, null, null);
                process(rs, tmpHandyman);
                tmpHandymanList.add(tmpHandyman);
            }
            for(int i=0; i<tmpHandymanList.size(); i++)
            {
                AllHandymanList.add(tmpHandymanList.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AllHandymanList;
    }

    public ArrayList<Client> findAllClient(){
        ArrayList<Client> tmpClientList = new ArrayList<>();
        ArrayList<Client> AllClientList = new ArrayList<>();
        //String SQL = "SELECT handyman.cvr, client.cpr from handyman, client";
        System.out.println("a");
        String SQL = "SELECT * from client";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        //System.out.println("a2");
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Client tmpClient = new Client(0, null, null, null, null, null);
                process(rs, tmpClient);
                tmpClientList.add(tmpClient);
            }
            for(int i=0; i<tmpClientList.size(); i++)
            {
                AllClientList.add(tmpClientList.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AllClientList;
    }


    public Handyman findHandymanWithCVR(long CVR){
        Handyman tmpHandyman = new Handyman(0, null, null, null, null, null, null, 0, null, null, null);
        String SQL = "SELECT * from handyman WHERE cvr=?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setLong(1, CVR);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                process(rs, tmpHandyman);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpHandyman;
    }

    public ArrayList<Handyman> findHandymanWithSkills(ArrayList<Handyman> tmpHandymanList, Skills skills){
        ArrayList<Handyman> handymanList = new ArrayList<>();
        for(int i=0; i<tmpHandymanList.size(); i++){
            if(Skills.containsAny(getSkills(tmpHandymanList.get(i).getCVR()).getSkills(), skills.getSkills())){
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


    public void updateClient(Client client, String password){

        if(password.isEmpty()){
            String SQL = "UPDATE client SET firstname=?, lastname=?, email=?, description=?, address=? WHERE cpr=?";
            PreparedStatement posted = null;
            try {
                //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
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
        }else{
            String SQL = "UPDATE client SET firstname=?, lastname=?, email=?, description=?, address=?, password=? WHERE cpr=?";
            PreparedStatement posted = null;
            try {
                //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
                posted = conn.prepareStatement(SQL);
                posted.setString(1, client.getFirstName());
                posted.setString(2, client.getLastName());
                posted.setString(3, client.getEmail());
                posted.setString(4, client.getDescription());
                posted.setInt(5, insertAddress(client.getAddress()));
                posted.setString(6, password);
                posted.setLong(7, client.getCPR());

                posted.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public void deleteAccount(String ID){
        String SQL = "DELETE FROM skills WHERE cvr=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Connection conn = null;
        try {
            System.out.println("database check for cvr " + ID);
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, Long.parseLong(ID));
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL = "DELETE FROM handyman WHERE cvr=?";
        rs = null;
        pstm = null;
        //Connection conn = null;
        try {
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, Long.parseLong(ID));
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQL = "DELETE FROM client WHERE cpr=?";
        rs = null;
        pstm = null;
        //Connection conn = null;
        try {
            System.out.println("database check for cvr " + ID);
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, Long.parseLong(ID));
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createJob(JobOffer job) {
        //Connection conn = null;
        String SQL =
            "INSERT INTO job_offer(jobTitle,description,budget,address,cpr)"
                + "VALUES(?,?,?,?,?)";
        PreparedStatement posted = null;
        try {
          //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setString(1, job.getJobTitle());
            posted.setString(2, job.getJobDescription());
            posted.setInt(3, job.getJobBudget());
            posted.setInt(4, insertAddress(job.getLocation()));
            //posted.setInt(4, 14);
            posted.setLong(5, job.getCpr());
            //adress is equal to 0
            posted.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addApplied(JobOffer jobOffer, long cvr){
        //Connection conn = null;
        String SQL =
            "INSERT INTO apply(jobtitle, cvr)"
                + "VALUES(?,?)";
        PreparedStatement posted = null;
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setString(1, jobOffer.getJobTitle());
            posted.setLong(2, cvr);
            posted.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<JobOffer> getAppliedJobs(long CVR) throws Exception{
        ArrayList<String> tmpJobOfferTitleList = new ArrayList<>();
        ArrayList<JobOffer> tmpJobOfferList = new ArrayList<>();

        String SQL = "SELECT jobtitle from apply WHERE cvr=?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setLong(1, CVR);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                tmpJobOfferTitleList.add(rs.getString("jobtitle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0; i<tmpJobOfferTitleList.size(); i++){
            tmpJobOfferList.add(getJobOfferFromTitle(tmpJobOfferTitleList.get(i)));
        }
        return tmpJobOfferList;
    }

    public void handymanDeleteApplied(String jobTitle, long CVR){
        String SQL = "DELETE FROM apply WHERE cvr=? AND jobtitle=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Connection conn = null;
        try {
            //conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, CVR);
            pstm.setString(2,jobTitle);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public JobOffer getJobOfferFromTitle(String jobTitle){
        JobOffer tmpJobOffer = new JobOffer(null, null, 0, null, 0, null);
        String SQL = "SELECT * from job_offer WHERE jobtitle=?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, jobTitle);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                process(rs, tmpJobOffer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpJobOffer;
    }


    public ArrayList<Handyman> getAppliedHandyman(String jobTitle) throws Exception
    {
        ArrayList<Handyman> tmpHandymanList = new ArrayList<>();

        long CVR = 0;

        String SQL = "SELECT * from apply WHERE jobtitle=?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, jobTitle);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CVR = rs.getLong("cvr");
                tmpHandymanList.add(getHandyman(CVR));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpHandymanList;
    }

    public ArrayList<JobOffer> clientManageOffers(long cpr){
        ArrayList<JobOffer> jobOffers = new ArrayList<>();
        String SQL = "Select * FROM job_offer WHERE cpr=?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setLong(1, cpr);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                JobOffer tmpJobOffer = new JobOffer(null, null,0,null,0,null);
                process(rs, tmpJobOffer);
                jobOffers.add(tmpJobOffer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobOffers;
    }

    public void insertJobType(JobOffer job){
        //Connection conn = null;
        String SQL =
            "INSERT INTO category(jobTitle, category)"
                + "VALUES(?,?)";
        PreparedStatement posted = null;
        try {
          //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);

           for(int i=0; i<job.getJobTypeList().size(); i++)
           {
                posted.setString(1, job.getJobTitle());
                posted.setString(2, job.getJobTypeList().get(i));
                posted.executeUpdate();
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public ArrayList<JobOffer> findWork(Address address, JobType type, int minBudget)
    {
        ArrayList<JobOffer> jobOffers = new ArrayList<>();
        String SQL = "SELECT * FROM job_offer WHERE  budget>=? AND address=?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        //Connection conn = null;
        try {
            // conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1, minBudget);
            preparedStatement.setInt(2, getAddressID(address));
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                JobOffer tmpJobOffer = new JobOffer(null, null, 0,null,0,null);
                process(rs, tmpJobOffer);
                jobOffers.add(tmpJobOffer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findWorkType(jobOffers, type);
    }

    public ArrayList<JobOffer> findWorkType(ArrayList<JobOffer> jobOffers, JobType type){
        ArrayList<JobOffer> tmpList = new ArrayList<>();
        for(int i=0; i<jobOffers.size(); i++){
            if(JobType.containsAny(jobOffers.get(i).getJobTypeList(), type.getJobTypes())){
                tmpList.add(jobOffers.get(i));
            }
        }
        return tmpList;
    }

    public JobType getJobType(String jobTitle){
        JobType jobType = new JobType(false, false, false, false);

        String SQL = "SELECT category FROM category WHERE jobtitle=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Connection conn = null;
        try {
            //  conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, jobTitle);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, jobType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobType;
    }


    private void process(ResultSet rs, Address address) throws SQLException {
        address.setCity(rs.getString("city"));
        address.setZip(rs.getString("zip"));

    }

    private void process(ResultSet rs, Skills skills) throws SQLException {
        if(rs.getString("skill").equals("plumber")){
            skills.setPlumber(true);
        }
        if(rs.getString("skill").equals("electrician")){
            skills.setElectrician(true);
        }
        if(rs.getString("skill").equals("mason")){
            skills.setMason(true);
        }
        if(rs.getString("skill").equals("groundworker")){
            skills.setGroundWorker(true);
        }

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
        handyman.setSkills(getSkills(rs.getLong("cvr")));
        handyman.setContactVisibility(rs.getString("contact"));
    }



    private void process(ResultSet rs, Client client) throws SQLException {
        client.setCPR(rs.getInt("cpr"));
        client.setEmail(rs.getString("email"));
        client.setFirstName(rs.getString("firstName"));
        client.setLastName(rs.getString("lastName"));
        client.setAddress(getAddressByID(rs.getInt("address")));
        client.setDescription(rs.getString("description"));
    }


    private void process(ResultSet rs, JobOffer jobOffer) throws SQLException {
        jobOffer.setJobTitle(rs.getString("jobTitle"));
        jobOffer.setJobDescription(rs.getString("description"));
        jobOffer.setJobBudget(rs.getInt("budget"));
        jobOffer.setLocation(getAddressByID(rs.getInt("address")));
        jobOffer.setCpr(rs.getLong("cpr"));
        jobOffer.setJobType(getJobType(rs.getString("jobTitle")));
    }

    private void process(ResultSet rs, JobType jobType) throws SQLException {
       if(rs.getString("category").equals("plumbing")){
           jobType.setPlumbing(true);
       }
        if(rs.getString("category").equals("electrical")){
            jobType.setElectrical(true);
        }
        if(rs.getString("category").equals("masonry")){
            jobType.setMasonry(true);
        }
        if(rs.getString("category").equals("groundworking")){
            jobType.setGroundWorking(true);
        }
    }
}
