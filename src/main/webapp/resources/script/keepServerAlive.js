//this is life-hack to keep free server alive otherwise it goes sleep after 30 minutes of inactivity

function fetchdata(){
    $.ajax({
        url: '/',
        // url: '/keepalive/up',
    });
}

$(document).ready(function(){
    // setInterval(fetchdata,5000);
    setInterval(fetchdata,600000); //10 minutes interval
});

