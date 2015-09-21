package com.fundmaster.mss.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.common.Crypta;
import com.fundmaster.mss.model.ActivityLog;
import com.fundmaster.mss.model.AnnuityProduct;
import com.fundmaster.mss.model.AuditTrail;
import com.fundmaster.mss.model.Banner;
import com.fundmaster.mss.model.Beneficiary;
import com.fundmaster.mss.model.BenefitPayment;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.ContactCategory;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Gender;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.InterestRateColumns;
import com.fundmaster.mss.model.MaritalStatus;
import com.fundmaster.mss.model.Media;
import com.fundmaster.mss.model.Member;
import com.fundmaster.mss.model.MemberPermission;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.Ordinal;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.PasswordPolicy;
import com.fundmaster.mss.model.PensionProduct;
import com.fundmaster.mss.model.Permission;
import com.fundmaster.mss.model.PieObject;
import com.fundmaster.mss.model.ProfileLoginField;
import com.fundmaster.mss.model.Scheme;
import com.fundmaster.mss.model.SchemeMemberManager;
import com.fundmaster.mss.model.SchemeReceipt;
import com.fundmaster.mss.model.Sector;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Sponsor;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.model.User;
import com.fundmaster.mss.model.UserProfile;
import com.fundmaster.mss.model.XiMember;
import com.fundmaster.mss.service.ActivityLogService;
import com.fundmaster.mss.service.AuditTrailService;
import com.fundmaster.mss.service.BannerService;
import com.fundmaster.mss.service.CompanyService;
import com.fundmaster.mss.service.ContactCategoryService;
import com.fundmaster.mss.service.CountryService;
import com.fundmaster.mss.service.GenderService;
import com.fundmaster.mss.service.HelpService;
import com.fundmaster.mss.service.InterestRateColumnsService;
import com.fundmaster.mss.service.MaritalStatusService;
import com.fundmaster.mss.service.MediaService;
import com.fundmaster.mss.service.MemberPermissionService;
import com.fundmaster.mss.service.MemberService;
import com.fundmaster.mss.service.MenuService;
import com.fundmaster.mss.service.PageContentService;
import com.fundmaster.mss.service.PasswordPolicyService;
import com.fundmaster.mss.service.PermissionService;
import com.fundmaster.mss.service.ProfileLoginFieldService;
import com.fundmaster.mss.service.SchemeMemberManagerService;
import com.fundmaster.mss.service.SectorService;
import com.fundmaster.mss.service.SettingService;
import com.fundmaster.mss.service.SocialService;
import com.fundmaster.mss.service.SponsorService;
import com.fundmaster.mss.service.ThemeService;
import com.fundmaster.mss.service.UsedPasswordService;
import com.fundmaster.mss.service.UserService;


public class GenericController extends HttpServlet implements Serializable{

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

