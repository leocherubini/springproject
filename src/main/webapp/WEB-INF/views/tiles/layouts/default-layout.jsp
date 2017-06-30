<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title"></tiles:getAsString></title>
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/font-awesome/4.7.0/css/font-awesome.min.css"/>
      
    </head>
    
    <body>
        <div class="container">
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
        
        <section id="sidemenu">
            <tiles:insertAttribute name="menu" />
        </section>
        
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
        
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
        </div>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.2.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
        
    </body>
    
</html>
