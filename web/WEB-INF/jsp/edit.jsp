<%@ page import="ru.javawebinar.webapp.model.ListSection" %>
<%@ page import="ru.javawebinar.webapp.model.OrganizationSection" %>
<%@ page import="ru.javawebinar.webapp.model.TextSection" %>
<%@ page import="ru.javawebinar.webapp.model.ContactType" %>
<%@ page import="ru.javawebinar.webapp.model.SectionType" %>

<%@ page import="ru.javawebinar.webapp.util.HtmlUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/resume.css">
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="js/edit.js"></script>
    <jsp:useBean id="resume" type="ru.javawebinar.webapp.model.Resume" scope="request"/> 
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>
<section>
    <h2>Резюме: ${resume.fullName}&nbsp;</h2>
    <form method="post">
        
    <p>
        <label for="resume_fullName">ФИО</label><br/>
        <input size="100" id="resume_fullName" type="text" value="${resume.fullName}" name="fullName"/>
    </p>    
    <p>
        <label for="resume_about">О себе</label><br/>
        <textarea cols="100" rows="10" name="about" id="resume_about">
                ${resume.about}
            </textarea>
    </p>  
     
    
    <div>
        <h3>Контакты</h3>
        <ul class="edit-list">
        <c:set var="contactTypes" value="<%=ContactType.values()%>"/>
        <c:forEach var="contactEntry" items="${contactTypes}">  
            <li>
                <label for="contact_${contactEntry}">${contactEntry.getTitle()}</label>
                <input 
                    id="contact_${contactEntry}" 
                    type="text" 
                    value="${resume.contacts.get(contactEntry)}" 
                    name="contact_${contactEntry}"
                    />                
            </li> 
        </c:forEach>
        </ul>    
    </div>
    <div>
    <h3>Секции</h3>    
    <c:set var="sectionTypes" value="<%=SectionType.values()%>"/>
    
        <c:forEach var="type" items="${sectionTypes}"> 
            <div> 
            <c:set var="section" value="${resume.sections.get(type)}"/>
                <h4>${type.getTitle()}</h4>
                <c:choose>
                <c:when test="${type=='OBJECTIVE'}">
                    <textarea name="section_${type.name()}" cols="100" rows="10"> ${section.getContent()}</textarea> 
                </c:when>
                <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                    <a href="#" data-name="section_${type.name()}" class="add-to-list"><img src="img/add.png"> Добавить</a>
                    <ul> 
                        <c:forEach var="item" items="${section.getLines()}">
                                <li><input type="text" value="${item}" name="section_${type.name()}" /> </li>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:when test="${type=='EXPERIENCE' || type=='EDUCATION'}">
                    <div  class="add-to-org" data-name="section_${type.name()}">
                    <a href="#"   class="org"><img src="img/add.png"> Добавить</a>
                    <ul> 
                        <c:set var="count" value="1"/>
                        <c:forEach var="org" items="${section.getOrganizations()}">
                            <li data-num="${count}">
                                Название: <input type="text" value="${org.getHomePage().getName()}" name="section_${type.name()}_${count}_name" />
                                url: <input type="text" value="" name="section_${type.name()}_${count}_url" />
                                <input type="hidden" value="${count}" name="section_${type.name()}_num" /><br/>
                                <a class="chi" href="#">Добавить организацию</a><ul>
                                <c:forEach var="pos" items="${org.getPositions()}">
                                <li>
                                Название: <input type="text" value="${pos.getTitle()}" name="section_${type.name()}_${count}_title"/><br/>
                             Дата начала: <input type="text" value="${pos.getStartDate()}" name="section_${type.name()}_${count}_date_start"/><br/>
                             Дата конца: <input type="text" value="${pos.getEndDate()}" name="section_${type.name()}_${count}_date_end"/><br/>
                            Описание: <textarea  name="section_${type.name()}_${count}_description" cols="50" rows="5">${pos.getDescription()}</textarea></li>
                                </c:forEach> 
                            </ul></li>
                            
                            <c:set var="count" value="${count + 1}"/> 
                        </c:forEach>    
                    </ul>    
                    </div>
                </c:when>
                </c:choose>    
                
                
            </div>             
                            
        </c:forEach>
    </div>
    <button type="submit" name="s1">Сохранить</button>
    </form>
</section>
<jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
</body>
</html>
