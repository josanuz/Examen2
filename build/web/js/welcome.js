function welcome(){
    //lf = $('#wrapper').offset().left ;
    w = document.getElementById('pwel').style.width;
    bw = document.body.clientWidth;
    rw = bw - w;
    lf = rw / 6;
    $("#pwel").animate({left:lf+"px"}, "slow");
}