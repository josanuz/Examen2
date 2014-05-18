<%-- 
    Document   : register
    Created on : 17/05/2014, 01:22:44 PM
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Examenes</title>
        <script type="text/javascript" src="js/validation.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <jsp:useBean id="record" class="beans.records.studentRecord" scope="session" > </jsp:useBean>
    </head>
    <body>
        <div id="wrapper">
            <section id="studentInfo">
                <form id="newStudent" method="POST" action="newStudent">
                    <table id="formLayout">
                        <tbody>
                            <tr>
                                <td  rowspan="4"> <img src="img/nsimg.jpg"/> </td>
                                <td> <label id="cl" class="alabel">Carnet</label> </td>
                                <td> <input id="ct" type="text" name="pCarnet" class="intext" onfocus="effect('cl');"
                                         onblur="deefect(cl)"/> 
                                </td>
                            </tr>
                            <tr>
                                <td> <label id="sl" class="alabel">Apellidos</label> </td>
                                <td> <input id="st" type="text" name="pSurName" class="intext" onfocus="effect('sl');"
                                            onblur="deefect(sl)"/> 
                                </td>
                            </tr>
                            <tr>
                                <td> <label id="nl" class="alabel">Nombre</label> </td>
                                <td> <input id="nt" type="text" name="pName" class="intext"  onfocus="effect('nl');"
                                            onblur ="deefect(nl)"/> 
                                </td>
                            </tr>
                            <tr> 
                                <td class="abutton"> <input class="btn" type="button" onclick="newStudentForm();" name="btnsbm" value="OK"/> </td>
                                <td> <input class="btn" type="reset" </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </section>
            <section id="infoDisplay">
                <!--form id="studentsScores" -->
                    <table id="displayTable">
                        <thead>
                            <tr>
                                <th>Carnet</th>
                                <th>Apellidos</th>
                                <th>Nombre</th>
                                <th>Examen 1</th>
                                <th>Examen 2</th>
                                <th>Examen 3</th>
                                <th>Promedio</th>
                                <th>Actualizar</th>
                                <th>Borrar</th>
                            </tr>
                        </thead>
                    ${record.record}
                    </table>
                <!-- /form -->                
            </section>     
        </div>
    </body>
</html>
