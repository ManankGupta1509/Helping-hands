function findrest()
{

    const xhr=new XMLHttpRequest();

    xhr.onreadystatechange=function (){
        if(this.readyState==4&&this.status==200)
        {
            const list=JSON.parse(this.responseText);

                (adding(list));

        }
    }
    const id=sessionStorage.getItem("rid")
    xhr.open("GET",`http://localhost:8080/rest/${id}`,true);
    xhr.send();



}
function adding(data)
{
    document.getElementById("r_name").innerHTML=data.name;
    document.getElementById("r_tl").innerHTML=data.tagline;
    document.getElementById("r_add").innerHTML=data.address;

    const parent=document.getElementById("papo")

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
    const id=data.id;
    xhr.open("GET",`http://localhost:8080/menu/get/${id}`,true);
    xhr.send();
}

function addingrest(data)
{
    const main_div=document.createElement("tr");

    let tdr=document.createElement("th");
    let  r_heading=document.createElement("h3");
    let text=document.createTextNode(data.iteamName);
    r_heading.appendChild(text);
    tdr.appendChild(r_heading);
    tdr.setAttribute("class","tst");
    main_div.appendChild(tdr);

    tdr=document.createElement("td");
    r_heading=document.createElement("h3");
    text=document.createTextNode(data.price);
    r_heading.appendChild(text);
    tdr.appendChild(r_heading);
    tdr.setAttribute("class","tst");
    main_div.appendChild(tdr);


    tdr=document.createElement("td");
    r_heading=document.createElement("button");
    text=document.createTextNode("buy");

    r_heading.appendChild(text);
    r_heading.setAttribute("onclick","addi");
    r_heading.setAttribute("class","tsk");
    tdr.appendChild(r_heading);
    tdr.setAttribute("class","tst");
    main_div.appendChild(tdr);
    main_div.setAttribute("class","tas");
    document.getElementById("ta").setAttribute("class","tas");
    return document.getElementById("ta").appendChild(main_div);

}
