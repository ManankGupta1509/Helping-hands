var login=document.getElementById('login');
var signup=document.getElementById('signup');
var logout=document.getElementById('logout');
var loginbtn=document.getElementById('loginbtn');

signup.style.display="none";
logout.style.display="none";

function close(){
    signup.style.display="none";
    login.style.display="none";
    logout.style.display="block";
}

function show(){
    signup.style.display="none";
    login.style.display="block";
    logout.style.display="none";
}

function closelogin(){

}

function showlogin(){
login.style.display="block";
signup.style.display="none";
}

function showsignup(){
    signup.style.display="block";
    login.style.display="none";
}