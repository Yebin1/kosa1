<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <style>
    body {
  padding:1.5em;
  background: #f5f5f5
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
}
  
thead {
  font-weight: bold;
  color: #fff;
  background: #73685d;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
  table {
    position: relative; 
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
  }
  
  thead {
    float: left;
    white-space: nowrap;
  }
  
  tbody {
    overflow-x: auto;
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }
  
  tr {
    display: inline-block;
    vertical-align: top;
  }
  
  th {
    border-bottom: 1px solid #a39485;
  }
  
  td {
    border-bottom: 1px solid #e5e5e5;
  }
  
  
  }
    </style>
   
   <script type="text/javascript">
      
      
    	  
    	  // 전체 조회
        function empList(){
        	 console.log("emplist 실행")
             $.ajax(
                   {  
                     type : "get",
                     url  : "emp",
                     success : function(data){ 
                        console.log(data);
                        $('#menuView').empty();
                        var opr="";
                        
                        $.each(data, function(){
                        	opr += "<tr>";
                        	opr += '<td>' + this.empno + '</td>';
                        	opr += '<td>' + this.ename + '</td>';
                        	opr += '<td>' + this.sal + '</td>';
                        	opr += "<td><input type='button' onclick='empupdate(this)' value='수정'  value2="+this.empno+
            				"></td><td><input type='button' value='삭제' class ='delete' value2="+this.empno+"></td></tr>";
						});
                        opr+="<tr><td colspan='10'><input type='button' onclick='createinput(this)' value='추가'></td></tr>";
						$("#menuView").append(opr);
                       
                     } 
                   });    
         } 
        
         
      	//전체 조회
		empList();
        
		$(document).ready(function(){
 		// 검색
 		$('#keyword').keyup(function(){
 			console.log($('#keyword').val());
              $.ajax(
                    {  
                      type : "get",
                      url  : "emp/" + $('#keyword').val(),
                      data: {
                         keyword : $('#keyword').val()
                      },
                      success : function(data){ 
                         console.log(data);
                         $('#menuView').empty();
                         var opr="";
                         
                         $.each(data, function(){
                         	opr += "<tr>";
                         	opr += '<td>' + this.empno + '</td>';
                         	opr += '<td>' + this.ename + '</td>';
                         	opr += '<td>' + this.sal + '</td>';
                         	opr += "<td><input type='button' onclick='empupdate(this)' value='수정'  value2="+this.empno+
             				"></td><td><input type='button' value='삭제' class ='delete' value2="+this.empno+"></td></tr>";
 						});
                         opr+="<tr><td colspan='10'><input type='button' onclick='createinput(this)' value='추가'></td></tr>";
 						
 						$("#menuView").append(opr);
                         
                      } 
                    })    
          });		 
 		 
        //삭제
        $(document).on("click",".delete",function(){
           $.ajax({
              type : "delete",
              url  : "emp/" + $(this).attr("value2"),
              data : {empno : $(this).attr("value2")},
              success : function(data){ 
					empList()
              } 
           })
        });
 		 

		      

    		
     })
		
     		   function empupdateconfirm(me){			
					empupdateok(me);
				}
		 		
    		//수정 폼
    		function empupdate(me){
				var tr = $(me).closest('tr')
				var datas = {empno:tr.children().html()};
				var empno = tr.children().html();
				tr.empty();
				
				$.ajax({
					type : "get",
					url:"emp/"+empno,
					data:datas,
					contentType:"application/json",
					success : function(data) {
						console.log(data)
					 	var td = "<td><input type='text' value='"+data[0].empno +"' readonly></td>";
							td +="<td><input type='text' value='"+data[0].ename +"'></td>";
							td +="<td><input type='text' value='"+data[0].sal +"'></td>";
							td +="<td colspan='2'><input type='button'onclick='empupdateconfirm(this)' value='완료' value2="+data[0].empno+" /></td>";
							$(tr).append(td); 
					}
				})
		}
     
		
		//수정 처리
		function empupdateok(me){
			var tr = $(me).closest('tr');
			var data = {empno:tr.find("td:eq(0)").children().val(),
						ename:tr.find("td:eq(1)").children().val(),
						sal:tr.find("td:eq(2)").children().val(),
					   };
			$.ajax({
				type : "put",
				url:"emp",
				contentType:"application/json",
				data: JSON.stringify(data),
				success : function(data){  
					$('#menuView').empty();
                    var opr="";
                  
					empList();
					
					$("#menuView").append(opr);
				} 
			})
		}
		

		
		//등록 폼
		function createinput(me){
			var tr = $(me).closest('tr');
			tr.empty();
			var td = "<td><input type='text'></td>";
			td +="<td><input type='text'></td>";
			td +="<td><input type='text'></td>";
			td +="<td><input type='button'onclick='empinsert(this)' value='완료'/></td>";
			td +="<td><input type='button'onclick='cancel(this)' value='취소'/></td>";
			$(tr).append(td); 
		
		}
		
		//취소버튼
		function cancel(me){
			var tr = $(me).closest('tr');
			tr.empty();
			tr.append("<td colspan='10'><input type='button' onclick='createinput(this)' value='추가'></td>");
			
		}
		
		//등록 처리
		function empinsert(me){
			var tr = $(me).closest('tr');
			var data = JSON.stringify({empno:tr.find("td:eq(0)").children().val(),
						ename:tr.find("td:eq(1)").children().val(),
						sal:tr.find("td:eq(2)").children().val(),
					   });
			$.ajax({
				type : "post",
				url:"emp",
				contentType:"application/json",
				data:data,
				success : function(data){  
					empList();
				} 
			})
		}

	</script>
		 <style>
table {
	border-collapse: collapse; /* 붕괴하다 , 무너지다 */
	width: 100%;
}

th {
	text-align: center;
	width: 10px;
}

td {
	text-align: center;
	width: 10px;
}
input[type="text"]{
	width: 60%;
}

#keyword {
width:200px;
}

</style>
</head>
<body>

<div class="wrapper">
    <div class="fresh-table toolbar-color-azure full-screen-table" style="align-content: center;">
<div class="container-fluid">
<div class="row">
<div class="col-sm-6">
<fieldset>
	<legend>EMP Table</legend>
</fieldset>
</div>
</div>

	<hr>
	   <input type="text" id="keyword" placeholder="숫자입력">
            <input type="button" id="search"  value="검색">
	<div id="exp"></div>
	<table>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>급여</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody id="menuView">
		<c:forEach items="${list}" var="l">
					<tr>
						<td>${l.empno}</td>
						<td>${l.ename}</td>
						<td>${l.sal}</td>
						<td><a class="btn" id="update">수정</a></td>
						<td><a class="btn">삭제</a></td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</div>
	
</body>
</html>