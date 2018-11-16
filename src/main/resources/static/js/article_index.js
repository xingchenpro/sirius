/**
 *@author :hly
 *@github :https://github.com/huangliangyun
 @blog :blog.csdn.net/Sirius_hly
 *@date :2018/11/15
 */




//layer UI :https://www.cnblogs.com/lxwphp/p/9717960.html
//微信二维码
$("#weChatBtn").click(function () {
    var weChatImg = '<img src="../../images/user/weChatCode.jpg">'
    layer.open({
        type: 1,
        title: false,
        closeBtn: 1,
        skin: 'layui-layer-nobg', //没有背景色
        area: ['430px', '430px'], //宽高
        shadeClose: true,
        content: weChatImg,
        end: function () {
            weChatImg.attr("style", "display:none;")
        }
    });
});


/*$("#weChatBtn").click(function () {
    layer.open({
        type: 1,
        title: '微信二维码',
        closeBtn: 1,
        area: ['500px', '500px'], //宽高
        shadeClose: true,
        content: $('#weChatCode'),
        end: function () {
            $("#weChatCode").attr("style", "display:none;")
        }
    });
});*/
