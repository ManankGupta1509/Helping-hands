var form=document.getElementById("add_rest");

form.addEventListener("submit",addrestraunt)

function addrestraunt(e){
    e.preventDefault();

    const r_name=document.getElementById("r_name").value;
    const r_tl=document.getElementById("r_tl").value;
    const r_em=document.getElementById("r_email").value;
    const r_mb=document.getElementById("r_mb").value;
    const r_address=document.getElementById("r_address").value;
    const r_fl=document.getElementById("r_fl").value;

    const xhr=new XMLHttpRequest();

    xhr.onreadystatechange=function (){
        if(this.readyState==4&&this.status==200)
        {
            console.log(this.responseText)
            if(this.responseText==="")
            {
                alert("Restruant not added");
            }
            else {
                sessionStorage.setItem("rid",this.responseText);
                alert("added");

                window.location="../html/addmenu.html"
            }
        }
    }
    xhr.open("POST","http://localhost:8080/addrestraunt",true);
    const data={
        "address":r_address,
        "foodlicense":r_fl,
        "contact_numb":r_mb,
        "email":r_em,
        "name":r_name,
        "tagline":r_tl
    }
    xhr.send(JSON.stringify(data));
}