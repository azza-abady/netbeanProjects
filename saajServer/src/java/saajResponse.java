/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author azza
 */
public class saajResponse extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static MessageFactory messageFactory = null;

    static {
        try {
            messageFactory = MessageFactory.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    ;
    @Override
    public void init(ServletConfig servletConfig)
            throws ServletException {
        super.init(servletConfig);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            MimeHeaders headers = getHeaders(request);
            InputStream is = request.getInputStream();
            SOAPMessage msg = messageFactory.createMessage(headers, is);
            SOAPMessage reply = null;
            reply = onMessage(msg);
            if (reply != null) {
                if (reply.saveRequired()) {
                    reply.saveChanges();
                }
                response.setStatus(HttpServletResponse.SC_OK);
                putHeaders(reply.getMimeHeaders(), response);
                OutputStream os = response.getOutputStream();
                reply.writeTo(os);
                os.flush();
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            MimeHeaders headers = getHeaders(request);
            InputStream is = request.getInputStream();
            SOAPMessage msg = messageFactory.createMessage(headers, is);
            SOAPMessage reply = null;
            reply = onMessage(msg);
            if (reply != null) {
                if (reply.saveRequired()) {
                    reply.saveChanges();
                }
                response.setStatus(HttpServletResponse.SC_OK);
                putHeaders(reply.getMimeHeaders(), response);
                OutputStream os = response.getOutputStream();
                reply.writeTo(os);
                os.flush();
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private MimeHeaders getHeaders(HttpServletRequest request) {
        Enumeration headerNames = request.getHeaderNames();
        MimeHeaders headers = new MimeHeaders();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            StringTokenizer values = new StringTokenizer(headerValue, ",");
            while (values.hasMoreTokens()) {
                headers.addHeader(headerName, values.nextToken().trim());
            }
        }
        return headers; //To change body of generated methods, choose Tools | Templates.
    }

    private SOAPMessage onMessage(SOAPMessage msg) throws SOAPException {
        SOAPMessage message = null;
        message = messageFactory.createMessage();
        SOAPBody body = message.getSOAPBody();
        QName bodyName = new QName("http://localhost:8080/saajServer/", "HelloSaajServer", "hi");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
        QName name = new QName("sayHello");
        SOAPElement symbol = bodyElement.addChildElement(name);
        SOAPElement personName=symbol.addChildElement("PersonName");
        personName.addTextNode("azza");
        SOAPElement employee=symbol.addChildElement("Employee");
        Employee e=new Employee();
        e.setEmployeeName("JEST");
        saveEmployee(e);
        SOAPElement empName=employee.addChildElement("EmployeeName");
        empName.addTextNode(e.getEmployeeName());
        

        message.saveChanges();
        return message;          //To change body of generated methods, choose Tools | Templates.
    }
    private void saveEmployee(Employee e){
    Configuration cfg=new Configuration();
        SessionFactory sessionFactory = cfg
                    .configure().buildSessionFactory();  
        Session session = sessionFactory.openSession();
        session.save(e);
		session.beginTransaction();
        session.persist(e);
        session.getTransaction().commit();
		System.out.println("Emplyoee saved");
    }
    private void putHeaders(MimeHeaders mimeHeaders, HttpServletResponse response) {
        Iterator it = mimeHeaders.getAllHeaders();
        while (it.hasNext()) {
            MimeHeader header = (MimeHeader) it.next();

            String[] values = mimeHeaders.getHeader(header.getName());
            if (values.length == 1) {
                response.setHeader(header.getName(), header.getValue());
            } else {
                StringBuffer concat = new StringBuffer();
                int i = 0;
                while (i < values.length) {
                    if (i != 0) {
                        concat.append(',');
                    }
                    concat.append(values[i++]);
                }
                response.setHeader(header.getName(), concat.toString());
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

}
