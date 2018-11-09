/**
 * 获取Cookie值
 * @param name cookie 键值
 * @returns {*}
 */
function getCookie(name) {
    var cookieList = document.cookie.split(';');
    for (var i = 0; i < cookieList.length; i++) {
        var cookie = cookieList[i];
        //当传入多个Cookie时，第二个或以后键值前面可能会多一个空格
        while (cookie.charAt(0) == ' ')
            cookie = cookie.substring(1);

        if (cookie.indexOf(name) != -1) {
            var str = cookie.substring(name.length, cookie.length);
            str = str.substring(1, str.length);
            return str;
        }
    }
    return "";
}