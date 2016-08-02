package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.ejb.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.*;
import nl.captcha.Captcha;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet implements Serializable {
	private static final String INDIVIDUAL_PENSION_FUND = "INDIVIDUAL_PENSION_FUND";
	private static final String UMBRELLA = "UMBRELLA";
	@EJB
	Helper helper;
    @EJB
    ProfileNameEJB profileNameEJB;
    @EJB
    UserEJB userEJB;
    @EJB
    CountryEJB countryEJB;
    @EJB
    SettingEJB settingEJB;
    @EJB
    GenderEJB genderEJB;
    @EJB
    CompanyEJB companyEJB;
    @EJB
    SocialEJB socialEJB;
    @EJB
    MenuEJB menuEJB;
    @EJB
    ThemeEJB themeEJB;
    @EJB
    HelpEJB helpEJB;
    @EJB
    PageContentEJB pageContentEJB;
    @EJB
    MaritalStatusEJB maritalStatusEJB;
    @EJB
    ProfileLoginFieldEJB profileLoginFieldEJB;
    @EJB
    BannerEJB bannerEJB;
    @EJB
    PermissionEJB permissionEJB;
    @EJB
    SectorEJB sectorEJB;
	public Register() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		List<Country> countries = countryEJB.find();
		request.setAttribute("countries",  countries);
		List<Gender> genders = genderEJB.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusEJB.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		Company company = companyEJB.find();
		request.setAttribute("company", company);
		Social social = socialEJB.find();
		request.setAttribute("social", social);
		List<Sector> sectors = sectorEJB.find();
		request.setAttribute("sectors", sectors);
		List<ProfileName> profileNames = profileNameEJB.find();
		request.setAttribute("profileNames", profileNames);
		List<Scheme> sponsorSchemes = null;
		try {
			sponsorSchemes = helper.getSchemeBySchemeModeAndPlanType(UMBRELLA, INDIVIDUAL_PENSION_FUND);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("sponsorSchemes", sponsorSchemes);
		List<Scheme> memberSchemes = null;
		try {
			memberSchemes = helper.getSchemeByPlanType(INDIVIDUAL_PENSION_FUND);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("memberSchemes", memberSchemes);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		List<ProfileLoginField> plf = helper.getProfileLoginFields();
		request.setAttribute("loginFields", plf);
		List<PensionProduct> pensionProducts = helper.getPensionProduct();
		request.setAttribute("pensionProducts",  pensionProducts);
		Theme theme = helper.getTheme();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = helpEJB.findHelp(Constants.PAGE_REGISTER);
		request.setAttribute("help", help);
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_REGISTER);
		request.setAttribute("content", content);
		PasswordPolicy policy = helper.getPasswordPolicy();
		request.setAttribute("policy", policy);
		helper.logActivity(Constants.PAGE_REGISTER, "accesed registration page", "0", null, null);
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
			Setting settings = helper.getSettings();
	    	if(request.getParameter("type").equalsIgnoreCase("member"))
			{
					JSONObject result = helper.createMember(request);
					out.write(result.toString());
			}
	    	else if(request.getParameter("type").equalsIgnoreCase("sponsor"))
			{
	    		
				JSONObject result = helper.createSponsor(request);
				out.write(result.toString());
				
			}
			else if(request.getParameter("type").equals("EXISTING"))
			{
				String memberID;
				JSONObject res;
				PasswordPolicy policy = helper.getPasswordPolicy();
				try {
					res = helper.memberExists(request.getParameter("category"), request.getParameter("idNumber"));
					memberID = res.get("memberId").toString();
					if(memberID != null  && !Objects.equals(BigDecimal.valueOf(Long.valueOf(memberID).longValue()), BigDecimal.ZERO))
					{
						if(!helper.userExists(request.getParameter("idNumber"), res.get("profile").toString()))
						{
							User u = new User(res.get("profile").toString(), Long.valueOf(memberID).longValue(), request.getParameter("idNumber"), request.getParameter("password") );
							Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
							u.setPassword_expiry(password_expiry);
							String securityCode = UUID.randomUUID().toString();
							u.setSecurityCode(securityCode);
							helper.create_user(u);
							String email_address = null;
							String schemeId = null;
							boolean proceed = false;
							if(u.getUserProfile().equals(Constants.MEMBER_PROFILE))
							{
								XiMember m = helper.getMemberDetails(u.getProfileID().toString(),null);
								email_address = m.getEmailAddress();
								schemeId = res.get("schemeId").toString();
								proceed = helper.isEmailAddress(email_address);
							}
							else
							{
								try {
									JSONObject resp = helper.getProviderDetails(u.getUserProfile(), request.getParameter("idNumber"));
									if(resp.get("success").equals(true))
									{
										try {
											//JSONArray json = (JSONArray) resp.get("rows");
											JSONObject provider = resp;//json.getJSONObject(0);
											try {
												email_address = provider.getString("email");
											}
											catch(Exception e1)
											{
												e1.getStackTrace();
												email_address=request.getParameter("idNumber");
											}
											try{schemeId = provider.get("schemeId").toString();}catch (Exception e){e.printStackTrace();}
											proceed = helper.isEmailAddress(email_address);
										} catch (Exception e)
										{
											e.printStackTrace();
											try {
												JSONArray json = (JSONArray) resp.get("rows");
												JSONObject provider = json.getJSONObject(0);
												email_address = provider.getString("user.email");
												schemeId = provider.get("user.schemeId").toString();
												proceed = helper.isEmailAddress(email_address);
											} catch (JSONException ex)
											{
												e.printStackTrace();
												proceed = false;
											}
										}
									}
								} catch (Exception e)
								{
									e.printStackTrace();
									proceed = false;
									
								}
								
								
								
							}
							System.out.println("Email "+email_address);
							if(proceed)
							{
								System.out.println("Trying to send mail");
								Company company = helper.getCompany();
								helper.sendNotification(email_address,company.getEmail(), null,"MSS Portal Account Activation Instructions", "Dear " + u.getUserProfile() + ", " +
										"Your account has been created on the FundMaster Xi Member Self Service Portal. " +
										"Please click this link '" + settings.getPortalBaseURL() + "activate?" + securityCode + "' to complete the activation process", schemeId, false, null);

									out.write(helper.result(true, "<strong>Registration Successful</strong><br /> Congratulations! Your account has been created on the portal. An email has been sent to your email address with account activation instructions.").toString());

							}
							else
							{
									out.write(helper.result(true, "<strong>Registration Successful</strong><br /> Congratulations! Your account has been created on the portal. We were however unable to send the activation instructions to your email. Please contact the administrator").toString());

							}
							
						}
						else
						{
								out.write(helper.result(false, "<strong>Registration Failed!</strong><br /> You are already registered to use the portal").toString());

						}
					}
					else
					{
							out.write(helper.result(false, "<strong>Registration Failed!</strong><br /> You are not an existing " + request.getParameter("category").toLowerCase() + ". Please contact the administrator.").toString());

					}
				} catch (IOException | JSONException | NullPointerException ex) {

						out.write(helper.result(false, "<strong>Registration Failed!</strong><br /> You are not an existing " + request.getParameter("category").toLowerCase() + ". Please contact the administrator.").toString());

				}
				
			}
	    }
	    else
	    {
	    	try {
	    		JSONObject result = helper.result(false, "<strong>Authorization Failed!</strong><br /> You did not pass our robot test.");
	    		result.put("captcha", true);
				out.write(result.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			} 
	    }
			
	}
	
}
