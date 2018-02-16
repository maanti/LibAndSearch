document.onkeyup = function (e) {
    e = e || window.event;
    if (e.keyCode === 13) {
        update();
    }
    return false;
};

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
            else document.getElementById("main").innerHTML = "Ничего не найдено по запросу";
        },
        dataType: "json"
    });
}
function draw(t) {

    var mainDiv = document.getElementById("main");
    var div2 = document.createElement("div");

    var li1 = document.createElement("h3");
    li1.innerHTML = "Название: ";
    if ((t[0]!==null)) {
        var b0 = document.createElement("b");
        b0.innerHTML = t[0];
        li1.appendChild(b0);
    } else {
        var i0 = document.createElement("i");
        i0.innerHTML = "неизвестно";
        li1.appendChild(i0);
    }


    var li2 = document.createElement("h3");
    li2.innerHTML ="Автор: ";
    if ((t[1]!==null)) {
        var b1 = document.createElement("b");
        b1.innerHTML = t[1];
        li2.appendChild(b1);
    } else {
        var i1 = document.createElement("i");
        i1.innerHTML = "неизвестно";
        li2.appendChild(i1);
    }


    var li3 = document.createElement("h3");
    li3.innerHTML ="Издательство: ";
    if ((t[2]!==null)) {
        var b2 = document.createElement("b");
        b2.innerHTML = t[2];
        li3.appendChild(b2);
    } else {
        var i2 = document.createElement("i");
        i2.innerHTML = "неизвестно";
        li3.appendChild(i2);
    }


    var li4 = document.createElement("h3");
    li4.innerHTML ="Год: ";
    if ((t[3]!==null)) {
        var b3 = document.createElement("b");
        b3.innerHTML = t[3];
        li4.appendChild(b3);
    } else {
        var i3 = document.createElement("i");
        i3.innerHTML = "неизвестно";
        li4.appendChild(i3);
    }

    var li5 = document.createElement("h3");
    if ((t[5]!==null)) {
        var a = document.createElement("a");
        a.href = t[5];
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

function clear() {
    var mainDiv = document.getElementById("main");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }
}