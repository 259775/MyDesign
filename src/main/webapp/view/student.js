var innerBox = document.getElementsByClassName("innerBox")[0];

var myInformation = document.getElementById("myInformation");
    myInformation.onclick = function () {
        innerBox.style.left = 0 + "px";
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open("post","selectInformation",true);
        xmlHttp.send();

        //要修改的值
        var username = document.getElementById("username");
        var age = document.getElementById("age");
        var sex = document.getElementById("sex");
        var native = document.getElementById("native");
        var phone = document.getElementById("phone");
        var email = document.getElementById("email");
        var information = document.getElementById("information");
        var myPortrait = document.getElementById("myPicture");

        xmlHttp.onreadystatechange = function () {
            if(xmlHttp.readyState==4 && xmlHttp.status==200){
                var responseText = xmlHttp.responseText;
                var jsonObject = JSON.parse(responseText);
                var nowUser = jsonObject.nowUser;
                username.value = nowUser.sName;
                age.value = nowUser.sAge;
                sex.value = nowUser.sSex;
                native.value = nowUser.sNative;
                phone.value = nowUser.sPhone;
                email.value = nowUser.sEmail;
                information.value = nowUser.sIntroduce;
                myPortrait.src=nowUser.sPicture;
            }
        }
        let savaButton = document.getElementById("saveButton");
        savaButton.onclick = function () {
            let value = {
                sName: username.value,
                sAge: age.value,
                sSex: sex.value,
                sNative: native.value,
                sPhone: phone.value,
                sEmail: email.value,
                sIntroduce: information.value,
                sPicture: myPortrait.src
            }

            let xmlhttp = new XMLHttpRequest();
            xmlhttp.open("post","saveInformation?information="+JSON.stringify(value),true);
            xmlhttp.send();

            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState==4&& xmlhttp.status==200){
                   let result = JSON.parse(xmlhttp.responseText).mes;
                    alert(result);
                }
            }
        }


    }

    var backIndex = document.getElementById("backIndex");
    backIndex.onclick = function () {
        window.history.back();
    }

    let upload = document.getElementById("upLoad");
    upload.onchange = function () {
        let myPicture = document.getElementById("myPicture");
        let url = this.value;
        //个人头像路径--由个人信息拼接路径-不同的人就有不同的路径 例：/2017305002/portraits/文件
                                                        //动态拼接用户文件夹/静态文件夹名/动态文件名
        myPicture.src = "../img/" + url.substring(url.lastIndexOf("\\")+1);
    }





//试题收缩框
var myDtails = document.getElementById("myDetails");

    myDtails.onclick = function (){
        changeMyDetails();
    }
        function changeMyDetails(){
            var myDetailsImg = document.getElementById("myDetailsImg");
            var leftBox = document.getElementsByClassName("leftBox")[0];
            var answer = document.getElementById("answer");
            var textList = document.getElementById("textList");
            if(textList.style.height == "0px"){
                //第一个元素
                textList.style.height = "25px";
                textList.innerHTML = "我的试题";

                //第二个元素
                answer.style.height = "25px";
                answer.innerHTML = "答题";
                leftBox.style.height = (parseInt(leftBox.style.height)+54)+"px";
                myDetailsImg.src = "../img/open.png"
            }else if(textList.style.height == "25px") {
                answer.style.height = "0px";
                answer.innerHTML = "";
                textList.style.height = "0px";
                textList.innerHTML = "";
                leftBox.style.height = (parseInt(leftBox.style.height)-54)+"px";
                myDetailsImg.src = "../img/close.png"
            }
        }


//我的课程
let myCourse = document.getElementById("myCourse");

    myCourse.onclick = function () {

        innerBox.style.left = -848 + "px";
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("post","allCourse",true);
        xmlHttp.send();

        xmlHttp.onreadystatechange = function () {
            if(xmlHttp.readyState == 4 && xmlHttp.status ==200){
                let courseList = document.getElementById("courseList")
                let jsonObject = JSON.parse(xmlHttp.responseText);
                let course = jsonObject.course;
                for (let i=0;i<course.length;i++){
                    let div = document.createElement("div");
                    let a =document.createElement("a");
                    let img =document.createElement("img");
                    img.src=course[i].cIconPath;
                    img.className="imgStyle";
                    img.onclick = (function () {
                        let cId = course[i].cId;
                        console.log(cId);
                       return  jumpPlay(cId);
                    });
                    a.className="aStyle";
                    div.className="divStyle";
                    courseList.appendChild(div);
                    div.appendChild(a);
                    a.appendChild(img);
                    div.append(course[i].cName);
                }
            }
        }
    }

    function jumpPlay(cId) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("post","../findVideo?cId="+cId,true);
        xmlHttp.send();

        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState==4&&xmlHttp.status==200){
              let responseText = xmlHttp.responseText;
              localStorage.setItem("course",responseText);
              location.href="./playPage.html";
            }
        }

    }

    //试题
    let list = document.getElementById("textList");
    let textBox =document.getElementById("textBox");
    list.onclick = function () {
        innerBox.style.left=-848-848+"px";
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("post","selectText",true);
        xmlHttp.send();

        xmlHttp.onreadystatechange = function () {
            if(xmlHttp.readyState==4&&xmlHttp.status==200){
                let responseText = xmlHttp.responseText;
                let jsonObject = JSON.parse(responseText);
                let texts = jsonObject.texts;

                for(let i=0;texts.length;i++){
                    let val = texts[i];
                    let outDiv = document.createElement("div");
                    let ele1 = document.createElement("div");
                    let ele2 = document.createElement("div");
                    let ele3 = document.createElement("div");
                    let ele4 = document.createElement("div");
                    let tName = document.createElement("a");
                    let videoName = document.createElement("a");

                    outDiv.className="outDiv";
                    textBox.append(outDiv);

                    ele1.innerText=val.cId;
                    ele1.className="listStyle";
                    outDiv.append(ele1);

                    videoName.innerText = val.cName;
                    videoName.className="jump";
                    videoName.onclick = (function () {
                        let cId =val.cId;
                        return jumpPlay(cId);
                    })
                    ele2.append(videoName);
                    ele2.className="listStyle";
                    outDiv.append(ele2);

                    tName.innerText = val.textName;
                    tName.className = "jump";
                    ele3.append(tName);
                    ele3.className="listStyle";
                    outDiv.append(ele3);

                    ele4.innerText=val.grade;
                    ele4.className="listStyle"
                    outDiv.append(ele4);
                }

            }
        }
    }


