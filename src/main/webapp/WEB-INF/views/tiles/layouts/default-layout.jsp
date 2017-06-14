<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title"></tiles:getAsString></title>
        
        <style type="text/css">
            
            #header {
                margin-left: 20%;
            }
            
            #footer {
                margin-left: 20%;
                bottom: 0px;
                height: 10%;
                position: fixed;
            }
            
            #site-content {
                float: left;
                z-index: 20;
                position: fixed;
                margin-left: 20%;
            }
            
            #sidemenu #menu {
                list-style-type: none;
                float: left;
            }
            
            #sidemenu #menu li {
                font-size: 1.2em;
            }
            
            #sidemenu #menu li a {
                text-decoration: none;
                text-transform: uppercase;
            }
            
         </style>
      
    </head>
    
    <body>
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
    </body>
    
</html>
