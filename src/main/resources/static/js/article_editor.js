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



    //添加分类
        $('.add-type').click(function () {
            var tpye = '<div class="input-category">'+
                '<input type="text" placeholder="输入分类">'+
                '<i class="del fa fa-remove">'+'</i>'+
                '</div>';

            $('.add-category').prepend(tpye);
            $(".input-category input").focus();

            // 删除表单
            $('.del').click(function () {
                $(this).parent().remove();
            });
        });

});

