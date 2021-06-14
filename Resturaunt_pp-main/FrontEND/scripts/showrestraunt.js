
function getallrest()
{
    const parent=document.getElementById("showrestro")

    const xhr=new XMLHttpRequest();

    xhr.onreadystatechange=function (){
        if(this.readyState==4&&this.status==200)
        {
            const list=JSON.parse(this.responseText);

            for(let i=0;i<list.length;i++)
            {
                parent.appendChild(addingrest(list[i]));
            }
        }
    }
    xhr.open("GET","http://localhost:8080/allrestraunts",true);
    xhr.send();
}

function addingrest(data)
{
    const main_div=document.createElement("tr");
    let tdr=document.createElement("th");
    let  r_heading=document.createElement("h4");
    let text=document.createTextNode(data.name);
    r_heading.appendChild(text);
    tdr.appendChild(r_heading)
    tdr.setAttribute("class","tst");
    main_div.appendChild(tdr);

    tdr=document.createElement("td");
    r_heading=document.createElement("h4");
    text=document.createTextNode(data.tagline);
    r_heading.appendChild(text);
    tdr.appendChild(r_heading);
    tdr.setAttribute("class","tst");
    main_div.appendChild(tdr);

    tdr=document.createElement("td");
    r_heading=document.createElement("h5");
    text=document.createTextNode(data.address);
    r_heading.appendChild(text);
    tdr.appendChild(r_heading);
    tdr.setAttribute("class","tst");
    main_div.appendChild(tdr);

    tdr=document.createElement("td");
    r_heading=document.createElement("button");
    text=document.createTextNode("Menu");

    r_heading.appendChild(text);
    r_heading.setAttribute("value",data.id);
    r_heading.setAttribute("onclick","gettherest(this)");
    r_heading.setAttribute("class","tsk");
    tdr.appendChild(r_heading);
    tdr.setAttribute("class","tst");
    main_div.appendChild(tdr);
    main_div.setAttribute("class","tas");
    document.getElementById("ta").setAttribute("class","tas");
    return document.getElementById("ta").appendChild(main_div);

}

function gettherest(e)
{
    sessionStorage.setItem("rid",e.value);
    window.location="../html/showmenu.html"
}