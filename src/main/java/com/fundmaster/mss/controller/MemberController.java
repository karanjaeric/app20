package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.LOGGER;
import com.fundmaster.mss.model.*;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
@WebServlet(name = "MemberController", urlPatterns = {"/member"})
public class MemberController extends HttpServlet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	Helper helper;
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
	LOGGER logger = new LOGGER(this.getClass());
	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		/* Check if user is already authenticated */
		HttpSession session = request.getSession(false);
    	PrintWriter out = response.getWriter();
		try {
			if(session != null)
			{
				if(!(session.getAttribute(Constants.LOGIN).equals(true) && (session.getAttribute(Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE) || helper.isManager(request))))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
				}
				else
				{
					List<ActivityLog> activityLogs = helper.getActivityLogs(session.getAttribute(Constants.UID).toString());
					request.setAttribute("activityLogs", activityLogs);
					Company company = companyEJB.find();
					request.setAttribute("company", company);
					request.setAttribute("username", session.getAttribute(Constants.USER).toString());
					request.setAttribute("path", "member");
					
					String user = session.getAttribute(Constants.USER).toString().trim();
					
					List<Scheme> schemes = helper.getProfileSchemes(user, session.getAttribute(Constants.U_PROFILE).toString());
					request.setAttribute("schemes", schemes);
					
					XiMember m= helper.getMemberDetails(session.getAttribute(Constants.PROFILE_ID).toString(),null);
					request.setAttribute("member_id", m.getId());
					session.setAttribute(Constants.PROFILE_ID,m.getId());
					if(schemes != null && schemes.size() > 0) {
						logger.i("Scheme is not null. email: "+session.getAttribute(Constants.USER).toString());
						if(session.getAttribute(Constants.SCHEME_ID) == null)
						{
							m= helper.getMemberDetails(session.getAttribute(Constants.PROFILE_ID).toString(),schemes.get(0).getId().toString());
						}
						else
						{
							m= helper.getMemberDetails(session.getAttribute(Constants.USER).toString(),session.getAttribute(Constants.SCHEME_ID).toString());
						}

					}
					request.setAttribute("member", m);
					try{
						if(m==null)
						{
							m= helper.getMemberDetails(session.getAttribute(Constants.PROFILE_ID).toString(),null);
						}
						session.setAttribute(Constants.PROFILE_ID,m.getId());

					}
					catch(Exception e){e.printStackTrace();};

					if(schemes != null && schemes.size() == 1)
					{
						try {

							if(session.getAttribute(Constants.SCHEME_ID) == null)
							{
								session.setAttribute(Constants.SCHEME_TYPE, schemes.get(0).getPlanType());
								session.setAttribute(Constants.SCHEME_ID, schemes.get(0).getId().toString());
								request.setAttribute("scheme_id", schemes.get(0).getId().toString());
							}
							else
							{
								request.setAttribute("scheme_id", session.getAttribute(Constants.SCHEME_ID));
								session.setAttribute(Constants.SCHEME_TYPE, schemes.get(0).getPlanType());
							}
						} catch(NullPointerException npe)
						{
                            logger.e("NullPointerException was detected: " + npe.getMessage());
                            session.setAttribute(Constants.SCHEME_ID, String.valueOf(schemes.get(0).getId()));
						}
					}

					else if(session.getAttribute(Constants.SCHEME_ID) != null)
					{
						for(Scheme scheme : schemes != null ? schemes : null)
						{
							if(scheme.getId() == session.getAttribute(Constants.SCHEME_ID))
							{
								try {

									if(session.getAttribute(Constants.SCHEME_ID) == null)
									{
										session.setAttribute(Constants.SCHEME_TYPE, scheme.getPlanType());
										session.setAttribute(Constants.SCHEME_ID, scheme.getId().toString());
										request.setAttribute("scheme_id", scheme.getId().toString());
									}
									else
									{
										request.setAttribute("scheme_id", session.getAttribute(Constants.SCHEME_ID));
										session.setAttribute(Constants.SCHEME_TYPE, scheme.getPlanType());
									}
								} catch(NullPointerException npe)
								{
									logger.e("NullPointerException was detected: " + npe.getMessage());
									session.setAttribute(Constants.SCHEME_ID, String.valueOf(scheme.getId()));
								}
							}
						}
					}
					request.setAttribute("profile", session.getAttribute(Constants.U_PROFILE));
					List<ContactCategory> contactReasons = helper.getContactReasons();
					request.setAttribute("contactReasons", contactReasons);
					request.setAttribute("isManager", helper.isManager(request));
					PasswordPolicy policy = helper.getPasswordPolicy();
					request.setAttribute("policy", policy);
					if((schemes != null ? schemes.size() : 0) > 1 && session.getAttribute(Constants.SCHEME_ID) == null)
						request.getRequestDispatcher("select_scheme.jsp").forward(request, response);
					else
						request.getRequestDispatcher("member.jsp").forward(request, response);
				}
			}
			else
				response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
		}
		catch (JSONException | NullPointerException npe)
		{
			logger.e("NullPointerException or JSONException was detected: " + npe.getMessage());
			response.sendRedirect(getServletContext().getContextPath() + "/sign-in");			
		} 
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

    	PrintWriter out = response.getWriter();

		if (request.getParameter("ACTION").equals("SWITCH_SCHEME"))
		{
			session.setAttribute(Constants.SCHEME_ID, request.getParameter("schemeID"));

				out.write(helper.result(true, "success").toString());

		}
		else if(request.getParameter("ACTION").equals("CH"))
		{
			try {
				String result = helper.getMemberContributions(session.getAttribute(Constants.PROFILE_ID).toString());
				out.write(result);
				
			} catch (JSONException e) {

					out.write(helper.result(false, "Sorry, an error was encountered loading your contribution history, please try again" + e.getMessage()).toString());

			}
		}
		else if(request.getParameter("ACTION").equals("PRE_CHANGE_PASSWORD"))
		{
			User u = helper.findByUsernameAndProfile(session.getAttribute(Constants.USER).toString(), session.getAttribute(Constants.U_PROFILE).toString());
			String securityCode = helper.shorterUUID(UUID.randomUUID().toString(), 1);
			/* Shorter code is more user friendly... the UUID was way too long :) */
			u.setSecurityCode(securityCode);
			helper.updateUser(u);
			XiMember m = null;
			try {
				List<Scheme> schemes = helper.getProfileSchemes(session.getAttribute(Constants.USER).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				m = helper.getMemberDetails(session.getAttribute(Constants.PROFILE_ID).toString(),null);
				if(schemes != null && schemes.size() == 1) {
					if(session.getAttribute(Constants.SCHEME_ID) == null)
					{
						m= helper.getMemberDetails(session.getAttribute(Constants.PROFILE_ID).toString(),schemes.get(0).getId().toString());
					}
					else
					{
						m= helper.getMemberDetails(session.getAttribute(Constants.USER).toString(),session.getAttribute(Constants.SCHEME_ID).toString());
					}

				}
				try
				{
					session.setAttribute(Constants.PROFILE_ID,m.getId());
				}
				catch(Exception e){e.printStackTrace();}
			} catch (JSONException je) {
				// TODO Auto-generated catch block
				logger.e("JSONException was detected: " + je.getMessage());
			}
			try {
				Company company = helper.getCompany();
				JSONObject resp = helper.sendNotification(m != null ? m.getEmailAddress() : null,company.getEmail(), null,"Change Password Request", "Dear " + u.getUsername() + ", " +
						"You recently requested to change your password. " +
						"Here is your security code:" +
						"" + securityCode +
						"You will require it to be able to change your password", session.getAttribute(Constants.SCHEME_ID).toString(), false, "");
				if(resp.get("success").equals(true))
				{
						out.write(helper.result(true, "The change password instructions have been sent to your email address").toString());

				}
				else
				{
						out.write(helper.result(false, "We are sorry, we were unable to send you the change password instructions").toString());

				}
			} catch (JSONException | NullPointerException jnpe) {

					out.write(helper.result(false, "We are sorry, we encountered a problem obtaining your email address. Please try again").toString());

			}

		}
		else if(request.getParameter("ACTION").equals("LOGOUT"))
		{

				try {
					helper.logActivity("", "logged out", session.getAttribute(Constants.UID).toString(), null, session.getAttribute(Constants.U_PROFILE).toString());
					session.invalidate();
					out.write(helper.result(true, "Logout was successful").toString());
				} catch (NullPointerException npe) {
					out.write(helper.result(true, "Logout was successful").toString());
				}
		}
		else if(request.getParameter("ACTION").equals("REASON"))
		{
			String res = helper.getReasonsForExit();
			
			out.write(res);
			
		}
		else if (request.getParameter("ACTION").equals("CHANGE_SCHEME")) {
			helper.audit(session, "Switched between schemes from scheme #" + session.getAttribute(Constants.SCHEME_ID)
					+ " to scheme #" + request.getParameter("schemeID"));
			logger.i("Switched between schemes from scheme #" + session.getAttribute(Constants.SCHEME_ID)
					+ " to scheme #" + request.getParameter("schemeID"));
			session.setAttribute(Constants.SCHEME_ID, request.getParameter("schemeID"));
			out.write(helper.result(true, "Scheme changed successfully").toString());
		}
		else if(request.getParameter("ACTION").equals("AP"))
		{

			DateFormat format_from = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			String date_string = request.getParameter("date");
			Date date = null;
			try {
				date = format_from.parse(date_string);
			} catch (ParseException pe) {
				// TODO Auto-generated catch block
				logger.e("ParseException was detected: " + pe.getMessage());
			}
			String result = helper.getAccountingPeriod(format.format(date), session.getAttribute(Constants.SCHEME_ID).toString());
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("CB"))
		{
			String result = null;
			try {
				result = helper.getMemberBalances(session.getAttribute(Constants.PROFILE_ID).toString());
				out.write(result);
			} catch (JSONException je) {
				// TODO Auto-generated catch block
				logger.e("JSONException was detected: " + je.getMessage());
			}

		}
		else if(request.getParameter("ACTION").equals("CURR"))
		{
			String result = helper.getSchemeCurrency(session.getAttribute(Constants.SCHEME_ID).toString());
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("BD"))
		{
			String result = helper.getMemberBeneficiaries(session.getAttribute(Constants.PROFILE_ID).toString());
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("CI"))
		{
			String result = helper.getMemberCummulativeInterest(session.getAttribute(Constants.PROFILE_ID).toString());
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("AI"))
		{
			String result = helper.getMemberAverageInterest(session.getAttribute(Constants.PROFILE_ID).toString());
			out.write(result);
		}
	}
}
