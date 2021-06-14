const  form=document.getElementById("l_form");

form.addEventListener("submit",loginu)

function  loginu(event)
{
    event.preventDefault();
    const u_id=document.getElementById("l_userid").value;
    const u_pass=document.getElementById("l_pass").value;

    const xhr=new XMLHttpRequest();

    xhr.onreadystatechange=function (){
        if(this.readyState==4&&this.status==200)
        {
            if(this.responseText==="")
            {
                alert("User Not Found");
            }
            else {
                sessionStorage.setItem("id",this.responseText);
                window.location="../home2.html"
            }
        }
    }
    xhr.open("POST","http://localhost:8080/user/login",true);
    const data={
        "password": u_pass,
        "userid": u_id
    }
    xhr.send(JSON.stringify(data));

}