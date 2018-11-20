/*@author :hly
@github :https://github.com/huangliangyun
@blog :blog.csdn.net/Sirius_hly
@date :2018/8/14*/
/*slimScroll文档*/
/*http://www.jq22.com/demo/jQuery-slimScroll-141223223505/*/
var handleSlimScroll = function () {
    "use strict";

    $('#my-scrollbar').slimScroll({
        height: '100%',
        railVisible: true,
        railColor: '#ff0f04'
    });

    /*todo 加上会影响sideBar滑动和点击，未解决*/
   /* $('#article_edit').slimScroll({
        height:'100%',
        railVisible: true,
        railColor: '#ff0b56'
    });*/

};

var handleSidebarMenu = function () {
    "use strict";
    $(".sidebar .nav > .has-sub > a").click(function () {
        /*查找下一个为sub-menu的同胞元素*/
        var e = $(this).next(".sub-menu");
        /*var t = ".sidebar .nav > li.has-sub > .sub-menu";
        $(t).not(e).slideUp(250);*/
        /*在显示和隐藏状态之间切换，0.25秒*/
        $(e).slideToggle(250)
    });

};

/*JQ控制不同方向的滑动：https://www.jb51.net/article/52347.htm*/
/*animate: http://www.w3school.com.cn/jquery/effect_animate.asp*/
var handlesSidebarStatus = function () {
    "use strict";
    $("#admin-sidebar-button").click(function () {
        var $lefty=$("#admin-sidebar");
        $lefty.animate({
            left:parseInt($lefty.css('left'),10)==0 ? - $lefty.outerWidth()+10 : 0
        });

        //改变文章编辑界面的位置
        var $articleEdit=$(".article_edit");
        $articleEdit.animate({
            /*动态改变位置*/
            marginLeft:parseInt($articleEdit.css('margin-left'),10)==230?0:230
        });

        //改变文章管理界面的位置
        var $articleManege = $(".admin-articles-list-part");
        $articleManege.animate({
           /* width:$articleManege.css('width')=='100%'?'82%':'100%',*/
            marginLeft:parseInt($articleManege.css('margin-left'),10)==230?10:230
        });
    });
};

var App = function () {
    "use strict";
    return {
        init: function () {
            handleSidebarMenu();
            handlesSidebarStatus();
            handleSlimScroll();
        }
    }
}();