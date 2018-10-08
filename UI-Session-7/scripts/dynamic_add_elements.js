function stateFunction()
{
    var state=document.getElementById("state").value;
    if("rajasthan"==state){
        removeElements();
        addWebsite();
        addProjectDescription();
    }
    else if("haryana"==state){
        removeElements();
        addZipCode();
        addHosting();
    }
    else if("maharashtra"==state){
        removeElements();
        addProjectDescription();
        addZipCode();
    }
}

function removeElements()
{
    var elements=document.getElementsByClassName("dynamic_div");
    while(elements.length>0){
        elements[0].parentNode.removeChild(elements[0]);
    }
}

function addWebsite()
{ 
    var website=document.createElement("div");
    website.setAttribute("class","input_field dynamic_div");
    
    var websiteLabel=document.createElement("label");
    websiteLabel.appendChild(document.createTextNode("Website or domain name"));
    website.appendChild(websiteLabel);
    
    var icon=document.createElement("i");
    icon.setAttribute("class","fas fa-globe-americas");
    website.appendChild(icon);
    
    var inputField= document.createElement("input");
    inputField.setAttribute("type", "text");
    inputField.setAttribute("id","website");
    inputField.setAttribute("placeholder","Enter website or domain name");
    website.appendChild(inputField);
    document.getElementById("form").appendChild(website);
}

function addProjectDescription()
{
    var project=document.createElement("div");
    project.setAttribute("class","input_field dynamic_div");
    
    var projectLabel=document.createElement("label");
    projectLabel.appendChild(document.createTextNode("Project Description"));
    project.appendChild(projectLabel);
    
    var icon=document.createElement("i");
    icon.setAttribute("class","fas fa-pen");
    project.appendChild(icon);
    
    var inputField= document.createElement("textArea");
    inputField.setAttribute("row", "2");
    inputField.setAttribute("id","projectDescription");
    inputField.setAttribute("placeholder","Project Description");
    inputField.required="true";
    project.appendChild(inputField);
    document.getElementById("form").appendChild(project);
}

function addZipCode()
{
    var zipcode=document.createElement("div");
    zipcode.setAttribute("class","input_field dynamic_div");
    
    var zipcodeLabel=document.createElement("label");
    zipcodeLabel.appendChild(document.createTextNode("ZipCode"));
    zipcode.appendChild(zipcodeLabel);
    
    var icon=document.createElement("i");
    icon.setAttribute("class","fas fa-home");
    zipcode.appendChild(icon);
    
    var inputField= document.createElement("input");
    inputField.setAttribute("type", "text");
    inputField.setAttribute("id","zipcode");
    inputField.setAttribute("placeholder","Zipcode");
    inputField.required="true";
    zipcode.appendChild(inputField);
    document.getElementById("form").appendChild(zipcode);
}

function addHosting()
{
    var hosting=document.createElement("div");
    hosting.setAttribute("class","input_field dynamic_div");
    hosting.setAttribute("id","hosting");
    
    var hostingLabel=document.createElement("label");
    hostingLabel.appendChild(document.createTextNode("Do you have hosting"));
    hosting.appendChild(hostingLabel);
    
    var inputDiv=document.createElement("div");
    inputDiv.setAttribute("class","hosting_radio_field");
    var labelNo=document.createElement("label");
    var inputField= document.createElement("input");
    inputField.setAttribute("type", "radio");
    inputField.setAttribute("value","no");
    inputField.setAttribute("name","hosting");
    labelNo.appendChild(inputField); 
    labelNo.appendChild(document.createTextNode("No"))
    inputDiv.appendChild(labelNo);

    var labelYes=document.createElement("label");
    inputField= document.createElement("input");
    inputField.setAttribute("type", "radio");
    inputField.setAttribute("value","yes");
    inputField.setAttribute("name","hosting");
    labelYes.appendChild(inputField); 
    labelYes.appendChild(document.createTextNode("Yes"))
    inputDiv.appendChild(labelYes);
    hosting.append(inputDiv);
    document.getElementById("form").appendChild(hosting);
}