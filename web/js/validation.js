function newStudentForm() {

    var carnet = document.forms["newStudent"]["pCarnet"].value;
    var surName = document.forms["newStudent"]["pSurName"].value;
    var name = document.forms["newStudent"]["pName"].value;
    if (carnet === null || carnet === "")
        alert("Debe Indicar El Carnet");
    else if (surName === null || surName === "")
        alert("Debe Indicar los Apellidos");
    else if (name === null || name === "")
        alert("Debe Indicar El Nombre");
    else
        document.forms["newStudent"].submit();
}
function effect(ele) {
    //a = ['1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'];
    e = document.getElementById(ele);
    //e.style.color = "red";
    e.style.fontWeight = "bold";
    e.style.textDecoration = "underline";
    jele = "#"+ele;
   $(jele).animate({color : "#FF0000", opacity: 1}, 400, function() { });
    //$("#"+ele).animate({color: '#FF0000'});
}
;
function deefect(e) {
    ///e.style.color = "black";
    e.style.fontWeight = "normal";
    e.style.textDecoration = "none";
    $(e).animate({color : "#000000", opacity: 0.75}, 400, function() { });
}
function DeleteStudent(id) {
    if(!confirm('Realmente desea Borrar Los Datos? ')) return;
    var myForm = document.createElement("form");
    myForm.method = "post";
    myForm.action = "DeleteStudent";
    var _id = document.createElement("input");

    _id.setAttribute("name", "pCarnet");
    _id.setAttribute("value", id);
    myForm.appendChild(_id);

    document.body.appendChild(myForm);
    myForm.submit();
    document.body.removeChild(myForm);
}
function UpdateStudent(id) {
    var myForm = document.createElement("form");
    myForm.method = "post";
    myForm.action = "UpdateStudent";
    var _id = document.createElement("input");
    var _t1 = document.createElement("input");
    var _t2 = document.createElement("input");
    var _t3 = document.createElement("input");
    var arr = new Array(3);
    arr[0] = document.getElementById("1" + id).value;
    arr[1] = document.getElementById("2" + id).value;
    arr[2] = document.getElementById("3" + id).value;

    _id.setAttribute("name", "pCarnet");
    _id.setAttribute("value", id);
    myForm.appendChild(_id);
    _t1.setAttribute("name", "pt1");
    _t1.setAttribute("value", arr[0]);
    myForm.appendChild(_t1);
    _t2.setAttribute("name", "pt2");
    _t2.setAttribute("value", arr[1]);
    myForm.appendChild(_t2);
    _t3.setAttribute("name", "pt3");
    _t3.setAttribute("value", arr[2]);
    myForm.appendChild(_t3);

    document.body.appendChild(myForm);
    myForm.submit();
    document.body.removeChild(myForm);
}
function begin() {
    rldBtn = document.getElementById('rldBtn');
    rldBtn.disabled = true;
    val = document.getElementById("dvMsj").innerHTML;
    if(!(val ==="" || val === null)) alert(val); 
}
function enaBtn(){
    rldBtn = document.getElementById('rldBtn');
    rldBtn.disabled = false;
}
/*
   //Postear data sin recargar tomado de stackoverflow 18/5/14
     http://stackoverflow.com/questions/5004233/jquery-ajax-post-example-with-php

    var request;
    // bind to the submit event of our form
    $("#foo").submit(function(event){
    // abort any pending request
    if (request) {
        request.abort();
    }
    // setup some local variables
    var $form = $(this);
    // let's select and cache all the fields
    var $inputs = $form.find("input, select, button, textarea");
    // serialize the data in the form
    var serializedData = $form.serialize();

    // let's disable the inputs for the duration of the ajax request
    // Note: we disable elements AFTER the form data has been serialized.
    // Disabled form elements will not be serialized.
    $inputs.prop("disabled", true);
 
    $.post('/form.php', serializedData, function(response) {
        // log the response to the console
        console.log("Response: "+response);
    });
 */