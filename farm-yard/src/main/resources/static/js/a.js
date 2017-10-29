/*<![CDATA[*/

function display_alert()
  {
  alert("I am an alert box!!")
  }

function changeToBeau(url ) {
	alert("helo ,this is text" + url);
	$("#content").empty();
	$("#content").append("<div><img src='"+url+"'/></div>");
	}



function showText(){
$("#showpanelDiv").empty();
$("#notebookDiv").show();
//alert("helO");

$("#showpanelDiv").appendAll($("#notebookDiv"));
}

function showMemoList() {
	
	alert("helo,the world");
	 $('#memoTable').DataTable( {
	        "ajax" : "/list",
	        "processing": true,
			"serverSide": true,

	        "columns" : [

	                          { "data": "title"},

	                          { "data" :"content"},

	                          { "data": "lastUpdate" }
	 ]
	  } );
	
	
	$("#showpanelDiv").empty();
	$("#memoListDiv").show();
	//alert("helO");

	$("#showpanelDiv").appendAll($("#memoListDiv"))
}

/*]]>*/