package com.fundmaster.mss.common;

import com.fundmaster.mss.beans.ejbInterface.ActivityLogEJB;
import com.fundmaster.mss.dao.*;
import com.fundmaster.mss.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.net.ssl.HttpsURLConnection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
@Stateless
public class Helper {

    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final int TIMEOUT = 300 * 1000;
    private static final String ROWS = "rows";
    private static final String BOTH = "BOTH";
    private static final String MSS = "PORTAL";
    private static final String XI = "FUNDMASTER";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String HTTP_POST = "POST";
    private static final String MESSAGE = "message";
    private static final String SUCCESS = "success";
    private static final String HTTP_GET = "GET";
    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";
    private static final String HTTPS = "https";
    /**
     *
     */
    private final LOGGER logger = new LOGGER(this.getClass());
    public static final long serialVersionUID = 1L;

    public long toLong(Object o)
    {
        return Long.valueOf(o.toString());
    }


    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;
    public Date dateFromString(String date, String ft)
    {

        DateFormat format = new SimpleDateFormat(ft, Locale.ENGLISH);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return null;
        }
    }
    public boolean isEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    public List<ProfileName> getProfileNames()
    {
        ProfileNameDAO dao = new ProfileNameDAO(entityManager);
        return dao.findAll();
    }
    public void logAttempt(String username)
    {
        UserDAO dao = new UserDAO(entityManager);
        User u = dao.findByUsername(username);
        PasswordPolicy policy = getPasswordPolicy();
        if(u != null)
        {
            u.setAttempt(u.getAttempt() + 1);
            if(u.getAttempt() >= policy.getLock_after_count_of())
            {
                u.setStatus(false);
            }
            dao.merge(u);
        }
    }
    public Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return new Date(cal.getTime().getTime());
    }
    public void resetAttempt(String username)
    {
        UserDAO dao = new UserDAO(entityManager);
        User u = dao.findByUsername(username);
        if(u != null)
        {
            u.setAttempt(0);
        }
        dao.merge(u);
    }
    public PasswordPolicy getPasswordPolicy()
    {
        PasswordPolicyDAO dao = new PasswordPolicyDAO(entityManager);
        List<PasswordPolicy> policies = dao.findAll();
        if(policies != null && policies.size() > 0)
            return policies.get(0);
        else
            return null;
    }
    public String encrypt(String string)
    {
        try {
            Crypta crypt = new Crypta();
            string = crypt.encrypt(string);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return string;
    }
    public List<Member> getPortalMembers(String agentId, String search, int start, int count)
    {
        MemberDAO dao = new MemberDAO(entityManager);
        return dao.findAll(agentId, search, start, count);
    }
    public List<Sponsor> getPortalSponsors(String agentId, String search, int start, int count)
    {
        SponsorDAO dao = new SponsorDAO(entityManager);
        return dao.findAll(agentId, search, start, count);
    }

    public int countPortalMembers(String search)
    {
        MemberDAO dao = new MemberDAO(entityManager);
        return dao.countAll(search);
    }
    public int countSponsors(String search)
    {
        SponsorDAO dao = new SponsorDAO(entityManager);
        return dao.countAll(search);
    }
    private String decrypt(String string)
    {
        try {
            Crypta crypt = new Crypta();
            string = crypt.decrypt(string);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return string;
    }

    public void audit(HttpSession session, String description)
    {
        logAuditTrail(session.getAttribute(Constants.USER).toString(), session.getAttribute(Constants.U_PROFILE).toString(), description);
    }
    private boolean isHttps(String link)
    {
        return link.trim().substring(0, Math.min(link.length(), 5)).equalsIgnoreCase(Helper.HTTPS);
    }
	/* GET Request to URL */

    private JSONObject URLGet(String link) throws JSONException {

        JSONObject json;
        logger.i("Getting...\n Network link: " + link);
        if(isHttps(link))
            json = HttpsGet(link);
        else
            json = HttpGet(link);
        logger.i("Response: \n" + json);
        return json;
    }

    private JSONObject HttpsGet(String link) throws JSONException
    {
        Setting settings = getSettings();
        StringBuilder sb = new StringBuilder();
        HttpsURLConnection httpConn;
        InputStreamReader in = null;
        JSONObject json;
        try {
            URL url = new URL(link);
            httpConn = (HttpsURLConnection) url.openConnection();
            if (httpConn != null)
            {
                httpConn.setRequestMethod(Helper.HTTP_GET);
                httpConn.setReadTimeout(Helper.TIMEOUT);
                httpConn.setRequestProperty(Helper.USERNAME, settings.getUsername());
                httpConn.setRequestProperty(Helper.PASSWORD, settings.getPassword());
            }
            if (httpConn != null && httpConn.getInputStream() != null) {
                try {
                    in = new InputStreamReader(httpConn.getInputStream(),
                            Charset.defaultCharset());
                    BufferedReader bufferedReader = new BufferedReader(in);
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                } catch (Exception ex)
                {
                    json = new JSONObject();
                    json.put(Helper.SUCCESS, false);
                    json.put(Helper.MESSAGE, "An error was encountered fetching the data from the url. " + ex.getMessage());
                    return json;
                }
            }
            in.close();
        } catch (Exception e) {
            json = new JSONObject();
            json.put(Helper.SUCCESS, false);
            json.put(Helper.MESSAGE, "An error was encountered fetching the data from the url2. " + e.getMessage());
            return json;
        }
        String return_sting = sb.toString().trim().replace("\\", "");

        try {
            json = new JSONObject(return_sting);
        } catch (JSONException e) {
            json = new JSONObject();
            try {
                json.put(Helper.SUCCESS, false);
            } catch (JSONException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            try {
                json.put(Helper.MESSAGE, return_sting);
            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return json;
        }
        return json;
    }
    private JSONObject HttpGet(String link) throws JSONException
    {
        Setting settings = getSettings();
        StringBuilder sb = new StringBuilder();
        HttpURLConnection httpConn;
        InputStreamReader in = null;
        JSONObject json;
        try {
            URL url = new URL(link);
            httpConn = (HttpURLConnection) url.openConnection();
            if (httpConn != null)
            {
                httpConn.setRequestMethod(Helper.HTTP_GET);
                httpConn.setReadTimeout(Helper.TIMEOUT);
                httpConn.setRequestProperty(Helper.USERNAME, settings.getUsername());
                httpConn.setRequestProperty(Helper.PASSWORD, settings.getPassword());
            }
            if (httpConn != null && httpConn.getInputStream() != null) {
                try {
                    in = new InputStreamReader(httpConn.getInputStream(),
                            Charset.defaultCharset());
                    BufferedReader bufferedReader = new BufferedReader(in);
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                } catch (Exception ex)
                {
                    json = new JSONObject();
                    json.put(Helper.SUCCESS, false);
                    json.put(Helper.MESSAGE, "An error was encountered fetching the data from the url. " + ex.getMessage());
                    return json;
                }
            }
            in.close();
        } catch (Exception e) {
            json = new JSONObject();
            json.put(Helper.SUCCESS, false);
            json.put(Helper.MESSAGE, "An error was encountered fetching the data from the url2. " + e.getMessage());
            return json;
        }
        String return_sting = sb.toString().trim().replace("\\", "");

        try {
            json = new JSONObject(return_sting);
        } catch (JSONException e) {
            json = new JSONObject();
            try {
                json.put(Helper.SUCCESS, false);
            } catch (JSONException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            try {
                json.put(Helper.MESSAGE, return_sting);
            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return json;
        }
        return json;
    }
    public List<User> findByStatus()
    {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findByStatus();
    }
    private void logAuditTrail(String username, String profile, String description)
    {
        AuditTrailDAO dao = new AuditTrailDAO(entityManager);
        AuditTrail at = new AuditTrail();
        at.setDescription(description);
        at.setProfile(profile);
        at.setUsername(username);
        dao.merge(at);
    }

    public Permission getPermissions(String profile)
    {
        return new PermissionDAO(entityManager).findByProfile(profile);
    }

    public List<SchemeMemberManager> getSchemeManagers()
    {
        SchemeMemberManagerDAO dao = new SchemeMemberManagerDAO(entityManager);
        return dao.findAll();
    }

    public String frontPageAccessByPage() throws JSONException
    {
        ActivityLogDAO alDAO = new ActivityLogDAO(entityManager);
        List<PieObject> poList = alDAO.findByFrontPageAccess();
        JSONObject access_list = new JSONObject().put(Helper.SUCCESS, true);
        for (PieObject aPoList : poList) {
            access_list.put(aPoList.getName(), aPoList.getCount());
        }
        return access_list.toString();
    }

    public String profileAccess() throws JSONException
    {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        List<PieObject> poList = dao.findAccessByProfile();
        JSONObject access_list = new JSONObject().put(Helper.SUCCESS, true);
        for (PieObject aPoList : poList) {
            access_list.put(aPoList.getName(), aPoList.getCount());
        }
        return access_list.toString();
    }
    public String mostAccessedByMembers() throws JSONException
    {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        List<PieObject> poList = dao.mostAccessedByMembers();
        JSONObject access_list = new JSONObject().put(Helper.SUCCESS, true);
        for (PieObject aPoList : poList) {
            access_list.put(aPoList.getName(), aPoList.getCount());
        }
        return access_list.toString();
    }
    public String mostAccesssedByManagers() throws JSONException
    {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        List<PieObject> poList = dao.mostAccessedByManagers();
        JSONObject access_list = new JSONObject().put(Helper.SUCCESS, true);
        for (PieObject aPoList : poList) {
            access_list.put(aPoList.getName(), aPoList.getCount());
        }
        return access_list.toString();
    }
    public SchemeMemberManager getSchemeManager(Long userid)
    {
        SchemeMemberManagerDAO  dao = new SchemeMemberManagerDAO(entityManager);
        return dao.findByUserID(userid);
    }

    public List<ContactCategory> getContactReasons()
    {
        ContactCategoryDAO dao = new ContactCategoryDAO(entityManager);
        return dao.findAll();
    }

    public List<AuditTrail> getAuditTrails(String search, int offset, int limit)
    {
        AuditTrailDAO dao = new AuditTrailDAO(entityManager);
        return dao.findAll(search, offset, limit);
    }

    public int getAuditCount(String search)
    {
        AuditTrailDAO dao = new AuditTrailDAO(entityManager);
        return dao.countAll(search);
    }
	/* POST Request to URL */

    private JSONObject URLPost(String link, String params, String encoding) throws JSONException {
        JSONObject json;
        logger.i("Posting...\n Network link: " + link + "\n Params: " + params + "\n Encoding: " + encoding);
        if(isHttps(link))
            json = HttpsPost(link, params, encoding);
        else
            json = HttpPost(link, params, encoding);
        logger.i("Response: \n" + json);
        return json;
    }

    private JSONObject HttpsPost(String link, String params, String encoding) throws JSONException
    {
        Setting settings = getSettings();
        StringBuilder sb = new StringBuilder();
        HttpsURLConnection urlConn;
        InputStreamReader in = null;
        JSONObject json;
        try {
            URL url = new URL(link);
            urlConn = (HttpsURLConnection) url.openConnection();
            if (urlConn != null)
            {
                urlConn.setRequestMethod(Helper.HTTP_POST);
                urlConn.setRequestProperty(Helper.CONTENT_TYPE, encoding);
                urlConn.setReadTimeout(Helper.TIMEOUT);
                urlConn.setRequestProperty(Helper.USERNAME, settings.getUsername());
                urlConn.setRequestProperty(Helper.PASSWORD, settings.getPassword());
                urlConn.setDoOutput(true);
                OutputStream os = urlConn.getOutputStream();
                os.write(params.getBytes());
                os.flush();
                os.close();
            }
            try
            {
                if (urlConn != null && urlConn.getInputStream() != null) {
                    try {
                        in = new InputStreamReader(urlConn.getInputStream(),
                                Charset.defaultCharset());
                        BufferedReader bufferedReader = new BufferedReader(in);
                        int cp;
                        while ((cp = bufferedReader.read()) != -1) {
                            sb.append((char) cp);
                        }
                        bufferedReader.close();
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                        json = new JSONObject();
                        json.put(Helper.SUCCESS, false);
                        json.put(Helper.MESSAGE, "An error was encountered fetching the data from the url. " + ex.getMessage());
                        return json;
                    }
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            json = new JSONObject();
            json.put(Helper.SUCCESS, false);
            json.put(Helper.MESSAGE, "An error was encountered fetching the data from the url. " + e.getMessage());
            return json;
        }

        json = new JSONObject(sb.toString().trim());
        return json;
    }

    private JSONObject HttpPost(String link, String params, String encoding) throws JSONException
    {
        Setting settings = getSettings();
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConn;
        InputStreamReader in = null;
        JSONObject json;
        try {
            URL url = new URL(link);
            urlConn = (HttpURLConnection) url.openConnection();
            if (urlConn != null)
            {
                urlConn.setRequestMethod(Helper.HTTP_POST);
                urlConn.setRequestProperty(Helper.CONTENT_TYPE, encoding);
                urlConn.setReadTimeout(Helper.TIMEOUT);
                urlConn.setRequestProperty(Helper.USERNAME, settings.getUsername());
                urlConn.setRequestProperty(Helper.PASSWORD, settings.getPassword());
                urlConn.setDoOutput(true);
                OutputStream os = urlConn.getOutputStream();
                os.write(params.getBytes());
                os.flush();
                os.close();
            }
            try
            {
                if (urlConn != null && urlConn.getInputStream() != null) {
                    try {
                        in = new InputStreamReader(urlConn.getInputStream(),
                                Charset.defaultCharset());
                        BufferedReader bufferedReader = new BufferedReader(in);
                        int cp;
                        while ((cp = bufferedReader.read()) != -1) {
                            sb.append((char) cp);
                        }
                        bufferedReader.close();
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                        json = new JSONObject();
                        json.put(Helper.SUCCESS, false);
                        json.put(Helper.MESSAGE, "An error was encountered fetching the data from the url. " + ex.getMessage());
                        return json;
                    }
                }
            }
            catch (IOException ioe)
            {
                return null;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            json = new JSONObject();
            json.put(Helper.SUCCESS, false);
            json.put(Helper.MESSAGE, "An error was encountered fetching the data from the url. " + e.getMessage());
            return json;
        }

        json = new JSONObject(sb.toString().trim());
        return json;
    }
    public String hash(String password)
    {
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return sha1;
    }


    private String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private void create_member(Member m)
    {
        MemberDAO dao = new MemberDAO(entityManager);
        try {
            dao.merge(m);
        }
        catch (Exception ex)
        {
        }
    }

    public void create_user(User u)
    {
        UserDAO dao = new UserDAO(entityManager);
        u.setPassword(hash(u.getPassword()));
        dao.save(u);
    }

    public InterestRateColumns getInterestRateColumns()
    {
        InterestRateColumnsDAO dao = new InterestRateColumnsDAO(entityManager);
        return dao.find();
    }

    public JSONObject result(boolean status, String message)
    {
        JSONObject obj = new JSONObject();
        try {
            obj.put(Helper.SUCCESS, status);
            obj.put(Helper.MESSAGE, message);
        } catch (JSONException je) {

        }
        return obj;
    }

    public String getLoginField(String profile)
    {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        ProfileLoginField plf = dao.findByProfile(profile);
        return plf != null? plf.getOrdinal() : null;
    }

    public ProfileLoginField getProfileLoginField(String profile)
    {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        return dao.findByProfile(profile);
    }

    public List<ProfileLoginField> getProfileLoginFields()
    {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        return dao.findAll();
    }

    public JSONObject memberExists(String profile, String idNumber) throws JSONException, IOException {

        Setting settings = getSettings();

        String ordinal = getLoginField(profile);

        JSONObject response = URLPost(settings.getXiPath() + "checkMemberExists/" + ordinal  + "/" + idNumber + "/" + profile, "", "application/x-www-form-urlencoded");

        try {
            if(response.get(Helper.SUCCESS).equals(true))
            {
                return response;
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        } catch (NullPointerException npe)
        {
            return null;
        }

    }



    public JSONObject uploadMemberDocument(String memberId, String docName, String docNotes, String docNum, String docTypeId) throws JSONException {

        Setting settings = getSettings();

        JSONObject response = URLPost(settings.getXiPath() + "upload/" + memberId  + "/" + docName + "/" + docNotes + "/" + docNum + "/" + docTypeId, "", "application/x-www-form-urlencoded");

        try {
            if(response.get(Helper.SUCCESS).equals(true))
            {
                return response;
            }
            else
            {
                return null;
            }
        } catch (NullPointerException npe)
        {
            return null;
        }

    }

    public String profileExistsInScheme(String profile, String idNumber, String schemeID) throws JSONException {

        Setting settings = getSettings();

        String ordinal = getLoginField(profile);

        JSONObject response = URLGet(settings.getXiPath() + "checkMemberExistsInScheme/" + ordinal + "/" + idNumber + "/" + profile + "/" + schemeID);

        if(response.get(Helper.SUCCESS).equals(true))
        {
            return response.get("memberId").toString();
        }
        else
        {
            return null;
        }

    }

    public String saveOrUpdateBeneficiary(String params) throws JSONException
    {

        Setting settings = getSettings();

        JSONObject response = URLPost(settings.getXiPath() + "saveorupdatebeneficiarydetails", params, "application/json");

        return response.toString();

    }

    public JSONObject getProviderDetails(String profile, String identifier) throws JSONException, UnsupportedOperationException {

        Setting settings = getSettings();

        return URLGet(settings.getXiPath() + "DAOprovider/get/" + profile + "/" + identifier);

    }

    private JSONObject saveOrUpdateSponsor(String params) throws JSONException
    {

        Setting settings = getSettings();

        return URLPost(settings.getXiPath() + "sponsor/saveorupdatepotentialsponsor", params, "application/json");

    }

    public JSONObject saveOrUpdateMember(String params) throws JSONException
    {

        Setting settings = getSettings();

        return URLPost(settings.getXiPath() + "saveorupdatemember", params, "application/json");

    }

    public User findByUsernameAndProfile(String username, String profile)
    {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findUserByUsernameAndProfile(username, profile);
    }

    public List<PensionProduct> getPensionProduct()
    {
        return null;
    }
    public String getOrdinalKey(String ordinal)
    {
        switch (ordinal) {
            case "EMAIL":
                return "email";
            case "MEMBER_NO":
                return "memberNo";
            case "NATIONAL":
                return "idNo";
            case "MEMBER_ID":
                return "id";
            case "PIN":
                return "pinNo";
            default:
                return null;
        }
    }
    public void updateUser(User u)
    {
        UserDAO dao = new UserDAO(entityManager);
        dao.merge(u);
    }
    public User findBySecurityCode(String code)
    {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findBySecurityCode(code);
    }
    public Gender genderById(long id)
    {
        GenderDAO dao = new GenderDAO(entityManager);
        return dao.findById(id);
    }
    public ContactCategory findConcactCategoryById(long id)
    {
        ContactCategoryDAO dao = new ContactCategoryDAO(entityManager);
        return dao.findById(id);
    }
    public void persistMedia(Media media)
    {
        MediaDAO dao = new MediaDAO(entityManager);
        dao.save(media);
    }
    public void mergeContactCategory(ContactCategory contactCategory)
    {
        ContactCategoryDAO dao = new ContactCategoryDAO(entityManager);
        if(contactCategory.getId() > 0)
            dao.merge(contactCategory);
        else
            dao.save(contactCategory);
    }
    public void mergeMemberPermission(MemberPermission mp)
    {
        MemberPermissionDAO dao = new MemberPermissionDAO(entityManager);
        if(mp.getId() > 0)
            dao.merge(mp);
        else
            dao.save(mp);
    }
    public void mergeProfileLoginField(ProfileLoginField plf)
    {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        if(plf.getId() > 0)
            dao.merge(plf);
        else
            dao.save(plf);
    }
    public void mergeSettings(Setting setting)
    {
        SettingDAO dao = new SettingDAO(entityManager);
        dao.merge(setting);
    }
    public void persistBanner(Banner banner)
    {
        BannerDAO dao = new BannerDAO(entityManager);
        dao.save(banner);
    }
    public List<Ordinal> getOrdinals()
    {
        Ordinal ordinal = new Ordinal(Long.valueOf("1").longValue(), "MEMBER_NO", "Member Number");
        Ordinal ordinal2 = new Ordinal(Long.valueOf("2").longValue(), "NATIONAL", "National ID");
        Ordinal ordinal3 = new Ordinal(Long.valueOf("3").longValue(), "VOTER", "Voter Number");
        Ordinal ordinal4 = new Ordinal(Long.valueOf("4").longValue(), "PASSPORT", "Passport Number");
        Ordinal ordinal5 = new Ordinal(Long.valueOf("5").longValue(), "PENNO", "Pension Number");
        Ordinal ordinal6 = new Ordinal(Long.valueOf("6").longValue(), "DRIVER", "Driver Licence Number");
        Ordinal ordinal7 = new Ordinal(Long.valueOf("7").longValue(), "STAFF", "Staff Number");
        Ordinal ordinal8 = new Ordinal(Long.valueOf("8").longValue(), "PIN", "PIN Number");
        Ordinal ordinal9 = new Ordinal(Long.valueOf("9").longValue(), "EMAIL", "Email Address");
        Ordinal ordinal10 = new Ordinal(Long.valueOf("10").longValue(), "NHIF", "NHIF Number");
        Ordinal ordinal11 = new Ordinal(Long.valueOf("11").longValue(), "PHONE", "Phone Number");
        Ordinal ordinal12 = new Ordinal(Long.valueOf("12").longValue(), "MEMBER_NO", "Member ID");
        List<Ordinal> ordinals = new ArrayList<>();
        ordinals.add(ordinal);
        ordinals.add(ordinal2);
        ordinals.add(ordinal3);
        ordinals.add(ordinal4);
        ordinals.add(ordinal5);
        ordinals.add(ordinal6);
        ordinals.add(ordinal7);
        ordinals.add(ordinal8);
        ordinals.add(ordinal9);
        ordinals.add(ordinal10);
        ordinals.add(ordinal11);
        ordinals.add(ordinal12);
        return ordinals;
    }

    public List<Help> getHelp()
    {
        HelpDAO dao = new HelpDAO(entityManager);
        return dao.findAll();
    }

    public List<User> getUsers(String search, int start, int count)
    {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findAll(search, start, count);
    }
    public int countUsers(String search)
    {
        UserDAO dao = new UserDAO(entityManager);
        return dao.countAll(search);
    }
    public List<PageContent> getPageContent()
    {
        PageContentDAO dao = new PageContentDAO(entityManager);
        return dao.findAll();
    }

    public PageContent getPageContentByPage(String page)
    {
        PageContentDAO dao = new PageContentDAO(entityManager);
        return dao.findPageContent(page);
    }

    public Help getHelpByPage(String page)
    {
       HelpDAO dao = new HelpDAO(entityManager);
        return dao.findHelp(page);
    }
    public Help getHelpByID(Long id)
    {
        HelpDAO dao = new HelpDAO(entityManager);
        return dao.findById(id);
    }
    public PageContent getPageContentByID(Long id)
    {
        PageContentDAO dao = new PageContentDAO(entityManager);
        return dao.findById(id);
    }
    public User login(String username, String password)
    {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findUser(username, hash(password));
    }

    public boolean userExists(String username, String profile)
    {
        UserDAO dao = new UserDAO(entityManager);
        User u = dao.find(username, profile);
        try
        {
            return u != null;
        }
        catch (NullPointerException ex)
        {
            return false;
        }
    }
    public JSONObject createSponsor(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        Setting settings = getSettings();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String date_string = request.getParameter("applicationDate");
        Date date = null;
        try {
            date = format.parse(date_string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Sponsor sponsor = new Sponsor();
        sponsor.setApplicationDate(date);
        sponsor.setCity(request.getParameter("city"));
        sponsor.setCompanyAddress(request.getParameter("address"));
        sponsor.setCompanyName(request.getParameter("name"));
        CountryDAO cDAO = new CountryDAO(entityManager);
        Country country = cDAO.findById(Long.valueOf(request.getParameter("country")));
        sponsor.setCountry(country);
        sponsor.setEmailAddress(request.getParameter("email"));
        sponsor.setEmployerRefNo(request.getParameter("employerNo"));
        sponsor.setPhoneNumber(request.getParameter("phone"));
        sponsor.setPinNumber(request.getParameter("pinNo"));
        sponsor.setScheme(request.getParameter("scheme"));
        try {
            if(session.getAttribute(Constants.U_PROFILE).equals(Constants.AGENT_PROFILE))
            {
                sponsor.setAgentId();
            }
        } catch (NullPointerException e)
        {
            logger.e("Non-logged in user trying to create sponsor");
        }
        SectorDAO dao = new SectorDAO(entityManager);
        Sector sector = dao.findById(Long.valueOf(request.getParameter("sector")));
        sponsor.setSector(sector);
        JSONObject result = null;
        if(settings.getSponsorOnboading().equals(Helper.MSS) || settings.getSponsorOnboading().equals(Helper.BOTH))
        {
            SponsorDAO sdao = new SponsorDAO(entityManager);
            try {
                sdao.merge(sponsor);
                result = result(true, "Sponsor details have been successfully saved.");
            } catch (Exception ex)
            {
                result = result(false, "Sponsor details could not be saved. We apologise for the inconvenience.");
            }
        }
        if(settings.getSponsorOnboading().equals(Helper.XI) || settings.getSponsorOnboading().equals(Helper.BOTH))
        {
            result = postSponsorToXi(sponsor);
        }
        return result;
    }
    public Member getMemberByID(String memberID)
    {
       MemberDAO dao = new MemberDAO(entityManager);
        return dao.findById(Long.valueOf(memberID));
    }
    public JSONObject postSponsorToXi(Sponsor sponsor)
    {
        DateFormat format_ = new SimpleDateFormat(Helper.YYYY_MM_DD, Locale.ENGLISH);
        JSONObject jsponsor = new JSONObject();
        JSONObject result = null;
        try {
            jsponsor.put("sponsor.name", sponsor.getCompanyName())
                    .put("sponsor.applicationDate", format_.format(sponsor.getApplicationDate()))
                    .put("sponsor.address.residentialAddress", sponsor.getCompanyAddress())
                    .put("sponsor.address.fixedPhone", sponsor.getPhoneNumber())
                    .put("sponsor.address.email", sponsor.getEmailAddress())
                    .put("sponsor.address.town", sponsor.getCity())
                    .put("sponsor.address.country", sponsor.getCountry().getName())
                    .put("sponsor.sector", sponsor.getSector().getName())
                    .put("sponsor.employerpin", sponsor.getEmployerRefNo())
                    .put("sponsor.status",  "POTENTIAL_SPONSOR");
            result = saveOrUpdateSponsor(jsponsor.toString());
            if(result.get(Helper.SUCCESS).equals(true))
            {
                SponsorDAO dao = new SponsorDAO(entityManager);
                sponsor.setPosted();
                dao.merge(sponsor);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    public JSONObject postMemberToXi(Member m)
    {
        DateFormat format_ = new SimpleDateFormat(Helper.YYYY_MM_DD, Locale.ENGLISH);
        String title;
        if(m.getGender().getName().equalsIgnoreCase("male"))
            title = "Mr";
        else
            title = "Mrs";
        JSONObject member = new JSONObject();
        JSONObject result = null;
        try {
            member.put("member.surname", m.getLastname());
            member.put("member.firstname", m.getFirstname());
            member.put("member.dob", format_.format(m.getDateOfBirth()))
                    .put("member.gender", m.getGender().getName().toUpperCase())
                    .put("member.title", title)
                    .put("member.postalAddress", m.getResidentialAddress())
                    .put("member.maritalStatus", m.getMaritalStatus().getName().toUpperCase())
                    .put("member.mbshipStatus", "INACTIVE")
                    .put("member.schemeId", m.getScheme());
            result = saveOrUpdateMember(member.toString());
            if(result.get(Helper.SUCCESS).toString().equalsIgnoreCase("true"))
            {
                m.setPosted();
                MemberDAO mDAO = new MemberDAO(entityManager);
                mDAO.merge(m);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    public JSONObject createMember(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        Setting settings = getSettings();
        CountryDAO dao = new CountryDAO(entityManager);
        Country country = dao.findById(Long.valueOf(request.getParameter("country")));
        GenderDAO gdao = new GenderDAO(entityManager);
        Gender gender = gdao.findById(Long.valueOf(request.getParameter("gender")));
        MaritalStatusDAO msDAO = new MaritalStatusDAO(entityManager);
        MaritalStatus mStatus = msDAO.findById(Long.valueOf(request.getParameter("maritalStatus")));
        String date_string = request.getParameter("dateOfBirth");
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date = null;
        JSONObject result = null;
        try {
            date = format.parse(date_string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Member m = new Member();
        m.setFirstname(request.getParameter("firstName"));
        m.setLastname(request.getParameter("lastName"));
        m.setOthernames(request.getParameter("otherName"));
        m.setGender(gender);
        m.setMaritalStatus(mStatus);
        m.setIdNumber(request.getParameter("idNumber"));
        m.setEmailAddress(request.getParameter("emailAddress"));
        m.setPhoneNumber(request.getParameter("phoneNumber"));
        m.setResidentialAddress(request.getParameter("residentialAddress"));
        m.setCity(request.getParameter("city"));
        m.setCountry(country);
        m.setDateOfBirth(date);
        m.setScheme(request.getParameter("pension_scheme"));

        try {
            if(session.getAttribute(Constants.U_PROFILE).equals(Constants.AGENT_PROFILE))
            {
                m.setAgentId();
            }
        } catch (NullPointerException e)
        {
            logger.e("Non-logged in user trying to create member");
        }
        if(settings.getMemberOnboarding().equals(Helper.MSS) || settings.getMemberOnboarding().equals(Helper.BOTH))
        {
            try {
                create_member(m);
                result = result(true, "Member details successfully saved");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if(settings.getMemberOnboarding().equals(Helper.XI) || settings.getMemberOnboarding().equals(Helper.BOTH))
        {
            result = postMemberToXi(m);
        }
        return result;
    }
    public List<Scheme> getSchemeByPlanType(String planType) throws JSONException{
        try
        {
            Setting settings = getSettings();
            List<Scheme> schemes = new ArrayList<>();
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebyplantype/" + planType);
            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i++){

                    JSONObject jsonobj = res.getJSONObject(i);

                    Scheme scheme = new Scheme(Long.valueOf(jsonobj.getString("id")).longValue(), jsonobj.getString("schemePin"), jsonobj.getString("schemeName"), jsonobj.getString("schemeType"), jsonobj.getString("schemePin"), jsonobj.getString("planType"), jsonobj.getString("sector"));

                    schemes.add(scheme);

                }

                return schemes;
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public List<AnnuityProduct> getAnnuityProducts() throws JSONException{
        try {
            Setting settings = getSettings();
            List<AnnuityProduct> annuityProducts = new ArrayList<>();
            JSONObject response = URLGet(settings.getXiPath() + "annuity_quote/getannuityproducts");
            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i++){

                    JSONObject jsonobj = res.getJSONObject(i);

                    AnnuityProduct annuityProduct = new AnnuityProduct(Long.valueOf(jsonobj.getString("id")).longValue(), jsonobj.getString("product_name"), jsonobj.getString("product_date"));

                    annuityProducts.add(annuityProduct);

                }

                return annuityProducts;
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public List<Scheme> getSchemeBySchemeMode(String schemeMode) {
        try
        {
            Setting settings = getSettings();
            List<Scheme> schemes = new ArrayList<>();
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebyschememode/" + schemeMode);
            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i++){

                    JSONObject jsonobj = res.getJSONObject(i);

                    Scheme scheme = new Scheme(Long.valueOf(jsonobj.getString("id")).longValue(), jsonobj.getString("schemePin"), jsonobj.getString("schemeName"), jsonobj.getString("schemeType"), jsonobj.getString("schemePin"), jsonobj.getString("planType"), jsonobj.getString("sector"));

                    schemes.add(scheme);

                }

                return schemes;
            }
            else
            {
                return null;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
    }


    public List<Scheme> getSchemeBySchemeModeAndPlanType(String schemeMode, String planType) throws JSONException{
        try
        {
            Setting settings = getSettings();
            List<Scheme> schemes = new ArrayList<>();
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebyschememodeandplantype/" + schemeMode + "/" + planType);
            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i++){

                    JSONObject jsonobj = res.getJSONObject(i);

                    Scheme scheme = new Scheme(Long.valueOf(jsonobj.getString("id")).longValue(), jsonobj.getString("schemePin"), jsonobj.getString("schemeName"), jsonobj.getString("schemeType"), jsonobj.getString("schemePin"), jsonobj.getString("planType"), jsonobj.getString("sector"));

                    schemes.add(scheme);

                }

                return schemes;
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public String getAnnuityQuote(String calculationMode, String productID, String lastName, String firstName, String otherNames, String idNumber, String address, String email, String phoneNumber, String purchaseDate, String pensionStartDate, String dateOfBirth, String gender, String guaranteedPercentage, String annuityIncrement, String paymentMode, String paymentFrequency, String registeredPurchasePrice, String unRegisteredPurchasePrice, String targetPension, String annuityMode, String spouseReversal, String spouseGender, String spouseDateOfBirth) throws JSONException {
        Setting settings = getSettings();
        String urlParameters = "annuityProductId=" + productID + "&" + "surname=" + lastName + "&" + "firstName=" + firstName + "&" + "otherNames=" + otherNames + "&" + "idNo=" + idNumber + "&" + "address=" + address + "&" + "email=" + email + "&" + "mobileNo=" + phoneNumber + "&" + "purchaseDate=" + purchaseDate + "&" + "pensionStartDate=" + pensionStartDate + "&" + "dob=" + dateOfBirth + "&" + "gender=" + gender.toUpperCase() + "&" + "guaranteedPerc=" + guaranteedPercentage + "&" + "annuityIncrement=" + annuityIncrement + "&" + "paymentMode=" + paymentMode + "&" + "paymentFrequency=" + paymentFrequency + "&" + "spouseReversal=" + spouseReversal + "&" + "dobSpouse=" + spouseDateOfBirth + "&" + "spouseGender=" + spouseGender.toUpperCase() + "&" + "regPurchasePrice=" + registeredPurchasePrice + "&" + "unRegPurchasePrice=" + unRegisteredPurchasePrice + "&" + "calcMode=" + calculationMode + "&" + "targetPension=" + targetPension + "&" + "agentId=" + "0" + "&" + "annuityMode=" + annuityMode;
        JSONObject response = URLPost(settings.getXiPath() + "annuity_quote/getquote", urlParameters, "application/x-www-form-urlencoded");
        return response.toString();

    }
    public String queryWhatIfAnalysis(String yearsToProject, String contributions, String rateOfReturn, String salaryEscalationRate, String inflationRate) throws JSONException {
        Setting settings = getSettings();
        //JSONObject response = URLPost(settings.getXiPath() + "whatifanalysis.json", "");
        JSONObject response = URLPost(settings.getXiPath() + "whatifanalysis/" + yearsToProject + "/" + contributions + "/" + rateOfReturn + "/" + salaryEscalationRate + "/" + inflationRate, "", "application/x-www-form-urlencoded");
        if(response.get(Helper.SUCCESS).equals(true))
        {

            return response.toString();
        }
        else
        {
            return response.toString();
        }

    }

    public String getSchemeInterestRates(String schemeID) throws JSONException {
        Setting settings = getSettings();
        JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemeinterestrates/" + schemeID);
        if(response.get(Helper.SUCCESS).equals(true))
        {

            JSONArray res = (JSONArray) response.get(Helper.ROWS);

            JSONArray jsonarray = new JSONArray();

            InterestRateColumns irc = getInterestRateColumns();

            Map<String, Boolean> temp = new HashMap<>();
            temp.put(Helper.SUCCESS, true);

            jsonarray.put(temp);


            for(int i = 0; i < res.length(); i += 2){

                JSONObject jsonobj = res.getJSONObject(i);

                JSONObject obj = new JSONObject();

                if(irc.isDateDeclared())
                {
                    obj.put("dateDeclared", jsonobj.get("dateDeclared"));
                }

                if(irc.isAccountingPeriod())
                {
                    obj.put("accountingPeriod", jsonobj.get("ap"));
                }

                if(irc.isContributions())
                {
                    obj.put("contributions", jsonobj.get("contributions"));
                }

                if(irc.isOpeningBalances())
                {
                    obj.put("openingBalances", jsonobj.get("openingBalances"));
                }

                if(irc.isPensionDrawDown())
                {
                    obj.put("pensionDrawDown", jsonobj.get("pensionDrawDown"));
                }

                if(irc.isYear())
                {
                    obj.put("year", jsonobj.get("year"));
                }

                if(jsonobj.getString("status").equals("Registered"))
                {
                    obj.put("registered", jsonobj.get("contributions"));

                    JSONObject jsonobj_ = res.getJSONObject(i + 1);

                    obj.put("unRegistered", jsonobj_.get("contributions"));
                }
                else
                {
                    obj.put("unRegistered", jsonobj.get("contributions"));

                    JSONObject jsonobj_ = res.getJSONObject(i + 1);

                    obj.put("registered", jsonobj_.get("contributions"));
                }

                jsonarray.put(obj);

            }

            return "{\"success\": true,\"rows\":" + jsonarray.toString() + "}";
        }
        else
        {
            return null;
        }
    }
    public String getMemberBalances(String memberID) throws JSONException{
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "getmemberbalances/" + memberID);
            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                double total = 0;

                for(int i = 0; i < res.length(); i ++)

                {

                    JSONObject obj = res.getJSONObject(i);

                    total = Double.parseDouble(obj.getString("total"));

                }

                response = new JSONObject().put(Helper.SUCCESS, true).put("total", total);

                return response.toString();
            }
            else
            {
                return response.toString();
            }
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        }
        catch (Exception ex)
        {
            return "failed";
        }
    }

    private String format_no(double amount)
    {
        if(amount > 0)
        {
            DecimalFormat formatter = new DecimalFormat("#,###.00");

            return formatter.format(amount);
        }
        else
            return String.valueOf(amount);
    }

    public List<BenefitPayment> getBenefitPayments(String schemeID, int start, int count) throws JSONException {
        Setting settings = getSettings();
        JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebenefitpayments/" + schemeID + "/?start=" + start + "&size=" + count);
        if(response.get(Helper.SUCCESS).equals(true))
        {

            List<BenefitPayment> benefitPayments = new ArrayList<>();

            JSONArray res = (JSONArray) response.get(Helper.ROWS);

            for(int i = 0; i < res.length(); i ++)
            {

                JSONObject payment = res.getJSONObject(i);

                BenefitPayment bp = new BenefitPayment();
                try {

                    bp.setGross(format_no(round(Double.parseDouble(String.valueOf(payment.get("gross").toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setGross("0.00");
                }
                try {
                    bp.setTaxFree(format_no(round(Double.parseDouble(String.valueOf(payment.get("lumpsumTaxFree").toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setTaxFree("0.00");
                }
                try {
                    bp.setTaxable(format_no(round(Double.parseDouble(String.valueOf(payment.get("taxableAmount").toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setTaxable("0.00");
                }
                try
                {
                    bp.setWithHolding(format_no(round(Double.parseDouble(String.valueOf(payment.get("withHoldingTax").toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setWithHolding("0.00");
                }
                try {
                    bp.setNet(format_no(round(Double.parseDouble(String.valueOf(payment.get("netPayment").toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setNet("0.00");
                }
                try {

                    bp.setDateApproved(humanReadableDate(payment.get("dateApproved").toString()));
                }
                catch (IllegalArgumentException ex)
                {
                    bp.setDateApproved(payment.get("dateApproved").toString());
                }
                try {
                    bp.setDateOfCalc(humanReadableDate(payment.get("dateOfCalc").toString()));
                }
                catch (IllegalArgumentException ex)
                {
                    ex.printStackTrace();
                    bp.setDateOfCalc(payment.get("dateOfCalc").toString());
                }
                bp.setType(payment.get("paymentType").toString());
                bp.setPayee(payment.get("member").toString());

                benefitPayments.add(bp);

            }

            return benefitPayments;
        }
        else
        {
            return null;
        }
    }


    private String humanReadableDate(String date_string)

    {
        Date compdate = null;
        DateFormat format = new SimpleDateFormat(Helper.YYYY_MM_DD, Locale.ENGLISH);
        try {
            try {
                compdate = format.parse(date_string);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            return formatter.format(compdate);
        }
        catch (Exception ex)
        {
            return date_string;
        }

    }


    public List<SchemeReceipt> getSchemeReceipts(String schemeID, int start, int count) throws JSONException {
        Setting settings = getSettings();

        Constants.RECORD_COUNT = 0;

        JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemereceipts/" + schemeID);
        try {
            if(response.get(Helper.SUCCESS).equals(true))
            {

                Constants.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());

                List<SchemeReceipt> schemeReceipts = new ArrayList<>();

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i ++)
                {

                    JSONObject receipt = res.getJSONObject(i);

                    SchemeReceipt sr = new SchemeReceipt();
                    try {
                        sr.setDate(humanReadableDate(receipt.get("datereceived").toString()));
                    }
                    catch (IllegalArgumentException ex)
                    {
                        sr.setDate(receipt.get("datereceived").toString());
                    }
                    sr.setPayee(receipt.get("payee").toString());
                    sr.setAmount(format_no(round(Double.parseDouble(receipt.get("amount").toString()))));
                    sr.setCategory(receipt.get("txncat").toString());
                    sr.setType(receipt.get("txntype").toString());
                    sr.setMode(receipt.get("paymentmethod").toString());
                    sr.setRef(receipt.get("cheqno").toString());
                    sr.setReceipt_no(receipt.get("receiptno").toString());

                    schemeReceipts.add(sr);

                }

                return schemeReceipts;
            }
            else
            {
                return null;
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public String listMembers(String schemeID, String profileID) throws JSONException
    {
        Setting settings = getSettings();
        JSONObject response = URLGet(settings.getXiPath() + "member/statistics/statusdistribution/" + schemeID+"/"+profileID);
        try {
            if(response.get(Helper.SUCCESS).equals(true))
            {
                return response.toString();
            }
            else
                return null;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public List<XiMember> getMemberListing(String profileID, String profile, String schemeID, int start, int size) throws JSONException {
        Constants.RECORD_COUNT = 0;

        Setting settings = getSettings();
        JSONObject response = URLPost(settings.getXiPath() + "getmemberlisting/" + profileID + "/" + profile + "/" + schemeID + "/?start=" + start + "&size=" + size, "", "application/x-www-form-urlencoded");
        try {
            if(response.get(Helper.SUCCESS).equals(true))
            {

                Constants.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());

                List<XiMember> xiMembers = new ArrayList<>();

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i ++)
                {

                    JSONObject xi_member = res.getJSONObject(i);

                    XiMember xm = new XiMember(xi_member.getLong("id"), xi_member.getString("mbio_id"), xi_member.getString("memberNo"), xi_member.getString("membershipNo"), xi_member.getString("partyrefno"), xi_member.getString("partnerNumber"), xi_member.getString("policyNo"), xi_member.getString("staffNo"), xi_member.getString("name"), xi_member.getString("idNo"), xi_member.getString("terminateCover"), xi_member.getString("pinNo"), xi_member.getString("postalAddress"), xi_member.getString("cellPhone"), xi_member.getString("email"), xi_member.getString("gender"), xi_member.getString("department"), xi_member.getString("dob"), xi_member.getString("maritalStatus"), xi_member.getString("dateJoinedScheme"), xi_member.getString("schemeId"), xi_member.getString("town"), xi_member.getString("country"), xi_member.getString("currentAnnualPensionableSalary"), xi_member.getString("firstname"), xi_member.getString("surname"), xi_member.getString("othernames"));

                    xiMembers.add(xm);

                }

                return xiMembers;
            }
            else
            {
                return null;
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public Sponsor getSponsor(String sponsorID)
    {
        SponsorDAO sDAO = new SponsorDAO(entityManager);
        return sDAO.findById(Long.valueOf(sponsorID));
    }

    public XiMember getMemberDetails(String memberID) throws JSONException{
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "getmemberdetails/" + memberID);
            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                JSONObject xi_member = res.getJSONObject(0);

                return new XiMember(xi_member.getLong("id"), xi_member.getString("mbio_id"), xi_member.getString("memberNo"), xi_member.getString("membershipNo"), xi_member.getString("partyrefno"), xi_member.getString("partnerNumber"), xi_member.getString("policyNo"), xi_member.getString("staffNo"), xi_member.getString("name"), xi_member.getString("idNo"), xi_member.getString("terminateCover"), xi_member.getString("pinNo"), xi_member.getString("postalAddress"), xi_member.getString("cellPhone"), xi_member.getString("email"), xi_member.getString("gender"), xi_member.getString("department"), xi_member.getString("dob"), xi_member.getString("maritalStatus"), xi_member.getString("dateJoinedScheme"), xi_member.getString("schemeId"), xi_member.getString("town"), xi_member.getString("country"), xi_member.getString("currentAnnualPensionableSalary"), xi_member.getString("firstname"), xi_member.getString("surname"), xi_member.getString("othernames"));
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public Permission getPermissions(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        Permission permissions;
        if(isManager(request))
        {
            permissions = getPermissions(Constants.MANAGER);
        }
        else
            permissions = getPermissions(session.getAttribute(Constants.U_PROFILE).toString());
        return permissions;
    }
    public List<Beneficiary> getBeneficiaries(String memberID)
    {
        Setting settings = getSettings();
        try {
            JSONObject response = URLPost(settings.getXiPath() + "getmemberbeneficiaries/" + memberID,"", "application/x-www-form-urlencoded");
            if(response.get(Helper.SUCCESS).equals(true))
            {
                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                List<Beneficiary> beneficiaries = new ArrayList<>();

                for(int i = 0; i < res.length(); i ++)

                {

                    JSONObject obj = res.getJSONObject(i);
                    Beneficiary ben = new Beneficiary(obj.getLong("id"), obj.getLong("memberNo"), obj.getString("relationship"), obj.getString("category"), obj.getString("surname"), obj.getString("name"), obj.getString("surname"), obj.getString("dob"), obj.getString("gender"), obj.get("monthlyEntitlement").toString(), obj.get("lumpsumEntitlement").toString(), obj.getString("idNo"), obj.getString("address"), obj.getString("mstatus"), obj.getString("physicalCondition"), obj.getString("dateOfAppointment"), obj.getString("trustFund"), obj.getString("trustFund"), obj.getString("trustFund"), obj.getString("trustFund"), obj.getString("trustFund"), obj.getString("trustFund"), obj.getString("trustFund"), obj.getString("trustFund"));

                    beneficiaries.add(ben);

                }

                return beneficiaries;

            }
            else
            {
                return null;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
    }


    public JSONObject searchProfilesJSON(String search, String identifier, String profile, String schemeID)
    {
        Setting settings = getSettings();
        try {

            return URLPost(settings.getXiPath() + "searchForMemberDetails/" + identifier + "/" + search + "/" + profile + "/" + schemeID + "/0/20", "", "application/x-www-form-urlencoded");
        }
        catch (Exception ex)
        {
            return null;
        }

    }
    public List<XiMember> searchProfiles(String search, String identifier, String profile, String schemeID, int start, int count)
    {
        Setting settings = getSettings();
        try {
            JSONObject response = URLPost(settings.getXiPath() + "searchForMemberDetails/" + identifier + "/" + search + "/" + profile + "/" + schemeID + "/" + start + "/" + count, "", "application/x-www-form-urlencoded");
            try {
                if(response.get(Helper.SUCCESS).equals(true))
                {

                    List<XiMember> xiMembers = new ArrayList<>();

                    JSONArray res = (JSONArray) response.get(Helper.ROWS);

                    for(int i = 0; i < res.length(); i ++)
                    {

                        JSONObject xi_member = res.getJSONObject(i);

                        XiMember xm = new XiMember(xi_member.getLong("id"), xi_member.getString("mbio_id"), xi_member.getString("memberNo"), xi_member.getString("membershipNo"), xi_member.getString("partyrefno"), xi_member.getString("partnerNumber"), xi_member.getString("policyNo"), xi_member.getString("staffNo"), xi_member.getString("name"), xi_member.getString("idNo"), xi_member.getString("terminateCover"), xi_member.getString("pinNo"), xi_member.getString("postalAddress"), xi_member.getString("cellPhone"), xi_member.getString("email"), xi_member.getString("gender"), xi_member.getString("department"), xi_member.getString("dob"), xi_member.getString("maritalStatus"), xi_member.getString("dateJoinedScheme"), xi_member.getString("schemeId"), xi_member.getString("town"), xi_member.getString("country"), xi_member.getString("currentAnnualPensionableSalary"), xi_member.getString("firstname"), xi_member.getString("surname"), xi_member.getString("othernames"));

                        xiMembers.add(xm);

                    }

                    return xiMembers;
                }
                else
                {
                    return null;
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch (Exception ex)
        {
            return null;
        }
        return null;

    }

    public String getReasonsForExit()
    {
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getreasonsforexit/" + "ALL");

            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }

    }

    public String getExitsInYear(String schemeID)
    {
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebenefitswithinyear/" + schemeID);

            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }

    }



    public String getAgentCommission(String agentID)
    {
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "commissions/get/" + agentID);

            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }

    }


    public JSONObject sendNotification(String receipients, String subject, String message, String schemeID, boolean attachment, String attachment_url) throws JSONException
    {
        Setting settings = getSettings();
        JSONObject params = new JSONObject();
        params.put("notificationPlatform", "EMAIL")
                .put("recipients", receipients)
                .put("subject", subject)
                .put("msg", message)
                .put("schemeId", schemeID);
        if(attachment)
            params.put("attachments", attachment_url);
        else
            params.put("attachments", new ArrayList<String>());
        try {

            return URLPost(settings.getXiPath() + "notification/push", params.toString(), "application/json");
        }
        catch (Exception ex)
        {
            return null;
        }

    }

    public String searchSchemes(String search)
    {
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebyname/" + search);

            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }

    }

    public List<XiMember> due4Retirement(String schemeID) throws JSONException
    {
        Setting settings = getSettings();
        JSONObject response = URLGet(settings.getXiPath() + "getmembersdueforretirement/" + schemeID + "/0/100000");
        try {
            if(response.get(Helper.SUCCESS).equals(true))
            {

                Constants.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());

                List<XiMember> xiMembers = new ArrayList<>();

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i ++)
                {

                    JSONObject xi_member = res.getJSONObject(i);

                    XiMember xm = new XiMember(xi_member.getLong("id"), xi_member.getString("mbio_id"), xi_member.getString("memberNo"), xi_member.getString("membershipNo"), xi_member.getString("partyrefno"), xi_member.getString("partnerNumber"), xi_member.getString("policyNo"), xi_member.getString("staffNo"), xi_member.getString("name"), xi_member.getString("idNo"), xi_member.getString("terminateCover"), xi_member.getString("pinNo"), xi_member.getString("postalAddress"), xi_member.getString("cellPhone"), xi_member.getString("email"), xi_member.getString("gender"), xi_member.getString("department"), xi_member.getString("dob"), xi_member.getString("maritalStatus"), xi_member.getString("dateJoinedScheme"), xi_member.getString("schemeId"), xi_member.getString("town"), xi_member.getString("country"), xi_member.getString("currentAnnualPensionableSalary"), xi_member.getString("firstname"), xi_member.getString("surname"), xi_member.getString("othernames"));

                    xiMembers.add(xm);

                }

                return xiMembers;
            }
            else
            {
                return null;
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public List<BenefitPayment> searchPayments(String schemeID, String from, String to, int start, int count)
    {
        Constants.RECORD_COUNT = 0;

        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebenefitpaymentsbetweendates/" + schemeID + "/" + from + "/" + to);

            if(response.get(Helper.SUCCESS).equals(true))
            {

                Constants.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());

                List<BenefitPayment> benefitPayments = new ArrayList<>();

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i ++)
                {

                    JSONObject payment = res.getJSONObject(i);

                    BenefitPayment bp = new BenefitPayment();
                    try {

                        bp.setGross(format_no(round(Double.parseDouble(String.valueOf(payment.get("gross").toString())))));
                    }
                    catch (NumberFormatException ex)
                    {
                        bp.setGross("0.00");
                    }
                    try {
                        bp.setTaxFree(format_no(round(Double.parseDouble(String.valueOf(payment.get("lumpsumTaxFree").toString())))));
                    }
                    catch (NumberFormatException ex)
                    {
                        bp.setTaxFree("0.00");
                    }
                    try {
                        bp.setTaxable(format_no(round(Double.parseDouble(String.valueOf(payment.get("taxableAmount").toString())))));
                    }
                    catch (NumberFormatException ex)
                    {
                        bp.setTaxable("0.00");
                    }
                    try
                    {
                        bp.setWithHolding(format_no(round(Double.parseDouble(String.valueOf(payment.get("withHoldingTax").toString())))));
                    }
                    catch (NumberFormatException ex)
                    {
                        bp.setWithHolding("0.00");
                    }
                    try {
                        bp.setNet(format_no(round(Double.parseDouble(String.valueOf(payment.get("netPayment").toString())))));
                    }
                    catch (NumberFormatException ex)
                    {
                        bp.setNet("0.00");
                    }
                    try {

                        bp.setDateApproved(humanReadableDate(payment.get("dateApproved").toString()));
                    }
                    catch (IllegalArgumentException ex)
                    {
                        bp.setDateApproved(payment.get("dateApproved").toString());
                    }
                    try {
                        bp.setDateOfCalc(humanReadableDate(payment.get("dateOfCalc").toString()));
                    }
                    catch (IllegalArgumentException ex)
                    {
                        ex.printStackTrace();
                        bp.setDateOfCalc(payment.get("dateOfCalc").toString());
                    }
                    bp.setType(payment.get("paymentType").toString());
                    bp.setPayee(payment.get("member").toString());

                    benefitPayments.add(bp);

                }

                return benefitPayments;
            }
            else
            {
                return null;
            }
        }
        catch (Exception ex)
        {
            return null;
        }

    }

    public List<SchemeReceipt> searchReceipts(String schemeID, String from, String to, int start, int count)
    {
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemereceiptsbetweendates/" + schemeID + "/" + from + "/" + to);

            if(response.get(Helper.SUCCESS).equals(true))
            {
                List<SchemeReceipt> schemeReceipts = new ArrayList<>();

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i ++)
                {

                    JSONObject receipt = res.getJSONObject(i);

                    SchemeReceipt sr = new SchemeReceipt();
                    try {
                        sr.setDate(humanReadableDate(receipt.get("datereceived").toString()));
                    }
                    catch (IllegalArgumentException ex)
                    {
                        sr.setDate(receipt.get("datereceived").toString());
                    }
                    sr.setPayee(receipt.get("payee").toString());
                    sr.setAmount(format_no(round(Double.parseDouble(receipt.get("amount").toString()))));
                    sr.setCategory(receipt.get("txncat").toString());
                    sr.setType(receipt.get("txntype").toString());
                    sr.setMode(receipt.get("paymentmethod").toString());
                    sr.setRef(receipt.get("cheqno").toString());
                    sr.setReceipt_no(receipt.get("receiptno").toString());

                    schemeReceipts.add(sr);

                }

                return schemeReceipts;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
        return null;

    }

    public String getNewMembersInYear(String schemeID,String profileID)
    {
        Setting settings = getSettings();
        try {
            JSONObject response = URLPost(settings.getXiPath() + "newMemberListingWithinYear/" + schemeID+"/"+profileID, "", "application/x-www-form-urlencoded");

            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }

    }

    public String getMemberBeneficiaries(String memberID)
    {
        Setting settings = getSettings();
        try {
            //JSONObject response = URLGet(settings.getXiPath() + "getmemberbeneficiaries.json");
            JSONObject response = URLPost(settings.getXiPath() + "getmemberbeneficiaries/" + memberID,"", "application/x-www-form-urlencoded");
            if(response.get(Helper.SUCCESS).equals(true))
            {


                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                JSONArray resp = new JSONArray();

                for(int i = 0; i < res.length(); i ++)

                {

                    JSONObject obj = res.getJSONObject(i);

                    JSONObject beneficiary = new JSONObject();

                    beneficiary.put("name", obj.get("name"));

                    beneficiary.put("amount", obj.get("lumpsumEntitlement"));

                    resp.put(beneficiary);

                }

                return new JSONObject().put(Helper.SUCCESS, true).put(Helper.ROWS, resp).toString();

            }
            else
            {
                return response.toString();
            }
        }
        catch (Exception ex)
        {
            return null;
        }

    }
    private double round(double value) {

        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    public String getSchemeContributions(String schemeID ,String profileID) throws JSONException{
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/gettotalschemecontributions/" + schemeID+"/"+profileID);
            return response.toString();
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        }
    }
    public String getMemberContributions(String memberID) throws JSONException{
        Setting settings = getSettings();
        try {
            JSONObject response = URLGet(settings.getXiPath() + "getmembercontributions/" + memberID);
            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                List<String> years = new ArrayList<>();

                for(int i = 0; i < res.length(); i ++)
                {

                    JSONObject jsonobj = res.getJSONObject(i);

                    if(!years.contains(jsonobj.get("year").toString()))
                        years.add(jsonobj.get("year").toString());

                }

                Set<String> hs = new HashSet<>();
                hs.addAll(years);
                years.clear();
                years.addAll(hs);

                Collections.sort(years);

                String[] year = years.toArray(new String[years.size()]);

                JSONArray json_array = new JSONArray();

                for (String aYear : year) {

                    JSONArray data = new JSONArray();

                    double yearTotal = 0;

                    for (int i = 0; i < res.length(); i++) {

                        JSONObject obj = new JSONObject();

                        JSONObject jsonobj = res.getJSONObject(i);

                        if (jsonobj.get("year").toString().equals(aYear)) {

                            obj.put("year", aYear);

                            obj.put("month", jsonobj.get("month").toString());

                            obj.put("total", String.valueOf(round(Double.parseDouble(jsonobj.get("total").toString()))));

                            try {
                                yearTotal += Double.parseDouble(jsonobj.get("total").toString());
                            } catch (Exception ex) {
                                yearTotal += 0;
                            }

                            data.put(obj);

                        }

                    }

                    json_array.put(new JSONObject().put("year", aYear).put("total", round(yearTotal))).put(data);
                }

                return new JSONObject().put(Helper.SUCCESS, true).put(Helper.ROWS, json_array).toString();

            }
            else
            {
                return response.toString();
            }
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }
    }
    public List<UserProfile> getUserProfiles() {
        try {
            Setting settings = getSettings();
            List<UserProfile> uprofiles = new ArrayList<>();
            JSONObject response = URLGet(settings.getXiPath() + "profile/getprofiles");
            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i++){

                    JSONObject jsonobj = res.getJSONObject(i);

                    UserProfile uprofile = new UserProfile(jsonobj.getLong("id"), jsonobj.get("name").toString());

                    uprofiles.add(uprofile);

                }

                return uprofiles;
            }
            else
            {
                return null;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public String getMemberCummulativeInterest(String memberID)
    {
        Setting settings = getSettings();
        try
        {
            //JSONObject response = URLPost(settings.getXiPath() + "getmembercummulativeinterest.json", "");
            JSONObject response = URLPost(settings.getXiPath() + "getmembercummulativeinterest/" + memberID, "", "application/x-www-form-urlencoded");
            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public String getAccountingPeriod(String date, String schemeID)
    {
        Setting settings = getSettings();
        try
        {
            //JSONObject response = URLPost(settings.getXiPath() + "getaccountingperiodfromdateforscheme.json", "");
            JSONObject response = URLPost(settings.getXiPath() + "getaccountingperiodfromdateforscheme/" + date + "/" + schemeID, "", "application/x-www-form-urlencoded");
            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public String getFundValue(String accountinPeriodId, String schemeID,String profileID)
    {
        Setting settings = getSettings();
        try
        {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getfundvalue/" + accountinPeriodId + "/" + schemeID+"/"+profileID);
            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public String getFundValueAsAt(String date,String accountinPeriodId, String schemeID,String profileID)
    {
        Setting settings = getSettings();
        try
        {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getfundvalueasat/"+date+"/" + accountinPeriodId + "/" + schemeID+"/"+profileID);
            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public String getSchemeCurrency(String schemeID)
    {
        Setting settings = getSettings();
        try
        {
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebasecurrency/" + schemeID);
            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public String getMemberAverageInterest(String memberID)
    {
        Setting settings = getSettings();
        try
        {
            JSONObject response = URLPost(settings.getXiPath() + "getmemberaverageinterest/" + memberID, "", "application/x-www-form-urlencoded");
            return response.toString();
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public boolean isManager(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        boolean member_manager;
        try {
            member_manager = session.getAttribute(Constants.MANAGER_PROFILE).equals(Constants.MANAGER);
        } catch (Exception e)
        {
            member_manager = false;
        }
        return member_manager;
    }

    public String shorterUUID(String uuid, int index)
    {
        try {
            String[] uuids = uuid.split("-");
            return uuids[index].toUpperCase();
        } catch (IndexOutOfBoundsException iOOB) {
            return uuid.toUpperCase();
        } catch (NullPointerException npe) {
            return uuid.toUpperCase();
        }
    }

    public String[] listProfiles()
    {
        return new String[]{"MEMBER", "ADMINISTRATOR", "SPONSOR", "TRUSTEE", "AGENT", "CUSTODIAN", "CUSTOMER_RELATIONSHIP_MANAGER", "CUSTOMER_RELATIONSHIP_EXECUTIVE", "FUND_MANAGER", "PENSIONER"};
    }

    public boolean isManagerial(String profile)
    {
        String[] profiles = listProfiles();
        for (String profile1 : profiles)
            if (profile1.equals(profile))
                return true;
        return false;
    }
    public User findUserByCode(String code)
    {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findBySecurityCode(code);
    }
    public List<Scheme> getSchemes(int start, int count) throws JSONException {
        Constants.RECORD_COUNT = 0;
        try
        {
            Setting settings = getSettings();
            List<Scheme> schemes = new ArrayList<>();
            JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemes/?start=" + start + "&size=" + count);
            if(response.get(Helper.SUCCESS).equals(true))
            {

                Constants.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i++){

                    JSONObject jsonobj = res.getJSONObject(i);

                    Scheme scheme = new Scheme(Long.valueOf(jsonobj.getString("id")).longValue(), jsonobj.getString("schemePin"), jsonobj.getString("schemeName"), jsonobj.getString("schemeType"), jsonobj.getString("schemePin"), jsonobj.getString("planType"), jsonobj.getString("sector"));

                    schemes.add(scheme);

                }

                return schemes;
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {

            throw new JSONException("JSON Exeption found");

        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public List<Scheme> getProfileSchemes(String user, String profile) {
        try
        {
            Setting settings = getSettings();
            List<Scheme> schemes = new ArrayList<>();

            String ordinal = getLoginField(profile);
            JSONObject response = URLPost(settings.getXiPath() + "getmemberschemes/" + ordinal + "/" + user + "/" + profile, "", "application/x-www-form-urlencoded");

            if(response.get(Helper.SUCCESS).equals(true))
            {

                JSONArray res = (JSONArray) response.get(Helper.ROWS);

                for(int i = 0; i < res.length(); i++){

                    JSONObject jsonobj = res.getJSONObject(i);

                    Scheme scheme = new Scheme(Long.valueOf(jsonobj.get("id").toString()).longValue(), "1", jsonobj.getString("name"), "1", "1", jsonobj.getString("planType"), "1");

                    schemes.add(scheme);

                }

                return schemes;
            }
            else
            {


                return null;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public List<Country> getCountries()
    {
        CountryDAO dao = new CountryDAO(entityManager);
        return dao.findAll();
    }

    public List<Gender> getGenders()
    {

        GenderDAO dao = new GenderDAO(entityManager);
        return dao.findAll();
    }

    public List<MaritalStatus> getMaritalStatuses()
    {

        MaritalStatusDAO dao = new MaritalStatusDAO(entityManager);
        return dao.findAll();
    }

    public Company getCompany()
    {

        CompanyDAO dao = new CompanyDAO(entityManager);
        return dao.find();
    }

    public Social getSocial()
    {

        SocialDAO dao = new SocialDAO(entityManager);
        return dao.findById(Long.valueOf("1"));
    }

    public List<ActivityLog> getActivityLogs(String user_id)
    {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        return dao.findAllByUserID(user_id);
    }

    public Setting getSettings()
    {

        SettingDAO dao = new SettingDAO(entityManager);
        Setting settings = dao.findById(Long.valueOf("1"));
        if(settings.isEncrypt())
        {

            settings.setXiPath(decrypt(settings.getXiPath()));
            settings.setPassword(decrypt(settings.getPassword()));
            settings.setUsername(decrypt(settings.getUsername()));
            settings.setXiReportPath(decrypt(settings.getXiReportPath()));
            settings.setXiReportUsername(decrypt(settings.getXiReportUsername()));
            settings.setXiReportPassword(decrypt(settings.getXiReportPassword()));
        }
        return settings;
    }

    public Menu getMenu()
    {

        MenuDAO dao = new MenuDAO(entityManager);
        return dao.find();
    }

    public List<Banner> getBanners()
    {

        BannerDAO dao = new BannerDAO(entityManager);
        return dao.findAll();
    }

    public List<Sector> getSectors()
    {

        SectorDAO dao = new SectorDAO(entityManager);
        return dao.findAll();
    }

    public Theme getTheme()
    {

        ThemeDAO dao  = new ThemeDAO(entityManager);
        return dao.find();
    }

    public MemberPermission getMemberPermissions()
    {

        MemberPermissionDAO dao = new MemberPermissionDAO(entityManager);
        return dao.find();
    }

    public Media getMediaById(Long id)
    {
        MediaDAO dao = new MediaDAO(entityManager);
        return dao.findById(id);
    }

    public List<Media> getMedia(String schemeID, String profile, String memberId)
    {

        MediaDAO dao = new MediaDAO(entityManager);
        return dao.findAll(schemeID, profile, memberId);
    }
    @EJB
    ActivityLogEJB activityLogEJB;
    public void logActivity(String access_menu, String description, String userID, String scheme, String userProfile)
    {
        activityLogEJB.add(new ActivityLog(description, new Date(), Long.valueOf(userID).longValue(), scheme, access_menu, userProfile));
    }

}
