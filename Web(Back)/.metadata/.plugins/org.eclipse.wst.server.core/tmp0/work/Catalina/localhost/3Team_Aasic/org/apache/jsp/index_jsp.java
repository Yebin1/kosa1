/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-12-02 02:58:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar", Long.valueOf(1669836028000L));
    _jspx_dependants.put("jar:file:/C:/KOSA_IT/Web(Back)/Labs/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/3Team_Aasic_1201/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1323225978000L));
    _jspx_dependants.put("jar:file:/C:/KOSA_IT/Web(Back)/Labs/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/3Team_Aasic_1201/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/fn.tld", Long.valueOf(1323225978000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>KingBird</title>\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("    <meta content=\"\" name=\"keywords\">\r\n");
      out.write("    <meta content=\"\" name=\"description\">\r\n");
      out.write("    <style>\r\n");
      out.write("       th, td {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <!-- Favicon -->\r\n");
      out.write("    <link href=\"images/kingbird.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Google Web Fonts -->\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- Icon Font Stylesheet -->\r\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Libraries Stylesheet -->\r\n");
      out.write("    <link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("    <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Template Stylesheet -->\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- ?????? ????????? ?????? -->\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Inconsolata\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("//HOT????????? ????????? \r\n");
      out.write("		$(document).ready(function(){\r\n");
      out.write("			//????????? ?????? ??????\r\n");
      out.write("			$.ajax(\r\n");
      out.write("				{\r\n");
      out.write("					 cache : false,\r\n");
      out.write("			            url : \"hotList.do\", \r\n");
      out.write("			            type:\"GET\", \r\n");
      out.write("			            dataType:\"html\",	\r\n");
      out.write("			            success : function(data) {\r\n");
      out.write("			                $('#hotboardtable').empty(data);\r\n");
      out.write("			                $('#hotboardtable').append(data);\r\n");
      out.write("			            }, // success \r\n");
      out.write("			    \r\n");
      out.write("			            error : function(request,status,error) {\r\n");
      out.write("			            	alert(\"code:\" +request.status+\"\\n\" + \"message:\"+request.responseText+\"\\n\"+\"error:\"+error);\r\n");
      out.write("							console.log(error);\r\n");
      out.write("			            }\r\n");
      out.write("			        }); // $.ajax */\r\n");
      out.write("			        \r\n");
      out.write("			        \r\n");
      out.write("			        \r\n");
      out.write("	        $.ajax(\r\n");
      out.write("					{\r\n");
      out.write("						 cache : false,\r\n");
      out.write("				            url : \"noticeList.do\", \r\n");
      out.write("				            type:\"GET\", \r\n");
      out.write("				            dataType:\"html\",	\r\n");
      out.write("				            success : function(data) {\r\n");
      out.write("				                $('#noticeboardtable').empty(data);\r\n");
      out.write("				                $('#noticeboardtable').append(data);\r\n");
      out.write("				            }, // success \r\n");
      out.write("				    \r\n");
      out.write("				            error : function(request,status,error) {\r\n");
      out.write("				            	alert(\"code:\" +request.status+\"\\n\" + \"message:\"+request.responseText+\"\\n\"+\"error:\"+error);\r\n");
      out.write("								console.log(error);\r\n");
      out.write("				            }\r\n");
      out.write("				        }); // $.ajax */\r\n");
      out.write("			    });\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("		<!-- ???????????? ????????? ?????? -->\r\n");
      out.write("		");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/include/sidebar_css.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Content Start -->\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("        <!-- ?????? -->\r\n");
      out.write("          ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/include/header_css.jsp", out, false);
      out.write("\r\n");
      out.write("		\r\n");
      out.write("           <!-- Sale & Revenue Start -->\r\n");
      out.write("            <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("            		<!-- <h6 class=\"mb-0\">????????? ??????</h6> ?????? ?????? ?????? ????????????\r\n");
      out.write("                <div><h4 align=\"center\"  style=\"background-color:gray; height:230px;\">?????? ????????? ??????</h4></div> -->\r\n");
      out.write("                <!-- ?????? ?????? ????????? -->\r\n");
      out.write("         <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("				<ol class=\"carousel-indicators\">\r\n");
      out.write("					<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("					<li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\r\n");
      out.write("					<li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\r\n");
      out.write("					<li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\r\n");
      out.write("				</ol>\r\n");
      out.write("\r\n");
      out.write("				<div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("\r\n");
      out.write("					<div class=\"item active\">\r\n");
      out.write("						<img src=\"./images/code1.png\" alt=\"??????1\" width=\"100%\" height=\"205\">\r\n");
      out.write("						<div class=\"carousel-caption\">\r\n");
      out.write("                            <!-- <h2>????????? ????????? ????????? ?????????</p> -->\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"item\">\r\n");
      out.write("						<img src=\"./images/code.png\" alt=\"??????2\" width=\"100%\" height=\"205\">\r\n");
      out.write("						<div class=\"carousel-caption\">\r\n");
      out.write("							<!-- <h3>??????2</h3> -->\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"item\">\r\n");
      out.write("						<img src=\"./images/code2.png\" alt=\"??????3\" width=\"100%\" height=\"205\">\r\n");
      out.write("						<div class=\"carousel-caption\">\r\n");
      out.write("							<!-- <h3>??????3</h3> -->\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"item\">\r\n");
      out.write("						<img src=\"./images/code.png\" alt=\"??????4\" width=\"100%\" height=\"205\">\r\n");
      out.write("						<div class=\"carousel-caption\">\r\n");
      out.write("							<!-- <h3>??????4</h3> -->\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Sale & Revenue End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Hot????????? Start -->\r\n");
      out.write("            <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("                <div class=\"row g-4\">\r\n");
      out.write("                    <div class=\"col-sm-12 col-xl-6\">\r\n");
      out.write("                        <div id=\"hotboardtable\" class=\"bg-light rounded h-100 p-4\" style=\"width:440px; float:left; margin-right:90px;\">\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                         <!-- ???????????? End -->\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        <!-- ???????????? ????????? Start -->\r\n");
      out.write("                        <div  id=\"noticeboardtable\" class=\"bg-light rounded h-100 p-4\" style=\"width:440px; float:left;\">\r\n");
      out.write("                           \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-12 col-xl-6\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- ???????????? ????????? End -->\r\n");
      out.write("           \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Recent Sales Start -->\r\n");
      out.write("        <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("                <div class=\"row g-4\">\r\n");
      out.write("                    <div class=\"col-sm-12 col-xl-6\" style=\"margin-left:20px;\">\r\n");
      out.write("                    <h4 class=\"mb-0\"><b><span style=\"color:#009CFF;\">KINGBIRD</span> ?????? ???????????? ?????????</b></h4>\r\n");
      out.write("                        <div class=\"bg-light rounded h-100 p-4\" style=\"width:440px; float:left; margin-right:74px;\">\r\n");
      out.write("                           <h5 class=\"mb-0\"><b>?????????<span style=\"color:#009CFF;\"> ????????????</span> ??????</b></h5>\r\n");
      out.write("									<canvas id=\"bar-chart\">?????? ??????</canvas>\r\n");
      out.write("									<h6 style=\"margin-left:50px;\">Kingbird ???????????? ?????? ????????? ?????? ??????????????? ???????????????.</h6>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"bg-light rounded h-100 p-4\" style=\"width:440px; float:left;\">\r\n");
      out.write("                        <h5 class=\"mb-0\"><b>??????<span style=\"color:#009CFF;\"> ????????? </span>??????</b></h5>\r\n");
      out.write("	                    			  <canvas id=\"worldwide-sales\"></canvas>\r\n");
      out.write("	                    			  <h6 style=\"margin-left:95px;\">Kingbird ???????????? ??????????????? ???????????????.</h6>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-12 col-xl-6\">\r\n");
      out.write("             \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Recent Sales End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Widgets Start -->\r\n");
      out.write("            <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("                <div class=\"row g-4\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Widgets End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Footer Start -->\r\n");
      out.write("            <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("                <div class=\"bg-light rounded-top p-4\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-12 col-sm-6 text-center text-sm-start\">\r\n");
      out.write("                            &copy; <a href=\"#\">KINGBIRD</a>, All Right Reserved. \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-12 col-sm-6 text-center text-sm-end\">\r\n");
      out.write("                            Designed By <a href=\"https://htmlcodex.com\">Kingbird Design Team</a>\r\n");
      out.write("                        </br>\r\n");
      out.write("                        Distributed By <a class=\"border-bottom\" href=\"https://themewagon.com\" target=\"_blank\">JunHans</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Footer End -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Content End -->\r\n");
      out.write("        <!-- Back to Top -->\r\n");
      out.write("        <a href=\"#\" class=\"btn btn-lg btn-primary btn-lg-square back-to-top\"><i class=\"bi bi-arrow-up\"></i></a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- JavaScript Libraries -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/chart/chart.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/easing/easing.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/waypoints/waypoints.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/tempusdominus/js/moment.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/tempusdominus/js/moment-timezone.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Template Javascript -->\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("		(function($) {\r\n");
      out.write("			\"use strict\";\r\n");
      out.write("\r\n");
      out.write("			// Spinner\r\n");
      out.write("			var spinner = function() {\r\n");
      out.write("				setTimeout(function() {\r\n");
      out.write("					if ($('#spinner').length > 0) {\r\n");
      out.write("						$('#spinner').removeClass('show');\r\n");
      out.write("					}\r\n");
      out.write("				}, 1);\r\n");
      out.write("			};\r\n");
      out.write("			spinner();\r\n");
      out.write("\r\n");
      out.write("			// Back to top button\r\n");
      out.write("			$(window).scroll(function() {\r\n");
      out.write("				if ($(this).scrollTop() > 300) {\r\n");
      out.write("					$('.back-to-top').fadeIn('slow');\r\n");
      out.write("				} else {\r\n");
      out.write("					$('.back-to-top').fadeOut('slow');\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			$('.back-to-top').click(function() {\r\n");
      out.write("				$('html, body').animate({\r\n");
      out.write("					scrollTop : 0\r\n");
      out.write("				}, 1500, 'easeInOutExpo');\r\n");
      out.write("				return false;\r\n");
      out.write("			});\r\n");
      out.write("\r\n");
      out.write("			// Sidebar Toggler\r\n");
      out.write("			$('.sidebar-toggler').click(function() {\r\n");
      out.write("				$('.sidebar, .content').toggleClass(\"open\");\r\n");
      out.write("				return false;\r\n");
      out.write("			});\r\n");
      out.write("\r\n");
      out.write("			// Progress Bar\r\n");
      out.write("			$('.pg-bar').waypoint(function() {\r\n");
      out.write("				$('.progress .progress-bar').each(function() {\r\n");
      out.write("					$(this).css(\"width\", $(this).attr(\"aria-valuenow\") + '%');\r\n");
      out.write("				});\r\n");
      out.write("			}, {\r\n");
      out.write("				offset : '80%'\r\n");
      out.write("			});\r\n");
      out.write("\r\n");
      out.write("			// Calender\r\n");
      out.write("			$('#calender').datetimepicker({\r\n");
      out.write("				inline : true,\r\n");
      out.write("				format : 'L'\r\n");
      out.write("			});\r\n");
      out.write("\r\n");
      out.write("			// Testimonials carousel\r\n");
      out.write("			$(\".testimonial-carousel\").owlCarousel({\r\n");
      out.write("				autoplay : true,\r\n");
      out.write("				smartSpeed : 1000,\r\n");
      out.write("				items : 1,\r\n");
      out.write("				dots : true,\r\n");
      out.write("				loop : true,\r\n");
      out.write("				nav : false\r\n");
      out.write("			});\r\n");
      out.write("\r\n");
      out.write("		/* 	// Single Bar Chart\r\n");
      out.write("			var ctx4 = $(\"#bar-chart\").get(0).getContext(\"2d\");\r\n");
      out.write("			var myChart4 = new Chart(ctx4,\r\n");
      out.write("					{\r\n");
      out.write("						type : \"bar\",\r\n");
      out.write("						data : {\r\n");
      out.write("							labels : [ \"Italy\", \"France\", \"Spain\", \"USA\",\r\n");
      out.write("									\"Argentina\" ],\r\n");
      out.write("							datasets : [ {\r\n");
      out.write("								backgroundColor : [ \"rgba(0, 156, 255, .7)\",\r\n");
      out.write("										\"rgba(0, 156, 255, .6)\",\r\n");
      out.write("										\"rgba(0, 156, 255, .5)\",\r\n");
      out.write("										\"rgba(0, 156, 255, .4)\",\r\n");
      out.write("										\"rgba(0, 156, 255, .3)\" ],\r\n");
      out.write("								data : [ 55, 49, 44, 24, 15 ]\r\n");
      out.write("							} ]\r\n");
      out.write("						},\r\n");
      out.write("						options : {\r\n");
      out.write("							responsive : true\r\n");
      out.write("						}\r\n");
      out.write("					}); */\r\n");
      out.write("\r\n");
      out.write("			// Pie Chart\r\n");
      out.write("			var ctx5 = $(\"#pie-chart\").get(0).getContext(\"2d\");\r\n");
      out.write("			var myChart5 = new Chart(ctx5,\r\n");
      out.write("					{\r\n");
      out.write("						type : \"pie\",\r\n");
      out.write("						data : {\r\n");
      out.write("							labels : [ \"Italy\", \"France\", \"Spain\", \"USA\",\r\n");
      out.write("									\"Argentina\" ],\r\n");
      out.write("							datasets : [ {\r\n");
      out.write("								backgroundColor : [ \"rgba(0, 156, 255, .7)\",\r\n");
      out.write("										\"rgba(0, 156, 255, .6)\",\r\n");
      out.write("										\"rgba(0, 156, 255, .5)\",\r\n");
      out.write("										\"rgba(0, 156, 255, .4)\",\r\n");
      out.write("										\"rgba(0, 156, 255, .3)\" ],\r\n");
      out.write("								data : [ 55, 49, 44, 24, 15 ]\r\n");
      out.write("							} ]\r\n");
      out.write("						},\r\n");
      out.write("						options : {\r\n");
      out.write("							responsive : true\r\n");
      out.write("						}\r\n");
      out.write("					});\r\n");
      out.write("\r\n");
      out.write("			/*    // Doughnut Chart\r\n");
      out.write("			   var ctx6 = $(\"#doughnut-chart\").get(0).getContext(\"2d\");\r\n");
      out.write("			   var myChart6 = new Chart(ctx6, {\r\n");
      out.write("			       type: \"doughnut\",\r\n");
      out.write("			       data: {\r\n");
      out.write("			           labels: [\"Italy\", \"France\", \"Spain\", \"USA\", \"Argentina\"],\r\n");
      out.write("			           datasets: [{\r\n");
      out.write("			               backgroundColor: [\r\n");
      out.write("			                   \"rgba(0, 156, 255, .7)\",\r\n");
      out.write("			                   \"rgba(0, 156, 255, .6)\",\r\n");
      out.write("			                   \"rgba(0, 156, 255, .5)\",\r\n");
      out.write("			                   \"rgba(0, 156, 255, .4)\",\r\n");
      out.write("			                   \"rgba(0, 156, 255, .3)\"\r\n");
      out.write("			               ],\r\n");
      out.write("			               data: [55, 49, 44, 24, 15]\r\n");
      out.write("			           }]\r\n");
      out.write("			       },\r\n");
      out.write("			       options: {\r\n");
      out.write("			           responsive: true\r\n");
      out.write("			       }\r\n");
      out.write("			   }); */\r\n");
      out.write("\r\n");
      out.write("		})(jQuery);\r\n");
      out.write("	</script>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		$(function() {\r\n");
      out.write("			$(document).ready(\r\n");
      out.write("					function() {\r\n");
      out.write("						//????????? ??????\r\n");
      out.write("						$.ajax({ // ????????? ?????? url ????????? ????????? ??????.\r\n");
      out.write("							url : \"/3Team_Aasic/chart/singlebarchartjson.jsp\",\r\n");
      out.write("							type : \"GET\",\r\n");
      out.write("							dataType : \"JSON\", //POINT\r\n");
      out.write("							success : function(data) {\r\n");
      out.write("\r\n");
      out.write("								var boardheader = new Array();\r\n");
      out.write("								var boardcnt = new Array();\r\n");
      out.write("								$.each(data, function(index, obj) {\r\n");
      out.write("									boardheader[index] = obj.boardheader\r\n");
      out.write("\r\n");
      out.write("								});\r\n");
      out.write("\r\n");
      out.write("								$.each(data, function(index, obj) {\r\n");
      out.write("									boardcnt[index] = parseInt(obj.boardcnt)\r\n");
      out.write("\r\n");
      out.write("								});\r\n");
      out.write("\r\n");
      out.write("								console.log(\"????????? ????????? : \" + boardcnt)\r\n");
      out.write("\r\n");
      out.write("								// Single Bar Chart\r\n");
      out.write("								var ctx4 = $(\"#bar-chart\").get(0).getContext(\"2d\");\r\n");
      out.write("								var myChart4 = new Chart(ctx4,\r\n");
      out.write("										{\r\n");
      out.write("											type : \"bar\",\r\n");
      out.write("											data : {\r\n");
      out.write("												labels : boardheader,\r\n");
      out.write("												datasets : [ {\r\n");
      out.write("													backgroundColor : [ \"rgba(0, 156, 255, .7)\",\r\n");
      out.write("															\"rgba(0, 156, 255, .6)\",\r\n");
      out.write("															\"rgba(0, 156, 255, .5)\",\r\n");
      out.write("															\"rgba(0, 156, 255, .4)\",\r\n");
      out.write("															\"rgba(0, 156, 255, .3)\" ],\r\n");
      out.write("													data : boardcnt\r\n");
      out.write("												} ]\r\n");
      out.write("											},\r\n");
      out.write("											options : {\r\n");
      out.write("												responsive : true\r\n");
      out.write("											}\r\n");
      out.write("										});\r\n");
      out.write("							},\r\n");
      out.write("							\r\n");
      out.write("							error : function(xhr) {\r\n");
      out.write("								alert(xhr.status + \"ERROR\");\r\n");
      out.write("							}\r\n");
      out.write("						});\r\n");
      out.write("					});\r\n");
      out.write("		});\r\n");
      out.write("	</script>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("      $(function() {\r\n");
      out.write("         $(document).ready(\r\n");
      out.write("               function() {\r\n");
      out.write("                  //????????? ??????\r\n");
      out.write("                  $.ajax({ // ????????? ?????? url ????????? ????????? ??????.\r\n");
      out.write("                     url : \"/3Team_Aasic/chart/checkvisitorjson.jsp\",\r\n");
      out.write("                     type : \"GET\",\r\n");
      out.write("                     dataType : \"JSON\", //POINT\r\n");
      out.write("                     success : function(data) {\r\n");
      out.write("\r\n");
      out.write("                        var perdate = new Array();\r\n");
      out.write("                        var boardcnt = new Array();\r\n");
      out.write("                        var visitor = new Array();\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        $.each(data, function(index, obj) {\r\n");
      out.write("                           perdate[index] = obj.perdate\r\n");
      out.write("                        });\r\n");
      out.write("                        \r\n");
      out.write("                        $.each(data, function(index, obj) {\r\n");
      out.write("                           boardcnt[index] = parseInt(obj.boardcnt)\r\n");
      out.write("                        });\r\n");
      out.write("                        \r\n");
      out.write("                        $.each(data, function(index, obj) {\r\n");
      out.write("                           visitor[index] = parseInt(obj.visitor)\r\n");
      out.write("                        });\r\n");
      out.write("                        \r\n");
      out.write("                        console.log(\"1 : \" + perdate)\r\n");
      out.write("                        console.log(\"1 : \" + boardcnt)\r\n");
      out.write("                        console.log(\"1 : \" + visitor)\r\n");
      out.write("\r\n");
      out.write("                        console.log(\"????????? ????????? : \" + boardcnt)\r\n");
      out.write("\r\n");
      out.write("                        // Worldwide Sales Chart\r\n");
      out.write("                         var ctx1 = $(\"#worldwide-sales\").get(0).getContext(\"2d\");\r\n");
      out.write("                         var myChart1 = new Chart(ctx1, {\r\n");
      out.write("                             type: \"bar\",\r\n");
      out.write("                             data: {\r\n");
      out.write("                                 labels: perdate,\r\n");
      out.write("                                 datasets: [{\r\n");
      out.write("                                         label: \"????????? ???\",\r\n");
      out.write("                                         data: visitor,\r\n");
      out.write("                                         backgroundColor: \"rgba(0, 156, 255, .7)\"\r\n");
      out.write("                                     },\r\n");
      out.write("                                     {\r\n");
      out.write("                                         label: \"????????? ???\",\r\n");
      out.write("                                         data: boardcnt,\r\n");
      out.write("                                         backgroundColor: \"rgba(0, 156, 255, .5)\"\r\n");
      out.write("                                     },\r\n");
      out.write("                                    \r\n");
      out.write("                                 ]\r\n");
      out.write("                                 },\r\n");
      out.write("                             options: {\r\n");
      out.write("                                 responsive: true\r\n");
      out.write("                             }\r\n");
      out.write("                         }); \r\n");
      out.write("                     },\r\n");
      out.write("\r\n");
      out.write("                     error : function(xhr) {\r\n");
      out.write("                        alert(xhr.status + \"ERROR\");\r\n");
      out.write("                     }\r\n");
      out.write("                  });\r\n");
      out.write("               });\r\n");
      out.write("      });\r\n");
      out.write("   </script>\r\n");
      out.write("	<!-- Template Javascript -->\r\n");
      out.write("	<!-- <script src=\"js/main.js\"></script> -->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
