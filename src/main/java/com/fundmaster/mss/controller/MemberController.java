package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.model.ActivityLog;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.ContactCategory;
import com.fundmaster.mss.model.PasswordPolicy;
import com.fundmaster.mss.model.Scheme;
import com.fundmaster.mss.model.XiMember;
@WebServlet(name = "MemberController", urlPatterns = {"/member"})
public class MemberController extends GenericController{

	String REPO_FOLDER = "member";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
				if(!(session.getAttribute(Common.LOGIN).equals(true) && (session.getAttribute(Common.U_PROFILE).equals(Common.MEMBER_PROFILE) || isManager(request))))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
				}
				else
				{
					List<ActivityLog> activityLogs = getActivityLogs(session.getAttribute(Common.UID).toString());
					request.setAttribute("activityLogs", activityLogs);
					Company company = getCompany();
					request.setAttribute("company", company);
					request.setAttribute("username", session.getAttribute(Common.USER).toString());
					request.setAttribute("path", "member");
					List<Scheme> schemes = getProfileSchemes(session.getAttribute(Common.USER).toString(), session.getAttribute(Common.U_PROFILE).toString());
					request.setAttribute("schemes", schemes);
					XiMember m = getMemberDetails(session.getAttribute(Common.PROFILE_ID).toString());
					request.setAttribute("member", m);

					if(schemes != null)
					{
						try {

							if(session.getAttribute(Common.SCHEME_ID).equals(null))
							{
								session.setAttribute(Common.SCHEME_TYPE, schemes.get(0).getPlanType());
								session.setAttribute(Common.SCHEME_ID, schemes.get(0).getId().toString());
								request.setAttribute("scheme_id", schemes.get(0).getId().toString());
							}
							else
							{
								request.setAttribute("scheme_id", session.getAttribute(Common.SCHEME_ID));
								session.setAttribute(Common.SCHEME_TYPE, schemes.get(0).getPlanType());
							}
						} catch(Exception ex)
						{
							ex.printStackTrace(out);
								session.setAttribute(Common.SCHEME_ID, String.valueOf(schemes.get(0).getId()).toString());
						}
					}
					request.setAttribute("profile", session.getAttribute(Common.U_PROFILE));
					List<ContactCategory> contactReasons = getContactReasons();
					request.setAttribute("contactReasons", contactReasons);
					request.setAttribute("isManager", isManager(request));
					PasswordPolicy policy = getPasswordPolicy();
					request.setAttribute("policy", policy);
					request.getRequestDispatcher("member.jsp").forward(request, response);
				}
			}
			else
				response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
		}
		catch (Exception e)
		{
			e.printStackTrace(out);
			response.sendRedirect(getServletContext().getContextPath() + "/sign-in");			
		} 
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

    	PrintWriter out = response.getWriter();
		if(request.getParameter("ACTION").equals("CH"))
		{
			try {
				String result = getMemberContributions(session.getAttribute(Common.PROFILE_ID).toString());
				out.write(result);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				try {
					out.write(result(false, "Sorry, an error was encountered loading your contribution history, please try again" + e.getMessage()).toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace(out);
				}
			}
		}
		else if(request.getParameter("ACTION").equals("LOGOUT"))
		{
			/* Logout Request */
			try {
				logActivity("", "logged out", session.getAttribute(Common.UID).toString(), null, session.getAttribute(Common.U_PROFILE).toString());
				session.invalidate();
				out.write("true");
			}
			catch (Exception e)
			{
				e.printStackTrace(out);
				out.write("false");
			}
		}
		else if(request.getParameter("ACTION").equals("REASON"))
		{
			String res = getReasonsForExit("ALL");
			
			out.write(res);
			
		}
		else if(request.getParameter("ACTION").equals("AP"))
		{

			DateFormat format_from = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			String date_string = request.getParameter("date");
			Date date = null;
			try {
				date = format_from.parse(date_string);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = getAccountingPeriod(format.format(date).toString(), session.getAttribute(Common.SCHEME_ID).toString());
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("CB"))
		{
			String result = null;
			try {
				result = getMemberBalances(session.getAttribute(Common.PROFILE_ID).toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("CURR"))
		{
			String result = getSchemeCurrency(session.getAttribute(Common.SCHEME_ID).toString());
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("BD"))
		{
			String result = getMemberBeneficiaries(session.getAttribute(Common.PROFILE_ID).toString());
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("CI"))
		{
			String result = getMemberCummulativeInterest(session.getAttribute(Common.PROFILE_ID).toString());
			out.write(result);
		}
		else if(request.getParameter("ACTION").equals("AI"))
		{
			String result = getMemberAverageInterest(session.getAttribute(Common.PROFILE_ID).toString());
			out.write(result);
		}
	}
}
