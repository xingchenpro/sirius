/**
 *@author :hly
 *@github :https://github.com/huangliangyun
 @blog :blog.csdn.net/Sirius_hly
 *@date :2018/10/13
 */

$(document).ready(function () {

    /*提交文章*/
    $('#submit-article').click(function () {
        submitArticle();
        //alert("提交文章");
    });

    //更新文章
    $('#update-article-modify').click(function () {
        updateArticle();
    });

    //编写提交文章
    function submitArticle() {

        var categoryList = [];

        //获取所有复选
        $.each($('input:checkbox:checked'), function () {
            categoryList.push($(this).val());
        });

        //获取所有input
        $.each($("input[name='inputCategory']"), function () {
            categoryList.push($(this).val());
        });

        var articleTitle = $("#article_title").val();
        var articleContent = $("#editor-md-doc").val();
        $.ajax({
            url: "/admin/articleWritingSubmit",
            /*这里属性名字和后端一直就行，顺序无所谓*/
            data: JSON.stringify({
                article: {
                    articleTitle: articleTitle,
                    articleContent: articleContent
                },
                categoryList: categoryList
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

    //更新文章
    function updateArticle() {
        var articleTitle = $("#article_title").val();
        var articleContent = $("#editor-md-doc").val();
        var categoryList = [];

        //获取所有复选
        $.each($('input:checkbox:checked'), function () {
            categoryList.push($(this).val());
        });

        //获取所有input
        $.each($("input[name='inputCategory']"), function () {
            categoryList.push($(this).val());
        });
        $.ajax({
            url: "/admin/updateArticle",
            /*这里属性名字和后端一直就行，顺序无所谓*/
            data: JSON.stringify({
                article: {
                    articleId: articleId,
                    articleTitle: articleTitle,
                    articleContent: articleContent
                },
                categoryList: categoryList
            }),
            type: "POST",
            contentType: 'application/json',
            success: function () {
                alert("更新成功" + articleId);

            },
            error: function () {
                alert("更新失败");
            }
        });
    }

    //添加分类
    $('.add-type').click(function () {
        var tpye = '<div class="input-category">' +
            '<input type="text" placeholder="输入分类" name="inputCategory">' +
            '<i class="del fa fa-remove">' + '</i>' +
            '</div>';
        $('.add-category').prepend(tpye);
        $(".input-category input").focus();
        // 删除表单
        $('.del').click(function () {
            $(this).parent().remove();
        });
    });
});

