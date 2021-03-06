package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Fields;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "Admin", urlPatterns = {"/admin"})
@MultipartConfig
public class Admin extends BaseServlet implements Serializable {

    private static final String REQUEST_ACTION = "ACTION";
    private static final String ADMIN_SWITCH_SCHEME = "SWITCH_SCHEME";
    private static final String ADMIN_COMPANY = "COMPANY";
    private static final String ADMIN_EMAILS = "EMAILS";
    private static final String ADMIN_SCHEME_CONTRIBUTIONS = "SC";
    private static final String ADMIN_SPONSOR_CONTRIBUTIONS = "SP";
    private static final String ADMIN_PROFILE_NAMES = "PROFILE_NAMES";
    private static final String ADMIN_CLIENT_NAMES = "CLIENT_NAMES";
    private static final String ADMIN_PWD_RESET = "ADMIN_PWD_RESET";
    private static final String EDIT_BENEFICIARY = "EDIT_BENEFICIARY";
    private static final String UPLOAD_DOCUMENT = "UPLOAD_DOCUMENT";
    private static final String UPDATE_MEMBER = "UPDATE_MEMBER";
    private static final String GET_BENEFICIARY = "GET_BENEFICIARY";
    private static final String GET_PERMISSION = "GET_PERMISSION";
    private static final String SAVE_PERMISSION = "SAVE_PERMISSION";
    private static final String SET_PASSWORD_POLICY = "SET_PASSWORD_POLICY";
    private static final String PROFILE_LOGIN_FIELD = "PROFILE_LOGIN_FIELD";
    private static final String CLIENT_SETUP_FIELD = "CLIENT_SETUP_FIELD";
    private static final String FRONTPAGE_ACCESS = "FRONTPAGE_ACCESS";
    private static final String DELETE_PORTAL_SPONSOR = "DELETE_PORTAL_SPONSOR";
    private static final String ADD_MEMBER = "ADD_MEMBER";
    private static final String ADD_SPONSOR = "ADD_SPONSOR";
    private static final String SUBMIT_PORTAL_MEMBER = "SUBMIT_PORTAL_MEMBER";
    private static final String FORWARD_PORTAL_MEMBER = "FORWARD_PORTAL_MEMBER";
    private static final String SUBMIT_PORTAL_SPONSOR = "SUBMIT_PORTAL_SPONSOR";
    private static final String FORWARD_PORTAL_SPONSOR = "FORWARD_PORTAL_SPONSOR";
    private static final String DELETE_PORTAL_MEMBER = "DELETE_PORTAL_MEMBER";
    private static final String SEARCH_MEMBER = "SEARCH_MEMBER";
    private static final String SEARCH_MEMBER_BY_SPONSOR = "SEARCH_MEMBER_BY_SPONSOR";
    private static final String PROFILE_ACCESS = "PROFILE_ACCESS";
    private static final String MOST_BY_MANAGER = "MOST_BY_MANAGER";
    private static final String MOST_BY_MEMBER = "MOST_BY_MEMBER";
    private static final String USER_TOGGLE = "USER_TOGGLE";
    public static final String RECEIPT = "RECEIPT";
    private static final String NEW = "NEW";
    private static final String AGENT_COMMISSION = "AGENT_COMMISSION";
    private static final String EXITS = "EXITS";
    private static final String SEARCH_SCHEMES = "SEARCH_SCHEMES";
    private static final String SCHEME_MODE = "SCHEME_MODE";
    private static final String GET_SCHEME_SPONSORS = "GET_SCHEME_SPONSORS";
    private static final String CHANGE_SCHEME = "CHANGE_SCHEME";
    private static final String GET_MEMBER = "GET_MEMBER";
    private static final String DELINK_SCHEME_MANAGER = "DELINK_SCHEME_MANAGER";
    private static final String ADD_SCHEME_MANAGER = "ADD_SCHEME_MANAGER";
    private static final String VIEW_MEMBER = "VIEW_MEMBER";
    private static final String VIEW_BENEFICIARY = "VIEW_BENEFICIARY";
    private static final String CURR = "CURR";
    private static final String ML = "ML";
    private static final String PRE_CHANGE_PASSWORD = "PRE_CHANGE_PASSWORD";
    private static final String CHANGE_PASSWORD = "CHANGE_PASSWORD";
    private static final String AP = "AP";
    private static final String PERIODS = "PERIODS";
    private static final String EXITREASONS = "EXITREASONS";
    
    private static final String FV = "FV";
    private static final String HELP = "HELP";
    private static final String REMOVE_BANNER = "REMOVE_BANNER";
    private static final String REMOVE_LOGO = "REMOVE_LOGO";
    private static final String PAGE_CONTENT = "PAGE_CONTENT";
    private static final String FAQ_CONTENT = "FAQ_CONTENT";
    private static final String THEME = "THEME";
    private static final String INTEREST_RATE_COLUMNS = "INTEREST_RATE_COLUMNS";
    private static final String SETTINGS = "SETTINGS";
    private static final String MENU = "MENU";
    private static final String RECOVERY = "RECOVERY";
    private static final String DB_MENU = "DB_MENU";
    private static final String LOGOUT = "LOGOUT";
    private static final String SOCIAL = "SOCIAL";
    private static final String REMOVE_CONTACT_REASON = "REMOVE_CONTACT_REASON";
    private static final String REMOVE_MEDIA = "REMOVE_MEDIA";
    private static final String MEMBER_PERMISSION = "MEMBER_PERMISSION";
    private static final String DISABLE_CONTRIBUTION_GRAPH = "DISABLE_CONTRIBUTION_GRAPH";
    private static final String MEMBER_MENU_CONFIG = "MEMBER_MENU_CONFIG";
    private static final String PENSIONER_MENU_CONFIG = "PENSIONER_MENU_CONFIG";
    private static final String MEMBER_DASHBOARD_ITEMS = "MEMBER_DASHBOARD_ITEMS";
    private static final String ADMIN_DASHBOARD_ITEMS = "ADMIN_DASHBOARD_ITEMS";
    private static final String PLF = "PLF";
    private static final String CS = "CS";
    private static final String ADD_CONTACT_REASON = "ADD_CONTACT_REASON";
    private static final String LOGO = "LOGO";
    private static final String BANNER = "BANNER";
    private static final String MEDIA = "MEDIA";
    private static final String EMAIL = "EMAIL";
    private static final String REPORTS = "REPORTS";

