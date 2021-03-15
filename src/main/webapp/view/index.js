let carouselOption = document.getElementsByClassName("carouselOption");
for(let n in carouselOption){
    carouselOption[n].onclick = function () {
        findVideo(this.name);
    }
}

function findVideo(id) {
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open("post","findVideo?cId="+id,true);
    xmlHttp.send();

    xmlHttp.onreadystatechange = function () {
        if(xmlHttp.readyState == 4 && xmlHttp.status ==200){
            let responseText = xmlHttp.responseText;
            localStorage.setItem("course",responseText);
            location.href = "./view/playPage.html";
        }
    }

}



//轮播图
var warp = document.getElementsByClassName("carousel")[0];
var childrens = document.getElementsByClassName("carouselIcon")[0].children;
childrens[0].style.backgroundColor = "#53868B";
var timer=null;
var controler = function(){
    timer=setInterval(function(){
        warp.style.left = parseInt(warp.style.left) - 4 + "px";
        if(parseInt(warp.style.left) == -1000 || parseInt(warp.style.left) == -2000 ||parseInt(warp.style.left) 	== -3000 || parseInt(warp.style.left) == -4000){
            if (parseInt(warp.style.left) == -4000) {
                warp.style.left = 0 + "px";
                childrens[0].style.backgroundColor = "#53868B";
            }
            var value = Math.abs(parseInt(warp.style.left))/1000 ;
            for (var i = 0; i < childrens.length; i++) {
                if(value == i){
                    childrens[i].style.backgroundColor = "#53868B";
                }else{
                    childrens[i].style.backgroundColor = "#00F5FF";
                }
            }
            clearInterval(timer);
        }
    },3);
};

var timer1 = setInterval(controler,5000);

//轮播图页面切换后的状态控制
document.onvisibilitychange=function(){
    if(document.visibilityState=="visible"){
        timer1=setInterval(controler,3000);
    }else{
        clearInterval(timer1);
    }
}