	private static final long serialVersionUID = 1L;
	public Date dateFromString(String date, String ft)
	{

		DateFormat format = new SimpleDateFormat(ft, Locale.ENGLISH);
		try {
			return (Date) format.parse(date);
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
	
	public List<AuditTrail> getFrequenters(String from, String to)
	{
		AuditTrailService service = new AuditTrailService();
		return service.frequenters(from, to);
	}
	public List<User> getDormants(String from, String to)
	{
		UserService service = new UserService();
		return service.dormants(from, to);
	}
	public void logAttempt(String username)
	{
		UserService uService = new UserService();
		User u = uService.findByUsername(username);
		PasswordPolicy policy = getPasswordPolicy();
		if(u != null)
		{
			u.setAttempt(u.getAttempt() + 1);
			if(u.getAttempt() >= policy.getLock_after_count_of())
			{
				u.setStatus(false);
			}
		}
		uService.update(u);
	}
	 public Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return new Date(cal.getTime().getTime());
    }
	public boolean isUsedPassword(String password)
	{
		UsedPasswordService uService = new UsedPasswordService();
		return uService.isUsed(hash(password));
	}
	public void resetAttempt(String username)
	{
		UserService uService = new UserService();
		User u = uService.findByUsername(username);
		if(u != null)
		{
			u.setAttempt(0);
		}
		uService.update(u);
	}
	public PasswordPolicy getPasswordPolicy()
	{
		PasswordPolicyService pPService = new PasswordPolicyService();
		List<PasswordPolicy> policies = pPService.findAll();
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
		MemberService mService = new MemberService();
		return mService.findAll(agentId, search, start, count);
	}
	public List<Sponsor> getPortalSponsors(String agentId, String search, int start, int count)
	{
		SponsorService sService = new SponsorService();
		return sService.findAll(agentId, search, start, count);
	}
	
	public int countPortalMembers(String search)
	{
		MemberService mService = new MemberService();
		return mService.countAll(search);
	}
	public int countSponsors(String search)
	{
		SponsorService sService = new SponsorService();
		return sService.countAll(search);
	}
	public String decrypt(String string)
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

	protected void audit(HttpSession session, String description)
	{
		logAuditTrail(session.getAttribute(Common.USER).toString(), session.getAttribute(Common.U_PROFILE).toString(), description);
	}
	private boolean isHttps(String link)
	{
		return link.trim().substring(0, Math.min(link.length(), 5)).equalsIgnoreCase(HTTPS);
	}
	/* GET Request to URL */
	
	public  JSONObject URLGet(String link) throws JSONException {
		
		JSONObject json = null;
		if(isHttps(link))
			json = HttpsGet(link);
		else
			json = HttpGet(link);
		return json;
	}

	private JSONObject HttpsGet(String link) throws JSONException
	{
		Setting settings = getSettings();
		StringBuilder sb = new StringBuilder();
		HttpsURLConnection httpConn = null;
		InputStreamReader in = null;
		JSONObject json = null;
		try {
			URL url = new URL(link);
			Logger.getAnonymousLogger().info("Getting..." + link);
			httpConn = (HttpsURLConnection) url.openConnection();
			if (httpConn != null)
			{
				httpConn.setRequestMethod(HTTP_GET);
				httpConn.setReadTimeout(TIMEOUT);
				httpConn.setRequestProperty(USERNAME, settings.getUsername());
				httpConn.setRequestProperty(PASSWORD, settings.getPassword());
			}
			if (httpConn != null && httpConn.getInputStream() != null) {
				try {
					in = new InputStreamReader(httpConn.getInputStream(),
							Charset.defaultCharset());
					BufferedReader bufferedReader = new BufferedReader(in);
					if (bufferedReader != null) {
						int cp;
						while ((cp = bufferedReader.read()) != -1) {
							sb.append((char) cp);
						}
						bufferedReader.close();
					}
				} catch (Exception ex)
				{
					json = new JSONObject();
					json.put(SUCCESS, false);
					json.put(MESSAGE, "An error was encountered fetching the data from the url. " + ex.getMessage());
					return json;
				}
			}
		in.close();
		} catch (Exception e) {
			json = new JSONObject();
			json.put(SUCCESS, false);
			json.put(MESSAGE, "An error was encountered fetching the data from the url2. " + e.getMessage());
			return json;
		} 
		String return_sting = sb.toString().trim().replace("\\", "");
		Logger.getAnonymousLogger().info("Fetched..." + return_sting);
		
		try {
			json = new JSONObject(return_sting);
		} catch (JSONException e) {
			json = new JSONObject();
			try {
				json.put(SUCCESS, false);
			} catch (JSONException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				json.put(MESSAGE, return_sting);
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
		HttpURLConnection httpConn = null;
		InputStreamReader in = null;
		JSONObject json = null;
		try {
			URL url = new URL(link);
			Logger.getAnonymousLogger().info("Getting..." + link);
			httpConn = (HttpURLConnection) url.openConnection();
			if (httpConn != null)
			{
				httpConn.setRequestMethod(HTTP_GET);
				httpConn.setReadTimeout(TIMEOUT);
				httpConn.setRequestProperty(USERNAME, settings.getUsername());
				httpConn.setRequestProperty(PASSWORD, settings.getPassword());
			}
			if (httpConn != null && httpConn.getInputStream() != null) {
				try {
					in = new InputStreamReader(httpConn.getInputStream(),
							Charset.defaultCharset());
					BufferedReader bufferedReader = new BufferedReader(in);
					if (bufferedReader != null) {
						int cp;
						while ((cp = bufferedReader.read()) != -1) {
							sb.append((char) cp);
						}
						bufferedReader.close();
					}
				} catch (Exception ex)
				{
					json = new JSONObject();
					json.put(SUCCESS, false);
					json.put(MESSAGE, "An error was encountered fetching the data from the url. " + ex.getMessage());
					return json;
				}
			}
		in.close();
		} catch (Exception e) {
			json = new JSONObject();
			json.put(SUCCESS, false);
			json.put(MESSAGE, "An error was encountered fetching the data from the url2. " + e.getMessage());
			return json;
		} 
		String return_sting = sb.toString().trim().replace("\\", "");
		Logger.getAnonymousLogger().info("Fetched..." + return_sting);
		
		try {
			json = new JSONObject(return_sting);
		} catch (JSONException e) {
			json = new JSONObject();
			try {
				json.put(SUCCESS, false);
			} catch (JSONException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				json.put(MESSAGE, return_sting);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return json;
		}
		return json;
	}
	public List<User> findByStatus(int status)
	{
		UserService uService = new UserService();
		return uService.findByStatus(status);
	}
	public boolean logAuditTrail(String username, String profile, String description)
	{
		AuditTrailService atService = new AuditTrailService();
		AuditTrail at = new AuditTrail();
		at.setDescription(description);
		at.setProfile(profile);
		at.setUsername(username);
		atService.update(at);
		return true;
	}
	
	public Permission getPermissions(String profile)
	{
		return new PermissionService().findByProfile(profile);
	}
	
	public List<SchemeMemberManager> getSchemeManagers()
	{
		SchemeMemberManagerService smmService = new SchemeMemberManagerService();
		return smmService.findAll();
	}
	
	public String frontPageAccessByPage() throws JSONException
	{
		ActivityLogService alService = new ActivityLogService();
		List<PieObject> poList = alService.findByFrontPageAccess();
		JSONObject access_list = new JSONObject().put(SUCCESS, true);
		for(int i = 0; i < poList.size(); i ++)
		{
			access_list.put(poList.get(i).getName(), poList.get(i).getCount());
		}
		return access_list.toString();
	}
	
	public String profileAccess() throws JSONException
	{
		ActivityLogService alService = new ActivityLogService();
		List<PieObject> poList = alService.findAccessByProfile();
		JSONObject access_list = new JSONObject().put(SUCCESS, true);
		for(int i = 0; i < poList.size(); i ++)
		{
			access_list.put(poList.get(i).getName(), poList.get(i).getCount());
		}
		return access_list.toString();
	}
	public String mostAccessedByMembers() throws JSONException
	{
		ActivityLogService alService = new ActivityLogService();
		List<PieObject> poList = alService.mostAccessedByMembers();
		JSONObject access_list = new JSONObject().put(SUCCESS, true);
		for(int i = 0; i < poList.size(); i ++)
		{
			access_list.put(poList.get(i).getName(), poList.get(i).getCount());
		}
		return access_list.toString();
	}
	public String mostAccesssedByManagers() throws JSONException
	{
		ActivityLogService alService = new ActivityLogService();
		List<PieObject> poList = alService.mostAccessedByManagers();
		JSONObject access_list = new JSONObject().put(SUCCESS, true);
		for(int i = 0; i < poList.size(); i ++)
		{
			access_list.put(poList.get(i).getName(), poList.get(i).getCount());
		}
		return access_list.toString();
	}
	public SchemeMemberManager getSchemeManager(Long userid)
	{
		SchemeMemberManagerService smmService = new SchemeMemberManagerService();
		return smmService.findByUserID(userid);
	}
	
	public List<ContactCategory> getContactReasons()
	{
		ContactCategoryService ccService = new ContactCategoryService();
		return ccService.findAll();
	}
	
	public List<AuditTrail> getAuditTrails(String search, int offset, int limit)
	{
		AuditTrailService atService = new AuditTrailService();
		return atService.findAll(search, offset, limit);
	}
	
	public int getAuditCount(String search)
	{
		AuditTrailService atService = new AuditTrailService();
		return atService.countAll(search);
	}
	/* POST Request to URL */
	
	public  JSONObject URLPost(String link, String params, String encoding) throws JSONException {
		JSONObject json = null;
		if(isHttps(link))
			json = HttpsPost(link, params, encoding);
		else
			json = HttpPost(link, params, encoding);
		return json;
	}
	
	private JSONObject HttpsPost(String link, String params, String encoding) throws JSONException
	{
		Setting settings = getSettings();
		StringBuilder sb = new StringBuilder();
		HttpsURLConnection urlConn = null;
		InputStreamReader in = null;
		JSONObject json;
		try {
			URL url = new URL(link);
			urlConn = (HttpsURLConnection) url.openConnection();

			Logger.getAnonymousLogger().info("Posting..." + link);
			if (urlConn != null)
			{	
				urlConn.setRequestMethod(HTTP_POST);
				urlConn.setRequestProperty(CONTENT_TYPE, encoding);
				urlConn.setReadTimeout(TIMEOUT);
				urlConn.setRequestProperty(USERNAME, settings.getUsername());
				urlConn.setRequestProperty(PASSWORD, settings.getPassword());
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
						if (bufferedReader != null) {
							int cp;
							while ((cp = bufferedReader.read()) != -1) {
								sb.append((char) cp);
							}
							bufferedReader.close();
						}
					} catch (Exception ex)
					{
						ex.printStackTrace();
						Logger.getAnonymousLogger().info("Exception1: " + ex.getMessage());
						json = new JSONObject();
						json.put(SUCCESS, false);
						json.put(MESSAGE, "An error was encountered fetching the data from the url. " + ex.getMessage());
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
			Logger.getAnonymousLogger().info("Exception: " + e.getMessage());
			json = new JSONObject();
			json.put(SUCCESS, false);
			json.put(MESSAGE, "An error was encountered fetching the data from the url. " + e.getMessage());
			return json;
		} 
		Logger.getAnonymousLogger().info("Fetched..." + sb.toString());

		json = new JSONObject(sb.toString().trim());
		return json;
	}
	
	private JSONObject HttpPost(String link, String params, String encoding) throws JSONException
	{
		Setting settings = getSettings();
		StringBuilder sb = new StringBuilder();
		HttpURLConnection urlConn = null;
		InputStreamReader in = null;
		JSONObject json;
		try {
			URL url = new URL(link);
			urlConn = (HttpURLConnection) url.openConnection();

			Logger.getAnonymousLogger().info("Posting..." + link);
			if (urlConn != null)
			{	
				urlConn.setRequestMethod(HTTP_POST);
				urlConn.setRequestProperty(CONTENT_TYPE, encoding);
				urlConn.setReadTimeout(TIMEOUT);
				urlConn.setRequestProperty(USERNAME, settings.getUsername());
				urlConn.setRequestProperty(PASSWORD, settings.getPassword());
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
						if (bufferedReader != null) {
							int cp;
							while ((cp = bufferedReader.read()) != -1) {
								sb.append((char) cp);
							}
							bufferedReader.close();
						}
					} catch (Exception ex)
					{
						ex.printStackTrace();
						Logger.getAnonymousLogger().info("Exception1: " + ex.getMessage());
						json = new JSONObject();
						json.put(SUCCESS, false);
						json.put(MESSAGE, "An error was encountered fetching the data from the url. " + ex.getMessage());
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
			Logger.getAnonymousLogger().info("Exception: " + e.getMessage());
			json = new JSONObject();
			json.put(SUCCESS, false);
			json.put(MESSAGE, "An error was encountered fetching the data from the url. " + e.getMessage());
			return json;
		} 
		Logger.getAnonymousLogger().info("Fetched..." + sb.toString());

		json = new JSONObject(sb.toString().trim());
		return json;
	}
	public  String hash(String password)
	{
	    String sha1 = "";
	    try
	    {
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(password.getBytes("UTF-8"));
	        sha1 = byteToHex(crypt.digest());
	    }
	    catch(NoSuchAlgorithmException e)
	    {
	        e.printStackTrace();
	    }
	    catch(UnsupportedEncodingException e)
	    {
	        e.printStackTrace();
	    }
	    return sha1;
	}


	public  String byteToHex(final byte[] hash)
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
	
	public boolean create_member(Member m)
	{
		MemberService mService = new MemberService();
		try {
			mService.update(m);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean create_user(User u)
	{
		UserService uService = new UserService();
		u.setPassword(hash(u.getPassword()));
		try {
			uService.persist(u);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public InterestRateColumns getInterestRateColumns()
	{
		InterestRateColumnsService iService = new InterestRateColumnsService();
		return iService.findById(Long.valueOf("1").longValue());
	}
	
	public JSONObject result(boolean status, String message) throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj.put(SUCCESS, status);
		obj.put(MESSAGE, message);
		return obj;
	}
	
	public String getLoginField(String profile)
	{
		ProfileLoginFieldService pSerice = new ProfileLoginFieldService();
		ProfileLoginField plf = pSerice.findByProfile(profile);
		return plf.getOrdinal();
	}
	
	public ProfileLoginField getProfileLoginField(String profile)
	{
		ProfileLoginFieldService pSerice = new ProfileLoginFieldService();
		ProfileLoginField plf = pSerice.findByProfile(profile);
		return plf;
	}
	
	public List<ProfileLoginField> getProfileLoginFields()
	{
		ProfileLoginFieldService pSerice = new ProfileLoginFieldService();
		return pSerice.findAll();
	}
	
	public JSONObject memberExists(String profile, String idNumber, Boolean known) throws JSONException, IOException
	{
		
			Setting settings = getSettings();
			
			String ordinal;
			
			if(!known)
			{				
				ordinal = getLoginField(profile);
			}
			else
				ordinal = "EMAIL";

			JSONObject response = URLPost(settings.getXiPath() + "checkMemberExists/" + ordinal  + "/" + idNumber + "/" + profile, "", "application/x-www-form-urlencoded");
			
			if(response.get(SUCCESS).equals(true))
			{
				return response;
			}
			else
			{
				return null;
			}
				
	}
	
	public String profileExistsInScheme(String profile, String idNumber, String schemeID) throws JSONException, IOException
	{
		
			Setting settings = getSettings();
			
			String ordinal = getLoginField(profile);

			JSONObject response = URLGet(settings.getXiPath() + "checkMemberExistsInScheme/" + ordinal + "/" + idNumber + "/" + profile + "/" + schemeID);
			
			if(response.get(SUCCESS).equals(true))
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
	
	public JSONObject getProviderDetails(String profile, String identifier) throws JSONException, UnsupportedOperationException, IOException
	{
		
		Setting settings = getSettings();
		
		JSONObject response = URLGet(settings.getXiPath() + "serviceprovider/get/" + profile + "/" + identifier);
		
		return response;
		
	}
	
	public JSONObject saveOrUpdateSponsor(String params) throws JSONException
	{
		
		Setting settings = getSettings();
		
		JSONObject response = URLPost(settings.getXiPath() + "sponsor/saveorupdatepotentialsponsor", params, "application/json");
		
		return response;
		
	}
	
	public JSONObject saveOrUpdateMember(String params) throws JSONException
	{
		
		Setting settings = getSettings();
		
		JSONObject response = URLPost(settings.getXiPath() + "saveorupdatemember", params, "application/json");
		
		return response;
		
	}
	
	public User findByUsernameAndProfile(String username, String profile)
	{
		UserService uService = new UserService();
		return uService.findUserByUsernameAndProfile(username, profile);
	}
	
	public List<PensionProduct> getPensionProduct()
	{
		return null;
	}
	public String getOrdinalKey(String ordinal)
	{
		if(ordinal.equals("EMAIL"))
			return "email";
		else if(ordinal.equals("MEMBER_NO"))
			return "memberNo";
		else if(ordinal.equals("NATIONAL"))
			return "idNo";
		else if(ordinal.equals("MEMBER_ID"))
			return "id";
		else if(ordinal.equals("PIN"))
			return "pinNo";
		else
			return null;
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
		Ordinal ordinal12 = new Ordinal(Long.valueOf("12").longValue(), "MEMBER_ID", "Member ID");
		List<Ordinal> ordinals = new ArrayList<Ordinal>();
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
	
	public User getUser(Long userID)
	{
		UserService uService = new UserService();
		return uService.findById(userID);
	}
	
	public List<Help> getHelp()
	{
		HelpService hService = new HelpService();
		return hService.findAll();
	}
	
	public List<User> getUsers(String search, int start, int count)
	{
		UserService uService = new UserService();
		return uService.findAll(search, start, count);
	}
	public int countUsers(String search)
	{
		UserService uService = new UserService();
		return uService.countAll(search);
	}
	public List<PageContent> getPageContent()
	{
		PageContentService pcService = new PageContentService();
		return pcService.findAll();
	}
	
	public PageContent getPageContentByPage(String page)
	{
		PageContentService pcService = new PageContentService();
		return pcService.findPageContent(page);
	}
	
	public Help getHelpByPage(String page)
	{
		HelpService hService = new HelpService();
		return hService.findHelp(page);
	}
	public Help getHelpByID(Long id)
	{
		HelpService hService = new HelpService();
		return hService.findById(id);
	}
	public PageContent getPageContentByID(Long id)
	{
		PageContentService pcService = new PageContentService();
		return pcService.findById(id);
	}
	public User login(String username, String password)
	{
		UserService uService = new UserService();
		return uService.findUser(username, hash(password));
	}

	public boolean userExists(String username, String profile)
	{
		UserService uService = new UserService();
		User u = uService.find(username, profile);
		try
		{
			if(!u.equals(null))
				return true;
			else
				return false;
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
		String date_string = request.getParameter("applicationDate").toString();
		Date date = null;
		try {
			date = (Date) format.parse(date_string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sponsor sponsor = new Sponsor();
		sponsor.setApplicationDate(date);
		sponsor.setCity(request.getParameter("city").toString());
		sponsor.setCompanyAddress(request.getParameter("address").toString());
		sponsor.setCompanyName(request.getParameter("name").toString());
		CountryService cService = new CountryService();
		Country country = cService.findById(Long.valueOf(request.getParameter("country").toString()).longValue());
		sponsor.setCountry(country);
		sponsor.setEmailAddress(request.getParameter("email").toString());
		sponsor.setEmployerRefNo(request.getParameter("employerNo").toString());
		sponsor.setPhoneNumber(request.getParameter("phone").toString());
		sponsor.setPinNumber(request.getParameter("pinNo").toString());
		sponsor.setScheme(request.getParameter("scheme").toString());
		try {
			if(session.getAttribute(Common.U_PROFILE).equals(Common.AGENT_PROFILE))
			{
				sponsor.setAgentId(Common.PROFILE_ID);
			}
		} catch (NullPointerException e)
		{
			Logger.getAnonymousLogger().info("Non-logged in user trying to create sponsor");
		}
		SectorService sService = new SectorService();
		Sector sector = sService.findById(Long.valueOf(request.getParameter("sector").toString()).longValue());
		sponsor.setSector(sector);
		JSONObject result = null;
		if(settings.getSponsorOnboading().equals(MSS) || settings.getSponsorOnboading().equals(BOTH))
		{
			SponsorService sponsorService = new SponsorService();
			try {
				sponsorService.update(sponsor);
				result = result(true, "Sponsor details have been successfully saved.");
			} catch (Exception ex)
			{
				try {
					result = result(false, "Sponsor details could not be saved. We apologise for the inconvenience.");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(settings.getSponsorOnboading().equals(XI) || settings.getSponsorOnboading().equals(BOTH))
		{
			result = postSponsorToXi(sponsor);
		}
		return result;
	}
	public Member getMemberByIDNumber(String idNumber)
	{
		MemberService mService = new MemberService();
		return mService.findByIDNumber(idNumber);
	}
	public Member getMemberByID(String memberID)
	{
		MemberService mService = new MemberService();
		return mService.findById(Long.valueOf(memberID).longValue());
	}
	public JSONObject postSponsorToXi(Sponsor sponsor)
	{
		DateFormat format_ = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
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
			Logger.getAnonymousLogger().info(jsponsor.toString().toString());
			result = saveOrUpdateSponsor(jsponsor.toString());
			if(result.get(SUCCESS).equals(true))
			{
				SponsorService sService = new SponsorService();
				sponsor.setPosted(true);
				sService.update(sponsor);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public JSONObject postMemberToXi(Member m)
	{
		DateFormat format_ = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
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
			Logger.getAnonymousLogger().info(member.toString());
			result = saveOrUpdateMember(member.toString());
			if(result.get(SUCCESS).toString().equalsIgnoreCase("true"))
			{
				m.setPosted(true);
				MemberService mService = new MemberService();
				mService.update(m);
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
		CountryService cService = new CountryService();
		Country country = cService.findById(Long.valueOf(request.getParameter("country")).longValue());
		GenderService gService = new GenderService();
		Gender gender = gService.findById(Long.valueOf(request.getParameter("gender")).longValue());
		MaritalStatusService msService = new MaritalStatusService();
		MaritalStatus mStatus = msService.findById(Long.valueOf(request.getParameter("maritalStatus")));
		String date_string = request.getParameter("dateOfBirth");
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date date = null;
		JSONObject result = null;
		try {
			date = (Date) format.parse(date_string);
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
			if(session.getAttribute(Common.U_PROFILE).equals(Common.AGENT_PROFILE))
			{
				m.setAgentId(Common.PROFILE_ID);
			}
		} catch (NullPointerException e)
		{
			Logger.getAnonymousLogger().info("Non-logged in user trying to create member");
		}
		if(settings.getMemberOnboarding().equals(MSS) || settings.getMemberOnboarding().equals(BOTH))
		{
			try {
				create_member(m);
				result = result(true, "Member details successfully saved");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		if(settings.getMemberOnboarding().equals(XI) || settings.getMemberOnboarding().equals(BOTH))
		{
			result = postMemberToXi(m);						
		}
		return result;
	}
	public List<Scheme> getSchemeByPlanType(String planType) throws JSONException, IOException
	{
			try
			{
				Setting settings = getSettings();
				List<Scheme> schemes = new ArrayList<Scheme>();
				JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebyplantype/" + planType);
				if(response.get(SUCCESS).equals(true))
				{
					
					JSONArray res = (JSONArray) response.get(ROWS);

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

	public List<AnnuityProduct> getAnnuityProducts() throws JSONException, IOException
	{
			try {
				Setting settings = getSettings();
				List<AnnuityProduct> annuityProducts = new ArrayList<AnnuityProduct>();
				JSONObject response = URLGet(settings.getXiPath() + "annuity_quote/getannuityproducts");
				if(response.get(SUCCESS).equals(true))
				{
					
					JSONArray res = (JSONArray) response.get(ROWS);

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
			}
			catch (Exception ex)
			{ 
				return null;
			}
	}
	public List<Scheme> getSchemeBySchemeMode(String schemeMode) throws JSONException, IOException
	{
		try
		{
			Setting settings = getSettings();
			List<Scheme> schemes = new ArrayList<Scheme>();
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebyschememode/" + schemeMode);
			if(response.get(SUCCESS).equals(true))
			{
				
				JSONArray res = (JSONArray) response.get(ROWS);

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

	
	public List<Scheme> getSchemeBySchemeModeAndPlanType(String schemeMode, String planType) throws JSONException, IOException
	{
		try
		{
			Setting settings = getSettings();
			List<Scheme> schemes = new ArrayList<Scheme>();
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebyschememodeandplantype/" + schemeMode + "/" + planType);
			if(response.get(SUCCESS).equals(true))
			{
				
				JSONArray res = (JSONArray) response.get(ROWS);

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
	public String getAnnuityQuote(String agentId, String calculationMode, String productID, String lastName, String firstName, String otherNames, String idNumber, String address, String email, String phoneNumber, String purchaseDate, String pensionStartDate, String dateOfBirth, String gender, String guaranteedPercentage, String annuityIncrement, String paymentMode, String paymentFrequency, String registeredPurchasePrice, String unRegisteredPurchasePrice, String targetPension, String annuityMode, String spouseReversal, String spouseGender, String spouseDateOfBirth) throws JSONException, IOException
	{
			Setting settings = getSettings();
			String urlParameters = "annuityProductId=" + productID + "&" + "surname=" + lastName + "&" + "firstName=" + firstName + "&" + "otherNames=" + otherNames + "&" + "idNo=" + idNumber + "&" + "address=" + address + "&" + "email=" + email + "&" + "mobileNo=" + phoneNumber + "&" + "purchaseDate=" + purchaseDate + "&" + "pensionStartDate=" + pensionStartDate + "&" + "dob=" + dateOfBirth + "&" + "gender=" + gender.toUpperCase() + "&" + "guaranteedPerc=" + guaranteedPercentage + "&" + "annuityIncrement=" + annuityIncrement + "&" + "paymentMode=" + paymentMode + "&" + "paymentFrequency=" + paymentFrequency + "&" + "spouseReversal=" + spouseReversal + "&" + "dobSpouse=" + spouseDateOfBirth + "&" + "spouseGender=" + spouseGender.toUpperCase() + "&" + "regPurchasePrice=" + registeredPurchasePrice + "&" + "unRegPurchasePrice=" + unRegisteredPurchasePrice + "&" + "calcMode=" + calculationMode + "&" + "targetPension=" + targetPension + "&" + "agentId=" + agentId + "&" + "annuityMode=" + annuityMode;
			Logger.getAnonymousLogger().info(urlParameters);
			//String urlParameters = "annuityProductId=" + URLEncoder.encode(productID, StandardCharsets.UTF_8.toString()) + "&" + "surname=" + URLEncoder.encode(lastName, StandardCharsets.UTF_8.toString()) + "&" + "firstName=" + URLEncoder.encode(firstName, StandardCharsets.UTF_8.toString()) + "&" + "otherNames=" + URLEncoder.encode(otherNames, StandardCharsets.UTF_8.toString()) + "&" + "idNo=" + URLEncoder.encode(idNumber, StandardCharsets.UTF_8.toString()) + "&" + "address=" + URLEncoder.encode(address, StandardCharsets.UTF_8.toString()) + "&" + "email=" + URLEncoder.encode(email, StandardCharsets.UTF_8.toString()) + "&" + "mobileNo=" + URLEncoder.encode(phoneNumber, StandardCharsets.UTF_8.toString()) + "&" + "purchaseDate=" + URLEncoder.encode(purchaseDate, StandardCharsets.UTF_8.toString()) + "&" + "pensionStartDate=" + URLEncoder.encode(pensionStartDate, StandardCharsets.UTF_8.toString()) + "&" + "dob=" + URLEncoder.encode(dateOfBirth, StandardCharsets.UTF_8.toString()) + "&" + "gender=" + URLEncoder.encode(gender.toUpperCase(), StandardCharsets.UTF_8.toString()) + "&" + "guaranteedPerc=" + URLEncoder.encode(guaranteedPercentage, StandardCharsets.UTF_8.toString()) + "&" + "annuityIncrement=" + URLEncoder.encode(annuityIncrement, StandardCharsets.UTF_8.toString()) + "&" + "paymentMode=" + URLEncoder.encode(paymentMode, StandardCharsets.UTF_8.toString()) + "&" + "paymentFrequency=" + URLEncoder.encode(paymentFrequency, StandardCharsets.UTF_8.toString()) + "&" + "spouseReversal=" + URLEncoder.encode(spouseReversal, StandardCharsets.UTF_8.toString()) + "&" + "dobSpouse=" + URLEncoder.encode(spouseDateOfBirth, StandardCharsets.UTF_8.toString()) + "&" + "spouseGender=" + URLEncoder.encode(spouseGender.toUpperCase(), StandardCharsets.UTF_8.toString()) + "&" + "regPurchasePrice=" + URLEncoder.encode(registeredPurchasePrice, StandardCharsets.UTF_8.toString()) + "&" + "unRegPurchasePrice=" + URLEncoder.encode("500500", StandardCharsets.UTF_8.toString()) + "&" + "calcMode=" + URLEncoder.encode(calculationMode, StandardCharsets.UTF_8.toString()) + "&" + "targetPension=" + URLEncoder.encode(targetPension, StandardCharsets.UTF_8.toString()) + "&" + "agentId=" + URLEncoder.encode("0", StandardCharsets.UTF_8.toString()) + "&" + "annuityMode=" + URLEncoder.encode(annuityMode, StandardCharsets.UTF_8.toString());
			//JSONObject response = URLPost(settings.getXiPath() + "annuity_quote/getquote.json", urlParameters);
			JSONObject response = URLPost(settings.getXiPath() + "annuity_quote/getquote", urlParameters, "application/x-www-form-urlencoded");
			return response.toString();
		
	}
	public String queryWhatIfAnalysis(String yearsToProject, String contributions, String rateOfReturn, String salaryEscalationRate, String inflationRate) throws JSONException, IOException
	{
			Setting settings = getSettings();
			//JSONObject response = URLPost(settings.getXiPath() + "whatifanalysis.json", "");
			JSONObject response = URLPost(settings.getXiPath() + "whatifanalysis/" + yearsToProject + "/" + contributions + "/" + rateOfReturn + "/" + salaryEscalationRate + "/" + inflationRate, "", "application/x-www-form-urlencoded");
			if(response.get(SUCCESS).equals(true))
			{
				
				return response.toString();
			}
			else
			{
				return response.toString();
			}
		
	}
	
	public String getSchemeInterestRates(String schemeID) throws JSONException, IOException
	{
			Setting settings = getSettings();
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemeinterestrates/" + schemeID);
			if(response.get(SUCCESS).equals(true))
			{
				
				JSONArray res = (JSONArray) response.get(ROWS);

		    	JSONArray jsonarray = new JSONArray();
		    	
				InterestRateColumns irc = getInterestRateColumns();
				
				Map<String, Boolean> temp = new HashMap<String, Boolean>();
				temp.put(SUCCESS, true);
				
				jsonarray.put(temp);
								
				
			    for(int i = 0; i < res.length(); i += 2){

			    	JSONObject jsonobj = res.getJSONObject(i);

			    	JSONObject obj = new JSONObject();
			    	
			    	if(irc.isDateDeclared())
			    	{
			    		obj.put("dateDeclared",  (String) jsonobj.get("dateDeclared"));
			    	}
			    	
			    	if(irc.isAccountingPeriod())
			    	{
			    		obj.put("accountingPeriod",  (String) jsonobj.get("ap"));
			    	}

			    	if(irc.isContributions())
			    	{
			    		obj.put("contributions",  (String) jsonobj.get("contributions"));
			    	}
			    	
			    	if(irc.isOpeningBalances())
			    	{
			    		obj.put("openingBalances",   (String) jsonobj.get("openingBalances"));
			    	}
			    	
			    	if(irc.isPensionDrawDown())
			    	{
			    		obj.put("pensionDrawDown",   (String) jsonobj.get("pensionDrawDown"));
			    	}
			    	
			    	if(irc.isYear())
			    	{
			    		obj.put("year",   (String) jsonobj.get("year"));
			    	}
			    	
			    	if(jsonobj.getString("status").equals("Registered"))
			    	{
			    		obj.put("registered", (String) jsonobj.get("contributions"));

				    	JSONObject jsonobj_ = res.getJSONObject(i + 1);
				    	
			    		obj.put("unRegistered", (String) jsonobj_.get("contributions"));
			    	}
			    	else
			    	{
			    		obj.put("unRegistered", (String) jsonobj.get("contributions"));

				    	JSONObject jsonobj_ = res.getJSONObject(i + 1);
				    	
			    		obj.put("registered", (String) jsonobj_.get("contributions"));
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
	public String getMemberBalances(String memberID) throws JSONException, IOException
	{
		Setting settings = getSettings();
		try {
			JSONObject response = URLGet(settings.getXiPath() + "getmemberbalances/" + memberID);
			Logger.getAnonymousLogger().info(settings.getXiPath() + "getmemberbalances/" + memberID);
			if(response.get(SUCCESS).equals(true))
			{

				JSONArray res = (JSONArray) response.get(ROWS);
				
				double total = 0;

			    for(int i = 0; i < res.length(); i ++)
			    
			    {
			    	
			    	JSONObject obj = res.getJSONObject(i);
			    	
			    	Logger.getAnonymousLogger().info(obj.getString("total").toString());
			    	
			    	total = Double.parseDouble(obj.getString("total").toString());
			    	
			    }
   	            
			    response = new JSONObject().put(SUCCESS, true).put("total", total);
				
				return response.toString();
			}
			else
			{
				return response.toString();
			}
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
			return String.valueOf(amount).toString();
	}

	public List<BenefitPayment> getBenefitPayments(String schemeID, int start, int count) throws JSONException, IOException
	{
			Setting settings = getSettings();
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebenefitpayments/" + schemeID + "/?start=" + start + "&size=" + count);
			if(response.get(SUCCESS).equals(true))
			{
				
				List<BenefitPayment> benefitPayments = new ArrayList<BenefitPayment>();
				
				JSONArray res = (JSONArray) response.get(ROWS);
				
				for(int i = 0; i < res.length(); i ++)
				{
					
					JSONObject payment = res.getJSONObject(i);
					
					BenefitPayment bp = new BenefitPayment();
					try {

						bp.setGross(format_no(round(Double.parseDouble(String.valueOf(payment.get("gross").toString()).toString()), 2)));
					}
					catch (NumberFormatException ex)
					{
						bp.setGross("0.00");
					}
					try {
						bp.setTaxFree(format_no(round(Double.parseDouble(String.valueOf(payment.get("lumpsumTaxFree").toString()).toString()), 2)));
					}
					catch (NumberFormatException ex)
					{
						bp.setTaxFree("0.00");
					}
					try {
						bp.setTaxable(format_no(round(Double.parseDouble(String.valueOf(payment.get("taxableAmount").toString()).toString()), 2)));
					}
					catch (NumberFormatException ex)
					{
						bp.setTaxable("0.00");
					}
					try
					{
						bp.setWithHolding(format_no(round(Double.parseDouble(String.valueOf(payment.get("withHoldingTax").toString()).toString()), 2)));
					}
					catch (NumberFormatException ex)
					{
						bp.setWithHolding("0.00");
					}
					try {
						bp.setNet(format_no(round(Double.parseDouble(String.valueOf(payment.get("netPayment").toString()).toString()), 2)));
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

	
	public String humanReadableDate(String date_string)
	
	{
		Date compdate = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		try {
			try {
				compdate = (Date) format.parse(date_string);
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
	
	
	public List<SchemeReceipt> getSchemeReceipts(String schemeID, int start, int count) throws JSONException, IOException
	{
			Setting settings = getSettings();
			
			Common.RECORD_COUNT = 0;
			
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemereceipts/" + schemeID);
			try {
				if(response.get(SUCCESS).equals(true))
				{
					
					Common.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());
					
					Logger.getAnonymousLogger().info(Common.RECORD_COUNT + "");
					
					List<SchemeReceipt> schemeReceipts = new ArrayList<SchemeReceipt>();
					
					JSONArray res = (JSONArray) response.get(ROWS);
					
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
						sr.setAmount(format_no(round(Double.parseDouble(receipt.get("amount").toString()), 2)));
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
	
	public String listMembers(String schemeID) throws IOException, JSONException
	{
			Setting settings = getSettings();
			JSONObject response = URLGet(settings.getXiPath() + "member/statistics/statusdistribution/" + schemeID);
			try {
				if(response.get(SUCCESS).equals(true))
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
	
	public List<XiMember> getMemberListing(String profileID, String profile, String schemeID, int start, int size) throws JSONException, IOException
	{
		Common.RECORD_COUNT = 0;
		
			Setting settings = getSettings();
			JSONObject response = URLPost(settings.getXiPath() + "getmemberlisting/" + profileID + "/" + profile + "/" + schemeID + "/?start=" + start + "&size=" + size, "", "application/x-www-form-urlencoded");
			try {
				if(response.get(SUCCESS).equals(true))
				{
					
					Common.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());
					
					List<XiMember> xiMembers = new ArrayList<XiMember>();
					
					JSONArray res = (JSONArray) response.get(ROWS);
					
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
		SponsorService sService = new SponsorService();
		return sService.findById(Long.valueOf(sponsorID).longValue());
	}
	
	public XiMember getMemberDetails(String memberID) throws JSONException, IOException
	{
		Setting settings = getSettings();
		try {
			JSONObject response = URLGet(settings.getXiPath() + "getmemberdetails/" + memberID);
			if(response.get(SUCCESS).equals(true))
			{
				
				JSONArray res = (JSONArray) response.get(ROWS);
				
				JSONObject xi_member = res.getJSONObject(0);
				
				XiMember xm = new XiMember(xi_member.getLong("id"), xi_member.getString("mbio_id"), xi_member.getString("memberNo"), xi_member.getString("membershipNo"), xi_member.getString("partyrefno"), xi_member.getString("partnerNumber"), xi_member.getString("policyNo"), xi_member.getString("staffNo"), xi_member.getString("name"), xi_member.getString("idNo"), xi_member.getString("terminateCover"), xi_member.getString("pinNo"), xi_member.getString("postalAddress"), xi_member.getString("cellPhone"), xi_member.getString("email"), xi_member.getString("gender"), xi_member.getString("department"), xi_member.getString("dob"), xi_member.getString("maritalStatus"), xi_member.getString("dateJoinedScheme"), xi_member.getString("schemeId"), xi_member.getString("town"), xi_member.getString("country"), xi_member.getString("currentAnnualPensionableSalary"), xi_member.getString("firstname"), xi_member.getString("surname"), xi_member.getString("othernames"));
				
				return xm;
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

	public Permission getPermissions(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		Permission permissions;
		if(isManager(request))
		{
			permissions = getPermissions(Common.MANAGER);
		}
		else
			permissions = getPermissions(session.getAttribute(Common.U_PROFILE).toString());
		return permissions;
	}
	public List<Beneficiary> getBeneficiaries(String memberID)
	{
		Setting settings = getSettings();
		try {
			JSONObject response = URLPost(settings.getXiPath() + "getmemberbeneficiaries/" + memberID,"", "application/x-www-form-urlencoded");
			if(response.get(SUCCESS).equals(true))
			{
				JSONArray res = (JSONArray) response.get(ROWS);
				
				List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
				
				for(int i = 0; i < res.length(); i ++)
					
				{
					
					JSONObject obj = res.getJSONObject(i);
					Logger.getAnonymousLogger().info(obj.toString());
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
			Logger.getAnonymousLogger().info("Exception: " + ex.getMessage());
			return null;
		}
	}


	public JSONObject searchProfilesJSON(String search, String identifier, String profile, String schemeID)
	{
		Setting settings = getSettings();
		try {
			JSONObject response = URLPost(settings.getXiPath() + "searchForMemberDetails/" + identifier + "/" + search + "/" + profile + "/" + schemeID + "/0/20", "", "application/x-www-form-urlencoded");

			return response;
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
				if(response.get(SUCCESS).equals(true))
				{
					
					List<XiMember> xiMembers = new ArrayList<XiMember>();
					
					JSONArray res = (JSONArray) response.get(ROWS);
					
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

	public String getReasonsForExit(String category)
	{
		Setting settings = getSettings();
		try {
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getreasonsforexit/" + category);

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
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebenefitpaymentswithinyear/" + schemeID);

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
	

	public JSONObject sendNotification(String type, String receipients, String subject, String message, String schemeID, boolean attachment, String attachment_url) throws JSONException
	{
		Setting settings = getSettings();
		JSONObject params = new JSONObject();
		params.put("notificationPlatform", type)
		.put("recipients", receipients)
		.put("subject", subject)
		.put("msg", message)
		.put("schemeId", schemeID);
		if(attachment)
			params.put("attachments", attachment_url);
		Logger.getAnonymousLogger().info(params.toString());
		try {
			JSONObject response = URLPost(settings.getXiPath() + "notification/push", params.toString(), "application/json");

			return response;
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

	public List<BenefitPayment> searchPayments(String schemeID, String from, String to, int start, int count)
	{
		Common.RECORD_COUNT = 0;
		
		Setting settings = getSettings();
		try {
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebenefitpaymentsbetweendates/" + schemeID + "/" + from + "/" + to);

			if(response.get(SUCCESS).equals(true))
			{
				
				Common.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());
				
				List<BenefitPayment> benefitPayments = new ArrayList<BenefitPayment>();
				
				JSONArray res = (JSONArray) response.get(ROWS);
				
				for(int i = 0; i < res.length(); i ++)
				{
					
					JSONObject payment = res.getJSONObject(i);
					
					BenefitPayment bp = new BenefitPayment();
					try {

						bp.setGross(format_no(round(Double.parseDouble(String.valueOf(payment.get("gross").toString()).toString()), 2)));
					}
					catch (NumberFormatException ex)
					{
						bp.setGross("0.00");
					}
					try {
						bp.setTaxFree(format_no(round(Double.parseDouble(String.valueOf(payment.get("lumpsumTaxFree").toString()).toString()), 2)));
					}
					catch (NumberFormatException ex)
					{
						bp.setTaxFree("0.00");
					}
					try {
						bp.setTaxable(format_no(round(Double.parseDouble(String.valueOf(payment.get("taxableAmount").toString()).toString()), 2)));
					}
					catch (NumberFormatException ex)
					{
						bp.setTaxable("0.00");
					}
					try
					{
						bp.setWithHolding(format_no(round(Double.parseDouble(String.valueOf(payment.get("withHoldingTax").toString()).toString()), 2)));
					}
					catch (NumberFormatException ex)
					{
						bp.setWithHolding("0.00");
					}
					try {
						bp.setNet(format_no(round(Double.parseDouble(String.valueOf(payment.get("netPayment").toString()).toString()), 2)));
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

			if(response.get(SUCCESS).equals(true))
			{
				List<SchemeReceipt> schemeReceipts = new ArrayList<SchemeReceipt>();
				
				JSONArray res = (JSONArray) response.get(ROWS);
				
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
					sr.setAmount(format_no(round(Double.parseDouble(receipt.get("amount").toString()), 2)));
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

	public String getNewMembersInYear(String schemeID)
	{
		Setting settings = getSettings();
		try {
			JSONObject response = URLPost(settings.getXiPath() + "newMemberListingWithinYear/" + schemeID, "", "application/x-www-form-urlencoded");

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
			if(response.get(SUCCESS).equals(true))
			{
				

				JSONArray res = (JSONArray) response.get(ROWS);
				
				JSONArray resp = new JSONArray();
				
				for(int i = 0; i < res.length(); i ++)
					
				{
					
					JSONObject obj = res.getJSONObject(i);
					
					JSONObject beneficiary = new JSONObject();
					
					beneficiary.put("name", obj.get("name"));
					
					beneficiary.put("amount", obj.get("lumpsumEntitlement"));
					
					resp.put(beneficiary);					
					
				}
				
				return new JSONObject().put(SUCCESS, true).put(ROWS, resp).toString();			
				
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
	public  double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	public String getSchemeContributions(String schemeID) throws JSONException, IOException
	{
		Setting settings = getSettings();
		try {
			JSONObject response = URLGet(settings.getXiPath() + "scheme/gettotalschemecontributions/" + schemeID);
			return response.toString();
		} catch (Exception ex)
		{
			return null;
		}
	}
	public String getMemberContributions(String memberID) throws JSONException, IOException
	{
		Setting settings = getSettings();
		try {
			JSONObject response = URLGet(settings.getXiPath() + "getmembercontributions/" + memberID);
			if(response.get(SUCCESS).equals(true))
			{
				
				JSONArray res = (JSONArray) response.get(ROWS);
				
				List<String> years = new ArrayList<String>();
				
				for(int i = 0; i < res.length(); i ++)
				{

			    	JSONObject jsonobj = res.getJSONObject(i);
			    	
			    	if(!years.contains(jsonobj.get("year").toString()))
			    		years.add(jsonobj.get("year").toString());
					
				}
				
				Set<String> hs = new HashSet<String>();
				hs.addAll(years);
				years.clear();
				years.addAll(hs);
				
				Collections.sort(years);
				
				String[] year = years.toArray(new String[years.size()]);
				
				JSONArray json_array = new JSONArray();
				
				for(int j = 0; j < year.length; j ++)
				{
					
					JSONArray data = new JSONArray();
					
					double yearTotal = 0;
		    							
					for(int i = 0; i < res.length(); i ++)
					{
						
			    		JSONObject obj = new JSONObject();

				    	JSONObject jsonobj = res.getJSONObject(i);
				    	
				    	if(jsonobj.get("year").toString().equals(year[j].toString()))
				    	{
				    		
				    		obj.put("year", year[j]);
				    		
				    		obj.put("month", jsonobj.get("month").toString());
				    		
				    		obj.put("total", String.valueOf(round(Double.parseDouble(jsonobj.get("total").toString()), 2)));
				    		
				    		try {
				    			yearTotal += Double.parseDouble(jsonobj.get("total").toString());
				    		} catch (Exception ex)
				    		{
				    			yearTotal += 0;
				    		}
					    	
					    	data.put(obj);
				    		
				    	}
						
					}
					
					json_array.put(new JSONObject().put("year", year[j]).put("total", round(yearTotal, 2))).put(data);
				}
				
				return new JSONObject().put(SUCCESS, true).put(ROWS, json_array).toString();
				
			}
			else
			{
				return response.toString();
			}
		}
		catch (Exception ex)
		{
			return ex.getMessage();
		}
	}
	public List<UserProfile> getUserProfiles() throws JSONException, IOException
	{
		try {
			Setting settings = getSettings();
			List<UserProfile> uprofiles = new ArrayList<UserProfile>();
			JSONObject response = URLGet(settings.getXiPath() + "profile/getprofiles");
			if(response.get(SUCCESS).equals(true))
			{
				
				JSONArray res = (JSONArray) response.get(ROWS);

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
	public String getFundValue(String accountingPeriodID, String schemeID)
	{
		Setting settings = getSettings();
		try
		{
			//JSONObject response = URLGet(settings.getXiPath() + "scheme/getfundvalue.json");
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getfundvalue/" + accountingPeriodID + "/" + schemeID);
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
			//JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemebasecurrency.json");
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
			//JSONObject response = URLGet(settings.getXiPath() + "getmemberaverageinterest.json");
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
			member_manager = session.getAttribute(Common.MANAGER_PROFILE).equals(Common.MANAGER);
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
			return uuids[index];
		} catch (IndexOutOfBoundsException iOOB) {
			return uuid;
		} catch (NullPointerException npe) {
			return uuid;
		}
	}

	public String[] listProfiles()
	{
		String profiles[] = {"MEMBER", "ADMINISTRATOR", "SPONSOR", "TRUSTEE", "AGENT", "CUSTODIAN", "CUSTOMER_RELATIONSHIP_MANAGER", "CUSTOMER_RELATIONSHIP_EXECUTIVE", "FUND_MANAGER", "PENSIONER"};
		return  profiles;
	}
	
	public boolean isManagerial(String profile)
	{
		String[] profiles = listProfiles();
		for(int i = 0; i < profiles.length; i ++)
			if(profiles[i].equals(profile))
				return true;
		return false;
	}
	public User findUserByCode(String code)
	{
		UserService uService = new UserService();
		return uService.findBySecurityCode(code);
	}
	public List<Scheme> getSchemes(int start, int count) throws JSONException, IOException
	{
		Common.RECORD_COUNT = 0;
		try
		{
			Setting settings = getSettings();
			List<Scheme> schemes = new ArrayList<Scheme>();
			JSONObject response = URLGet(settings.getXiPath() + "scheme/getschemes/?start=" + start + "&size=" + count);
			if(response.get(SUCCESS).equals(true))
			{
				
				Common.RECORD_COUNT = Integer.parseInt(response.get("totalcount").toString());
				
				JSONArray res = (JSONArray) response.get(ROWS);

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
	public List<Scheme> getProfileSchemes(String user, String profile) throws JSONException, IOException
	{
		try
		{
			Setting settings = getSettings();
			List<Scheme> schemes = new ArrayList<Scheme>();
			
			String ordinal = getLoginField(profile);
			JSONObject response = URLPost(settings.getXiPath() + "getmemberschemes/" + ordinal + "/" + user + "/" + profile, "", "application/x-www-form-urlencoded");
			
			if(response.get(SUCCESS).equals(true))
			{
				
				JSONArray res = (JSONArray) response.get(ROWS);

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
			Logger.getAnonymousLogger().info(ex.getMessage());
			return null;
		}
	}
	
	public String[] getPensionProducts()
	{
		return null;
	}
	
	public List<Country> getCountries()
	{
		CountryService cService = new CountryService();
		List<Country> countries = cService.findAll();
		return countries;
	}
	
	public List<Gender> getGenders()
	{

		GenderService gService = new GenderService();
		List<Gender> genders = gService.findAll();
		return genders;
	}
	
	public List<MaritalStatus> getMaritalStatuses()
	{

		MaritalStatusService msService = new MaritalStatusService();
		List<MaritalStatus> marital_statuses = msService.findAll();
		return marital_statuses;
	}
	
	public Company getCompany()
	{

		CompanyService companyService = new CompanyService();
		Company company = companyService.findById(Long.valueOf("1").longValue());
		return company;
	}
	
	public Social getSocial()
	{

		SocialService sService = new SocialService();
		Social social = sService.findById(Long.valueOf("1").longValue());
		return social;
	}
	
	public List<ActivityLog> getActivityLogs(String user_id)
	{
		ActivityLogService aLogService = new ActivityLogService();
		List<ActivityLog> logs = aLogService.findAllByUserID(user_id);
		return logs;
	}
	
	public Setting getSettings()
	{

		SettingService settingService = new SettingService();
		Setting settings = settingService.findById(Long.valueOf("1").longValue());
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

		MenuService menuService = new MenuService();
		Menu menu = menuService.findById(Long.valueOf("1").longValue());
		return menu;
	}
	
	public List<Banner> getBanners()
	{

		BannerService bService = new BannerService();
		List<Banner> banners = bService.findAll();
		return banners;
	}
	
	public List<Sector> getSectors()
	{

		SectorService sectorService = new SectorService();
		List<Sector> sectors = sectorService.findAll();
		return sectors;
	}
	
	public Theme getTheme()
	{

		ThemeService themeService  = new ThemeService();
		Theme theme = themeService.findById(Long.valueOf("1").longValue());
		return theme;
	}
	
	public MemberPermission getMemberPermissions()
	{

		MemberPermissionService mService = new MemberPermissionService();
		MemberPermission memberPermission = mService.findById(Long.valueOf("1").longValue());
		return memberPermission;
	}
	
	public Media getMediaById(Long id)
	{
		MediaService mService = new MediaService();
		return mService.findById(id);
	}
	
	public void deleteMedia(Media m)
	{
		MediaService mService = new MediaService();
		mService.delete(m);
	}
	
	public List<Media> getMedia(String schemeID, boolean admin)
	{

		MediaService mService = new MediaService();
		List<Media> medias = mService.findAll(schemeID, admin);
		return medias;
	}
	
	public void logActivity(String access_menu, String description, String userID, String scheme, String userProfile)
	{
		ActivityLogService aService = new ActivityLogService();
        Date datetime = new Date();
		ActivityLog log = new ActivityLog(null, description, datetime, Long.valueOf(userID).longValue(), scheme, access_menu, userProfile);
		aService.persist(log);
	}
	
}
