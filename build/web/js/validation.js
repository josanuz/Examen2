var oldColor;
var oldFontW;
function newStudentForm(){

var carnet = document.forms["newStudent"]["pCarnet"].value;
var surName = document.forms["newStudent"]["pSurName"].value;
var name = document.forms["newStudent"]["pName"].value;
if (carnet===null || carnet==="")
    alert("Falta Informacion de Carnet");
else if (surName===null || surName==="")
    alert("Debe Llenar los Apellidos");
else if (name===null || name==="")
    alert("Debe Llenar El Nombre");
else document.forms["newStudent"].submit();
};

function effect(ele){
    e = document.getElementById(ele);
    e.style.color= "red";
    e.style.fontWeight = "bold";
    e.style.textDecoration ="underline";
};
function deefect(e){
    e.style.color= "black";
    e.style.fontWeight = "normal";
    e.style.textDecoration ="none";
}
function DeleteStudent(){
    alert("TODO");
}
function UpdateStudent(id){
  var myForm = document.createElement("form");
  myForm.method="post" ;
  myForm.action = "UpdateStudent";
 var _id = document.createElement("input") ; var _t1 = document.createElement("input") ; 
 var _t2 = document.createElement("input") ; var _t3 = document.createElement("input") ;
 var arr = new Array(3);
 arr[0] = document.getElementById("1"+id).value;
 arr[1] = document.getElementById("2"+id).value;
 arr[2] = document.getElementById("3"+id).value;

 _id.setAttribute("name", "pCarnet") ; _id.setAttribute("value", id);  myForm.appendChild(_id) ;
 _t1.setAttribute("name", "pt1") ;     _t1.setAttribute("value", arr[0]); myForm.appendChild(_t1) ;
 _t2.setAttribute("name", "pt2") ;     _t2.setAttribute("value", arr[1]); myForm.appendChild(_t2) ;
 _t3.setAttribute("name", "pt3") ;     _t3.setAttribute("value", arr[2]);  myForm.appendChild(_t3) ;
  
  document.body.appendChild(myForm) ;
  myForm.submit() ;
  document.body.removeChild(myForm) ;
}