    private final JLogger jLogger = new JLogger(this.getClass());
    @EJB
    MediaBeanI mediaBeanI;
    @EJB
    CompanyBeanI companyBeanI;
    @EJB
    EmailsBeanI emailsBeanI;
    @EJB
    SettingBeanI settingBeanI;
    @EJB
    CountryBeanI countryBeanI;
    @EJB
    ProfileNameBeanI profileNameBeanI;
    @EJB
    ClientNameBeanI clientNameBeanI;
    @EJB
    ProfileLoginFieldBeanI profileLoginFieldBeanI;
    @EJB
    ClientSetupI clientSetupI;
    @EJB
    UserBeanI userBeanI;
    @EJB
    MemberPermissionBeanI memberPermissionBeanI;
    @EJB
    PermissionBeanI permissionBeanI;
    @EJB
    PasswordPolicyBeanI passwordPolicyBeanI;
    @EJB
    MemberBeanI memberBeanI;
    @EJB
    SponsorBeanI sponsorBeanI;
    @EJB
    SchemeManagerBeanI schemeManagerBeanI;
    @EJB
    UsedPasswordBeanI usedPasswordBeanI;
    @EJB
    HelpBeanI helpBeanI;
    @EJB
    PageContentBeanI pageContentBeanI;
    @EJB
    FaqContentBeanI faqContentBeanI;
    @EJB
    ContactCategoryBeanI contactCategoryBeanI;
    @EJB
    ImageBannerBeanI imageBannerBeanI;
    @EJB
    LogoBeanI logoBeanI;
    @EJB
    ThemeBeanI themeBeanI;
    @EJB
    InterestRateColumnBeanI interestRateColumnBeanI;
    @EJB
    MenuBeanI menuBeanI;
    @EJB
    AccountRecoveryBeanI accountRecoveryBeanI;
    @EJB
    DBMenuBeanI dbMenuBeanI;
    @EJB
    DBGraphBeanI dbGraphBeanI;
    @EJB
    MemberMenuBeanI memberMenuBeanI;
    @EJB
    PensionerMenuBeanI pensionerMenuBeanI;
    @EJB
    MemberDashboardBeanI memberDashboardBeanI;
    @EJB
    AdminDashboardI adminDashboardI;
    @EJB
    SocialBeanI socialBeanI;
    @EJB
    ApiEJB apiEJB;
    @EJB
    SectorBeanI sectorBeanI;
    Helper helper = new Helper();
    private static final long serialVersionUID = 1L;
    private File[] fileUpload;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        /* Check if user is already authenticated */
        HttpSession session = request.getSession(false);
        try {
            if (session != null) {
                if (!(session.getAttribute(Constants.LOGIN).equals(true) && (helper.isManagerial(this.getSessKey(request, Constants.U_PROFILE)) || helper.isManager(request)))) {
                    response.sendRedirect(getServletContext().getContextPath() + "/login");
                } else {
                    Company company = companyBeanI.find();
                    List<ActivityLog> activityLogs = activityLogBeanI.findAllByUserID(this.getSessKey(request, Constants.UID));
                    request.setAttribute("activityLogs", activityLogs);
                    request.setAttribute("company", company);

                    List<Scheme> schemes;
                    if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.ADMIN_PROFILE)) {

                        try {
                            schemes = apiEJB.getSchemes(0, 10000);

                        } catch (Exception e) {
                            schemes = null;
                            e.printStackTrace();
                        }

                    } else {
                        schemes = apiEJB.getProfileSchemes(this.getSessKey(request, Constants.USER),
                                this.getSessKey(request, Constants.U_PROFILE));

                    }

                    request.setAttribute("schemes", schemes);
                    PasswordPolicy policy = passwordPolicyBeanI.find();
                    request.setAttribute("policy", policy);
                    //request.setAttribute("username", this.getSessKey(request, Constants.USER));

                    String userName = this.getSessKey(request, Constants.USER);
                    jLogger.i("Username is ===============> " + userName);

                    User usr = userBeanI.findByUsername(userName);
                    String userProfile = usr.getUserProfile();
                    XiMember mbr = apiEJB.memberExists(userProfile, userName);
                    String memberName = mbr.getName();
                    request.setAttribute("memberName", memberName);

                    if (schemes != null && schemes.size() > 0) {
                        jLogger.i("We have the schemes");

                        if (this.getSessKey(request, Constants.SCHEME_ID) == null || this.getSessKey(request, Constants.SCHEME_ID).isEmpty()) {
                            jLogger.i("Session Scheme Id is null");
                            session.setAttribute(Constants.SCHEME_TYPE, schemes.get(0).getPlanType());
                            session.setAttribute(Constants.SCHEME_ID, schemes.get(0).getId().toString());
                            session.setAttribute(Constants.SCHEME_NAME, schemes.get(0).getName());
                            request.setAttribute("scheme_id", schemes.get(0).getId().toString());  //schemeID
                        } else {
                            jLogger.i("Session Scheme Id is not null, it is: " + this.getSessKey(request, Constants.SCHEME_ID));
                            for (Scheme scheme : schemes) {
                                if (this.getSessKey(request, Constants.SCHEME_ID)
                                        .equals(helper.toString(scheme.getId()))) {
                                    session.setAttribute(Constants.SCHEME_TYPE, scheme.getPlanType());
                                    break;
                                }
                            }
                            request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
                        }
                    } else if (this.getSessKey(request, Constants.SCHEME_ID) != null && !this.getSessKey(request, Constants.SCHEME_ID).isEmpty()) {
                        jLogger.i("Scheme ID is null here");
                        if (schemes != null) {
                            for (Scheme scheme : schemes) {
                                if (scheme.getId() == helper.toLong(this.getSessKey(request, Constants.SCHEME_ID))) {
                                    if (this.getSessKey(request, Constants.SCHEME_ID) == null) {
                                        session.setAttribute(Constants.SCHEME_TYPE, scheme.getPlanType());
                                        session.setAttribute(Constants.SCHEME_ID, scheme.getId().toString());
                                        session.setAttribute(Constants.SCHEME_NAME, scheme.getName());
                                        request.setAttribute("scheme_id", scheme.getId().toString());
                                    } else {
                                        for (Scheme scheme1 : schemes) {
                                            if (this.getSessKey(request, Constants.SCHEME_ID)
                                                    .equals(String.valueOf(scheme1.getId()))) {
                                                session.setAttribute(Constants.SCHEME_TYPE, scheme1.getPlanType());
                                                break;
                                            }
                                        }
                                        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
                                    }
                                    break;
                                }
                            }
                        }
                    }

                    jLogger.i("Scheme Set for " + this.getSessKey(request, Constants.SCHEME_ID));
                    request.setAttribute("path", "admin");
                    request.setAttribute("profile", this.getSessKey(request, Constants.U_PROFILE));
                    jLogger.i("Profile: " + this.getSessKey(request, Constants.U_PROFILE));
                    request.setAttribute("profileID", this.getSessKey(request, Constants.PROFILE_ID));
                    jLogger.i("Profile_id: " + this.getSessKey(request, Constants.PROFILE_ID));
                    Permission permissions = getPermissions(request);
                    request.setAttribute("permissions", permissions);
                    List<ContactCategory> contactReasons = contactCategoryBeanI.find();
                    request.setAttribute("contactReasons", contactReasons);
                    request.setAttribute("isManager", helper.isManager(request));
                    Emails email = emailsBeanI.find();
                    request.setAttribute("email", email);
                    AdminDashboardItems adminDashboardItems = adminDashboardI.find();
                    request.setAttribute("adminDashboard", adminDashboardItems);

                    if ((schemes != null ? schemes.size() : 0) > 1 && this.getSessKey(request, Constants.SCHEME_ID) == null) {
                        request.getRequestDispatcher("select_scheme.jsp").forward(request, response);
                    } else {

                        List<XiMember> due4retirement = null;
                        jLogger.i("The Profile id finding members due for retirement is " + this.getSessKey(request, Constants.PROFILE_ID));

                        if (this.getSessKey(request, Constants.U_PROFILE).equals("SPONSOR")) {
                            jLogger.i("TRUE");
                            due4retirement = apiEJB.due4RetirementPerSponsor(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID));
                            if (due4retirement != null) {
                                request.setAttribute("retirement", due4retirement.size());

                            } else {
                                request.setAttribute("retirement", 0);
                            }
                        } else {
                            due4retirement = apiEJB.due4Retirement(this.getSessKey(request, Constants.SCHEME_ID));
                            request.setAttribute("retirement", due4retirement.size());

                        }

                        request.getRequestDispatcher("admin.jsp").forward(request, response);
                    }
                }
            } else {
                jLogger.e("We have a problem, the session was null");
                response.sendRedirect(getServletContext().getContextPath() + "/login");
            }
        } catch (NullPointerException jnpe) {
            jnpe.printStackTrace();
            jLogger.e("We have a problem " + jnpe.getMessage());
            response.sendRedirect(getServletContext().getContextPath() + "/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        String FILE_SEPERATOR = System.getProperty("file.separator");
        String SCHEME_DOC_ROOT_FOLDER = "XI_Fundmaster_scheme_docs";
        String scheme_doc_folder = null;
        String MEDIA_DIR = "media";
        String BANNER_DIR = "banner";
        String LOGO_DIR = "logo";
        String action = this.get(request, REQUEST_ACTION);
        switch (action) {
            case ADMIN_SWITCH_SCHEME:
                switchScheme(request, response, session);
                break;
            case ADMIN_COMPANY:
                updateCompany(request, response, session);
                break;
            case ADMIN_EMAILS:
                updateEmails(request, response, session);
                break;
            case ADMIN_SCHEME_CONTRIBUTIONS:
                getSchemeContributions(request, response);
                break;
            case ADMIN_SPONSOR_CONTRIBUTIONS:
                getSponsorContributions(request, response);
                break;
            case ADMIN_PROFILE_NAMES:
                updateProfileNames(request, response, session);
                break;
            case ADMIN_CLIENT_NAMES:
                updateClientNames(request, response, session);
                break;
            case ADMIN_PWD_RESET:
                adminPasswordReset(request, response, session);
                break;
            case EDIT_BENEFICIARY:
                editBeneficiary(request, response, out, FILE_SEPERATOR, SCHEME_DOC_ROOT_FOLDER, scheme_doc_folder);
                break;
            case UPDATE_MEMBER:
                updateMember(request, response, out, FILE_SEPERATOR, SCHEME_DOC_ROOT_FOLDER, scheme_doc_folder);
                break;
            case UPLOAD_DOCUMENT:
                uploadDocument(request, response, out, FILE_SEPERATOR, SCHEME_DOC_ROOT_FOLDER, scheme_doc_folder);
                break;
            case GET_BENEFICIARY:
                showMemberBeneficiary(request, response);
                break;
            case GET_PERMISSION:
                showPermissions(request, response);
                break;
            case SAVE_PERMISSION:
                savePermissions(request, response, session);
                break;
            case SET_PASSWORD_POLICY:
                editPasswordPolicy(request, response);
                break;
            case PROFILE_LOGIN_FIELD:
                editProfileLoginFields(request, response, session);
                break;
            case CLIENT_SETUP_FIELD:
                editClientSetupFields(request, response, session);
                break;
            case FRONTPAGE_ACCESS:
                getFrontPageAccessByPage(response);
                break;
            case DELETE_PORTAL_SPONSOR:
                deletePortalSponsor(request, response);
                break;
            case ADD_MEMBER:
                this.createMember(request, response);
                break;
            case ADD_SPONSOR:
                addSponsor(response, request);
                break;
            case SUBMIT_PORTAL_MEMBER:
                submitPortalMemberToXi(response, request);
                break;
            case FORWARD_PORTAL_MEMBER:
                forwardMemberToXi(request, response);
                break;
            case SUBMIT_PORTAL_SPONSOR:
                submitSponsorToXi(response, request);
                break;
            case FORWARD_PORTAL_SPONSOR:
                forwardSponsorToXi(request, response);
                break;
            case DELETE_PORTAL_MEMBER:
                deletePortalMember(request, response);
                break;
            case SEARCH_MEMBER:
                searchMember(request, response, session);
                break;
            case SEARCH_MEMBER_BY_SPONSOR:
                searchMemberBySponsor(request, response, session);
                break;
            case PROFILE_ACCESS:
                getProfileAccess(response);
                break;
            case MOST_BY_MANAGER:
                getMostAccessedByManagers(response);
                break;
            case MOST_BY_MEMBER:
                mostAccessedByMembers(response);
                break;
            case USER_TOGGLE:
                toggleUserStatus(request, response, session);
                break;
            case RECEIPT:
                showReceipts(request, response, session);
                break;
            case NEW:
                getNewMembersInYear(request, response);
                break;
            case AGENT_COMMISSION:
                getAgentCommission(request, response);
                break;
            case EXITS:
                getExitsInYear(request, response);
                break;
            case SEARCH_SCHEMES:
                searchSchemes(request, response, session);
                break;
            case SCHEME_MODE:
                getSchemeMode(request, response, session);
                break;
            case GET_SCHEME_SPONSORS:
                getSchemeSponsors(request, response);
                break;
            case CHANGE_SCHEME:
                changeScheme(request, response, session);
                break;
            case GET_MEMBER:
                showMemberPersonalInformation(request, response, session);
                break;
            case DELINK_SCHEME_MANAGER:
                removeSchemeManager(request, response, session);
                break;
            case ADD_SCHEME_MANAGER:
                addSchemeManager(request, response, session);
                break;
            case VIEW_MEMBER:
                showMemberInformationView(request, response, session);
                break;
            case VIEW_BENEFICIARY:
                showBeneficiaryInformationView(request, response, session);
                break;
            case CURR:
                getSchemeCurrency(request, response);
                break;
            case ML:
                listMembers(request, response, session);
                break;
            case PRE_CHANGE_PASSWORD:
                preChangeUserPassword(request, response);
                break;
            case CHANGE_PASSWORD:
                changePassword(request, response, session);
                break;
            case AP:
                getAccountingPeriod(request, response);
                break;
            case PERIODS:
                getAllAccountingPeriods(request, response);
                break;
            case EXITREASONS:
                getReasonsForExit(request, response);
                break;
            case FV:
                getFundValueAsAt(request, response);
                break;
            case HELP:
                updateHelpContent(request, response, session);
                break;
            case REMOVE_BANNER:
                deleteImageBanner(request, response);
                break;
            case REMOVE_LOGO:
                deleteLogo(request, response);
                break;
            case PAGE_CONTENT:
                editPageContent(request, response, session);
                break;
            case FAQ_CONTENT:
                editFaqContent(request, response, session);
                break;
            case THEME:
                editTheme(request, response, session);
                break;
            case INTEREST_RATE_COLUMNS:
                editInterestRateColumns(request, response, session);
                break;
            case SETTINGS:
                editPortalSettings(request, response, session);
                break;
            case MENU:
                editMenuSettings(request, response, session);
                break;
            case RECOVERY:
                enableAccountRecovery(request, response, session);
                break;
            case DB_MENU:
                editDbMenu(request, response, session);
                break;
            case LOGOUT:
                logout(request, response, session);
                break;
            case SOCIAL:
                editSocialMediaSettings(request, response, session);
                break;
            case REMOVE_CONTACT_REASON:
                deleteContactReason(request, response, session);
                break;
            case REMOVE_MEDIA:
                deleteMediaFile(request, response, session);
                break;
            case MEMBER_PERMISSION:
                editMemberPermissions(request, response, session);
                break;
            case DISABLE_CONTRIBUTION_GRAPH:
                editContributionGraph(request, response, session);
                break;
            case MEMBER_MENU_CONFIG:
                editMemberMenu(request, response, session);
                break;
            case PENSIONER_MENU_CONFIG:
                editPensionerMenu(request, response, session);
                break;
            case MEMBER_DASHBOARD_ITEMS:
                configureMemberDashboard(request, response, session);
                break;
            case ADMIN_DASHBOARD_ITEMS:
                configureAdminDashboard(request, response, session);
                break;
            case PLF:
                updateProfileLoginFields(request, response, session);
                break;
            case CS:
                updateClientSetupConfig(request, response, session);
                break;
            case ADD_CONTACT_REASON:
                addContactReason(request, response, session);
                break;
            case LOGO:
                addLogo(request, response, session, LOGO_DIR);
                break;
            case BANNER:
                addBanner(request, response, session, BANNER_DIR);
                break;
            case MEDIA:
                addMediaFile(request, response, session, MEDIA_DIR);
                break;
            case EMAIL:
                sendEmail(request, response, MEDIA_DIR);
                break;
        }
    }

    private void mostAccessedByMembers(HttpServletResponse response) {

        List<PieObject> poList = activityLogBeanI.mostAccessedByMembers();
        try {
            JSONObject access_list = new JSONObject().put(Fields.SUCCESS, true);
            for (PieObject aPoList : poList) {
                access_list.put(aPoList.getName(), aPoList.getCount());
            }
            this.respond(response, true, "", access_list);
        } catch (JSONException je) {
            this.respond(response, false, "Json exception just occured", null);
        }
    }

    private void updateProfileLoginFields(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<ProfileLoginField> pfs = profileLoginFieldBeanI.find();
        boolean status = true;
        for (ProfileLoginField plf : pfs) {
            plf.setOrdinal(this.get(request, String.valueOf(plf.getId())));
            status = status && profileLoginFieldBeanI.edit(plf) != null;
        }
        if (status) {
            audit(session, "Updated the profile unique login fields for the various user profiles");
            this.respond(response, true, "Profile login ordinals successfully saved", null);
        } else {
            this.respond(response, true, "Profile login ordinals could not be saved", null);
        }
    }

    private void updateClientSetupConfig(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<ClientSetup> clientSetups = clientSetupI.find();
        boolean status = true;
        for (ClientSetup clientSetup : clientSetups) {
            clientSetup.setClientOrdinal(this.get(request, String.valueOf(clientSetup.getId())));
            status = status && clientSetupI.edit(clientSetup) != null;
        }
        if (status) {
            audit(session, "Updated the client setup configs for the various clients");
            this.respond(response, true, "client setup configs successfully saved", null);
        } else {
            this.respond(response, true, "client setup configs could not be saved", null);
        }
    }

    private void sendEmail(HttpServletRequest request, HttpServletResponse response, String MEDIA_DIR) throws IOException, ServletException {
        String url = request.getRequestURL().toString();
        String baseURL = url.substring(0, url.length() - request.getRequestURI().length())
                + request.getContextPath() + "/";
        boolean attachment = false;
        String attachment_url = null;
        String path = getServletContext().getRealPath("/") + MEDIA_DIR;
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            if (!fileName.equals("")) {
                //Get absolute path
                String fullpath = request.getServletContext().getRealPath("");
                //String savePath = fullpath + File.separator + MEDIA_DIR;
                jLogger.i("full path is:" + path);
                File fileSaveDir = new File(path);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                path = getServletContext().getRealPath("/") + MEDIA_DIR + File.separator + fileName;
                //savePath = fullpath + File.separator + MEDIA_DIR + File.separator + fileName;
                part.write(path);
                jLogger.i("Complete file path is: " + path);
                //attachment_url = baseURL + MEDIA_DIR + File.separator + fileName;
                attachment_url = path;
                attachment = true;
            }
        }
        String recipient = this.get(request, "recipient");
        jLogger.i("Recipient: " + recipient);
        String subject = this.get(request, "subject") + " [" + this.get(request, "category") + "]";
        String message = this.get(request, "message");
        Emails emails = emailsBeanI.find();
        //String sendTo = null;
        //List<String> recipients = new L;
        List recipients = new ArrayList();

        if (recipient != null) {
            if (recipient.equalsIgnoreCase("defaultEmail")) {

                recipients.add(emails.getDefaultEmail());
            } else if (recipient.equalsIgnoreCase("marketingEmail")) {
                recipients.add(emails.getMarketingEmail());
                //sendTo = emails.getMarketingEmail();
            } else if (recipient.equalsIgnoreCase("supportEmail")) {
                recipients.add(emails.getSupportEmail());
                //sendTo = emails.getSupportEmail();
            } else if (recipient.equalsIgnoreCase("crmEmail")) {
                recipients.add(emails.getCrmEmail());

            }

        }
        jLogger.i("Send to: " + recipients);

        /*String senderId = this.getSessKey(request, Constants.PROFILE_ID);
        jLogger.i("SENDER ID ========================> " + senderId);*/
        String userName = this.getSessKey(request, Constants.USER);

        if (helper.isValidPhone(userName)) {

            String zero = "0";
            String plus = "+";
            String xiMemPhone = userName;
            if (xiMemPhone.startsWith(plus)) {
                userName = zero + xiMemPhone.substring(4);
            } else if (userName.startsWith(zero)) {
                userName = xiMemPhone;
            } else {

                userName = null;
            }

        }
        jLogger.i("Username is ===============> " + userName);

        User usr = userBeanI.findByUsername(userName);
        String userProfile = usr.getUserProfile();

        //XiMember mbr = apiEJB.getMemberDetails(senderId, null);
        String code = "+233";
        userName = code + userName.substring(1);
        jLogger.i("Username is ===============> " + userName);

        XiMember mbr = apiEJB.memberExists(userProfile, userName);

        String senderEmail = mbr.getEmailAddress();
        jLogger.i("SENDER NAME ======================> " + senderEmail);

        boolean status = apiEJB.sendEmail(recipients, senderEmail, senderEmail, subject, message,
                this.getSessKey(request, Constants.SCHEME_ID), attachment, attachment_url);

        if (status) {
            this.respond(response, true, "The email was successfully sent", null);
        } else {
            this.respond(response, true, "We are sorry, but we were unable to send the email address", null);
        }
    }

    private void addMediaFile(HttpServletRequest request, HttpServletResponse response, HttpSession session, String MEDIA_DIR) throws IOException, ServletException {
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            if (!fileName.equals("")) {
                // Get absolute path (fullpath)
                String fullpath = request.getServletContext().getRealPath("");
                String savePath = fullpath + File.separator + MEDIA_DIR;

                File fileSaveDir = new File(savePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                savePath = fullpath + File.separator + MEDIA_DIR + File.separator + fileName;
                part.write(savePath);

                jLogger.i("Complete file path is: " + savePath);

                File file = new File(savePath);
                byte[] bFile = new byte[(int) file.length()];

                try {
                    FileInputStream fileInputStream = new FileInputStream(file);

                    //Convert file into array of bytes
                    fileInputStream.read(bFile);
                    fileInputStream.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                Blob fileBlob;
                try {
                    jLogger.i("================ Tuko Hapa ==================");
                    fileBlob = new javax.sql.rowset.serial.SerialBlob(bFile);
                    Date date = new Date();

                    String schemeId = this.get(request, "scheme");
                    jLogger.i("============ Scheme Id passed: " + schemeId + " ====================");

                    if (schemeId == null || schemeId.isEmpty()) {
                        schemeId = this.getSessKey(request, Constants.SCHEME_ID);
                    }

                    Media media = new Media(fileName, schemeId, this.get(request, "description"), this.get(request, "access"), date);
                    media.setFile(fileBlob);
                    media.setPath(savePath);
                    boolean administrator = this.get(request, Constants.ADMIN_PROFILE) != null && this.get(request, Constants.ADMIN_PROFILE).equals("on");
                    boolean member = this.get(request, Constants.MEMBER_PROFILE) != null && this.get(request, Constants.MEMBER_PROFILE).equals("on");
                    boolean agent = this.get(request, Constants.AGENT_PROFILE) != null && this.get(request, Constants.AGENT_PROFILE).equals("on");
                    boolean sponsor = this.get(request, Constants.SPONSOR) != null && this.get(request, Constants.SPONSOR).equals("on");
                    boolean trustee = this.get(request, Constants.TRUSTEE) != null && this.get(request, Constants.TRUSTEE).equals("on");
                    boolean custodian = this.get(request, Constants.CUSTODIAN) != null && this.get(request, "CUSTODIAN").equals("on");
                    boolean crm = this.get(request, Constants.CUSTOMER_RELATIONSHIP_MANAGER) != null && this.get(request, Constants.CUSTOMER_RELATIONSHIP_MANAGER).equals("on");
                    boolean cre = this.get(request, Constants.CUSTOMER_RELATIONSHIP_EXECUTIVE) != null && this.get(request, Constants.CUSTOMER_RELATIONSHIP_EXECUTIVE).equals("on");
                    boolean fm = this.get(request, Constants.FUND_MANAGER) != null && this.get(request, Constants.FUND_MANAGER).equals("on");
                    boolean pensioner = this.get(request, Constants.PENSIONER) != null && this.get(request, Constants.PENSIONER).equals("on");
                    media.setAdministrator(administrator);
                    media.setAgent(agent);
                    media.setCre(cre);
                    media.setCrm(crm);
                    media.setFundManager(fm);
                    media.setCustodian(custodian);
                    media.setPensioner(pensioner);
                    media.setSponsor(sponsor);
                    media.setMember(member);
                    media.setTrustee(trustee);
                    try {
                        media.setMemberId(Long.valueOf(this.get(request, "member_id")));
                    } catch (NullPointerException | NumberFormatException npe) {
                        media.setMemberId(Long.valueOf("0"));
                    }
                    if (mediaBeanI.add(media) != null) {
                        audit(session, "Uploaded a media file");
                        this.respond(response, true, "Media file successfully uploaded", null);
                    } else {
                        this.respond(response, true, "Media file was not uploaded", null);
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    private void addBanner(HttpServletRequest request, HttpServletResponse response, HttpSession session, String BANNER_DIR) throws IOException, ServletException {
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            if (!fileName.equals("")) {
                //Save banner to directory
                String fullpath = request.getServletContext().getRealPath("");
                String savePath = fullpath + File.separator + BANNER_DIR;
                jLogger.i("full path is:" + savePath);
                File fileSaveDir = new File(savePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                savePath = fullpath + File.separator + BANNER_DIR + File.separator + fileName;
                part.write(savePath);
                jLogger.i("Where the banner is saved ================>  " + savePath);

                //Save banner to database as blob
                File file = new File(savePath);
                byte[] bFile = new byte[(int) file.length()];

                try {
                    FileInputStream fileInputStream = new FileInputStream(file);

                    // Convert file into array of bytes
                    fileInputStream.read(bFile);
                    fileInputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                //convert to blob
                Blob fileBlob;
                try {
                    fileBlob = new javax.sql.rowset.serial.SerialBlob(bFile);
                    ImageBanner imageBanner = new ImageBanner();
                    imageBanner.setPath(savePath);
                    imageBanner.setName(fileName);
                    imageBanner.setImage(fileBlob);
                    if (imageBannerBeanI.add(imageBanner) != null) {
                        audit(session, "Uploaded a imageBanner for the portal");
                        this.respond(response, true, "ImageBanner image was successfully uploaded", null);
                    } else {
                        this.respond(response, false, "ImageBanner image could not be uploaded", null);
                    }
                } catch (SQLException sqe) {
                    this.respond(response, false, "ImageBanner image could not be uploaded", null);
                }
            }
        }
    }

    private void addLogo(HttpServletRequest request, HttpServletResponse response, HttpSession session, String LOGO_DIR) throws IOException, ServletException {
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            if (!fileName.equals("")) {
                //Save banner to directory
                String fullpath = request.getServletContext().getRealPath("");
                String savePath = fullpath + File.separator + LOGO_DIR;
                jLogger.i("full path is:" + savePath);
                jLogger.i("Filename is:" + fileName);
                File fileSaveDir = new File(savePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                savePath = fullpath + File.separator + LOGO_DIR + File.separator + fileName;
                part.write(savePath);
                jLogger.i("Where the banner is saved ================>  " + savePath);
                //Save banner to database as blob
                File file = new File(savePath);
                byte[] bFile = new byte[(int) file.length()];

                try {
                    FileInputStream fileInputStream = new FileInputStream(file);

                    // Convert file into array of bytes
                    fileInputStream.read(bFile);
                    fileInputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    //convert to blob
                    Blob fileBlob;
                    fileBlob = new javax.sql.rowset.serial.SerialBlob(bFile);
                    try {
                        List<Logo> logoz = logoBeanI.findAll();
                        for (Logo logo : logoz) {
                            logoBeanI.delete(logo);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Logo logo = new Logo();
                    logo.setPath(savePath);
                    logo.setImage(fileBlob);
                    logo.setName(fileName);
                    if (logoBeanI.add(logo) != null) {
                        audit(session, "Uploaded a logo for the portal");
                        this.respond(response, true, "Logo was successfully uploaded", null);
                    } else {
                        this.respond(response, false, "Logo could not be uploaded", null);
                    }
                } catch (SQLException sqe) {
                    this.respond(response, false, "Logo could not be uploaded", null);
                }
            }
        }
    }

    private void addContactReason(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (this.get(request, "type").equalsIgnoreCase("ADD")) {
            ContactCategory cc = new ContactCategory();
            cc.setName(this.get(request, "name"));
            if (contactCategoryBeanI.add(cc) != null) {
                audit(session, "Added a new contact category " + this.get(request, "name"));
                this.respond(response, true, "Contact category successfully saved", null);
            } else {
                this.respond(response, true, "Contact category could not be saved", null);
            }
        } else {
            ContactCategory cc = contactCategoryBeanI.findById(helper.toLong(this.get(request, "id")));
            cc.setName(this.get(request, "name"));
            if (contactCategoryBeanI.edit(cc) != null) {
                audit(session, "Updated a contact category " + this.get(request, "name"));
                this.respond(response, true, "Contact category successfully saved", null);
            } else {
                this.respond(response, true, "Contact category could not be saved", null);
            }
        }
    }

    private void editMemberPermissions(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        MemberPermission mp = new MemberPermission(
                helper.toLong(this.get(request, "member_permission_id")),
                this.get(request, "memberNo").equalsIgnoreCase("true"),
                this.get(request, "partyRefNo").equalsIgnoreCase("true"),
                this.get(request, "partnerNo").equalsIgnoreCase("true"),
                this.get(request, "policyNo").equalsIgnoreCase("true"),
                this.get(request, "staffNo").equalsIgnoreCase("true"),
                this.get(request, "name").equalsIgnoreCase("true"),
                this.get(request, "idNumber").equalsIgnoreCase("true"),
                this.get(request, "pinNo").equalsIgnoreCase("true"),
                this.get(request, "postalAddress").equalsIgnoreCase("true"),
                this.get(request, "phoneNumber").equalsIgnoreCase("true"),
                this.get(request, "emailAddress").equalsIgnoreCase("true"),
                this.get(request, "gender").equalsIgnoreCase("true"),
                this.get(request, "dateOfBirth").equalsIgnoreCase("true"),
                this.get(request, "maritalStatus").equalsIgnoreCase("true"),
                this.get(request, "country").equalsIgnoreCase("true"),
                this.get(request, "town").equalsIgnoreCase("true"),
                this.get(request, "annualPensionableSalary").equalsIgnoreCase("true"),
                this.get(request, "designation").equalsIgnoreCase("true"),
                this.get(request, "region").equalsIgnoreCase("true"),
                this.get(request, "county").equalsIgnoreCase("true"),
                this.get(request, "depot").equalsIgnoreCase("true"),
                this.get(request, "department").equalsIgnoreCase("true"));
        if (memberPermissionBeanI.edit(mp) != null) {
            audit(session, "Updated member edit permissions");
            this.respond(response, true, "Member edit permissions successfully saved", null);
        } else {
            this.respond(response, false, "Member edit permissions could not be saved", null);
        }
    }

    private void editContributionGraph(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        DBContributionGraph dbContributionGraph = dbGraphBeanI.find();
        boolean contributionGraphActive = this.get(request, "contributionGraphActive").equalsIgnoreCase("true");
        boolean interestActive = this.get(request, "interestActive").equalsIgnoreCase("true");

        dbContributionGraph.setContributionGraphActive(contributionGraphActive);
        dbContributionGraph.setInterestActive(interestActive);

        if (dbGraphBeanI.edit(dbContributionGraph) != null) {
            audit(session, "Updated DB Scheme configuration settings");
            this.respond(response, true, "DB Scheme configurations successfully saved", null);
        } else {
            this.respond(response, true, "DB Scheme configurations could not be saved", null);
        }
    }

    private void editMemberMenu(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        MemberMenu memberMenu = memberMenuBeanI.find() == null ? new MemberMenu() : memberMenuBeanI.find();
        boolean contributionHistoryReport = this.get(request, "contributionHistoryReport").equalsIgnoreCase("true");
        boolean contributionHistoryGrid = this.get(request, "contributionHistoryGrid").equalsIgnoreCase("true");
        boolean BalancesHistory = this.get(request, "BalancesHistory").equalsIgnoreCase("true");
        boolean BalancesHistoryGrid = this.get(request, "BalancesHistoryGrid").equalsIgnoreCase("true");
        boolean StatementOfAccount = this.get(request, "StatementOfAccount").equalsIgnoreCase("true");
        boolean StatementOfAccountGrid = this.get(request, "StatementOfAccountGrid").equalsIgnoreCase("true");
        boolean UnitizedStatement = this.get(request, "UnitizedStatement").equalsIgnoreCase("true");
        boolean memberCertificate = this.get(request, "memberCertificate").equalsIgnoreCase("true");
        boolean WhatIfAnalysis = this.get(request, "WhatIfAnalysis").equalsIgnoreCase("true");
        boolean BenefitsProjection = this.get(request, "benefitsProjection").equalsIgnoreCase("true");
        boolean BenefitsProjectionPage = this.get(request, "benefitsProjectionPage").equalsIgnoreCase("true");
        boolean MemberBenefit = this.get(request, "memberBenefit").equalsIgnoreCase("true");
        boolean BenefitsProjectionGrid = this.get(request, "benefitProjectionGrid").equalsIgnoreCase("true");
        boolean AnnualContributionStatementGrid = this.get(request, "annualContributionStatementGrid").equalsIgnoreCase("true");
        boolean AnnualContributionStatement = this.get(request, "annualContributionStatement").equalsIgnoreCase("true");
        boolean ProvisionalMemberStatement = this.get(request, "provisionalMemberStatement").equalsIgnoreCase("true");
        boolean Media = this.get(request, "Media").equalsIgnoreCase("true");
        boolean document = this.get(request, "document").equalsIgnoreCase("true");

        memberMenu.setContributionHistoryReport(contributionHistoryReport);
        memberMenu.setContributionHistoryGrid(contributionHistoryGrid);
        memberMenu.setBalancesHistory(BalancesHistory);
        memberMenu.setBalancesHistoryGrid(BalancesHistoryGrid);
        memberMenu.setStatementOfAccount(StatementOfAccount);
        memberMenu.setStatementOfAccountGrid(StatementOfAccountGrid);
        memberMenu.setUnitizedStatement(UnitizedStatement);
        memberMenu.setMemberCertificate(memberCertificate);
        memberMenu.setWhatIfAnalysis(WhatIfAnalysis);
        memberMenu.setBenefitsProjection(BenefitsProjection);
        memberMenu.setBenefitsProjectionPage(BenefitsProjectionPage);
        memberMenu.setMemberBenefit(MemberBenefit);
        memberMenu.setBenefitProjectionGrid(BenefitsProjectionGrid);
        memberMenu.setAnnualContributionStatementGrid(AnnualContributionStatementGrid);
        memberMenu.setAnnualContributionStatement(AnnualContributionStatement);
        memberMenu.setProvisionalMemberStatement(ProvisionalMemberStatement);
        memberMenu.setMedia(Media);
        memberMenu.setDocument(document);

        if (memberMenuBeanI.edit(memberMenu) != null) {
            audit(session, "Updated Member Menu configuration settings");
            this.respond(response, true, "Member Menu configurations successfully saved", null);
        } else {
            this.respond(response, true, "Member Menu configurations could not be saved", null);
        }
    }

    private void editPensionerMenu(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        PensionerMenu pensionerMenu = pensionerMenuBeanI.find();

        boolean personalInfo = this.get(request, "personalInfo").equalsIgnoreCase("true");
        boolean pensionDetails = this.get(request, "pensionDetails").equalsIgnoreCase("true");
        boolean pensionAdviceReport = this.get(request, "pensionAdviceReport").equalsIgnoreCase("true");
        boolean pensionAdviceGrid = this.get(request, "pensionAdviceGrid").equalsIgnoreCase("true");
        boolean media = this.get(request, "media").equalsIgnoreCase("true");

        pensionerMenu.setPersonalInfo(personalInfo);
        pensionerMenu.setPensionDetails(pensionDetails);
        pensionerMenu.setPensionAdviceReport(pensionAdviceReport);
        pensionerMenu.setPensionAdviceGrid(pensionAdviceGrid);
        pensionerMenu.setMedia(media);

        if (pensionerMenuBeanI.edit(pensionerMenu) != null) {
            audit(session, "Updated Pensioner Menu configuration settings");
            this.respond(response, true, "Pensioner Menu configurations successfully saved", null);
        } else {
            this.respond(response, true, "Pensioner Menu configurations could not be saved", null);
        }
    }

    private void configureMemberDashboard(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        MemberDashboardItems memberDashboardItems = memberDashboardBeanI.find() == null ? new MemberDashboardItems() : memberDashboardBeanI.find();
        boolean name = this.get(request, "memberName2").equalsIgnoreCase("true");
        boolean dateOfBirth = this.get(request, "dateOfBirth2").equalsIgnoreCase("true");
        boolean dateOfJoiningScheme = this.get(request, "dateOfJoiningScheme").equalsIgnoreCase("true");
        boolean gender = this.get(request, "gender2").equalsIgnoreCase("true");
        boolean idNumber = this.get(request, "idNumber2").equalsIgnoreCase("true");
        boolean phoneNumber = this.get(request, "phoneNumber2").equalsIgnoreCase("true");
        boolean emailAddress = this.get(request, "emailAddress2").equalsIgnoreCase("true");
        boolean memberNo = this.get(request, "memberNo2").equalsIgnoreCase("true");
        boolean memberId = this.get(request, "memberId2").equalsIgnoreCase("true");
        boolean pinNumber = this.get(request, "pinNumber").equalsIgnoreCase("true");
        boolean ssnitNumber = this.get(request, "ssnitNumber").equalsIgnoreCase("true");
        boolean town = this.get(request, "town").equalsIgnoreCase("true");

        memberDashboardItems.setName(name);
        memberDashboardItems.setDateOfBirth(dateOfBirth);
        memberDashboardItems.setDateOfJoiningScheme(dateOfJoiningScheme);
        memberDashboardItems.setGender(gender);
        memberDashboardItems.setIdNumber(idNumber);
        memberDashboardItems.setPhoneNumber(phoneNumber);
        memberDashboardItems.setEmailAddress(emailAddress);
        memberDashboardItems.setMemberNo(memberNo);
        memberDashboardItems.setMemberId(memberId);
        memberDashboardItems.setPinNumber(pinNumber);
        memberDashboardItems.setSsnitNumber(ssnitNumber);
        memberDashboardItems.setTown(town);

        if (memberDashboardBeanI.edit(memberDashboardItems) != null) {
            audit(session, "Updated Member Dashboard configuration settings");
            this.respond(response, true, "Member Dashboard configurations successfully saved", null);
        } else {
            this.respond(response, true, "Member Dashboard configurations could not be saved", null);
        }
    }

    private void configureAdminDashboard(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        AdminDashboardItems adminDashboardItems = adminDashboardI.find();
        boolean activeMembers = this.get(request, "activeMembers").equalsIgnoreCase("true");
        boolean defferedMembers = this.get(request, "defferedMembers").equalsIgnoreCase("true");
        boolean pensioners = this.get(request, "pensioners").equalsIgnoreCase("true");
        boolean exits = this.get(request, "exits").equalsIgnoreCase("true");
        boolean newMembers = this.get(request, "newMembers").equalsIgnoreCase("true");
        boolean membersDueRetirement = this.get(request, "membersDueRetirement").equalsIgnoreCase("true");
        boolean membersOnExitNotice = this.get(request, "membersOnExitNotice").equalsIgnoreCase("true");

        adminDashboardItems.setActiveMembers(activeMembers);
        adminDashboardItems.setDefferedMembers(defferedMembers);
        adminDashboardItems.setPensioners(pensioners);
        adminDashboardItems.setExits(exits);
        adminDashboardItems.setNewMembers(newMembers);
        adminDashboardItems.setMembersDueRetirement(membersDueRetirement);
        adminDashboardItems.setMembersOnExitNotice(membersOnExitNotice);

        if (adminDashboardI.edit(adminDashboardItems) != null) {
            audit(session, "Updated Admin Dashboard configuration settings");
            this.respond(response, true, "Admin Dashboard configurations successfully saved", null);
        } else {
            this.respond(response, true, "Admin Dashboard configurations could not be saved", null);
        }
    }

    private void deleteMediaFile(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Media m = mediaBeanI.findById(helper.toLong(this.get(request, "id")));
        if (mediaBeanI.delete(m)) {
            audit(session, "Deleted a media/file: " + m.getName());
            this.respond(response, true, "Media/File was successfully deleted", null);
        } else {
            this.respond(response, true, "Media/File could not be deleted", null);
        }
    }

    private void deleteContactReason(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ContactCategory cc = contactCategoryBeanI.findById(helper.toLong(this.get(request, "id")));
        if (contactCategoryBeanI.delete(cc)) {
            audit(session, "Deleted a contact category: " + cc.getName());
            this.respond(response, true, "Contact category was successfully deleted", null);
        } else {
            this.respond(response, false, "Contact category could not be deleted", null);
        }
    }

    private void editSocialMediaSettings(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        /* Social Media Links Update Request */
        Social social = socialBeanI.find();
        social.setTwitter(this.get(request, "twitter"));
        social.setFacebook(this.get(request, "facebook"));
        social.setLinkedin(this.get(request, "linkedin"));
        social.setGoogle(this.get(request, "google"));
        social.setYoutube(this.get(request, "youtube"));
        social.setPinterest(this.get(request, "pinterest"));
        if (socialBeanI.edit(social) != null) {
            audit(session, "Updated portal social network settings");
            this.respond(response, true, "Social network details successfully saved", null);
        } else {
            this.respond(response, false, "Social network details could not be saved", null);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        /* Logout Request */
        logActivity("", "logged out", this.getSessKey(request, Constants.UID), null,
                this.getSessKey(request, Constants.U_PROFILE));
        audit(session, "Logged out of the portal");
        session.invalidate();
        this.respond(response, true, "You have been successfully logged out", null);
    }

    private void editMenuSettings(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        /* Menu Update Request */
        boolean annuityQuotationActive = this.get(request, "annuityQuotationActive").equalsIgnoreCase("true");
        boolean benefitProjectionActive = this.get(request, "benefitProjectionActive").equalsIgnoreCase("true");
        boolean potentialMemberActive = this.get(request, "potentialMemberActive").equalsIgnoreCase("true");
        boolean potentialSponsorActive = this.get(request, "potentialSponsorActive").equalsIgnoreCase("true");
        boolean interestRatesActive = this.get(request, "interestRatesActive").equalsIgnoreCase("true");
        boolean unitPriceActive = this.get(request, "unitPriceActive").equalsIgnoreCase("true");
        boolean whatIfAnalysisActive = this.get(request, "whatIfAnalysisActive").equalsIgnoreCase("true");
        boolean contactUsActive = this.get(request, "contactUsActive").equalsIgnoreCase("true");
        boolean faqActive = this.get(request, "faqActive").equalsIgnoreCase("true");
        Menu menu = menuBeanI.find();
        menu.setAnnuityQuotationActive(annuityQuotationActive);
        menu.setBenefitProjectionActive(benefitProjectionActive);
        menu.setPotentialMemberActive(potentialMemberActive);
        menu.setPotentialSponsorActive(potentialSponsorActive);
        menu.setInterestRatesActive(interestRatesActive);
        menu.setUnitPriceActive(unitPriceActive);
        menu.setWhatIfAnalysisActive(whatIfAnalysisActive);
        menu.setContactUsActive(contactUsActive);
        menu.setFaqActive(faqActive);
        menu.setAnnuityQuotationName(this.get(request, "annuityQuotationName"));
        menu.setBenefitProjectionName(this.get(request, "benefitProjectionName"));
        menu.setPotentialMemberName(this.get(request, "potentialMemberName"));
        menu.setPotentialSponsorName(this.get(request, "potentialSponsorName"));
        menu.setInterestRatesName(this.get(request, "interestRatesName"));
        menu.setUnitPriceName(this.get(request, "unitPriceName"));
        menu.setWhatIfAnalysisName(this.get(request, "whatIfAnalysisName"));
        menu.setContactUsName(this.get(request, "contactUsName"));
        menu.setFaqName(this.get(request, "faqName"));
        if (menuBeanI.edit(menu) != null) {
            audit(session, "Updated portal menu configuration settings");
            this.respond(response, true, "Portal menu configurations successfully saved", null);
        } else {
            this.respond(response, true, "Portal menu configurations could not be saved", null);
        }
    }

    private void enableAccountRecovery(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        boolean accountRecoveryActive = this.get(request, "accountRecoveryActive").equalsIgnoreCase("true");

        AccountRecovery accountRecovery = accountRecoveryBeanI.find();
        accountRecovery.setAccountRecoveryActive(accountRecoveryActive);

        accountRecovery.setAccountRecoveryName(this.get(request, "accountRecoveryName"));

        if (accountRecoveryBeanI.edit(accountRecovery) != null) {
            audit(session, "Updated portal Account recovery configuration settings");
            this.respond(response, true, "Portal Account recovery configurations successfully saved", null);
        } else {
            this.respond(response, true, "Portal Account recovery configurations could not be saved", null);
        }
    }

    private void editDbMenu(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        /* DB_Menu Update Request */

        boolean contributionHistoryActive = this.get(request, "contributionHistoryActive").equalsIgnoreCase("true");
        boolean contributionHistoryGridActive = this.get(request, "contributionHistoryGridActive").equalsIgnoreCase("true");
        boolean balancesHistoryActive = this.get(request, "balancesHistoryActive").equalsIgnoreCase("true");
        boolean balancesHistoryGridActive = this.get(request, "balancesHistoryGridActive").equalsIgnoreCase("true");
        boolean statementOfAccountActive = this.get(request, "statementOfAccountActive").equalsIgnoreCase("true");
        boolean statementOfAccountGridActive = this.get(request, "statementOfAccountGridActive").equalsIgnoreCase("true");
        boolean benefitsProjectionActive = this.get(request, "benefitsProjectionActive").equalsIgnoreCase("true");
        boolean benefitsProjectionGridActive = this.get(request, "benefitsProjectionGridActive").equalsIgnoreCase("true");
        boolean whatIfAnalysisActiveDb = this.get(request, "whatIfAnalysisActiveDb").equalsIgnoreCase("true");

        DBMenu dbMenu = dbMenuBeanI.find();

        dbMenu.setContributionHistoryActive(contributionHistoryActive);
        dbMenu.setContributionHistoryGridActive(contributionHistoryGridActive);
        dbMenu.setBalancesHistoryActive(balancesHistoryActive);
        dbMenu.setBalancesHistoryGridActive(balancesHistoryGridActive);
        dbMenu.setStatementOfAccountActive(statementOfAccountActive);
        dbMenu.setStatementOfAccountGridActive(statementOfAccountGridActive);
        dbMenu.setBenefitsProjectionActive(benefitsProjectionActive);
        dbMenu.setBenefitsProjectionGridActive(benefitsProjectionGridActive);
        dbMenu.setWhatIfAnalysisActiveDb(whatIfAnalysisActiveDb);

        dbMenu.setContributionHistoryName(this.get(request, "contributionHistoryName"));
        dbMenu.setContributionHistoryGridName(this.get(request, "contributionHistoryGridName"));
        dbMenu.setBalancesHistoryName(this.get(request, "balancesHistoryName"));
        dbMenu.setBalancesHistoryGridName(this.get(request, "balancesHistoryGridName"));
        dbMenu.setStatementOfAccountName(this.get(request, "statementOfAccountName"));
        dbMenu.setStatementOfAccountGridName(this.get(request, "statementOfAccountGridName"));
        dbMenu.setBenefitsProjectionName(this.get(request, "benefitsProjectionName"));
        dbMenu.setBenefitsProjectionGridName(this.get(request, "benefitsProjectionGridName"));
        dbMenu.setWhatIfAnalysisNameDb(this.get(request, "whatIfAnalysisNameDb"));

        if (dbMenuBeanI.edit(dbMenu) != null) {
            audit(session, "Updated DB Scheme menu configuration settings");
            this.respond(response, true, "DB Scheme menu configurations successfully saved", null);
        } else {
            this.respond(response, true, "DB Scheme menu configurations could not be saved", null);
        }
    }

    private void editPortalSettings(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Setting settings = settingBeanI.find();
        if (this.get(request, "encrypt").equalsIgnoreCase("true")) {
            settings.setXiPath(helper.encrypt(this.get(request, "fundmasterXi")));
            settings.setUsername(helper.encrypt(this.get(request, "username")));
            settings.setPassword(helper.encrypt(this.get(request, "password")));
            settings.setPortalBaseURL(helper.encrypt(this.get(request, "portalBaseURL")));
            settings.setXiReportPath(helper.encrypt(this.get(request, "xiReportPath")));
            settings.setXiReportUsername(helper.encrypt(this.get(request, "xiReportUsername")));
            settings.setXiReportPassword(helper.encrypt(this.get(request, "xiReportPassword")));
        } else {
            settings.setXiPath(this.get(request, "fundmasterXi"));
            settings.setUsername(this.get(request, "username"));
            settings.setPassword(this.get(request, "password"));
            settings.setPortalBaseURL(this.get(request, "portalBaseURL"));
            settings.setXiReportPath(this.get(request, "xiReportPath"));
            settings.setXiReportUsername(this.get(request, "xiReportUsername"));
            settings.setXiReportPassword(this.get(request, "xiReportPassword"));
        }
        settings.setMemberOnboarding(this.get(request, "memberOnboarding"));
        settings.setSponsorOnboarding(this.get(request, "sponsorOnboarding"));
        settings.setWhatIfAnalysisFormula(this.get(request, "whatIfAnalysisFormula"));
        settings.setProjectedROR(this.get(request, "projectedROR"));
        settings.setEncrypt(this.get(request, "encrypt").equalsIgnoreCase("true"));
        if (settingBeanI.edit(settings) != null) {
            audit(session, "Updated other portal settings and configurations");
            this.respond(response, true, "Portal Settings & Configurations successfully saved", null);
        } else {
            this.respond(response, true, "Portal Settings & Configurations could not be saved", null);
        }
    }

    private void editInterestRateColumns(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        boolean accountingPeriod = this.get(request, "accountingPeriod").equalsIgnoreCase("true");
        boolean contributions = this.get(request, "contributions").equalsIgnoreCase("true");
        boolean dateDeclared = this.get(request, "dateDeclared").equalsIgnoreCase("true");
        boolean openingBalances = this.get(request, "openingBalances").equalsIgnoreCase("true");
        boolean pensionDrawDown = this.get(request, "pensionDrawDown").equalsIgnoreCase("true");
        boolean year = this.get(request, "year").equalsIgnoreCase("true");
        InterestRateColumns irc = interestRateColumnBeanI.find();
        irc.setDateDeclared(dateDeclared);
        irc.setYear(year);
        irc.setContributions(contributions);
        irc.setOpeningBalances(openingBalances);
        irc.setPensionDrawDown(pensionDrawDown);
        irc.setAccountingPeriod(accountingPeriod);
        irc.setDateDeclaredText(this.get(request, "dateDeclaredText"));
        irc.setYearText(this.get(request, "yearText"));
        irc.setContributionsText(this.get(request, "contributionsText"));
        irc.setOpeningBalancesText(this.get(request, "openingBalancesText"));
        irc.setPensionDrawDownText(this.get(request, "pensionDrawDownText"));
        irc.setAccountingPeriodText(this.get(request, "accountingPeriodText"));
        if (interestRateColumnBeanI.edit(irc) != null) {
            audit(session, "Updated interest rate column settings");
            this.respond(response, true, "Interest rate settings successfully saved", null);
        } else {
            this.respond(response, false, "Interest rate settings could not be saved", null);
        }
    }

    private void editTheme(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Theme theme = themeBeanI.findById(helper.toLong(this.get(request, "theme_id")));
        theme.setMajor(this.get(request, "major"));
        theme.setMinor(this.get(request, "minor"));
        theme.setFont(this.get(request, "font"));
        theme.setOther(this.get(request, "other"));
        theme.setHeader(this.get(request, "header"));
        theme.setContent(this.get(request, "content"));
        theme.setFooter(this.get(request, "footer"));
        if (themeBeanI.edit(theme) != null) {
            audit(session, "Updated portal theme settings");
            this.respond(response, true, "Theme settings saved", null);
        } else {
            this.respond(response, false, "Theme settings not saved", null);
        }
    }

    private void editPageContent(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        PageContent pc = pageContentBeanI.findById(helper.toLong(this.get(request, "ID")));
        pc.setPage(this.get(request, "page"));
        pc.setText(this.get(request, "description"));
        pc.setPosition(this.get(request, "position"));
        pc.setPublish(this.get(request, "publish").equalsIgnoreCase("true"));
        if (pageContentBeanI.edit(pc) != null) {
            audit(session, "Updated portal page content for page " + this.get(request, "page"));
            this.respond(response, true, "Content was successfully updated", null);
        } else {
            this.respond(response, true, "Content could not be updated", null);
        }
    }

    private void editFaqContent(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        FaqContent fc = null;
        String id = this.get(request, "ID");

        if (id == null || id.isEmpty()) {

            fc = new FaqContent();
            fc.setText(this.get(request, "answer"));
            fc.setTitle(this.get(request, "title"));
            fc.setPublish(this.get(request, "publish").equalsIgnoreCase("true"));

        } else {
            fc = faqContentBeanI.findById(helper.toLong(id));
            fc.setText(this.get(request, "answer"));
            fc.setTitle(this.get(request, "title"));
            fc.setPublish(this.get(request, "publish").equalsIgnoreCase("true"));
        }

        if (faqContentBeanI.edit(fc) != null) {
            audit(session, "Updated portal faq content");
            this.respond(response, true, "Content was successfully updated", null);
        } else {
            this.respond(response, true, "Content could not be updated", null);
        }
    }

    private void deleteLogo(HttpServletRequest request, HttpServletResponse response) {
        Logo lg = logoBeanI.findById(helper.toLong(this.get(request, "id")));
        if (logoBeanI.delete(lg)) {
            this.respond(response, true, "Logo successfully deleted", null);
        } else {
            this.respond(response, false, "Logo could not be deleted", null);
        }
    }

    private void deleteImageBanner(HttpServletRequest request, HttpServletResponse response) {
        ImageBanner b = imageBannerBeanI.findById(helper.toLong(this.get(request, "id")));
        if (imageBannerBeanI.delete(b)) {
            this.respond(response, true, "ImageBanner image successfully deleted", null);
        } else {
            this.respond(response, false, "ImageBanner image could not be deleted", null);
        }
    }

    private void updateHelpContent(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Help h = helpBeanI.findById(helper.toLong(this.get(request, "ID")));
        h.setPage(this.get(request, "page"));
        h.setDescription(this.get(request, "description"));
        helpBeanI.edit(h);
        audit(session, "Updated portal help content for page " + this.get(request, "page"));
        this.respond(response, true, "content edited", null);
    }

    private void getFundValueAsAt(HttpServletRequest request, HttpServletResponse response) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = new Date();

        String profile = this.get(request, "profile");
        jLogger.i("Profile is: " + profile);
        String profileID = this.get(request, "profileID");
        jLogger.i("profileID is: " + profileID);

        jLogger.i("The accounting period is >>>>>>>>>>>>>>>>>>>>>> " + this.get(request, "accountingPeriodId") + " <<<<<<<<<<<<<<<");

        if (profile.equalsIgnoreCase("SPONSOR")) {
            jLogger.i(" Am here (Using SPONSOR profile) ");

            this.respond(response, true, "", apiEJB.getSponsorFundValue(format.format(date), this.get(request, "accountingPeriodId"),
                    this.getSessKey(request, Constants.SCHEME_ID), profileID,
                    this.getSessKey(request, Constants.PROFILE_ID)));

        } else {
            jLogger.i(" Am here (Profile Not Sponsor) ");
            this.respond(response, true, "", apiEJB.getFundValueAsAt(format.format(date), this.get(request, "accountingPeriodId"),
                    this.getSessKey(request, Constants.SCHEME_ID), "0",
                    this.getSessKey(request, Constants.PROFILE_ID)));
        }

    }

    private void getAccountingPeriod(HttpServletRequest request, HttpServletResponse response) {
        DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date = new Date();
        this.respond(response, true, "", apiEJB.getAccountingPeriod(format.format(date), this.getSessKey(request, Constants.SCHEME_ID)));
    }

    private void getAllAccountingPeriods(HttpServletRequest request, HttpServletResponse response) {

        this.respond(response, true, "", apiEJB.getAllAccountingPeriods(this.getSessKey(request, Constants.SCHEME_ID)));
    }
    
     private void getReasonsForExit(HttpServletRequest request, HttpServletResponse response) {

        this.respond(response, true, "", apiEJB.getReasonsForExit());
    }
    
    
    

    private void changePassword(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        PasswordPolicy policy = passwordPolicyBeanI.find();
        String securityCode = this.get(request, "securityCode");
        String username = this.getSessKey(request, Constants.USER);
        String password = this.get(request, "currentPassword");
        String new_password = this.get(request, "newPassword");

        User u = userBeanI.findUser(username, password);
        jLogger.i("Am changing the password for user :" + username);

        if (u != null) {
            if (u.getSecurityCode() != null) {
                if (u.getSecurityCode().equalsIgnoreCase(securityCode)) {
                    setNewPassword(request, response, session, new_password, u);
                } else {
                    this.respond(response, false, "Sorry, your security code is invalid. Please enter a valid security code.", null);
                }
            } else if (u.getSmsActivationCode() != null) {
                if (u.getSmsActivationCode().equalsIgnoreCase(securityCode)) {
                    setNewPassword(request, response, session, new_password, u);
                } else {
                    this.respond(response, false, "Sorry, your sms code is invalid. Please enter a valid  code.", null);
                }
            } else {

                this.respond(response, false, "Sorry, your security code is invalid. Please enter a valid security code.", null);
            }
        } else {
            this.respond(response, false, "The current password you entered is wrong. Please try again.", null);
        }
    }

    private void preChangeUserPassword(HttpServletRequest request, HttpServletResponse response) {

        User u = userBeanI.find(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
        String userProfile = u.getUserProfile();
        String userName = u.getUsername();
        jLogger.i("User found: " + u.getUsername());

        //XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
        XiMember m = apiEJB.memberExists(userProfile, userName);
        String recipient = m.getPhoneNumber();

        try {
            if (helper.isEmailAddress(userName)) {
                String securityCode = UUID.randomUUID().toString();
                u.setSecurityCode(securityCode);
                userBeanI.edit(u);
                List<String> recipients = new ArrayList<>();
                recipients.add(m.getEmailAddress());
                jLogger.i("Our member still: " + m.getEmailAddress());

                Emails emails = emailsBeanI.find();
                boolean status = apiEJB.sendEmail(recipients, emails.getDefaultEmail(), null, "Change Password Request",
                        "Dear " + u.getUsername() + ", " + "You recently requested to change your password. "
                        + "Here is your security code:" + "" + securityCode
                        + "\nYou will require it to be able to change your password",
                        this.getSessKey(request, Constants.SCHEME_ID), false, "");
                if (status) {
                    this.respond(response, true, "The change password instructions have been sent to your email address", null);
                } else {
                    this.respond(response, false, "We are sorry, we were unable to send you the change password instructions", null);
                }

            } else if (helper.isValidPhone(recipient) && recipient != null || userName != null) {
                String smsCode = helper.randomNumber().toString();
                u.setSmsActivationCode(smsCode);
                userBeanI.edit(u);
                boolean smsStatus = apiEJB.sendSMS(recipient, "Dear " + u.getUserProfile() + " , " + " You recently requested to change your password."
                        + " Here is your security code: " + "" + smsCode + " You will require it to be able to change your password");
                if (smsStatus) {
                    this.respond(response, true, "The change password instructions have been sent to your phone number", null);
                } else {
                    this.respond(response, false, "We are sorry, we were unable to send you the change password instructions", null);
                }

            }
        } catch (NullPointerException e1) {
            this.respond(response, false,
                    "We are sorry, we encountered a problem obtaining your User Name. Please try again", null);
        }
    }

    private void listMembers(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        audit(session, "Accessed scheme member listing");
        jLogger.i("The SchemeId for Stats is " + this.getSessKey(request, Constants.SCHEME_ID));
        this.respond(response, true, "", apiEJB.listMembers(this.getSessKey(request, Constants.SCHEME_ID),
                this.getSessKey(request, Constants.PROFILE_ID)));
    }

    private void getSchemeCurrency(HttpServletRequest request, HttpServletResponse response) {
        this.respond(response, true, "", apiEJB.getSchemeCurrency(this.getSessKey(request, Constants.SCHEME_ID)));
    }

    private void showMemberInformationView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        XiMember xm = apiEJB.getMemberDetails(this.get(request, "memberID"), null);
        List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(this.get(request, "memberID"));
        request.setAttribute("beneficiaries", beneficiaries);
        MemberPermission memberPermission = memberPermissionBeanI.find();
        request.setAttribute("memberPermission", memberPermission);
        request.setAttribute("member", xm);
        audit(session, "Viewed member details for member #" + xm.getName());
        request.getRequestDispatcher("member/personal_information_view.jsp").forward(request, response);
    }

    private void showBeneficiaryInformationView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(this.get(request, "memberID"));
        request.setAttribute("beneficiaries", beneficiaries);

        request.setAttribute("beneficiary_id", this.get(request, "beneficiaryID"));
        request.getRequestDispatcher("member/beneficiary_info_view.jsp").forward(request, response);
    }

    private void addSchemeManager(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String profile = this.get(request, "profile");
        String email = this.get(request, "email");
        String ordinal = profileLoginFieldBeanI.findByProfile(profile);
        String ordinal_key = helper.getOrdinalKey(ordinal);
        JSONObject res = apiEJB.searchProfilesJSON(email, "EMAIL", profile,
                this.getSessKey(request, Constants.SCHEME_ID), 0, 20);
        String username;
        try {
            JSONArray json_arr = (JSONArray) res.get("rows");
            JSONObject obj = json_arr.getJSONObject(0);
            username = obj.getString(ordinal_key);
            User u = userBeanI.findUserByUsernameAndProfile(username, profile);
            SchemeMemberManager smm = new SchemeMemberManager();
            smm.setUser_id(u.getId());
            smm.setName(obj.getString("name"));
            smm.setScheme(this.getSessKey(request, Constants.SCHEME_NAME));
            smm.setSchemeID(this.getSessKey(request, Constants.SCHEME_ID));
            smm.setProfile(profile);
            schemeManagerBeanI.add(smm);
            audit(session, "Added a new scheme manager " + smm.getName());
            this.respond(response, true, "Scheme member successfully added as scheme manager", null);
        } catch (JSONException je) {
            this.respond(response, false, "Scheme member could not be added as a scheme manager", null);
        }
    }

    private void removeSchemeManager(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        SchemeMemberManager smm = schemeManagerBeanI.findById(helper.toLong(this.get(request, "id")));
        if (schemeManagerBeanI.delete(smm)) {
            audit(session, "De-linked scheme manager #" + smm.getName());
            this.respond(response, true, "Scheme member successfully delinked from scheme managers", null);
        } else {
            this.respond(response, false, "Scheme member could not be delinked from scheme managers", null);
        }
    }
    @EJB
    GenderBeanI genderBeanI;

    private void showMemberPersonalInformation(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        XiMember xm;
        xm = apiEJB.getMemberDetails(this.get(request, "memberID"), null);
        List<Country> countries = countryBeanI.find();
        request.setAttribute("countries", countries);
        List<Gender> genders = genderBeanI.find();
        request.setAttribute("genders", genders);
        List<MaritalStatus> marital_statuses = maritalStatusBeanI.find();
        request.setAttribute("maritalStatuses", marital_statuses);
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        List<Sector> sectors = sectorBeanI.find();
        request.setAttribute("sectors", sectors);
        List<Scheme> schemes;
        schemes = apiEJB.getSchemes(0, 10000);
        jLogger.i("Calling Next API");

        List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(this.get(request, "memberID"));

        request.setAttribute("beneficiaries", beneficiaries);
        request.setAttribute("schemes", schemes);
        MemberPermission memberPermission = memberPermissionBeanI.find();
        request.setAttribute("memberPermission", memberPermission);
        request.setAttribute("member", xm);

        audit(session, "Accessed editable view for member " + xm.getName());
        request.getRequestDispatcher("member/personal_information.jsp").forward(request, response);
    }

    private void changeScheme(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        audit(session, "Switched between schemes from scheme #" + this.getSessKey(request, Constants.SCHEME_ID)
                + " to scheme #" + this.get(request, "schemeID"));
        session.setAttribute(Constants.SCHEME_ID, this.get(request, "schemeID"));
        this.respond(response, true, "Scheme changed successfully", null);
    }

    private void searchSchemes(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        audit(session, "Searched schemes with parameter " + this.get(request, "search"));
        this.respond(response, true, "", apiEJB.searchSchemes(this.get(request, "search")));
    }

    private void getSchemeMode(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String scheme = this.get(request, "scheme");
        jLogger.i("Scheme from frontend ============> " + scheme);
        this.respond(response, true, "", apiEJB.getSchemeMode(scheme));
    }

    private void getSchemeSponsors(HttpServletRequest request, HttpServletResponse response) {
        String schemeId = this.get(request, "schemeId");
        jLogger.i("Scheme from frontend ============> " + schemeId);
        this.respond(response, true, "", apiEJB.getAllSchemeSponsors(schemeId));
    }

    private void getExitsInYear(HttpServletRequest request, HttpServletResponse response) {
        if (this.getSessKey(request, Constants.U_PROFILE).equals("SPONSOR")) {
            jLogger.i("AM a Sponsor");
            this.respond(response, true, "", apiEJB.getExitsInYearPerSponsor(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID)));

        } else {

            this.respond(response, true, "", apiEJB.getExitsInYear(this.getSessKey(request, Constants.SCHEME_ID)));
        }

    }

    private void getAgentCommission(HttpServletRequest request, HttpServletResponse response) {
        this.respond(response, true, "", apiEJB.getAgentCommission(this.getSessKey(request, Constants.PROFILE_ID)));
    }

    private void getNewMembersInYear(HttpServletRequest request, HttpServletResponse response) {
        this.respond(response, true, "", apiEJB.getNewMembersInYear(this.getSessKey(request, Constants.SCHEME_ID),
                this.getSessKey(request, Constants.PROFILE_ID)));
    }

    private void toggleUserStatus(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User u = userBeanI.findById(helper.toLong(this.get(request, "userID")));
        u.setStatus(!u.isStatus());
        u = userBeanI.edit(u);
        if (u != null) {
            audit(session, "Updated user status for " + u.getUserProfile() + " " + u.getUsername());
            this.respond(response, true, "The user status was successfully changed", null);
        } else {
            this.respond(response, false, "We are sorry, the user status could not be changed", null);
        }
    }

    private void showReceipts(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        // List<SchemeReceipt> receipts =new ArrayList<>();

        String date_from_string = this.get(request, "dateFrom");
        jLogger.i("Date from string: " + date_from_string);

        String date_to_string = this.get(request, "dateTo");
        jLogger.i("Date to string: " + date_to_string);

        Date date_from = null;
        Date date_to = null;

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        try {
            date_from = format.parse(date_from_string);
            date_to = format.parse(date_to_string);
        } catch (ParseException pe) {

            pe.printStackTrace();
        }

        DateFormat format_ = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (date_from != null && date_to != null) {
            //receipts = apiEJB.searchReceipts(this.getSessKey(request, Constants.SCHEME_ID), format_.format(date_from), format_.format(date_to), 0, 0);
            jLogger.i("Am here getting scheme receipts");
            if (this.getSessKey(request, Constants.U_PROFILE).equals("SPONSOR")) {

                this.respond(response, true, "", apiEJB.getReceipts(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID), format_.format(date_from), format_.format(date_to), 0, 0));
            }
        }

//        request.setAttribute("receipts", receipts);
//       logActivity("SCHEME RECEIPTS", "Viewed scheme receipts for scheme #" + this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
//       this.audit(session, "Viewed scheme receipts for scheme #" + this.getSessKey(request, Constants.SCHEME_ID));
    }

    private void getMostAccessedByManagers(HttpServletResponse response) {

        List<PieObject> poList = activityLogBeanI.mostAccessedByManagers();
        try {
            JSONObject access_list = new JSONObject().put(Fields.SUCCESS, true);
            for (PieObject aPoList : poList) {
                access_list.put(aPoList.getName(), aPoList.getCount());
            }
            this.respond(response, true, "", access_list);
        } catch (JSONException je) {
            this.respond(response, false, "Json exception just occured", null);
        }
    }
    @EJB
    ActivityLogBeanI activityLogBeanI;

    private void getProfileAccess(HttpServletResponse response) {

        List<PieObject> poList = activityLogBeanI.findAccessByProfile();
        try {
            JSONObject access_list = new JSONObject().put(Fields.SUCCESS, true);
            for (PieObject aPoList : poList) {
                access_list.put(aPoList.getName(), aPoList.getCount());
            }
            this.respond(response, true, "", access_list);
        } catch (JSONException je) {
            this.respond(response, false, "Json exception just occured", null);
        }
    }

    private void searchMember(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        JSONObject result = apiEJB.searchProfilesJSON(this.get(request, "search"),
                this.get(request, "identifier"), this.get(request, "profile"),
                this.getSessKey(request, Constants.SCHEME_ID), 0, 20);
        jLogger.i(result.toString());
        try {
            JSONArray array = result.getJSONArray("rows");
            JSONObject unitObj = array.getJSONObject(0);
            session.setAttribute("unitization", unitObj.get("unitization"));
            //jLogger.i("found unitization:::" + unitObj.get("unitization"));
            request.setAttribute("unitization", unitObj.get("unitization"));
            audit(session, "Searched members with search parameter " + this.get(request, "search"));
            this.respond(response, true, "Success", result);
        } catch (JSONException je) {
            this.respond(response, false, "", null);
        }
    }
    // List<XiMember> searchProfilesBySponsor(String search, String identifier, String profile, String sponsorID, String schemeID);

    private void searchMemberBySponsor(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String sponsorId = "";
        if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.SPONSOR)) {

            sponsorId = this.getSessKey(request, Constants.PROFILE_ID);
            jLogger.i("Searching Using SponsorId " + sponsorId);
        }
        JSONObject result = apiEJB.searchProfilesBySponsorJSON(this.get(request, "search"),
                this.get(request, "identifier"), this.get(request, "profile"), sponsorId,
                this.getSessKey(request, Constants.SCHEME_ID));
        jLogger.i(result.toString());

        try {
            JSONArray array = result.getJSONArray("rows");
            JSONObject unitObj = array.getJSONObject(0);
            session.setAttribute("unitization", unitObj.get("unitization"));
            jLogger.i("found unitization:::" + unitObj.get("unitization"));
            request.setAttribute("unitization", unitObj.get("unitization"));
            audit(session, "Searched members with search parameter " + this.get(request, "search"));
            this.respond(response, true, "Success", result);
        } catch (JSONException je) {
            this.respond(response, false, "", null);
        }
    }

    private void deletePortalMember(HttpServletRequest request, HttpServletResponse response) {
        Member m = memberBeanI.findById(helper.toLong(this.get(request, "id")));
        if (memberBeanI.delete(m)) {
            this.respond(response, true, "Potential member record successfully deleted", null);
        } else {
            this.respond(response, false, "Potential member record could not be deleted", null);
        }
    }

    private void forwardSponsorToXi(HttpServletRequest request, HttpServletResponse response) {
        String sponsorID = this.get(request, "id");
        Sponsor sp = sponsorBeanI.findById(helper.toLong(sponsorID));
        DateFormat format_ = new SimpleDateFormat(Constants.YYYY_MM_DD, Locale.ENGLISH);
        JSONObject jsponsor = new JSONObject();
        try {
            jsponsor.put("sponsor.name", sp.getCompanyName())
                    .put("sponsor.applicationDate", format_.format(sp.getApplicationDate()))
                    .put("sponsor.address.residentialAddress", sp.getCompanyAddress())
                    .put("sponsor.address.fixedPhone", sp.getPhoneNumber())
                    .put("sponsor.address.email", sp.getEmailAddress())
                    .put("sponsor.address.town", sp.getCity())
                    .put("sponsor.address.country", sp.getCountry() != null ? sp.getCountry().getName() : null)
                    .put("sponsor.sector", sp.getSector() != null ? sp.getSector().getName() : null)
                    .put("sponsor.employerpin", sp.getEmployerRefNo())
                    .put("sponsor.pin", sp.getPinNumber())
                    .put("sponsor.status", "POTENTIAL_SPONSOR");
            boolean status = apiEJB.saveOrUpdateSponsor(sp.toString());
            this.respond(response, status, status ? "Sponsor details were successfully saved" : "Sponsor details could not be saved", null);
        } catch (JSONException je) {
            jLogger.e("We encountered a JSON Exception " + je.getMessage());
        }
    }

    private void submitSponsorToXi(HttpServletResponse response, HttpServletRequest request) {
        JSONObject jsponsor = xtractSponsorFromRequest(request);
        boolean status = apiEJB.saveOrUpdateSponsor(jsponsor.toString());
        this.respond(response, status, status ? "Sponsor details were successfully saved" : "Sponsor details could not be saved", null);
    }

    private void forwardMemberToXi(HttpServletRequest request, HttpServletResponse response) {
        String memberID = this.get(request, "id");
        Member m = memberBeanI.findById(helper.toLong(memberID));
        DateFormat format_ = new SimpleDateFormat(Constants.MMM_d_yyyy, Locale.ENGLISH);
        String title;
        if (m.getGender().getName().equalsIgnoreCase("male")) {
            title = "Mr";
        } else {
            title = "Mrs";
        }
        JSONObject member = new JSONObject();
        boolean status = false;
        try {
            member.put("member.surname", m.getLastname());
            member.put("member.firstname", m.getFirstname());
            member.put("member.othernames", m.getOthernames());
            member.put("member.address.email", m.getEmailAddress());
            member.put("member.idNo", m.getIdNumber());
            member.put("member.address.cellPhone", m.getPhoneNumber());
            member.put("member.dob", format_.format(m.getDateOfBirth()))
                    .put("member.gender", m.getGender().getName().toUpperCase())
                    .put("member.title", title)
                    .put("member.address.residentialAddress", m.getResidentialAddress())
                    .put("member.address.town", m.getCity())
                    .put("member.country", m.getCountry())
                    .put("member.maritalStatus", m.getMaritalStatus().getName().toUpperCase())
                    .put("member.mbshipStatus", "INACTIVE")
                    .put("member.schemeId", m.getScheme());
            status = apiEJB.saveOrUpdateMember(member.toString());
        } catch (JSONException je) {
            jLogger.e("WE have a JSOn Exception " + je.getMessage());
        }
        this.respond(response, status, status ? "Member details were successfully saved" : "Member details could not be saved", null);
    }

    private void submitPortalMemberToXi(HttpServletResponse response, HttpServletRequest request) {
        boolean status = apiEJB.saveOrUpdateMember(xtractMemberFromRequest(request).toString());
        this.respond(response, status, status ? "Member details were successfully saved" : "Could not save the member details", null);
    }

    private void deletePortalSponsor(HttpServletRequest request, HttpServletResponse response) {
        Sponsor s = sponsorBeanI.findById(helper.toLong(this.get(request, "id")));
        if (sponsorBeanI.delete(s)) {
            this.respond(response, true, "Potential sponsor record successfully deleted", null);
        } else {
            this.respond(response, false, "Potential sponsor record could not be deleted", null);
        }
    }

    private void getFrontPageAccessByPage(HttpServletResponse response) {
        List<PieObject> poList = activityLogBeanI.findByFrontPageAccess();
        try {
            JSONObject access_list = new JSONObject().put(Fields.SUCCESS, true);
            for (PieObject aPoList : poList) {
                access_list.put(aPoList.getName(), aPoList.getCount());
            }
            this.respond(response, true, "", access_list);
        } catch (JSONException je) {
            this.respond(response, false, "Json exception just occured", null);
        }
    }

    private void editProfileLoginFields(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String[] profiles = helper.listProfiles();
        boolean status = true;
        for (String profile : profiles) {
            ProfileLoginField plf = profileLoginFieldBeanI.find(profile);
            plf.setOrdinal(this.get(request, plf.getProfile()));
            jLogger.i("Ordinal to be set >>>>>>>>>>> " + this.get(request, plf.getProfile()) + " <<<<<<<<<<<<<<<");
            plf.setPublished(this.get(request, plf.getProfile() + "_PUBLISHED").equalsIgnoreCase("true"));
            status = status && profileLoginFieldBeanI.edit(plf) != null;
        }
        if (status) {
            audit(session, "Updated profile login settings");
            this.respond(response, true, "Profile login settings successfully saved", null);
        } else {
            this.respond(response, false, "Profile login settings could not be saved", null);
        }
    }

    private void editClientSetupFields(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String clientAbb = this.get(request, "client");
        String message = this.get(request, "msg");
        message.trim();
        jLogger.i("The message is " + message);
        jLogger.i("The client is " + clientAbb);
        ClientSetup csf = clientSetupI.find(clientAbb);
        if (csf != null) {
            csf.setClientRegistrationMessage(message);
            clientSetupI.edit(csf);
        } else {
            csf = new ClientSetup();
            csf.setClientRegistrationMessage(message);
            csf.setClientOrdinal(clientAbb);
            clientSetupI.add(csf);

        }
        if (clientSetupI.edit(csf) != null || clientSetupI.add(csf) != null) {
            audit(session, "Updated Client Setup settings");
            this.respond(response, true, "Client Setup settings successfully saved", null);
        } else {
            this.respond(response, false, "Client Setup settings could not be saved", null);
        }

    }

    private void editPasswordPolicy(HttpServletRequest request, HttpServletResponse response) {
        PasswordPolicy p = passwordPolicyBeanI.find();
        p.setExpiry_days(Integer.parseInt(this.get(request, "expiry_days")));
        p.setLength(Integer.parseInt(this.get(request, "length")));
        p.setLock_after_count_of(Integer.parseInt(this.get(request, "lock_after_count_of")));
        p.setLowercase(this.get(request, "lowercase").equalsIgnoreCase("true"));
        p.setNumbers(this.get(request, "numbers").equalsIgnoreCase("true"));
        p.setPassword_reuse(this.get(request, "password_reuse").equalsIgnoreCase("true"));
        p.setUppercase(this.get(request, "uppercase").equalsIgnoreCase("true"));
        if (passwordPolicyBeanI.edit(p) != null) {
            this.respond(response, true, "Password policy successfully saved", null);
        } else {
            this.respond(response, false, "Password policy could not be saved", null);
        }
    }

    private void savePermissions(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        audit(session, "Updated permissions and privileges for " + this.get(request, "profile"));
        Permission perm = permissionBeanI.findByProfile(this.get(request, "profile"));
        perm.setSetup(this.get(request, "setup").equalsIgnoreCase("true"));
        perm.setContent(this.get(request, "content").equalsIgnoreCase("true"));
        perm.setSchemes(this.get(request, "schemes").equalsIgnoreCase("true"));
        perm.setReceipts(this.get(request, "receipts").equalsIgnoreCase("true"));
        perm.setPayments(this.get(request, "payments").equalsIgnoreCase("true"));
        perm.setOperations(this.get(request, "member_operations").equalsIgnoreCase("true"));
        perm.setWithdrawal_statement(this.get(request, "withdrawal_statement").equalsIgnoreCase("true"));
        perm.setAdmin_fee_listing(this.get(request, "admin_fee_listing").equalsIgnoreCase("true"));
        perm.setWithdrawal_settlements(this.get(request, "withdrawal_settlements").equalsIgnoreCase("true"));
        perm.setMembers(this.get(request, "members").equalsIgnoreCase("true"));
        perm.setMedia(this.get(request, "media").equalsIgnoreCase("true"));
        perm.setDocument(this.get(request, "document").equalsIgnoreCase("true"));
        perm.setReports(this.get(request, "reports").equalsIgnoreCase("true"));
        perm.setMember_movement(this.get(request, "member_movement").equalsIgnoreCase("true"));
        perm.setMember_listing(this.get(request, "member_listing").equalsIgnoreCase("true"));
        perm.setCorporate_statement(this.get(request, "corporate_statement").equalsIgnoreCase("true"));
        perm.setFund_movement(this.get(request, "fund_movement").equalsIgnoreCase("true"));
        perm.setReceipt_summary(this.get(request, "receipt_summary").equalsIgnoreCase("true"));
        perm.setPending_contribution(this.get(request, "pending_contribution").equalsIgnoreCase("true"));
        perm.setUac(this.get(request, "uac").equalsIgnoreCase("true"));
        perm.setAnalytics(this.get(request, "analytics").equalsIgnoreCase("true"));
        perm.setBenefitProjectionPage(this.get(request, "benefitProjectionPage").equalsIgnoreCase("true"));
        perm.setSponsorBenefitProjectionPage(this.get(request, "sponsorBenefitProjectionPage").equalsIgnoreCase("true"));

        perm.setCalculator_log(this.get(request, "calculator_log").equalsIgnoreCase("true"));
        perm.setContent_help(this.get(request, "content_help").equalsIgnoreCase("true"));
        perm.setContent_page(this.get(request, "content_page").equalsIgnoreCase("true"));
        perm.setFaq_page(this.get(request, "faq_page").equalsIgnoreCase("true"));
        perm.setMedia_remove(this.get(request, "media_remove").equalsIgnoreCase("true"));
        perm.setMedia_upload(this.get(request, "media_upload").equalsIgnoreCase("true"));
        perm.setMember_edit(this.get(request, "member_edit").equalsIgnoreCase("true"));
        perm.setMember_view(this.get(request, "member_view").equalsIgnoreCase("true"));
        perm.setMember_edit_permissions(this.get(request, "member_edit_permissions").equalsIgnoreCase("true"));
        perm.setShow_db_contribution_graph(this.get(request, "show_db_contribution_graph").equalsIgnoreCase("true"));
        perm.setMember_menu_config(this.get(request, "member_menu_config").equalsIgnoreCase("true"));
        perm.setPensioner_menu_config(this.get(request, "pensioner_menu_config").equalsIgnoreCase("true"));
        perm.setMember_dashboard_items(this.get(request, "member_dashboard_items").equalsIgnoreCase("true"));
        perm.setAdmin_dashboard_items(this.get(request, "admin_dashboard_items").equalsIgnoreCase("true"));
        perm.setProfile_login_username(this.get(request, "profile_login_username").equalsIgnoreCase("true"));
        perm.setClient_setup_config(this.get(request, "client_setup_config").equalsIgnoreCase("true"));
        perm.setProfile_privileges(this.get(request, "profile_privileges").equalsIgnoreCase("true"));
        perm.setProfile_names(this.get(request, "profile_names").equalsIgnoreCase("true"));
        perm.setClient_names(this.get(request, "client_names").equalsIgnoreCase("true"));
        perm.setSetup_banner(this.get(request, "setup_banner").equalsIgnoreCase("true"));
        perm.setSetup_company(this.get(request, "setup_company").equalsIgnoreCase("true"));
        perm.setSetup_email(this.get(request, "setup_email").equalsIgnoreCase("true"));
        perm.setSetup_contact_reason(this.get(request, "setup_contact_reason").equalsIgnoreCase("true"));
        perm.setSetup_interest_rate(this.get(request, "setup_interest_rate").equalsIgnoreCase("true"));
        perm.setEnable_acc_recovery(this.get(request, "enable_acc_recovery").equalsIgnoreCase("true"));
        perm.setSetup_logo(this.get(request, "setup_logo").equalsIgnoreCase("true"));
        perm.setSetup_menu(this.get(request, "setup_menu").equalsIgnoreCase("true"));
        perm.setDb_menu(this.get(request, "db_menu").equalsIgnoreCase("true"));
        perm.setSetup_other(this.get(request, "setup_other").equalsIgnoreCase("true"));
        perm.setSetup_social(this.get(request, "setup_social").equalsIgnoreCase("true"));
        perm.setSetup_theme(this.get(request, "setup_theme").equalsIgnoreCase("true"));
        perm.setOperation_balance_history(
                this.get(request, "operation_balance_history").equalsIgnoreCase("true"));
        perm.setOperation_benefit_projection(
                this.get(request, "operation_benefit_projection").equalsIgnoreCase("true"));
        perm.setOperation_annual_contribution(
                this.get(request, "operation_annual_contribution").equalsIgnoreCase("true"));
        perm.setOperation_claim_status(
                this.get(request, "operation_claim_status").equalsIgnoreCase("true"));
        perm.setOperation_contribution_history(
                this.get(request, "operation_contribution_history").equalsIgnoreCase("true"));
        perm.setOperation_personal_info(this.get(request, "operation_personal_info").equalsIgnoreCase("true"));
        perm.setOperation_statement_of_account(
                this.get(request, "operation_statement_of_account").equalsIgnoreCase("true"));
        perm.setOperation_unitized_statement(this.get(request, "operation_unitized_statement").equalsIgnoreCase("true"));
        perm.setUsers(this.get(request, "users").equalsIgnoreCase("true"));
        perm.setUser_enable_disable(this.get(request, "user_enable_disable").equalsIgnoreCase("true"));
        perm.setAudit_trail(this.get(request, "audit_trail").equalsIgnoreCase("true"));
        perm.setPortal_member_add(this.get(request, "portal_member_add").equalsIgnoreCase("true"));
        perm.setPortal_member_delete(this.get(request, "portal_member_delete").equalsIgnoreCase("true"));
        perm.setPortal_member_process(this.get(request, "portal_member_process").equalsIgnoreCase("true"));
        perm.setPortal_member_view(this.get(request, "portal_member_view").equalsIgnoreCase("true"));
        perm.setPortal_members(this.get(request, "portal_members").equalsIgnoreCase("true"));
        perm.setPortal_sponsor_add(this.get(request, "portal_sponsor_add").equalsIgnoreCase("true"));
        perm.setPortal_sponsor_delete(this.get(request, "portal_sponsor_delete").equalsIgnoreCase("true"));
        perm.setPortal_sponsor_process(this.get(request, "portal_sponsor_process").equalsIgnoreCase("true"));
        perm.setPortal_sponsor_view(this.get(request, "portal_sponsor_view").equalsIgnoreCase("true"));
        perm.setPortal_sponsors(this.get(request, "portal_sponsors").equalsIgnoreCase("true"));
        perm.setPassword_policy(this.get(request, "password_policy").equalsIgnoreCase("true"));
        if (permissionBeanI.edit(perm) != null) {
            this.respond(response, true, "Permissions successfully saved", null);
        } else {
            this.respond(response, false, "Permissions could not be saved", null);
        }
    }

    private void showPermissions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Permission perm = permissionBeanI.findByProfile(this.get(request, "profile"));
        request.setAttribute("permissions", perm);
        request.getRequestDispatcher("dashboard/permissions.jsp").forward(request, response);
    }

    private void showMemberBeneficiary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this.get(request, "type").equals("EDIT")) {
            List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(this.get(request, "memberID"));
            request.setAttribute("beneficiaries", beneficiaries);
        }
        request.setAttribute("beneficiary_id", this.get(request, "beneficiaryID"));
        request.setAttribute("type", this.get(request, "type"));
        request.getRequestDispatcher("member/beneficiary.jsp").forward(request, response);
    }

    private void updateMember(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String FILE_SEPERATOR, String SCHEME_DOC_ROOT_FOLDER, String scheme_doc_folder) {

        try {

            String memberID = this.get(request, "memberID");
            XiMember mbr = apiEJB.getMemberDetails(memberID, null);

            JSONObject member = new JSONObject();
            String firstname = this.get(request, "firstname");
            if (firstname == "" || firstname == null) {
                firstname = mbr.getFirstname();
            }

            String surname = this.get(request, "surname");
            if (surname == "" || surname == null) {
                surname = mbr.getSurname();
            }
            jLogger.i(" Surname  & firstname " + surname + " " + firstname);

            String othernames = this.get(request, "othernames");
            if (othernames == "" || othernames == null) {
                othernames = mbr.getOthernames();
            }

            String memberNo = this.get(request, "memberNo");
            if (memberNo == "" || memberNo == null) {
                memberNo = mbr.getMemberNo();
            }

            String postalAddress = this.get(request, "postalAddress");
            if (postalAddress == "" || postalAddress == null) {
                postalAddress = mbr.getPostalAddress();
            }

            String maritalStatus = this.get(request, "maritalStatus");
            if (maritalStatus == "" || maritalStatus == null) {
                maritalStatus = mbr.getMaritalStatus();
            }

            String phoneNumber = this.get(request, "phoneNumber");
            if (phoneNumber == "" || phoneNumber == null) {
                phoneNumber = mbr.getPhoneNumber();
            }

            String emailAddress = this.get(request, "emailAddress");
            if (emailAddress == "" || emailAddress == null) {
                emailAddress = mbr.getEmailAddress();
            }

            /*String salary = this.get(request, "currentAnnualPensionableSalary");
            if (salary == "" || salary == null) {
                salary = mbr.getAnnualPensionableSalary();
            }*/
            String city = this.get(request, "city");
            if (city == "" || city == null) {
                city = mbr.getTown();
            }

            String country = this.get(request, "country");
            if (country == "" || country == null) {
                country = mbr.getCountry();
            }

            String dateOfBirth = this.get(request, "dateOfBirth");
            if (dateOfBirth == "" || dateOfBirth == null) {
                dateOfBirth = mbr.getDateOfBirth();
            }
            jLogger.i("Date of birth from user >>>>>>>>>>>>> " + dateOfBirth + " <<<<<<<<<<<<<<<<");
            DateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
            Date dob = null;
            try {
                dob = df.parse(dateOfBirth);
            } catch (ParseException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            String status = "ACTIVE";

            String gender = this.get(request, "gender").toUpperCase();
            if (gender == "" || gender == null) {
                gender = mbr.getGender().toUpperCase();
            }
            jLogger.i("Gender is >>>>>>>>>> " + gender + " <<<<<<<<<<<<<");

            DateFormat format_ = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            try {
                member.put("member.surname", surname).put("member.firstname", firstname)
                        .put("member.othernames", othernames)
                        .put("member.person.biodata.town", city)
                        .put("member.dob", format_.format(dob))
                        .put("member.id", memberID)
                        .put("member.memberNo", memberNo)
                        .put("member.gender", gender)
                        .put("member.mbshipStatus", status)
                        .put("member.address.email", emailAddress)
                        .put("member.address.cellPhone", phoneNumber)
                        .put("member.address.postalAddress", postalAddress)
                        .put("member.country", country)
                        .put("member.address.town", city)
                        .put("member.maritalStatus", maritalStatus);

                boolean status_ = apiEJB.saveOrUpdateMember(member.toString());
                this.respond(response, status_, status_ ? "Member details were successfully saved" : "Member details could not be saved", null);
            } catch (JSONException e) {
                this.respond(response, false, "Sorry, something didn't work out right. Couldn't save the member details", null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void uploadDocument(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String FILE_SEPERATOR, String SCHEME_DOC_ROOT_FOLDER, String scheme_doc_folder) {

        boolean attachment = false;
        String attachment_path = null;
        String attachment_name = null;

        try {

            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (!fileName.equals("")) {
                    jLogger.i("File name is :::::::::" + fileName);
                    File path = new File(getServletContext().getRealPath("/"));
                    if (scheme_doc_folder == null) {
                        scheme_doc_folder = path.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getPath() + FILE_SEPERATOR + SCHEME_DOC_ROOT_FOLDER;
                        helper.createFolderIfNotExists(scheme_doc_folder);
                    }
                    try {
                        // String url = scheme_doc_folder + FILE_SEPERATOR + fileName;
                        String fullpath = scheme_doc_folder + FILE_SEPERATOR + fileName;
                        jLogger.i("full path is:" + fullpath);
                        part.write(fullpath);
                        jLogger.i("Complete file path is: " + fullpath);
                        attachment_name = fileName;
                        attachment_path = fullpath;
                        attachment = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            jLogger.i("Attachment has been uploaded >>>>>>>> " + attachment + " <<<<<<<<<<<");

            String attachment_url = attachment_path;
            jLogger.i("Attachment URL is ::::::::::::::::::> " + attachment_url);

            String memberID = this.get(request, "memberID");
            XiMember mbr = apiEJB.getMemberDetails(memberID, null);

            JSONObject member = new JSONObject();

            try {
                member.put("member.attachmentname", attachment_name)
                        .put("member.id", memberID);
                if (attachment) {
                    member.put("member.attachment", attachment_url);
                } else {
                    member.put("member.attachment", new ArrayList<String>());
                }

                boolean status_ = apiEJB.uploadMemberDocument(member.toString());

                this.respond(response, status_, status_ ? "Document was successfully uploaded" : "Document was not uploaded", null);
            } catch (JSONException e) {
                this.respond(response, false, "Sorry, something didn't work out right. Couldn't upload document", null);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void editBeneficiary(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String FILE_SEPERATOR, String SCHEME_DOC_ROOT_FOLDER, String scheme_doc_folder) {
        boolean attachment = false;
        String attachment_path = null;
        String attachment_name = null;
        try {
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (!fileName.equals("")) {
                    jLogger.i("File name is :::::::::" + fileName);
                    File path = new File(getServletContext().getRealPath("/"));
                    if (scheme_doc_folder == null) {
                        scheme_doc_folder = path.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getPath() + FILE_SEPERATOR + SCHEME_DOC_ROOT_FOLDER;
                        helper.createFolderIfNotExists(scheme_doc_folder);
                    }
                    try {
                        String url = scheme_doc_folder + FILE_SEPERATOR + fileName;
                        String fullpath = scheme_doc_folder + FILE_SEPERATOR + fileName;
                        jLogger.i("full path is:" + fullpath);
                        part.write(fullpath);
                        jLogger.i("Complete file path is: " + fullpath);
                        attachment_name = fileName;
                        attachment_path = fullpath;
                        attachment = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject b = new JSONObject();
            String beneficiary_id = this.get(request, "beneficiary_id");
            String memberID = this.get(request, "memberID");
            jLogger.i("The member Id passed is <<<<<<<<<<< " + memberID + " >>>>>>>>>>");
            String relationshipCategory = this.get(request, "relationshipCategory");
            jLogger.i("The relationship category >>>>>>>>>>>>>>>>>> " + relationshipCategory + " <<<<<<<<<<<<<<<<<<<");
            String surname = this.get(request, "surname");
            String lumpsum = this.get(request, "lumpsum");
            String firstname = this.get(request, "firstname");
            jLogger.i("First name to be passed: " + firstname);
            String gender = this.get(request, "gender");
            jLogger.i("The gender is >>>>>>>>>>>>>> " + gender + " <<<<<<<<<<<<<<<<<");
            String maritalStatus = this.get(request, "mStatus");
            jLogger.i("Marital status is >>>>>>>>>>>>>>>> " + maritalStatus + " <<<<<<<<<<<<<<<<<");
            String status = this.get(request, "status");
            String othernames = this.get(request, "othernames");
            String relationship = this.get(request, "relationship");
            jLogger.i("The relationship >>>>>>>>>>>>>>>> " + relationship + " <<<<<<<<<<<<<<<<<<<");
            String attachment_url = attachment_path;
            jLogger.i("Attachment URL is ::::::::::::::::::> " + attachment_url);
            try {
                if (this.get(request, "type").equalsIgnoreCase("EDIT")) {
                    b.put("ben.memberId", memberID).put("ben.relationship", relationship)
                            .put("ben.attachmentname", attachment_name)
                            .put("beneficiary.id", beneficiary_id)
                            .put("ben.relShipCategory", relationshipCategory)
                            .put("ben.surname", surname)
                            .put("ben.firstname", firstname).put("ben.othernames", othernames).put("ben.dob", "")
                            .put("ben.gender", gender).put("ben.monthlyEntitlement", 0)
                            .put("ben.lumpsumEntitlement", lumpsum).put("ben.idNo", "")
                            .put("ben.address.postalAddress", "").put("ben.mstatus", maritalStatus)
                            .put("ben.physicalCondition", "").put("ben.status", status);
                    if (attachment) {
                        b.put("ben.attachment", attachment_url);
                    } else {
                        b.put("ben.attachment", new ArrayList<String>());
                    }
                } else if (this.get(request, "type").equalsIgnoreCase("ADD")) {
                    b.put("ben.memberId", memberID).put("beneficiary.id", beneficiary_id)
                            .put("ben.relationship", relationship).put("ben.attachmentname", attachment_name)
                            .put("ben.relShipCategory", relationshipCategory)
                            .put("ben.surname", surname).put("ben.firstname", firstname)
                            .put("ben.othernames", othernames).put("ben.dob", "").put("ben.gender", gender)
                            .put("ben.monthlyEntitlement", 0).put("ben.lumpsumEntitlement", lumpsum).put("ben.idNo", "")
                            .put("ben.address.postalAddress", "").put("ben.mstatus", maritalStatus)
                            .put("ben.physicalCondition", "").put("ben.status", status);
                    if (attachment) {
                        b.put("ben.attachment", attachment_url);
                    } else {
                        b.put("ben.attachment", new ArrayList<String>());
                    }
                }
                boolean done = apiEJB.saveOrUpdateBeneficiary(b.toString());
                this.respond(response, done, done ? "Beneficiary information was successfully updated" : "Beneficiary information could not be updated", null);

            } catch (JSONException e) {
                this.respond(response, false, "Sorry, something didn't work out right. Couldn't save the beneficiary details", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adminPasswordReset(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String userID = this.get(request, "userID");
        User u = userBeanI.findById(helper.toLong(userID));
        if (u != null) {
            String password = helper.shorterUUID(UUID.randomUUID().toString(), 0);
            u.setPassword(helper.hash(password));
            String email_address = null;
            List<String> recipients = new ArrayList<>();
            String schemeId = null;
            boolean proceed = false;
            JSONObject res;
            String memberID;
            XiMember member = apiEJB.memberExists(u.getUserProfile(), u.getUsername());
            if (member != null) {
                jLogger.i("memberID " + member.getId() + " u.getProfileID() " + u.getProfileID());
                if (u.getUserProfile().equals(Constants.MEMBER_PROFILE)) {
                    member = apiEJB.getMemberDetails(helper.toString(member.getId()), null);
                    session.setAttribute("member_id", member.getId());
                    email_address = member.getEmailAddress();
                    //recipients.add(member.getEmailAddress());
                    schemeId = member.getSchemeId();
                    proceed = helper.isEmailAddress(email_address);
                } else {
                    member = apiEJB.getMemberDetails(u.getUserProfile(), helper.toString(member.getId()));
                    if (member != null) {
                        session.setAttribute("member_id", member.getId());
                        email_address = member.getEmailAddress();
                        schemeId = member.getSchemeId();
                        proceed = helper.isEmailAddress(email_address);
                    } else {
                        proceed = false;
                    }
                }
                if (proceed) {
                    Setting settings = settingBeanI.find();
                    Emails emails = emailsBeanI.find();
                    recipients.add(email_address);
                    apiEJB.sendEmail(recipients, emails.getDefaultEmail(), null, "MSS Portal Password Reset",
                            "Dear " + u.getUserProfile() + ",<br />"
                            + "Your password has been reset on the FundMaster Xi Member Self Service Portal. Your new password is "
                            + password + ".<br />Please click this <a href='" + settings.getPortalBaseURL()
                            + "sign-in'>link</a> to gain access to the Self Service Portal",
                            schemeId, false, null);
                    if (userBeanI.edit(u) != null) {
                        this.respond(response, true,
                                "<strong>Password Reset Successful</strong><br /> Success! The user's password has been reset. An email has been sent to the user with the new password.", null);
                    } else {
                        this.respond(response, false,
                                "We could not complete the requested action as we were unable to obtain the user's email address", null);
                    }
                } else {
                    this.respond(response, false,
                            "We could not complete the requested action as we were unable to obtain the user's email address", null);
                }
            } else {
                this.respond(response, false,
                        "We could not complete the requested action as we were unable to obtain the user's email address", null);
            }
        }
    }

    private void updateProfileNames(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<ProfileName> pNames = profileNameBeanI.find();
        boolean status = true;
        for (ProfileName pName : pNames) {
            pName.setName(this.get(request, pName.getProfile()));
            status = status && profileNameBeanI.edit(pName) != null;
        }
        if (status) {
            audit(session, "Updated profile name settings");
            this.respond(response, true, "Profile name settings successfully saved", null);
        } else {
            this.respond(response, false, "Profile name settings could not be saved", null);
        }
    }

    private void updateClientNames(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<ClientName> cNames = clientNameBeanI.find();
        boolean status = true;
        for (ClientName cName : cNames) {
            cName.setClientName(this.get(request, cName.getClientName()));
            status = status && clientNameBeanI.edit(cName) != null;
        }
        if (status) {
            audit(session, "Updated Client name settings");
            this.respond(response, true, "Client name settings successfully saved", null);
        } else {
            this.respond(response, false, "Client name settings could not be saved", null);
        }
    }

    private void getSchemeContributions(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = apiEJB.getSchemeContributions(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID));
        this.respond(response, true, "success", result);
    }

    private void getSponsorContributions(HttpServletRequest request, HttpServletResponse response) {

        jLogger.i("Getting sponsor Contributions:: ");
        jLogger.i("The SchemeId is " + this.getSessKey(request, Constants.SCHEME_ID));
        jLogger.i("The ProfileId is " + this.getSessKey(request, Constants.PROFILE_ID));

        JSONObject result = apiEJB.getSponsorContributions(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID));
        this.respond(response, true, "success", result);
    }

    private void updateCompany(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        /* Company Details Update Request */
        Country country = countryBeanI.findById(helper.toLong(this.get(request, "country")));
        Company company = new Company(helper.toLong(this.get(request, "company_id")),
                this.get(request, "companyName"), this.get(request, "streetAddress"),
                this.get(request, "telephone"), this.get(request, "fax"),
                this.get(request, "city"), country, this.get(request, "geolocation"));
        if (companyBeanI.edit(company) != null) {
            audit(session, "Updated company details");
            this.respond(response, true, "success", null);
        } else {
            this.respond(response, false, "failed", null);
        }
    }

    private void updateEmails(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        /* Email Addresses Update Request */

        boolean defaultEmailActive = this.get(request, "defaultEmailActive").equalsIgnoreCase("true");
        boolean marketingEmailActive = this.get(request, "marketingEmailActive").equalsIgnoreCase("true");
        boolean supportEmailActive = this.get(request, "supportEmailActive").equalsIgnoreCase("true");
        boolean crmEmailActive = this.get(request, "crmEmailActive").equalsIgnoreCase("true");
        boolean sendWhatifEmail = this.get(request, "sendWhatifEmail").equalsIgnoreCase("true");

        Emails emails = emailsBeanI.find();

        emails.setDefaultEmailActive(defaultEmailActive);
        emails.setMarketingEmailActive(marketingEmailActive);
        emails.setSupportEmailActive(supportEmailActive);
        emails.setCrmEmailActive(crmEmailActive);

        emails.setSendWhatifEmail(sendWhatifEmail);

        emails.setDefaultEmail(this.get(request, "defaultEmail"));
        emails.setMarketingEmail(this.get(request, "marketingEmail"));
        emails.setSupportEmail(this.get(request, "supportEmail"));
        emails.setCrmEmail(this.get(request, "crmEmail"));

        /*Emails emails = new Emails(helper.toLong(this.get(request, "email_id")), this.get(request, "defaultEmail"),
        this.get(request, "marketingEmail"), this.get(request, "supportEmail"), this.get(request, "sendWhatifEmail").equalsIgnoreCase("true"));*/
        if (emailsBeanI.edit(emails) != null) {
            audit(session, "Updated Email Addresses");
            this.respond(response, true, "success", null);
        } else {
            this.respond(response, false, "failed", null);
        }
    }

    private void switchScheme(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.setAttribute(Constants.SCHEME_ID, this.get(request, "schemeID"));
        this.respond(response, true, "success", null);
    }

    private void setNewPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session, String newPass, User user) {
        PasswordPolicy policy = passwordPolicyBeanI.find();
        if (!(usedPasswordBeanI.isUsed(newPass) && policy.isPassword_reuse())) {
            user.setPassword(helper.hash(newPass));
            Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
            user.setPassword_expiry(password_expiry);
            userBeanI.edit(user);
            audit(session, "Changed password");
            this.respond(response, true, "Your password was changed successfully", null);
        } else {
            this.respond(response, false, "", null);
        }
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
