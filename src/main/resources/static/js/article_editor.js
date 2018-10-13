/**
 *@author :hly
 *@github :github.com/SiriusHly
 @blog :blog.csdn.net/Sirius_hly
 *@date :2018/10/13
 */

$(document).ready(function () {

    /*提交文章函数和方法*/

    $('#submit_article').click(function () {
        submit_article();
        //alert("提交文章");
    });

    function submit_article() {
        var title = $("#article_title").val();
        var htmlContent = $("#editor-md-html").val();
        var markdownContent = $("#editor-md-doc").val();
        $.ajax({
            url: "/editorContent",
            data: JSON.stringify({title: title, htmlContent: htmlContent, markdownContent: markdownContent}),
            type: "POST",
            contentType: 'application/json',
            success: function () {
                alert("发布成功"+htmlContent);

            },
            error: function () {
                alert("发布失败");
            }
        });
    }

});

