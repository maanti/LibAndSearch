var cnt = 0;

function update(){
    $.ajax({
        url:"/getPublishersList",
        type: "POST",
        success: function (data) {
            clear();
            if(data.length>0) {
                data.forEach(function (t) {
                    if(t.length != 0)
                        draw(t);
                })
            }
            else document.getElementById("main").innerHTML= "Ничего не найдено по запросу";
        },
        dataType: "json"
    });
}


function isBlank(string){
    if (string === ""){
        return true;
    } else {
        return false;
    }
}
function draw(t) {
    var mainDiv = document.getElementById("main");
    var div2 = document.createElement("div");
    cnt++;


    var li2 = document.createElement("h3");
    li2.innerHTML =cnt+".  ";
    var b1 = document.createElement("a");
    b1.innerHTML = t;
    b1.onclick = function () {
        document.getElementById("req_par").value = this.innerHTML;
        updateWithArgs(document.getElementById('req_par').value, 'publisher')
    };
    li2.appendChild(b1);

    div2.appendChild(li2);

    mainDiv.appendChild(div2);
}

function clear() {
    var mainDiv = document.getElementById("main");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }
}

function updateWithArgs(request, filter){
    $.ajax({
        url:"/findBook",
        type: "POST",
        data:{
            search_req: request,
            filter: filter
        },
        success: function (data) {
            clear();
            if(data.length>0) {
                var mainDiv = document.getElementById("main");
                var li6 = document.createElement("h3");
                var a = document.createElement("a");
                a.href = "/publishers";
                a.innerHTML = "Вернуться к списку";
                a.style = "color:dodgerblue"
                li6.appendChild(a);
                mainDiv.appendChild(a);
                data.forEach(function (t) {
                    drawBooks(t);
                });
            }
            else document.getElementById("main").innerHTML = "Ничего не найдено по запросу";
        },
        dataType: "json"
    });
}

function drawBooks(t) {

    var mainDiv = document.getElementById("main");
    var div2 = document.createElement("div");

    var li1 = document.createElement("h4");
    li1.innerHTML = "Название: ";
    if (t.name.length != 0) {
        var b0 = document.createElement("b");
        b0.innerHTML = t.name;
        li1.appendChild(b0);
    } else {
        var i0 = document.createElement("i");
        i0.innerHTML = "неизвестно";
        li1.appendChild(i0);
    }


    var li2 = document.createElement("h3");
    li2.innerHTML ="Автор: ";
    if (t.author.length != 0) {
        var b1 = document.createElement("b");
        b1.innerHTML = t.author;
        li2.appendChild(b1);
    } else {
        var i1 = document.createElement("i");
        i1.innerHTML = "неизвестно";
        li2.appendChild(i1);
    }


    var li3 = document.createElement("h3");
    li3.innerHTML ="Издательство: ";
    if (t.publisher.length != 0) {
        var b2 = document.createElement("b");
        b2.innerHTML = t.publisher;
        li3.appendChild(b2);
    } else {
        var i2 = document.createElement("i");
        i2.innerHTML = "неизвестно";
        li3.appendChild(i2);
    }


    var li4 = document.createElement("h3");
    li4.innerHTML ="Год: ";
    if (t.year != null) {
        var b3 = document.createElement("b");
        b3.innerHTML = t.year;
        li4.appendChild(b3);
    } else {
        var i3 = document.createElement("i");
        i3.innerHTML = "неизвестно";
        li4.appendChild(i3);
    }

    var li5 = document.createElement("h3");
    if (t.link.length != 0) {
        var a = document.createElement("a");
        a.href = t.link;
        a.innerHTML = "Открыть";
        a.target = "_blank";
        li5.appendChild(a);
    } else {
        var i4 = document.createElement("i");
        i4.innerHTML = "неизвестно";
        li5.appendChild(i4);
    }

    div2.appendChild(li1);
    div2.appendChild(li2);
    div2.appendChild(li3);
    div2.appendChild(li4);
    div2.appendChild(li5);

    mainDiv.appendChild(div2);
}