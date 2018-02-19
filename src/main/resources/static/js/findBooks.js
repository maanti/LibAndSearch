// $(function () {
//     $("#search").click(
//         function send() {
//             $.ajax({
//                 url: "/findBook",
//                 type: "POST",
//                 data: {
//                     search_req: $("#search_req").val(),
//                     filter: document.querySelector('input[name="filter"]:checked').value
//                 },
//                 dataType: 'json',
//                 success: function (jq) {
//                     var table = document.getElementById('tbody');
//                     var rowCount = table.rows.length;
//                     for (var i = rowCount-1; i >= 0; i--) {
//                         table.deleteRow(i);
//                     }
//                     if(jq.length===0)
//                         $('booksNotFound').val("Нет книг по указанным параметрам!");
//                     jq.forEach(function (t) {
//                         var table = document.getElementById('tbody');
//                         var tr31 = document.createElement('tr'); //создаем строку
//                         var td31 = document.createElement('td');
//                         td31.innerHTML = t.name; //создаем столбец
//                         var td32 = document.createElement('td');
//                         td32.innerHTML = t.author; //создаем еще столбец
//                         var td33 = document.createElement('td');
//                         td33.innerHTML = t.publisher; //создаем еще столбец
//
//                         tr31.appendChild(td31); //кладем в новосозданную строку первый новосозданный столбец
//                         tr31.appendChild(td32); //кладем в новосозданную строку второй новосозданный столбец
//                         tr31.appendChild(td33);
//                         table.appendChild(tr31); //кладем в таблицу полученную строку
//                     });
//
//                 } ,
//                 error: function(){
//                     alert("no");
//                     var table = document.getElementById('tbody');
//                     var rowCount = table.rows.length;
//                     for (var i = rowCount-1; i >= 0; i--) {
//                         table.deleteRow(i);
//                     }
//                     $('booksNotFound').val("Нет книг по указанным параметрам!")
//
//                 }
//             });
//         }
//
//     )
//
// });
