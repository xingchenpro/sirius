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
        var articleTitle = $("#article_title").val();
        var articleContent = $("#editor-md-doc").val();
        $.ajax({
            url: "/editorContent",
            /*这里属性名字和后端一直就行，顺序无所谓*/
            data: JSON.stringify({
                /*8属性*/
                articleCreatorId:'hly',
                articleTitle: articleTitle,
                articleContent: articleContent,
                articleCategoryIds:'',
                articleTags:'',
                articleCreateTime:'',
                articleCommentStatus:"1",
                articleStatus:"1"

            }),
            type: "POST",
            contentType: 'application/json',
            success: function () {
                alert("发布成功" + articleContent);

            },
            error: function () {
                alert("发布失败");
            }
        });
    }

});

