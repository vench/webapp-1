package ru.javawebinar.webapp.web;

import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.SectionType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import static ru.javawebinar.webapp.Config.STORAGE;
import ru.javawebinar.webapp.model.Link;
import ru.javawebinar.webapp.model.ListSection;
import ru.javawebinar.webapp.model.Organization;
import ru.javawebinar.webapp.model.Organization.Position;
import ru.javawebinar.webapp.model.OrganizationSection;
import ru.javawebinar.webapp.model.TextSection;

/**
 * GKislin
 * 22.04.2016
 */
public class ResumeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("resumeList", STORAGE.getAllSorted());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            return;
        }

        Resume r;
        switch (action) {
            case "delete":
                STORAGE.delete(uuid);
                response.sendRedirect("resume");
                return;
            case "create":
                r = Resume.EMPTY;
                break;
            case "view":
            case "edit":
                r = STORAGE.get(uuid);
                break;
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }
        request.setAttribute("resume", r);
        request.getRequestDispatcher(
                ("view".equals(action) ? "/WEB-INF/jsp/view.jsp" : "/WEB-INF/jsp/edit.jsp")
        ).forward(request, response);
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException { 
         String action = request.getParameter("action");
         
         Resume r;
         switch (action) {
            case "create":  
                r = new Resume(request.getParameter("fullName"), request.getParameter("about"));
                applyContacts(request, r);
                applySections(request, r);
                STORAGE.save(r);
                
                resp.sendRedirect("resume?uuid="+r.getUuid()+"&action=view");
                return;
                
            case "edit":
                r = STORAGE.get(request.getParameter("uuid"));
                r.setFullName(request.getParameter("fullName"));
                r.setAbout(request.getParameter("about"));
                applyContacts(request, r);
                applySections(request, r);
                STORAGE.update(r);
                
                resp.sendRedirect("resume?uuid="+r.getUuid()+"&action=view");
                return; 
         } 
         
         
         resp.sendRedirect("resume");
     }
     
     private void applyContacts(HttpServletRequest request, Resume r) {
         r.getContacts().clear();
         for(ContactType ct : ContactType.values()) {
             String name = "contact_" + ct.name();
             String value = request.getParameter(name);
             if(value != null && value.length() > 0) {
                 r.addContact(ct, value);
             }
         }
     }
     
     
     private void applySections(HttpServletRequest request, Resume r) {
         r.getSections().clear();
         for(SectionType st : SectionType.values()) {
             String name = "section_" + st.name(); 
             
             if(st.equals(SectionType.OBJECTIVE)) { 
                 String value = request.getParameter(name);
                 if(value != null && value.length() > 0){
                    TextSection section = new TextSection(value);
                    r.addSection(st, section);
                 }
             }
             if(st.equals(SectionType.QUALIFICATIONS) || st.equals(SectionType.ACHIEVEMENT)) {
                 String[] parameterValues = request.getParameterValues(name);
                 if(parameterValues != null && parameterValues.length > 0) {
                     ListSection section = new ListSection(Arrays.asList(parameterValues));
                     r.addSection(st, section);  
                 }
             }
             if(st.equals(SectionType.EXPERIENCE) || st.equals(SectionType.EDUCATION)) {
                 String[] valuesNum = request.getParameterValues(name + "_num");
                 if(valuesNum == null) {
                     continue;
                 }
                 OrganizationSection section = new OrganizationSection();
                 for(String num : valuesNum) {
                     String valueName = request.getParameter(name + "_" + num + "_name"); 
                     String valueUrl = request.getParameter(name + "_" + num + "_url"); 
                     Organization o = new Organization(
                             new Link(valueName, valueUrl)
                     );
                     
                     String[] valueTitles = request.getParameterValues(name + "_" + num + "_title"); 
                     String[] valueDescriptions = request.getParameterValues(name + "_" + num + "_description");
                     String[] valueDatesEnd = request.getParameterValues(name + "_" + num + "_date_end");
                     String[] valueDetesStart = request.getParameterValues(name + "_" + num + "_date_start");
                     if(valueTitles != null) {
                         for(int i = 0; i < valueTitles.length; i ++ ) {
                             LocalDate startDate = parseDate(valueDetesStart[i]);
                             LocalDate endDate = parseDate(valueDatesEnd[i]);
                             
                             Position p = new Position(startDate, endDate, valueTitles[i], valueDescriptions[i]);
                             o.getPositions().add(p);
                         }
                     }                     
                     section.addOrganization(o); 
                 }
                  r.addSection(st, section); 
             }
              
         } 
     }
     
     public LocalDate parseDate(String text) {
         try {
             return LocalDate.parse(text);
         } catch(Exception e){}
         return LocalDate.now();
     }
}
