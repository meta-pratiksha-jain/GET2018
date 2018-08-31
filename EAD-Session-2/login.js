function validateEmail()
{
    var email=document.getElementById("emailId");
    var emailValue=email.value;
    var pattern=/^([a-zA-Z])([a-zA-Z0-9_.-])*@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+$/;
    if(pattern.test(emailValue)){         
        email.style.border="2px solid green";
        return true;  
    }
    else{   
        email.style.border="2px solid red";
        return false;
    }
}