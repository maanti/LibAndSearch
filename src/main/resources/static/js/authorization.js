//скрипт написан не до конца,долго сидела с валидацией, но набросок имеет место быть
//
//
//
// // $.ajax({
// //     url:"/getUsers",
// //     type: "POST",
// //     data:{
// //         username:$("#username").val(),
// //         password:$("#password").val()
// //     },
// //     dataType: "json"
// // });
//
//
// function checkInput() {
//     $(function ()
//     {
//         $("#AsubmitButton").click(
//             function send(){
//                 $.ajax({
//                     url:"/getUsers",
//                     type: "POST",
//                     data:{
//                         username:$("#username").val(),
//                         password:$("#password").val()
//                     },
//                     dataType: "json",
//                     success:
//                         function (jq) {
//
//                             if(jq.length === 0) {
//
//                                 var nameField = document.getElementById("username").value;
//                                 var passwordField = document.getElementById("password").value;
//
//                                 if (nameField.length === 0 || passwordField.length === 0){
//                                     alert("Заполните пустые поля");
//
//                                 }
//                                 else{
//                                     alert("Неверный логин или пароль");
//
//                                 }
//
//                             }
//                             else
//                                 alert("Нашел");
//                         }
//                 });
//             }
//         )
//
//     })
//
// }
//
// function noErrorName() {
//     document.getElementById("AenterEmail").setAttribute("style", "color:transparent");
//     document.getElementById("error").setAttribute("style", "color:transparent");
// }
//
// function noErrorPassword() {
//     document.getElementById("AincorrectPassword").setAttribute("style", "color:transparent");
//     document.getElementById("error").setAttribute("style", "color:transparent");
//
// }
//
// // var count = 0;
// // var nameField = document.getElementById("username").value;
// // var passwordField = document.getElementById("password").value;
// // if ((nameField.length === 0) || (passwordField.length === 0)) alert("Заполните пустые поля формы!");
// // else { count++; if ((nameField != t[0]) || (passwordField != t[1])) {alert("Неверный логин или пароль");
// // alert(t[0]);} else count++; } if(count === 2)
// //     return true;
// // else
// //     return false;
