$(document).ready(function(){
       $("#login_section").show();     
       $("#register_section").hide();     
       ChangeUrl("Login","/login.html");  
});

$("#registerLink").click(function(e) {
	$("#login_section").hide();     
    $("#register_section").show(); 
});

$("#loginLink").click(function(e) {
	$("#login_section").show();     
    $("#register_section").hide(); 
});

/* registrazione nuovo utente */
$("#register").click(function(e) {
    e.preventDefault();
    //TODO fare validazione campi
//    if($("#codeInput").val() != "" && $("#valueInput").val() != ""){      
       $.ajax({
          url: 'http://localhost:8094/user/add',                  
          type: "POST",
          data: {
        	 		nome:          	$("#nome").val(),                        
        	 		cognome:       	$("#cognome").val(),
             	email: 			$("#email").val(),
             	username:  			$("#user").val(),
             	password:  			$("#pwd").val()
          },
          success: function (data, status, xhr) {
             //alert("Registrazione avvenuta con successo. E'stata inviata una mail con le credenziali di accesso.");
             alert("Registrazione avvenuta con successo.");
             $("#login_section").show();     
		     $("#register_section").hide();
          },
          error: function(result) {
             alert("Error!");
             console.log(result);
          }
       });
//    }else{
//        alert("Insert a valid operation!");
//    }
});



/* function used to get the jwt from cookies after having saved it, for later async ajax calls to microservices */
function getCookie(name) {
     var value = "; " + document.cookie;
     var parts = value.split("; " + name + "=");
     if (parts.length == 2)
         return parts.pop().split(";").shift();
}

 /* function used to change the text of the url giving the impression we're changing page */
 function ChangeUrl(title, url) {
     if (typeof (history.pushState) != "undefined") {
    var obj = { Title: title, Url: url };
    history.pushState(obj, obj.Title, obj.Url);
 } else {
    alert("Browser does not support HTML5.");
     }
 }
