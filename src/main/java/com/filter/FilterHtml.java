/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahm.jx.common.constant.CommonConstant;

/**
 *
 * @author achmad.ha
 */
public class FilterHtml implements Filter {

    private static final boolean debug = true;
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public FilterHtml() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("FilterHtml:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
         for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
         String name = (String)en.nextElement();
         String values[] = request.getParameterValues(name);
         int n = values.length;
         StringBuffer buf = new StringBuffer();
         buf.append(name);
         buf.append("=");
         for(int i=0; i < n; i++) {
         buf.append(values[i]);
         if (i < n-1)
         buf.append(",");
         }
         log(buf.toString());
         }
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("FilterHtml:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
         for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
         String name = (String)en.nextElement();
         Object value = request.getAttribute(name);
         log("attribute: " + name + "=" + value.toString());

         }
         */
        // For example, a filter might append something to the response.
        /*
         PrintWriter respOut = new PrintWriter(response.getWriter());
         respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("FilterHtml:doFilter()1");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            System.out.println("Start Filter");
            String db = filterConfig.getInitParameter("db");
            System.out.println("database : " + db);
            boolean valid = false;

            if (db.equals(CommonConstant.dbMysql)) {

            } else if (db.equals(CommonConstant.dbOracle)) {

            }

            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String url = httpServletRequest.getRequestURL().toString();
            System.out.println("ip address : " + request.getRemoteAddr());
            System.out.println("url : " + url);
            System.out.println("length url : " + url.length());
            int idxRest = url.indexOf("/rest/") + "/rest/".length();
            System.out.println("idxRest : " + idxRest);
            int idxLogin = url.indexOf("login.htm");
            System.out.println("idxLogin : " + idxLogin);
            int idxDashboard = url.indexOf("dashboard.htm");
            System.out.println("idxDashboard : " + idxDashboard);
            int idxForm = url.indexOf("/forms/") + "/forms/".length();
            System.out.println("idxForm : " + idxForm);
            int idxApp = url.indexOf("ahmjxdsh000-rest");
            System.out.println("idxApp : " + idxApp);
            int idxResources = url.indexOf("/resources/") + "/resources/".length();
            System.out.println("idxResources : " + idxResources);

            if (idxResources == 10) {

                //check apakah url ke halaman login
                if ((idxLogin > 0) && (idxLogin + 9 == url.length())) {
                    if (validateCookie(httpServletRequest)) {
                        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                        httpServletResponse.sendRedirect("dashboard.htm");
                        return;
                    } else {
                        System.out.println("valid");
                        valid = true;
                    }
                } else //check apakah url ke halaman dashboard
                 if ((idxDashboard > 0) && (idxDashboard + 13 == url.length())) {
                        if (validateCookie(httpServletRequest)) {
                            valid = true;
                        }
                    } else if ((idxForm > 0) && (idxForm + 15 == url.length())) {
                        String applicationId = url.substring(idxForm, url.length() - 4);
                        System.out.println("kode aplikasi : " + applicationId);
                        if (validateCookie(httpServletRequest)) {
                            String username = null;
                            Cookie[] cookies = httpServletRequest.getCookies();
//                                if(cookies!=null){
//                                    for(Cookie c : cookies){
//                                        if(c.getName().equals(CommonConstant.cookieDimsUser)){
//                                            username = c.getValue();
//                                            break;
//                                        }
//                                    }
//                                }
                            username = (String) httpServletRequest.getSession().getAttribute(CommonConstant.cookieDimsUser);
                            if (username != null) {
                                if (authorization(applicationId, username)) {
                                    System.out.println("valid Forms");
                                    valid = true;
                                } else {
                                    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                                    httpServletResponse.sendRedirect("../not_authorize.htm");
                                    return;
                                }
                            }
                        } else {
                            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                            httpServletResponse.sendRedirect("../login.htm");
                            return;
                        }
                    } else {
                        valid = true;
                    }

                if (!valid) {
                    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                    httpServletResponse.sendRedirect("login.htm");
                    return;
                }

            }
            System.out.println("End Filter");
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("FilterHtml:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("FilterHtml()");
        }
        StringBuffer sb = new StringBuffer("FilterHtml(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

    private boolean validateCookie(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        String tokenSession = httpServletRequest.getSession().getAttribute(CommonConstant.cookieDims) + "";
        System.out.println("tokenSession : " + tokenSession);
        if (cookies != null) {
            for (Cookie c : cookies) {
                System.out.println("c.getName() : " + c.getName());
                System.out.println("c.getValue() : " + c.getValue());
                if (c.getName().equals(CommonConstant.cookieDims)) {
                    if (tokenSession.equals(c.getValue())) {
                        System.out.println("tokenSession : " + tokenSession);
                        Object objTimeOut = httpServletRequest.getSession().getAttribute(CommonConstant.sessionTimeOut);
                        if (objTimeOut != null) {
                            Date date = (Date) objTimeOut;
                            Date now = new Date();
                            Timestamp timestampNow = new Timestamp(now.getTime());
                            long diffInMiliSecond = Math.abs(timestampNow.getTime() - date.getTime());
                            long diffInMinutes = diffInMiliSecond / 1000 / 60;
                            if (diffInMinutes < CommonConstant.timeOut) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean authorization(String applicationId, String username) {
        boolean result = false;
        System.out.println("applicationId : " + applicationId);
        System.out.println("username : " + username);
        DBConnection dBConnection = null;
        Connection connection;
        String db = filterConfig.getInitParameter("db");
        if (db.equals(CommonConstant.dbMysql)) {
            dBConnection = new DBConnectionMysqlImpl();
        } else if (db.equals(CommonConstant.dbOracle)) {
            dBConnection = new DBConnectionOracleImpl();
        }

        connection = dBConnection.getConnection();
        String query = "SELECT menu.VAPPLICATION_ID appId "
                + "FROM AHMJXUAM_MSTUSERS user , AHMJXUAM_MSTUSRROLS usrrls , "
                + "AHMJXUAM_MSTROLES roles , AHMJXUAM_HDRRLACCESS rlacs , AHMJXUAM_MSTMENUS menu "
                + "WHERE user.VUSERNAME = ? "
                + "AND menu.VAPPLICATION_ID = ? "
                + "AND user.vid = usrrls.vid_Ahmjxuam_Mstusers "
                + "AND usrrls.vid_Ahmjxuam_Mstroles = roles.vid "
                + "AND rlacs.vid_Ahmjxuam_Mstroles = roles.vid "
                + "AND menu.vid = rlacs.vid_Ahmjxuam_Mstmenus ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, applicationId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String tempString = null;
            while (resultSet.next()) {
                System.out.println("resultSet.getString(\"appId\") : " + resultSet.getString("appId"));
                tempString = resultSet.getString("appId");
                break;
            }

            if (tempString != null) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilterHtml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FilterHtml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
