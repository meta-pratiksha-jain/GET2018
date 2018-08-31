function validateName(nameId)
{
    var name=document.getElementById(nameId);
    var nameValue=name.value;
    if(nameValue.length>1)
    {
        for(var i=0;i<nameValue.length;i++)
        {
            var character = nameValue.charAt(i);
            var asciiCode = character.charCodeAt(0);
            if(!(asciiCode>=97 && asciiCode<=122) && !(asciiCode>=65 && asciiCode<=90))
            {
                name.style.border="2px solid red";
                return false;
            }
        }
            name.style.border="2px solid green";
            return true;
    }
    else{
        name.style.border="2px solid red";
        return false;
    }
}
            
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
            
function validatePassword()
{
    var password=document.getElementById("passwordId");
    var passwordValue=password.value;
    var pattern=/^(?=.*[A-Z])(?=.*[!@#$%^&*-_])(?=.*[0-9])(?=.*[a-z]).{8,}$/;
    if(pattern.test(passwordValue)){         
        password.style.border="2px solid green";
        return true;  
    }
    else{   
        password.style.border="2px solid red";
        document.getElementById("passwordSpan").innerHTML="inavalid password";
        return false;
    }            
}
            
function matchPassword()
{
    var password=document.getElementById("passwordId");
    var passwordValue=password.value;
    var confirmPassword=document.getElementById("confirmPasswordId");
    var confirmPasswordValue=confirmPassword.value;
    if(confirmPasswordValue===passwordValue)
    {
        confirmPassword.style.border="2px solid green";
        return true;  
    }
    else{   
        confirmPassword.style.border="2px solid red";
        return false;
    }
}
            
function validateContact()
{
    var contact=document.getElementById("contactId")
    var contactValue=contact.value;
    var pattern=/^([0-9]){8,}$/;
    if(pattern.test(contactValue)){         
        contact.style.border="2px solid green";
        return true;  
    }
    else{   
        contact.style.border="2px solid red";
        return false;
    }
}
            
function submitForm()
{
    if(validateName("firstName") && validateName("lastName") && validateEmail() && validatePassword() && matchPassword() && validateContact())
    {
        alert("Registration Successful!! Welcome to our site.");
        return true;
    }
    else
    {
        alert("Please enter valid details");
        return false;
    }
}