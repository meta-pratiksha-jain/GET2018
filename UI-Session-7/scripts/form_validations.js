user = [];

function validateName(name) {
    var nameValue = name.value;
    var pattern = /^([a-zA-Z]){2,50}$/;
    if (pattern.test(nameValue)) {
        showSuccess(name);
        return true;
    } else {
        showError(name);
        return false;
    }
}

function validateEmail() {
    var emailValue = email.value;
    var pattern = /^([a-zA-Z])([a-zA-Z0-9_.-])*@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+$/;
    if (pattern.test(emailValue)) {
        showSuccess(email);
        return true;
    } else {
        showError(email);
        return false;
    }
}

function validateContact() {
    var contactValue = contact.value;
    var pattern = /^([0-9]){8,15}$/;
    if (pattern.test(contactValue)) {
        showSuccess(contact);
        return true;
    } else {
        showError(contact);
        return false;
    }
}

function validateState() {
    if (state.value == "") {
        return false;
    }
    return true;
}

function validateZipcode() {
    var zipcodeValue = zipcode.value;
    var pattern = /^([0-9]){3,6}$/;
    if (pattern.test(zipcodeValue)) {
        showSuccess(zipcode);
        return true;
    } else {
        showError(zipcode);
        return false;
    }
}

function submitForm() {
    
    firstName=document.getElementById("firstName");
    lastName=document.getElementById("lastName");
    email=document.getElementById("email");
    contact=document.getElementById("contact");
    address=document.getElementById("address");
    city=document.getElementById("city");
    state=document.getElementById("state");
    website=document.getElementById("website");
    zipcode=document.getElementById("zipcode");
    projectDescription=document.getElementById("projectDescription");
    
    var error = "";
    if (firstName.value == "") {
        error += "Please enter first name\n"
    } else if (!validateName(firstName)) {
        error += "first name is invalid\n";
    }
    if (lastName.value == "") {
        error += "Please enter last name\n"
    } else if (!validateName(lastName)) {
        error += "last name is invalid\n";
    }
    if (email.value == "") {
        error += "Please enter email\n"
    } else if (!validateEmail()) {
        error += "email is invalid\n";
    }
    if (!contact.value == "") {
        if (!validateContact()) {
            error += "contact is invalid\n";
        }
    }
    if (city.value != "") {
        if (!validateName(city)) {
            error += "city name is invalid\n";
        }
    }
    if (!validateState()) {
        error += "please choose state\n";
    }
    var form = document.getElementById("form");
    if (form.contains(zipcode)) {
        if (zipcode.value == "") {
            error += "please enter zipcode";
        } else if (!validateZipcode()) {
            error += "zipcode is invalid";
        }
    }
    if (form.contains(projectDescription)) {
        if (projectDescription.value == "") {
            error += "Please enter project description";
        }
    }
    if (error != "") {
        alert(error);
        return false;
    }
    storeUserDetails();
    return true;
}

function showError(elementId) {
    elementId.style.border = "2px solid red";
}

function showSuccess(elementId) {
    elementId.style.border = "2px solid green";
}

function storeUserDetails() {
    insertDetailToUser("First Name", firstName.value);
    insertDetailToUser("Last Name", lastName.value);
    insertDetailToUser("Email", email.value);
    var contactValue=contact.value;
    if (contactValue != "") {
        insertDetailToUser("Phone No", contactValue);
    }
    addressValue = address.value;
    if (addressValue != "") {
        insertDetailToUser("Address", addressValue);
    }
    cityValue = city.value;
    if (cityValue != "") {
        insertDetailToUser("City", cityValue);
    }
    stateValue = state.value;
    if (stateValue != "") {
        insertDetailToUser("State", stateValue);
    }
    if (form.contains(zipcode)) {
        insertDetailToUser("Zipcode", zipcode.value);
    }
    hostingDiv=document.getElementById("hosting");
    if (form.contains(hostingDiv)) {
        insertDetailToUser("Do you have hosting",document.querySelector('[name="hosting"]:checked').value);
    }
    if (form.contains(website)) {
        if (website.value != "") {
            insertDetailToUser("Website or domain name", website.value);
        }
    }
    if (form.contains(projectDescription)) {
        insertDetailToUser("Project description", projectDescription.value);
    }
    localStorage.setItem("user", JSON.stringify(user));
}

function insertDetailToUser(fieldLabel, fieldValue) {
    user.push({
        label: fieldLabel,
        value: fieldValue
    });
}
