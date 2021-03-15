function check(form) {
    for (let i = 0; i < 2; i++) {
        //form属性的elements的首字母e要小写
        if (form.elements[i].value == "") {
            $("errorMes").text("账号/密码不能为空!");
            return false;
        }
    }
}

