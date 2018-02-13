function update(){
    $.ajax({
        url:"/findBook",
        type: "POST",
        data:{
            search_req: $("#search_req").val(),
            filter: document.querySelector('input[name="filter"]:checked').value
        },
        success: function (data) {
            clear();
            if(data.length>0) {
                data.forEach(function (t) {
                    draw(t);
                })
            }
            else document.getElementById("main").innerHTML= "Ничего не найдено по запросу";
        },
        dataType: "json"
    });
}

function draw(t) {
    var mainDiv = document.getElementById("main");
    var innerDiv = document.createElement("div");
    var innerDiv1 = document.createElement("div");
    var div2 = document.createElement("div");

    var li1 = document.createElement("h3");
    li1.innerHTML = "Название: ";
    var b0 = document.createElement("b");
    b0.innerHTML = t.name;
    li1.appendChild(b0);


    var li2 = document.createElement("h3");
    li2.innerHTML ="Автор: ";
    var b1 = document.createElement("b");
    b1.innerHTML = t.author;
    li2.appendChild(b1);

    var li3 = document.createElement("h3");
    li3.innerHTML ="Издательство: ";
    var b2 = document.createElement("b");
    b2.innerHTML = t.publisher;
    li3.appendChild(b2);

    var li4 = document.createElement("h3");
    li4.innerHTML ="Год: ";
    var b3 = document.createElement("b");
    b3.innerHTML = t.year;
    li4.appendChild(b3);

    var li5 = document.createElement("h3");
    li5.innerHTML ="Ссылка: ";
    var a = document.createElement("a");
    a.href = t.link;
    a.innerHTML = t.link;
    li5.appendChild(a);

    /*div2.appendChild(li1);
    div2.appendChild(li2);
    div2.appendChild(li3);
    div2.appendChild(li4);
    div2.appendChild(li5);

    innerDiv1.appendChild(div2);
    innerDiv.appendChild(innerDiv1);
    mainDiv.appendChild(innerDiv);*/
    div2.appendChild(li1);
    div2.appendChild(li2);
    div2.appendChild(li3);
    div2.appendChild(li4);
    div2.appendChild(li5);

    mainDiv.appendChild(div2);
}

function clear() {
    var mainDiv = document.getElementById("main");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }
}