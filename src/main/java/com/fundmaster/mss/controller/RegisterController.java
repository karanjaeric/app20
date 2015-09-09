package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Gender;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.MaritalStatus;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.PasswordPolicy;
import com.fundmaster.mss.model.PensionProduct;
import com.fundmaster.mss.model.ProfileLoginField;
import com.fundmaster.mss.model.Scheme;
import com.fundmaster.mss.model.Sector;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.model.User;
import com.fundmaster.mss.model.UserProfile;
import com.fundmaster.mss.model.XiMember;
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends GenericController {
	private static final String INDIVIDUAL_PENSION_FUND = "INDIVIDUAL_PENSION_FUND";
	private static final String UMBRELLA = "UMBRELLA";
	public RegisterController() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		List<Country> countries = getCountries();
		request.setAttribute("countries",  countries);
		List<Gender> genders = getGenders();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = getMaritalStatuses();
		request.setAttribute("maritalStatuses",  marital_statuses);
		Company company = getCompany();
		request.setAttribute("company", company);
		Social social = getSocial();
		request.setAttribute("social", social);
		List<Sector> sectors = getSectors();
		request.setAttribute("sectors", sectors);
		List<Scheme> sponsorSchemes = null;
		try {
			sponsorSchemes = getSchemeBySchemeModeAndPlanType(UMBRELLA, INDIVIDUAL_PENSION_FUND);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("sponsorSchemes", sponsorSchemes);
		List<Scheme> memberSchemes = null;
		try {
			memberSchemes = getSchemeByPlanType(INDIVIDUAL_PENSION_FUND);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("memberSchemes", memberSchemes);
		Menu menu = getMenu();
		request.setAttribute("menu", menu);
		Setting settings = getSettings();
		request.setAttribute("settings", settings);
		List<ProfileLoginField> plf = getProfileLoginFields();
		request.setAttribute("loginFields", plf);
		List<PensionProduct> pensionProducts = getPensionProduct();
		request.setAttribute("pensionProducts",  pensionProducts);
		List<UserProfile> userProfiles = null;
		try {
			userProfiles = getUserProfiles();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("userProfiles", userProfiles);
		Theme theme = getTheme();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = getHelpByPage(Common.PAGE_REGISTER);
		request.setAttribute("help", help);
		PageContent content = getPageContentByPage(Common.PAGE_REGISTER);
		request.setAttribute("content", content);
		PasswordPolicy policy = getPasswordPolicy();
		request.setAttribute("policy", policy);
		logActivity(Common.PAGE_REGISTER, "accesed registration page", "0", null, null);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	// Get the request params.
	    @SuppressWarnings("rawtypes")
		Map paramMap = request.getParameterMap();
	    if ( paramMap.isEmpty() )
	    {
	      response.sendError( HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Post method not allowed without parameters." );
	      return;
	    }
	    String[] arr2 = (String[])paramMap.get( "inCaptchaChars" );
	    if ( arr2==null  )
	    {
	      response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Expected parameters were not found." );
	      return;
	    }

	    String sessId = request.getSession().getId();
	    String inputChars = arr2.length>0 ? arr2[0] : "";

	    // Check validity and consistency of the data.
	    if ( sessId==null)
	    {
	      response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Browser must support session cookies." );
	      return;
	    }

	    // Validate whether input from user is correct.
	    System.out.println( "Validating - inputChars are: " + inputChars );
	      HttpSession session = request.getSession(true);
	      Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		  request.setCharacterEncoding("UTF-8"); // Do this so we can capture non-Latin chars
			  
	    boolean passedCaptchaTest = captcha.isCorrect(inputChars);
	    session.invalidate();
	    if(passedCaptchaTest)
	    {
			Setting settings = getSettings();
	    	if(request.getParameter("type").equalsIgnoreCase("member"))
			{
					JSONObject result = createMember(request);
					out.write(result.toString());
			}
	    	else if(request.getParameter("type").equalsIgnoreCase("sponsor"))
			{
	    		
				JSONObject result = createSponsor(request);
				out.write(result.toString());
				
			}
			else if(request.getParameter("type").equals("EXISTING"))
			{
				String memberID = null;
				JSONObject res = null;
				PasswordPolicy policy = getPasswordPolicy();
				try {
					res = memberExists(request.getParameter("category").toString(), request.getParameter("idNumber").toString(), false);
					memberID = res.get("memberId").toString();
					if(memberID != null  && BigDecimal.valueOf(Long.valueOf(memberID.toString()).longValue()) != BigDecimal.ZERO)
					{
						if(!userExists(request.getParameter("idNumber").toString(), res.get("profile").toString()))
						{
							User u = new User(null, res.get("profile").toString(), Long.valueOf(memberID).longValue(), request.getParameter("idNumber"), request.getParameter("password") );
							Date password_expiry = addDays(new Date(), policy.getExpiry_days());
							u.setPassword_expiry(password_expiry);
							String securityCode = UUID.randomUUID().toString();
							u.setSecurityCode(securityCode);
							create_user(u);
							String email_address = null;
							String schemeId = null;
							boolean proceed = false;
							if(u.getUserProfile().equals(Common.MEMBER_PROFILE))
							{
								XiMember m = getMemberDetails(u.getProfileID().toString());
								email_address = m.getEmailAddress();
								schemeId = res.get("schemeId").toString();
								proceed = isEmailAddress(email_address);
							}
							else
							{
								Logger.getAnonymousLogger().info("Not a member");
								try {
									JSONObject resp = getProviderDetails(u.getUserProfile(), memberID);
									if(resp.get("success").equals(true))
									{
										Logger.getAnonymousLogger().info("We have the details");
										try {
											JSONArray json = (JSONArray) resp.get("rows");
											JSONObject provider = json.getJSONObject(0);
											email_address = provider.getString("email");
											schemeId = provider.get("schemeId").toString();
											proceed = isEmailAddress(email_address);
											Logger.getAnonymousLogger().info("We have everything for the provider");
										} catch (JSONException e)
										{
											Logger.getAnonymousLogger().info("We don't have a thing, so this is just a user");
											try {
												JSONArray json = (JSONArray) resp.get("rows");
												JSONObject provider = json.getJSONObject(0);
												email_address = provider.getString("user.email");
												schemeId = provider.get("user.schemeId").toString();
												proceed = isEmailAddress(email_address);
												Logger.getAnonymousLogger().info("We have everything from the user");
											} catch (JSONException ex)
											{
												proceed = false;
											}
										}
									}
								} catch (Exception e)
								{
									proceed = false;
									
								}
								
								
								
							}
							if(proceed)
							{
								sendNotification("EMAIL", email_address, "MSS Portal Account Activation Instructions" , "Dear " + u.getUserProfile() + ",<br />" +
										"Your account has been created on the FundMaster Xi Member Self Service Portal. " +
										"Please click this <a href='" + settings.getPortalBaseURL() + "activate?" + securityCode + "'>link</a> to complete the activation process", schemeId, false, null);
								try {
									out.write(result(true, "<strong>Registration Successful</strong><br /> Congratulations! Your account has been created on the portal. An email has been sent to your email address with account activation instructions.").toString());
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace(out);
								} 
							}
							else
							{
								try {
									out.write(result(true, "<strong>Registration Successful</strong><br /> Congratulations! Your account has been created on the portal. We were however unable to send the activation instructions to your email. Please contact the administrator").toString());
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace(out);
								} 
							}
							
						}
						else
						{
							try {
								out.write(result(false, "<strong>Registration Failed!</strong><br /> You are already registered to use the portal").toString());
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace(out);
							} 
						}
					}
					else
					{
						try {
							out.write(result(false, "<strong>Registration Failed!</strong><br /> You are not an existing " + request.getParameter("category").toString().toLowerCase() + ". Please contact the administrator.").toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace(out);
						} 
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace(out);
					try {
						out.write(result(false, "<strong>Registration Failed!</strong><br /> You are not an existing " + request.getParameter("category").toString().toLowerCase() + ". Please contact the administrator.").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					} 
				}
				
			}
	    }
	    else
	    {
	    	try {
	    		JSONObject result = result(false, "<strong>Authorization Failed!</strong><br /> You did not pass our robot test.");
	    		result.put("captcha", true);
				out.write(result.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(out);
			} 
	    }
			
	}
	
}
