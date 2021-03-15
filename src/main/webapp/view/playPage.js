let responseText = localStorage.getItem("course");
let jsonObject = JSON.parse(responseText);
let course = jsonObject.course;
let videoTitle = document.getElementById("videoTitle");
let videoDiv = document.getElementById("videoDiv");

    videoTitle.innerHTML = course.cName;
    videoDiv.src = course.cVideoPath;
