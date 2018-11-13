/**
 *@author :hly
 *@github :https://github.com/huangliangyun
 @blog :blog.csdn.net/Sirius_hly
 *@date :2018/11/13
 */
window.onload =function (ev) {
    var new_scroll_position = 0;
    var last_scroll_position;
    var nav = document.getElementById("nav");

    window.addEventListener('scroll', function (e) {
        last_scroll_position = window.scrollY;

        // Scrolling down
        if (new_scroll_position < last_scroll_position && last_scroll_position > 60) {
            // nav.removeClass('slideDown').addClass('slideUp');
            nav.classList.remove("slideDown");
            nav.classList.add("slideUp");

            // Scrolling up
        } else if (new_scroll_position > last_scroll_position) {
            // nav.removeClass('slideUp').addClass('slideDown');
            nav.classList.remove("slideUp");
            nav.classList.add("slideDown");
        }

        new_scroll_position = last_scroll_position;
    });
}
