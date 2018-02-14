var cnt = 0;

function update(){
    $.ajax({
        url:"/getAuthorsList",
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