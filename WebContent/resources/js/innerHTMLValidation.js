var namepattern=/^[a-zA-Z]+$/
 var phonepattern = /^\d{10}$/
 var emailpattern =/^[a-zA-Z][a-zA-Z0-9_]*(\.[a-zA-Z0-9_]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.([a-zA-Z]{2,4})$/
 var emailpattern2 =/^[a-zA-Z][a-zA-Z0-9_]*(\.[a-zA-Z0-9_]+)*$/
 var idpattern=/^\d{6}$/;

function validateForm()
{
 
 var x=document.forms["form1"]["firstname"];
 if (x.value=="")
   {
  
  document.getElementById('pointfn').innerHTML="Please enter the first name.";
    x.focus();
  return false;
   }
 
 else if(x.value.length>20)
   {
  x.value="";
  document.getElementById('pointfn').innerHTML="Please enter less than 20 characters.";
  x.focus();
  return false;
   }
 else if ((!namepattern.test(x.value)))
   {
  document.getElementById('pointfn').innerHTML="Please enter only alphabets.";
    x.value="";
  x.focus();
  return false;
   }

 document.getElementById('pointfn').innerHTML='';

 x=document.form1.lastname;

 if(x.value=="")
   {
  document.getElementById('pointln').innerHTML="Please enter the Last name.";
  x.focus();
  return false;
 } 
  else if(x.value.length>20)
   {
  x.value="";
  document.getElementById('pointln').innerHTML="Please enter less than 20 characters.";
  x.focus();
  return false;
 }
 else if (!namepattern.test(x.value))
   {
  x.value="";
  document.getElementById('pointln').innerHTML="Please enter only alphabets.";
  x.focus();
  return false;
 }
 document.getElementById('pointln').innerHTML='';

 x=document.form1.email;
 if(x.value=="")
 {
  x.value="";
  document.getElementById('pointemail').innerHTML="Please enter the email id.";
  x.focus();
  return false;
 }
 else if(!emailpattern.test(x.value))
 {
  x.value="";
  document.getElementById('pointemail').innerHTML="Please enter a valid email address.";
  x.focus();
  return false;
 }
 document.getElementById('pointemail').innerHTML="";
 x=document.form1.contctno;

 if(x.value=="")
 {
  
  x.value="";
  document.getElementById('pointcontct').innerHTML="Please enter the contact number.";
  x.focus();
  return false;
 }
 else if(isNaN(x.value))
 {
  x.value="";
  document.getElementById('pointcontct').innerHTML="Please enter only digits.";
  x.focus();
  return false;
 }
 else if(x.value.length!=10)
 {
  x.value="";
  document.getElementById('pointcontct').innerHTML="Please enter only 10 digits.(Mobile number)";
  x.focus();
  return false;
 }
 else if(!phonepattern.test(x.value))
 {
  x.value="";
  document.getElementById('pointcontct').innerHTML="Please enter a valid contact number.";
  x.focus();
  return false;
 }
 document.getElementById('pointcontct').innerHTML="";
 x=document.form1.usernam;

 if(x.value=="")
 {
  
  x.value="";
  document.getElementById('pointname').innerHTML="Please enter the username.";
  x.focus();
  return false;
 }
 document.getElementById('pointname').innerHTML="";
 x=document.form1.password1;

 if(x.value=="")
 {
  
  x.value="";
  document.getElementById('pointpassword').innerHTML="Please enter the password.";
  x.focus();
  return false;
 }
 else if(passwordpattern.test(x.value))
 {
  x.value="";
  document.getElementById('pointpassword').innerHTML="Please enter any one digits.";
  x.focus();
  return false;
 }
 document.getElementById('pointpassword').innerHTML="";
 
 return confirm("Do you want to submit the form?");
}
 function confirmreset()
 {
  if(confirm("Do you want to reset the form?"))
{
 document.getElementById('pointfn').innerHTML="";
 document.getElementById('pointln').innerHTML="";
 document.getElementById('pointcontct').innerHTML="";
 document.getElementById('pointemail').innerHTML="";
 document.getElementById('pointname').innerHTML="";
 document.getElementById('pointpassword').innerHTML="";
 return true;
}
else
 return false;
 }