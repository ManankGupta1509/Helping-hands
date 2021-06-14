const form=document.getElementById("s_form")

form.addEventListener("submit",signupu)

function signupu(event)
{
    event.preventDefault();
    const u_id=document.getElementById("s_uid").value;
    const u_pass=document.getElementById("s_pass").value;
    const u_email=document.getElementById("s_email").value;
    const u_umane=document.getElementById("s_uname").value;
    const u_mb=document.getElementById("s_mb").value;

    const xhr=new XMLHttpRequest();

    xhr.onreadystatechange=function (){
        if(this.readyState==4&&this.status==200)
        {
            if(this.responseText==="")
            {
                alert("User Can't be added");
            }
            else {
                sessionStorage.setItem("id",this.responseText);
                sendmail();
                window.location="../home.html"
            }
        }
    }
    xhr.open("POST","http://localhost:8080/user/signin",true);
    const data={
        "email": u_email,
        "mobile": u_mb,
        "password": u_pass,
        "userid": u_id,
        "username": u_umane
    }
    xhr.send(JSON.stringify(data));


}
function sendmail(){
    const u_email = document.getElementById("s_email").value;
    const xhr1 = new XMLHttpRequest();
    alert("Thank you,Check your mail for confirmation");
    xhr1.onreadystatechange=function (){
        if(this.readyState==4&&this.status==200) {

        }
    }
    xhr1.open("POST","http://localhost:8080/sendingemail",true);
    const maildata={
        "to" : u_email,
        "subject" : "Confirmation Mail From Helping Hands",
        "message" : "Thank you for Successfully Registering with Helping Hands"
    }
    xhr1.send(JSON.stringify(maildata));
}