/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50152
Source Host           : localhost:3306
Source Database       : sirius

Target Server Type    : MYSQL
Target Server Version : 50152
File Encoding         : 65001

Date: 2018-11-22 22:30:19
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `articleTitle` varchar(255) DEFAULT NULL,
  `articleContent` text,
  `articleCreateTime` datetime DEFAULT NULL,
  `articleViewCount` int(11) DEFAULT '0',
  `articleLikeCount` int(11) DEFAULT NULL,
  `articleOrder` int(11) DEFAULT '1',
  PRIMARY KEY (`articleId`),
  KEY `FK_USER_ARTICLE` (`username`),
  CONSTRAINT `FK_USER_ARTICLE` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('4', 'hly', 'MarkDown编辑器的使用', '### 主要特性\n\n- 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；\n- 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；\n- 支持ToC（Table of Contents）、Emoji表情、Task lists、@链接等Markdown扩展语法；\n- 支持TeX科学公式（基于KaTeX）、流程图 Flowchart 和 时序图 Sequence Diagram;\n- 支持识别和解析HTML标签，并且支持自定义过滤标签解析，具有可靠的安全性和几乎无限的扩展性；\n- 支持 AMD / CMD 模块化加载（支持 Require.js & Sea.js），并且支持自定义扩展插件；\n- 兼容主流的浏览器（IE8+）和Zepto.js，且支持iPad等平板设备；\n- 支持自定义主题样式；\n\n# Editor.md\n\n![](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png)\n\n![](https://img.shields.io/github/stars/pandao/editor.md.svg) ![](https://img.shields.io/github/forks/pandao/editor.md.svg) ![](https://img.shields.io/github/tag/pandao/editor.md.svg) ![](https://img.shields.io/github/release/pandao/editor.md.svg) ![](https://img.shields.io/github/issues/pandao/editor.md.svg) ![](https://img.shields.io/bower/v/editor.md.svg)\n\n**目录 (Table of Contents)**\n\n[TOCM]\n\n[TOC]\n\n# Heading 1\n## Heading 2\n### Heading 3\n#### Heading 4\n##### Heading 5\n###### Heading 6\n# Heading 1 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n## Heading 2 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n### Heading 3 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n#### Heading 4 link [Heading link](https://github.com/pandao/editor.md \"Heading link\") Heading link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n##### Heading 5 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n###### Heading 6 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n\n#### 标题（用底线的形式）Heading (underline)\n\nThis is an H1\n=============\n\nThis is an H2\n-------------\n\n### 字符效果和横线等\n                \n----\n\n~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n*斜体字*      _斜体字_\n**粗体**  __粗体__\n***粗斜体*** ___粗斜体___\n\n上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n**缩写(同HTML的abbr标签)**\n\n> 即更长的单词或短语的缩写形式，前提是开启识别HTML标签时，已默认开启\n\nThe <abbr title=\"Hyper Text Markup Language\">HTML</abbr> specification is maintained by the <abbr title=\"World Wide Web Consortium\">W3C</abbr>.\n\n### 引用 Blockquotes\n\n> 引用文本 Blockquotes\n\n引用的行内混合 Blockquotes\n                    \n> 引用：如果想要插入空白换行`即<br />标签`，在插入处先键入两个以上的空格然后回车即可，[普通链接](http://localhost/)。\n\n### 锚点与链接 Links\n\n[普通链接](http://localhost/)\n\n[普通链接带标题](http://localhost/ \"普通链接带标题\")\n\n直接链接：<https://github.com>\n\n[锚点链接][anchor-id] \n\n[anchor-id]: http://www.this-anchor-link.com/\n\nGFM a-tail link @pandao\n\n> @pandao\n\n### 多语言代码高亮 Codes\n\n#### 行内代码 Inline code\n\n执行命令：`npm install marked`\n\n#### 缩进风格\n\n即缩进四个空格，也做为实现类似`<pre>`预格式化文本(Preformatted Text)的功能。\n\n    <?php\n        echo \"Hello world!\";\n    ?>\n    \n预格式化文本：\n\n    | First Header  | Second Header |\n    | ------------- | ------------- |\n    | Content Cell  | Content Cell  |\n    | Content Cell  | Content Cell  |\n\n#### JS代码　\n\n```javascript\nfunction test(){\n	console.log(\"Hello world!\");\n}\n \n(function(){\n    var box = function(){\n        return box.fn.init();\n    };\n\n    box.prototype = box.fn = {\n        init : function(){\n            console.log(\'box.init()\');\n\n			return this;\n        },\n\n		add : function(str){\n			alert(\"add\", str);\n\n			return this;\n		},\n\n		remove : function(str){\n			alert(\"remove\", str);\n\n			return this;\n		}\n    };\n    \n    box.fn.init.prototype = box.fn;\n    \n    window.box =box;\n})();\n\nvar testBox = box();\ntestBox.add(\"jQuery\").remove(\"jQuery\");\n```\n\n#### HTML代码 HTML codes\n\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <title>Hello world!</title>\n    </head>\n    <body>\n        <h1>Hello world!</h1>\n    </body>\n</html>\n```\n\n### 图片 Images\n\nImage:\n\n![](https://pandao.github.io/editor.md/examples/images/4.jpg)\n\n> Follow your heart.\n\n![](https://pandao.github.io/editor.md/examples/images/8.jpg)\n\n> 图为：厦门白城沙滩\n\n图片加链接 (Image + Link)：\n\n[![](https://pandao.github.io/editor.md/examples/images/7.jpg)](https://pandao.github.io/editor.md/examples/images/7.jpg \"李健首张专辑《似水流年》封面\")\n\n> 图为：李健首张专辑《似水流年》封面\n                \n----\n\n### 列表 Lists\n\n#### 无序列表（减号）Unordered Lists (-)\n                \n- 列表一\n- 列表二\n- 列表三\n     \n#### 无序列表（星号）Unordered Lists (*)\n\n* 列表一\n* 列表二\n* 列表三\n\n#### 无序列表（加号和嵌套）Unordered Lists (+)\n                \n+ 列表一\n+ 列表二\n    + 列表二-1\n    + 列表二-2\n    + 列表二-3\n+ 列表三\n    * 列表一\n    * 列表二\n    * 列表三\n\n#### 有序列表 Ordered Lists (-)\n                \n1. 第一行\n2. 第二行\n3. 第三行\n\n#### GFM task list\n\n- [x] GFM task list 1\n- [x] GFM task list 2\n- [ ] GFM task list 3\n    - [ ] GFM task list 3-1\n    - [ ] GFM task list 3-2\n    - [ ] GFM task list 3-3\n- [ ] GFM task list 4\n    - [ ] GFM task list 4-1\n    - [ ] GFM task list 4-2\n                \n----\n                    \n### 绘制表格 Tables\n\n| 项目        | 价格   |  数量  |\n| --------   | -----:  | :----:  |\n| 计算机      | $1600   |   5     |\n| 手机        |   $12   |   12   |\n| 管线        |    $1    |  234  |\n                    \nFirst Header  | Second Header\n------------- | -------------\nContent Cell  | Content Cell\nContent Cell  | Content Cell \n\n| First Header  | Second Header |\n| ------------- | ------------- |\n| Content Cell  | Content Cell  |\n| Content Cell  | Content Cell  |\n\n| Function name | Description                    |\n| ------------- | ------------------------------ |\n| `help()`      | Display the help window.       |\n| `destroy()`   | **Destroy your computer!**     |\n\n| Left-Aligned  | Center Aligned  | Right Aligned |\n| :------------ |:---------------:| -----:|\n| col 3 is      | some wordy text | $1600 |\n| col 2 is      | centered        |   $12 |\n| zebra stripes | are neat        |    $1 |\n\n| Item      | Value |\n| --------- | -----:|\n| Computer  | $1600 |\n| Phone     |   $12 |\n| Pipe      |    $1 |\n                \n----\n\n#### 特殊符号 HTML Entities Codes\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot; \n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n### Emoji表情 :smiley:\n\n> Blockquotes :star:\n\n#### GFM task lists & Emoji & fontAwesome icon emoji & editormd logo emoji :editormd-logo-5x:\n\n- [x] :smiley: @mentions, :smiley: #refs, [links](), **formatting**, and <del>tags</del> supported :editormd-logo:;\n- [x] list syntax required (any unordered or ordered list supported) :editormd-logo-3x:;\n- [x] [ ] :smiley: this is a complete item :smiley:;\n- [ ] []this is an incomplete item [test link](#) :fa-star: @pandao; \n- [ ] [ ]this is an incomplete item :fa-star: :fa-gear:;\n    - [ ] :smiley: this is an incomplete item [test link](#) :fa-star: :fa-gear:;\n    - [ ] :smiley: this is  :fa-star: :fa-gear: an incomplete item [test link](#);\n \n#### 反斜杠 Escape\n\n\\*literal asterisks\\*\n            \n### 科学公式 TeX(KaTeX)\n                    \n$$E=mc^2$$\n\n行内的公式$$E=mc^2$$行内的公式，行内的$$E=mc^2$$公式。\n\n$$\\(\\sqrt{3x-1}+(1+x)^2\\)$$\n                    \n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n\n多行公式：\n\n```math\n\\displaystyle\n\\left( \\sum\\_{k=1}^n a\\_k b\\_k \\right)^2\n\\leq\n\\left( \\sum\\_{k=1}^n a\\_k^2 \\right)\n\\left( \\sum\\_{k=1}^n b\\_k^2 \\right)\n```\n\n```katex\n\\displaystyle \n    \\frac{1}{\n        \\Bigl(\\sqrt{\\phi \\sqrt{5}}-\\phi\\Bigr) e^{\n        \\frac25 \\pi}} = 1+\\frac{e^{-2\\pi}} {1+\\frac{e^{-4\\pi}} {\n        1+\\frac{e^{-6\\pi}}\n        {1+\\frac{e^{-8\\pi}}\n         {1+\\cdots} }\n        } \n    }\n```\n\n```latex\nf(x) = \\int_{-\\infty}^\\infty\n    \\hat f(\\xi)\\,e^{2 \\pi i \\xi x}\n    \\,d\\xi\n```\n                \n### 绘制流程图 Flowchart\n\n```flow\nst=>start: 用户登陆\nop=>operation: 登陆操作\ncond=>condition: 登陆成功 Yes or No?\ne=>end: 进入后台\n\nst->op->cond\ncond(yes)->e\ncond(no)->op\n```\n                    \n### 绘制序列图 Sequence Diagram\n                    \n```seq\nAndrew->China: Says Hello \nNote right of China: China thinks\\nabout it \nChina-->Andrew: How are you? \nAndrew->>China: I am good thanks!\n```\n\n### End', '2018-02-17 02:50:36', '17', null, '1');
INSERT INTO `article` VALUES ('5', 'hly', 'Docker $ 第二篇：Docker镜像的使用', '###  一.Docker镜像简介\n\n  1.镜像是Docker三大组件之一，Docker运行容器需要对应的镜像，如果说镜像是程序，那容器就是进程,如果本地不存在镜像，Docker就会从仓库自动下载镜像。\n\n### 二.Docker使用镜像\n\n+ ##### 拉取镜像\n```\n# docker pull huangliangyun/hello-world:v1\n```\n**语法**\n>1. \\# docker pull [选项][Docker Registry 地址[:端口号]/]仓库名[:标签]\n>2. 地址格式：<域名/IP>[:端口号]	。默认地址是 Docker Hub。\n>3. 仓库名格式：<用户名>/<软件名>(用户名默认为librury）。\n+ ##### 查看镜像\n```\n# 查看所有镜像\n# docker images\n```\n**语法**\n>1. \\#  docker images [OPTIONS] [REPOSITORY[:TAG]]\n\n+ ##### 删除镜像\n```\n# 删除所有镜像\n# docker rmi $(docker images)\n```\n**语法**\n>1. \\#  docker rmi [OPTIONS] IMAGE [IMAGE...]\n\n### 三.commit 定制镜像\n\n##### 原则：\n> 1.不轻易适应，应使用Dockerfile完成。\n2.除了改动的文件，很多无关文件被修改、添加，导致镜像臃肿，难以维护。\n3.可用作入侵后保存现场。\n\n##### 原理：\n> 1.在原有镜像的基础上，叠加上容器的存储层。\n2.将容器存储层保存下来成为镜像。\n\n##### 语法：\n>\\# docker commit [选项] <容器ID或容器名> [<仓库名>[:<标签>]]\n#####  实例:\n\n1. 启动容器\n\n```\n# docker run --rm -d -p 80:80 --name webserver nginx\n```\n通过80端口可访问到nginx页面\n \n2. 进入容器\n\n```\n# docker exec -it webserver bash\n```\n3. 更改页面信息\n\n```\n/# echo \'<h1>Hello,Docker!</h1>\'>/usr/share/nginx/html/index.html\n```\n修改后再次访问页面，发现内容已变\n\n4. 退出容器\n\n```\n/# exit\n```\n5. 保存为新的镜像\n\n```\n# docker commit --author \"hly <1136513099@qq.com>\" --message \"修改网页\" webserver nginx:v2\n```\n6. 关闭旧容器，运行新镜像\n\n```\n# docker rm -f $(docker ps -aq) \n# docker run  --rm -d -p 80:80 --name webserver nginx:v2\n```\n内容为修改后的内容\n\n7. 可关闭新容器，运行旧镜像\n\n```\n# docker rm -f $(docker ps -aq) \n# docker run --rm -d -p 80:80 --name webserver nginx\n```\n原来的镜像没有变化。\n\n8. 查看改动内容\n\n```\n# docker diff webserver\n```\n9. 查看镜像历史\n\n```\n# docker history nginx:v2\n```\n\n### 四.Dockerfile定制镜像\n\n##### 原理\n>1.镜像定制是定制每一层添加的配置、文件。\n2.把每一层修改、安装、构建、操作都写入一个脚本，用这个脚本定制镜像。\n3.Dockerfile是文本文件，包含一条条指令，每一条指令构建一层，描述该层如何构建。\n\n#####  特点\n> 构建的镜像透明，体积不臃肿，易于维护。\n\n##### 实例\n\n1. 在空文件夹下创建一个Dockerfile(名字可不为Dockerfile)\n```\n# mkdir myngnix\n# cd mynginx\n# touch Dockerfile\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181027192203463.png)\n\n2. 在Dockerfile文件里面输入以下内容\n```\nFROM nginx\nRUN echo \'<h1>Hello,Docker!</h1>\'       > /usr/share/nginx/html/index.html\n```\n> + FROM\n> 1.指定镜像基础(以一个镜像为基础，在其上进行定制)\n> + RUN\n> 1.每一个RUN指令建立一层镜像。\n> 2.可用&&将各命令串联，简化为一层。\n> 3.支持行尾添加\\换行，首行#注释。\n\n3.  构建镜像\n\n```\n# docker build -t nginx:v3 .\n```\n(文件所在目录执行,末尾有点,指上下文目录)\n\n**过程**\n>1.RUN指令启动容器。\n\n >\\# docker build [选项] <上下文路径/URL/->\n 2.提交修改(层)。\n 3.删除容器。\n \n**参数**\n>-f：指定要使用的Dockerfile路径\n-m：设置内存最大值\n--no-cache：创建镜像的过程不使用缓存\n--pull：尝试去更新镜像的新版本\n-quiet, -q：安静模式，成功后只输出镜像 ID\n--rm：设置镜像成功后删除中间容器\n--tag, -t：镜像的名字及标签\n\n**注意事项**\n>1.不能放到根目录，否则会打包硬盘下所有文件。\n2.可以写.dockerignore剔除不需要上下文传递给docker引擎文件。\n3.可用-f ../xx/指定某个文件作为Dockerfile.\n4.支持URL构建:docker build	https://github.com/xxx。\n\n4. 构建成功后查看镜像\n```\n# docker images\n```\n', '2018-03-17 02:50:36', '19', null, '1');
INSERT INTO `article` VALUES ('6', 'hly', 'Docker $ Docker三剑客：Docker-Compose', '### 一.Docker-Compose 简介\n**简介**\n>1.Docker官方三剑客项目之一。\n>2.负责快速部署分布式应用。\n>3.定义和运行多个Docker容器应用。\n>4.微服务一般有多个实例，为了提高效率，使用Compose管理容器，无需每个微服务都要手动启停。\n\n**功能**\n>1.有时候，我们的一个项目由多个服务，如Web项目，数据库，负载均衡相互配合完成某项任务，这时就需要docker-compose。\n>2.通过docker-compose.yml模板文件定义一组关联的容器为一个项目(project)。\n>3.默认管理对象是项目，通过子命令对项目中一组容器进行便捷声明周期管理。\n\n**基本概念**\n+ 1.服务(service)\n>1.应用容器，可以包括若干相同镜像的容器实例。\n\n+ 2 .项目(project)\n>1.一组关联的应用容器组成完整的业务单元。\n>2.一个项目由多个服务(容器)关联而成,compose 面向项目进行管理。\n>3.在docker-compose.yml文件中定义。\n\n### 二.实战(CentOS)\n##### 1.下载docker-compose\n```\n# curl -L https://github.com/docker/compose/releases/download/1.20.0/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose\n```\n##### 2.安装\n\n```\n# chmod +x /usr/local/bin/docker-compose\n```\n##### 3.查看版本\n\n```\n# docker-compose version\n```\n##### 5.在任意目录新建文件夹\n\n```\n# mkdir hlyCompose\n```\n##### 6.进入文件夹\n\n```\n# cd hlyCompose\n```\n##### 7.新建文件加入代码\n```\n# vi app.py\n```\n\n```\nfrom flask import Flask\nfrom redis import Redis\napp=Flask(__name__)\nredis=Redis(host=\'redis\',port=6379)\n@app.route(\'/\')\ndef hello():\n     count      = redis.incr(\'hits\')\n     return     \'Hello World! 该页面已被访问{}  次。\\n\'.format(count)\nif __name__ == \"__main__\":\n       app.run(host=\"0.0.0.0\",debug=True)\n\n```\n保存退出\n##### 8.编写Dockerfile文件\n\n```\n# vi Dockerfile\n```\n```\nFROM python:3.6-alpine\nADD . /code\nWORKDIR /code\nRUN pip install redis flask\nCMD [\"python\", \"app.py\"]\n```\n##### 9.编写docker-compose.yml\n```\n# vi docker-compose.yml\n```\n```\nversion: \'3\'\nservices:\n   web:\n        build:  .\n        ports:\n            - \"5000:5000\"\n\n   redis:\n       image: \"redis:alpine\"\n\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181102095509795.png)\n\n##### 10.执行命令\n\n```\n# docker-compose up\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181102101024376.png)\n##### 11.输入网址:5000刷新访问\n完成！\n>参考<https://yeasy.gitbooks.io/docker_practice/content/>', '2018-04-17 02:50:36', '10', null, '1');
INSERT INTO `article` VALUES ('7', 'hly', 'Docker $ 第三篇 ：Docker容器的使用', '### 一.Docker容器简介\n   1.镜像和容器的关系，就像面向对象的程序设计中的类和实例，镜像是静态的，容器是镜像运行后产生的，容器1可被创建，启动，停止，删除。\n   2.容器是一个独立的空间，就下宿主下的操作系统，有自己的文件系统，网络配置，进程，由于容器的隔离性，在容器下运行的应用比在宿主下更加安全。\n   3.容器和镜像一样都是分层存储，容器以镜像为基础运行，运行时创建一个当前容器的存储层，存储层的生命周期和容器一样，容器消亡，存储层也消亡，保存于存储层的信息随着容器消亡而消失，所以，文件的写入操作，应该使用数据卷(Volume),数据卷的生存周期独立于容器，容器消亡，数据卷不会消亡，数据也不会丢失。\n   \n   ### 二.Docker容器命令\n   \n   + ##### 运行容器 \\# docker run\n   **功能**\n   >创建一个新的容器并运行一个命令\n   \n   **语法**\n  \n\n>\\# docker run [OPTIONS] IMAGE [COMMAND] [ARG...]\n\n   **参数**\n   >-d : 后台运行容器，返回容器id\n   >-t : 让docker分配一个伪终端，绑定到容器标准输入上，通常与 -i 同时使用。\n   >-it : -i：交互式操作，-t：终端，进入bash执行命令查看返回结果，需要交互式终端。\n   >-i : 以交互模式运行容器，让容器的标准输入保持打开，通常与 -t 同时使用。\n   >--rm : 容器退出后删除容器(避免浪费空间)，可选，docker rm conName 删除容器。\n   >--name : 命名\n   >-p : 暴露给外部的端口，主机(宿主)端口:容器端口\n   >bash : 镜像后的命令，shell交互模式。\n\n   **实例**\n\n```\n# docker run --rm -d -p 80:80 --name webserver nginx\n# docker exec -it webserver bash \n```\n\n+ ##### 进入容器\\# docker attach\n\n **功能**\n >连接到正在运行中的容器,进行命令操作。\n \n **语法**\n >docker attach [OPTIONS] CONTAINER\n \n **参数**\n >--sig-proxy=false ：CTRL-C不会关闭容器\n >\n **实例**\n \n```\n# docker attach --sig-proxy=false b11\n```\n\n+ ##### 进入容器\\# docker exec\n\n **功能**\n >连接到正在运行中的容器,进行命令操作。\n \n **语法**\n > docker exec -it [ID Or NANME] bash\n \n **参数**\n >-i :以交互模式运行容器，让容器的标准输入保持打开，通常与 -t 同时使用。\n >-t :让docker分配一个伪终端，绑定到容器标准输入上，通常与 -i 同时使用。\n >-it :-i：交互式操作，-t：终端，进入bash执行命令查看返回结果，需要交互式终端。\n\n **实例**\n\n```\n# docker run --rm -d -p 80:80 --name webserver nginx\n# docker exec -it webserver bash \n```\n\n+ ##### 终止容器 # docker stop\n\n **语法**\n >\\# docker stop [ID Or NANME]\n \n + ##### 重启容器 # docker restart\n **语法**\n >\\# docker restart [ID Or NANME]\n \n + ##### 启动已终止容器 # docker start \n **语法**\n >\\# docker start [ID Or NANME]\n\n+ ##### 删除容器  # docker rm\n\n **语法**\n \n **1.删除单个停止的容器**\n \n```\n# docker container rm [ID Or NANME]\n# docker rm [ID Or NANME]\n```\n**2.删除所有容器**\n```\n# 停止并删除所有容器\n# docker rm -f $(docker ps -aq)\n# docker stop $(docker ps -q) & docker rm $(docker ps -aq)\n```\n```\n# 删除所有运行的容器\n# docker rm -f $(docker ps -q)\n```\n```\n# 删除所有停止的容器\n# docker container prune\n```\n+ ##### 列出容器 \\# docker ps\n\n **功能**\n >列出容器\n \n **语法**\n \n\n>\\# docker ps [OPTIONS]\n\n **参数**\n>-a :显示所有的容器，包括未运行的。\n>-l :显示最近创建的容器。\n>-f :根据条件过滤显示的内容。\n>-n :列出最近创建的n个容器。\n>-q :静默模式，只显示容器编号。\n>\n **实例**\n```\n# docker ps -a\n```\n+ ##### 查看容器信息 \\# docker inspect\n\n **功能**\n >获取容器和镜像的信息\n >\n **语法**\n >docker inspect [OPTIONS] NAME|ID [NAME|ID...]\n \n **参数**\n >-f :指定返回值的模板文件。\n >-s :显示总的文件大小。\n >--type :为指定类型返回JSON。\n \n **实例**\n```\n# docker inspect nginx\n```\n+ ##### 查看容器进程信息 \\# docker top\n\n **功能**\n >查看容器中运行的进程信息,支持 ps 命令参数\n >\n **语法**\n >docker top [OPTIONS] CONTAINER [ps OPTIONS]\n \n+ ##### 容器的日志 # docker logs\n\n **功能**\n >获取容器的日志\n \n **语法**\n >docker logs [OPTIONS] CONTAINER\n >\n **参数**\n >-f : 跟踪日志输出\n >--since :显示某个开始时间的所有日志\n >-t : 显示时间戳\n >--tail :仅列出最新N条容器日志\n \n+ ##### 容器端口映射 # docker port\n\n **功能**\n >列出指定的容器的端口映射\n \n **语法**\n >docker port [OPTIONS] CONTAINER [PRIVATE_PORT[/PROTO]]\n ', '2018-05-08 02:50:36', '19', null, '1');
INSERT INTO `article` VALUES ('8', 'hly', 'Docker $ 第四篇 ：Docker仓库的使用', '### 一.Docker仓库简介\n1.仓库(Repository)是集中存放镜像的地方，每个仓库有多个镜像。[Docker hub](https://hub.docker.com/)是Docker官方维护的公共仓库，这里存放了大量的镜像，大部分镜像都可以在这里拉取。\n2.注册服务器(Registry)和仓库不同，注册服务器是管理仓库的地方，注册服务器相当于github,注册服务器有很多仓库，仓库相当于项目，每个仓库有不同版本的镜像，相当于不同版本的项目。\n2.在：<https://cloud.docker.com/>可以注册自己的docker账号，然后上传下载自己本地的Docker镜像。\n3.Docker官网：<https://www.docker.com>\n### 二.Docker仓库命令\n+ ##### \\# docker login\n**功能**\n>登录Docker镜像仓库\n>\n**语法**\n>docker login [OPTIONS] [SERVER]\n>\n**实例**\n\n```\n# docker login -u 用户名 -p 密码\n```\n\n+ ##### \\# docker logout\n**功能**\n>登出Docker镜像仓库\n>\n**语法**\n>docker logout [OPTIONS] [SERVER]\n>\n**实例**\n\n```\n# docker logout\n```\n\n+ ##### \\# docker pull \n**功能**\n>从仓库拉取或更新镜像\n>\n**语法**\n>docker pull [OPTIONS] NAME[:TAG(版本)]\n>\n**实例**\n\n```\n# 拉取最新版镜像。\n# docker pull nginx\n```\n```\n# 拉取所有镜像。\n# docker pull -a nginx\n```\n\n\n+ ##### \\# docker push\n**功能**\n>将本地镜像上传到仓库\n>\n**语法**\n>docker push [OPTIONS] NAME[:TAG]\n>\n**实例**\n\n```\n# 上传镜像hly:v1到仓库中\n# docker push hly:v1\n```\n\n+ ##### \\# docker search \n**功能**\n>从Docker Hub查找镜像\n>\n**语法**\n>docker search [OPTIONS] TERM\n>\n**实例**\n\n```\n# 列出收藏数大于10java镜像。\n# docker search -s 10 java\n```\n### 三.实例\n\n##### 1.先在：<https://cloud.docker.com/>注册自己的docker账号\n##### 2.登录\n\n```\n# docker login -u 用户名 -p 密码\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031200322778.png)\n##### 3.拉取一个镜像\n\n```\n# 拉取镜像\n# docker pull huangliangyun/hello-world:v1\n# 查看本地镜像\n# docker images\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031200755827.png)\n##### 4.为刚才拉取这个镜像创建一个标签\n\n```\n# docker tag huangliangyun/hello-world:v1 huangliangyun/hello-world:v2\n# docker images\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031201023686.png)\n第二个为更改标签的镜像\n##### 5.推送镜像\n\n```\n# docker push huangliangyun/hello-world:v2\n```\n访问仓库可以发现上传的镜像\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031201305492.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1Npcml1c19obHk=,size_16,color_FFFFFF,t_70)\n##### 6.我们可以删除刚才的镜像，重新拉取\n\n```\n# docker pull huangliangyun/hello-world:v2\n```\n##### 7.注销账号\n\n```\n# docker logout\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031201658966.png)', '2018-06-17 02:50:36', '20', null, '1');
INSERT INTO `article` VALUES ('9', 'hly', 'Docker $ 第五篇 ：Docker数据管理', '### 一.Docker数据卷简介\n1.在Docker内部及容器之间对数据的管理有两种方式，一种是数据卷，另一种是挂载主机目录。\n(1)数据卷(Volumes)：提供一个或多个容器使用的特殊目录，它的特性有\n> + 在容器之间可共享，可重用\n> + 对数据卷的修改立即生效\n> + 对数据卷的更新不会影响镜像\n>  + 容器被删除，数据卷也不会被删除\n>  \n(2)挂载主机目录(Bind mounts)：挂载一个本地主机目录到容器中去，作为数据卷。\n### 二.实战\n#### 2.1.数据卷\n##### 1.创建数据卷\n\n```\n# docker volume create hly-vol\n```\n##### 2.查看数据卷\n\n```\n# docker volume ls\n```\n##### 3.查看数据卷信息\n\n```\n# docker volume inspect hly-vol\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031213101146.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1Npcml1c19obHk=,size_16,color_FFFFFF,t_70)\n\n##### 4.启动容器并挂载数据卷\n\n```\n# docker run -d -p 5000:5000 --name web -v hly-vol:/webapp training/webapp\n```\n> -v 把一个书卷hly-vol挂载到了/webapp目录下\n\n##### 5.查看容器信息\n\n```\n# docker inspect web\n```\n数据卷所在的位置和信息：\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031214339263.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1Npcml1c19obHk=,size_16,color_FFFFFF,t_70)\n\n##### 6.其他命令\n\n```\n删除指定数据卷\n# docker volume rm hly-vol\n删除无主数据卷\n# docker volume prune\n```\n#### 2.1.挂载主机目录\n##### 1.启动容器\n\n```\n# docker run -d -p 5000:5000 --name web -v /src/webapp:/webapp training/webapp\n```\n>把本机目录/src/webapp挂载到容器的/webapp下\n>-v /src/webapp:/webapp\n>加ro挂载为为只读，在容器/webapp下创建文件则或报错。\n>-v /src/webapp:/webapp:ro\n##### 2.查看容器信息\n\n```\n# docker inspect web\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031215522837.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1Npcml1c19obHk=,size_16,color_FFFFFF,t_70)\n\n\n', '2018-07-17 02:50:36', '17', null, '1');
INSERT INTO `article` VALUES ('11', 'hly', 'Docker $ 项目部署 ：Docker部署微服务+Mysql', '### 一.准备工作\n这里以两个项目为例：\n[micro-servive-client](https://github.com/huangliangyun/springCloud/tree/master/service-client)\n[micro-servive-server](https://github.com/huangliangyun/springCloud/tree/master/service-server)\n&nbsp;&nbsp;这里配置方面需要注意，服务提供者的host名称为server的镜像名，否则服务无法向注册中心注册。\n\n```\neureka:\n  client:\n    serviceUrl:\n    # server服务端镜像名\n      defaultZone: http://server:8761/eureka/\n```\n\n把项目打包为jar包，然后[上传到linux服务器](https://blog.csdn.net/Sirius_hly/article/details/82590584)。\n### 二.编译镜像\n1.编写server的Dockerfile\n\n```\nFROM java:8\nVOLUME /tmp\nADD server.jar /app.jar\nEXPOSE 8761\nENTRYPOINT [\"java\",\"-Djava.security.egd=file:/dev/./urandom\",\"-jar\",\"/app.jar\"]\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181106212753481.png)\n\n```\n# docker build -t server .\n```\n\n2.编写client的Dockerfile\n\n```\nFROM java:8\nVOLUME /tmp\nADD client.jar /app.jar\nEXPOSE 8762\nENTRYPOINT [\"java\",\"-Djava.security.egd=file:/dev/./urandom\",\"-jar\",\"/app.jar\"]\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181106213128109.png)\n构建镜像\n```\n# docker build -t client .\n```\n### 三.运行服务\n\n#### 3.1.依次以docker命令方式运行\n为了使所有容器在同一个网络内能够相互访问，首先创建一个网桥\n\n```\n# docker network create -d bridge micro\n```\n运行mysql\n\n```\n# docker volume create mysql_vol\n# docker run -it --rm --name mysql -v mysql_vol:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=roof -p 3306:3306 -d --network micro mysql\n```\n运行server\n\n```\n# docker run --name server -d -p 8761:8761 --network micro server\n```\n运行client\n\n```\n# docker run --name client  -p 8762:8762 -d --network micro client\n```\n\n### 3.2.通过docker-compose.yml方式运行\n&nbsp;&nbsp;当服务非常多的时候，一个一个地启动会非常麻烦，我们可以通过编写docker-compose.yml文件，直接命令启动所有的容器。\n1.编写docker-compose.yml文件\n```\nversion: \'2\'\nservices:\n\n mysql:\n    image: mysql\n    restart: always\n    container_name: mysql\n    environment:\n      MYSQL_ROOT_PASSWORD: roof\n    ports:\n      - \"3306:3306\"\n    volumes:\n      - mysql_vol:/var/lib/mysql\n    networks:\n      - micro\n\n server:\n    image: server\n    container_name: server\n    ports:\n      - \"8761:8761\"\n    networks:\n      - micro\n\n client:\n    image: client\n    container_name: client\n    ports:\n      - \"8762:8762\"\n    depends_on:\n      - mysql\n      - server\n    networks:\n      - micro\n\nnetworks:\n  micro:\n    driver: bridge\n\nvolumes:\n  mysql_vol:\n```\n2.启动docker-compose运行项目\n\n```\n# docker-compose up -d\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181106215658767.png)\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181106215636888.png)\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181106213627196.png)\n\n### 四.通过docker-compose.yml直接编排和运行项目\n&nbsp;&nbsp;docker-compose.yml也可以直接构建镜像，然后运行，跳过第二步，根据上传的jar直接使用docker-compose.yml构建镜像。\n\n1.修改docker-compose.yml文件，其他不变\n```\nversion: \'2\'\nservices:\n\n mysql:\n    image: mysql\n    restart: always\n    container_name: mysql\n    environment:\n      MYSQL_ROOT_PASSWORD: roof\n    ports:\n      - \"3306:3306\"\n    volumes:\n      - mysql_vol:/var/lib/mysql\n    networks:\n      - micro\n\n server:\n    image: server\n    build:\n      context: ./server\n      dockerfile: ./Dockerfile\n    container_name: server\n    ports:\n      - \"8761:8761\"\n    networks:\n      - micro\n\n client:\n    image: client\n    build:\n      context: ./client\n      dockerfile: ./Dockerfile\n    container_name: client\n    ports:\n      - \"8762:8762\"\n    depends_on:\n      - mysql\n      - server\n    networks:\n      - micro\n\nnetworks:\n  micro:\n    driver: bridge\nvolumes:\n  mysql_vol:\n```\n改动的关键代码如下\n>    build:\n      context: ./client\n      dockerfile: ./Dockerfile\n      >1.build是构建镜像的命令\n      >2.context是构建的路径\n      >3.dockerfile是dockerfile的路径，相对于构建路径。\n      \n      比如\n  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107091121312.png)\n  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107091212194.png)\n2.在docker-compose.yml文件目录下执行命令构建和编排镜像\n\n```\n# docker-compose up -d\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107091402184.png)', '2018-08-17 02:50:36', '26', null, '1');
INSERT INTO `article` VALUES ('12', 'hly', 'Docker $ 第六篇 ：Docker网络功能', '### 一.Docker网络功能简介\n1.Docker允许通过外部访问容器，容器需要开放一个端口映射到容器外部的端口，外部可通过这个端口访问到联网的容器。\n### 二.外部访问容器\n##### 1.运行容器开放端口\n\n```\n# docker run --rm -d -p 80:80 --name webserver nginx\n```\n访问域名:80即可访问网页\n>-p(小写) :暴露给外部的端口，主机(宿主)端口:容器端口\n>-P(大写) :随机映射一个49000~49900到内部容器开放的端口。\n\n##### 2.查看容器映射到的外部端口\n\n```\n# docker port webserver 80\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031221016707.png)\n\n### 三.Docker容器之间网络连接\n\n##### 1.创建docker网络\n\n```\n# docker network create -d bridge hly-net\n# 查看网络\n# docker network ls\n```\n>\\# docker network create -d bridge [netName]\n>-d：指定Docker网络类型，bridge,overlay(用于Swarm)\n\n##### 2.运行容器\n\n```\n# 运行第一个容器\n# docker run -d -P --name web1 --network hly-net -v /src/webapp:/webapp training/webapp\n```\n\n```\n# 运行第二个容器\ndocker run -d -P --name web2 --network hly-net -v /src/webapp:/webapp training/webapp\n```\n##### 3.进入容器，测试连接\n\n```\n# docker exec -it web1 bash\n# ping web2\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181031222336668.png)\n', '2018-09-17 02:50:36', '42', null, '1');
INSERT INTO `article` VALUES ('19', 'hly', 'Docker $ 项目部署 ：Docker部署SpringBoot+Mysql', '### 一.Dockerfile常用指令\n\n+ #####  FROM\n**目的**\n>指定基础镜像\n>\n**特点**\n>需要写在其他指令之前，之后的指令都依赖于该指令指定的镜像。\n>\n**语法**\n>FROM \\<image>\n>FROM \\<image>:<tag>\n>FROM \\<image>@<digest>\n>\n**实例**\n>FROM java:8\n\n+ #####  ADD\n**目的**\n>1.复制文件\n>\n**语法**\n> ADD [\"<src>\",...\"<dest>\"]\n>ADD \\<src>...\\<dest>\n>从src复制文件到容器的dest。src可以是Dockerfile所在目录的相对路径。\n>\n**实例**\n>ADD spring-boot-docker.jar app.jar\n>拷贝文件并且重命名\n\n+ ##### VOLUME\n**目的**\n>1.加载本地目录下的配置文件到容器目标地址下\n>2.使容器中的一个目录具有持久化存储的功能，该目录可被容器本身使用，也可共享其他容器。。\n>\n**语法**\n>VOLUME [\"<路径1>\",\"<路径2>\"...]\n>VOLUME <路径>\n>\n**实例**\n>VOLUME /tmp\n>VOLUME 指向了一个 /tmp的目录，由于 Spring Boot 使用内置的Tomcat容器，Tomcat 默认使用 /tmp作为工作目录。这个命令的效果是：在宿主机的 /var/lib/docker目录下创建一个临时文件并把它链接到容器中的 /tmp目录\n\n+ ##### EXPOSE\n**目的**\n>声明端口\n>\n**特点**\n>声明容器打算用什么端口，不会自动在宿主进行端口映射。\n>运行时用随机映射，会自动映射EXPOSE的端口。\n>-p <宿主端口>:<容器端口>,将容器对应端口服务公开给外界访问。\n>\n**语法**\n>EXPOSE <端口1> [<端口2>...]\n>\n**实例**\n>EXPOSE 8080\n\n+ ##### ENTRYPOINT\n**目的**\n>入口点，在指定容器启动程序及参数\n>\n**特点**\n>场景一：让镜像变成像命令一样使用。\n>场景二：应用运行前的准备工作。\n>可多次设置，但只有最后一个有效。\n>\n**语法**\n>ENTRYPOINT[\"executable\",\"param1\",\"param2\"]\n>ENTRYPOINT command param1 param2\n>\n**实例**\n>ENTRYPOINT [\"java\",\"-Djava.security.egd=file:/dev/./urandom\",\"-jar\",\"/app.jar\"]\n>为了缩短 Tomcat 的启动时间，添加 java.security.egd的系统属性指向 /dev/urandom作为 ENTRYPOINT\n>\n### 二.部署SpringBoot+Mysql\n\n#####  1.准备部署项目\n1.完整项目在笔者github：[spring-boot-docker](https://github.com/huangliangyun/Spring-Boot-2.X/tree/master/spring-boot-docker)\n2.将项目打包为.jar形式，[上传项目到linux服务器](https://blog.csdn.net/Sirius_hly/article/details/82590584)任意文件夹\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181103125230573.png)\n\n##### 2.编写Dockerfile\n\n```\nFROM java:8\nVOLUME /tmp\nADD spring-boot-docker.jar /app.jar\nEXPOSE 8080\nENTRYPOINT [\"java\",\"-Djava.security.egd=file:/dev/./urandom\",\"-jar\",\"/app.jar\"]\n```\n\n##### 3.编译镜像\n\n```\n# docker build -t spring-boot-docker .\n末尾的点代表文件所在目录执行,指上下文目录\n```\n\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181103125556189.png)\n编译好的镜像如下:\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181103125933557.png)\n\n##### 4.安装Mysql\n&nbsp;&nbsp;创建[数据卷](https://blog.csdn.net/Sirius_hly/article/details/83590830)用来保存mysql的数据，可多个容器共享一个数据卷，当容器被删除时，数据卷不会被删除，mysql的数据依然存在。\n```\n# docker volume create mysql_data\n```\n运行mysql容器\n```\n# docker run -it --rm --name mysql -v mysql_data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=roof -p 3306:3306 -d mysql\n```\n>-v mysql_data:/var/lib/mysql\n>/var/lib/mysql是mysql容器数据存储位置\n>-e MYSQL_ROOT_PASSWORD=t\n>设置mysql密码\n\n##### 5.数据库配置\n\n1.进入mysql容器\n\n```\n# docker exec -it mysql bash\n```\n2.输入用户名密码\n\n```\nmysql -u root -p\n```\n3.设置外部网络访问mysql权限\n\n```\nALTER user \'root\'@\'%\' IDENTIFIED WITH mysql_native_password BY \'roof\';\n```\n\n```\nFLUSH PRIVILEGES;\n```\n4.创建数据库，添加数据\n\n```\ncreate database springboot\n\nDROP TABLE IF EXISTS `users`;\nCREATE TABLE `users` (\n  `user_id` varchar(20) NOT NULL,\n  `user_password` varchar(100) DEFAULT NULL,\n  PRIMARY KEY (`user_id`)\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;\n\nINSERT INTO `users` VALUES (\'hly\', \'123\');\n```\n##### 6.启动项目\n\n```\ndocker run --name spring-boot-docker -d -p 8080:8080 --link mysql:mysql spring-boot-docker\n```\n>-\\-link <name or id>:alias 添加链接到另一个容器；\n>name和id是源容器的name和id，alias是源容器在link下的别名。\n\n### 三.初始化Mysql数据\n&nbsp;&nbsp;为了方便部署，无需每次部署都需要运行mysql数据库，然后再进行创建表，插入数据等一些列操作，我们可以制作一个mysql镜像，初始化数据库的数据。\n##### 1.准备工作\n首先需要创建一个文件夹，添加四个文件，如下。\n+ Dockerfile\n\n```\nFROM mysql:8\n# 把数据库初始化数据文件复制到工作目录\nCOPY springboot.sql /springboot.sql\nCOPY privileges.sql /privileges.sql\n# 把要执行的shell文件放到/docker-entrypoint-initdb.d/目录下，容器会自动执行这个shell\nCOPY setup.sh /docker-entrypoint-initdb.d/setup.sh\n# 给执行文件增加可执行权限\nRUN chmod a+x /docker-entrypoint-initdb.d/setup.sh\n```\n+ springboot.sql\n\n```\ncreate database springboot;\nuse springboot;\nDROP TABLE IF EXISTS `users`;\nCREATE TABLE `users` (\n  `user_id` varchar(20) NOT NULL,\n  `user_password` varchar(100) DEFAULT NULL,\n  PRIMARY KEY (`user_id`)\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;\n\nINSERT INTO `users` VALUES (\'hly\', \'123\');\n```\n+ privileges.sql\n\n```\nuse springboot;\nALTER user \'root\'@\'%\' IDENTIFIED WITH mysql_native_password BY \'roof\';\nFLUSH PRIVILEGES;\n```\n+ setup.sh\n制作sh文件，执行sql脚本。\n```\n#!/bin/bash\nmysql -u root -p$MYSQL_ROOT_PASSWORD <<EOF\nsource springboot.sql;\nsource privileges.sql;\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181105212657705.png)\n\n##### 2.编译镜像\n\n```\n# docker build -t mysql .\n```\n##### 3.运行容器\n\n```\n# docker run -it --rm --name mysql -e MYSQL_ROOT_PASSWORD=roof -p 3306:3306 -d\n```\n\n##### 4.进入容器\n\n```\n# docker exec -it 1a6 bash\n```\n查看表，发现已经创建\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181105213404537.png)\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20181105213414900.png)\n\n参考资料\n>https://blog.csdn.net/leonardc/article/details/79612612\n>https://www.jianshu.com/p/21d66ca6115e', '2018-10-17 10:42:19', '17', null, '1');
INSERT INTO `article` VALUES ('71', 'hly', 'Spring-Cloud-OAuth', 'Spring-Cloud-OAuth', '2018-11-21 09:35:38', '1', null, '1');

-- ----------------------------
-- Table structure for `article_category`
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category` (
  `articleId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`articleId`,`categoryId`),
  KEY `FK_CATEGORYID` (`categoryId`),
  CONSTRAINT `FK_ARTICLEID` FOREIGN KEY (`articleId`) REFERENCES `article` (`articleId`),
  CONSTRAINT `FK_CATEGORYID` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_category
-- ----------------------------
INSERT INTO `article_category` VALUES ('71', '1');
INSERT INTO `article_category` VALUES ('71', '2');
INSERT INTO `article_category` VALUES ('19', '3');
INSERT INTO `article_category` VALUES ('4', '6');
INSERT INTO `article_category` VALUES ('5', '6');
INSERT INTO `article_category` VALUES ('6', '6');
INSERT INTO `article_category` VALUES ('7', '6');
INSERT INTO `article_category` VALUES ('8', '6');
INSERT INTO `article_category` VALUES ('9', '6');
INSERT INTO `article_category` VALUES ('11', '6');
INSERT INTO `article_category` VALUES ('12', '6');
INSERT INTO `article_category` VALUES ('19', '6');
INSERT INTO `article_category` VALUES ('71', '29');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(100) NOT NULL,
  `categoryOrder` int(11) DEFAULT NULL,
  `categoryArticleNum` int(11) DEFAULT '0',
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `categoryName` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '微服务架构', null, '1');
INSERT INTO `category` VALUES ('2', 'SpringCloud', null, '1');
INSERT INTO `category` VALUES ('3', 'SpringBoot', null, '0');
INSERT INTO `category` VALUES ('4', 'Java', null, '0');
INSERT INTO `category` VALUES ('5', 'Linux', null, '0');
INSERT INTO `category` VALUES ('6', 'Docker', null, '8');
INSERT INTO `category` VALUES ('7', 'Git', null, '0');
INSERT INTO `category` VALUES ('8', 'Redis', null, '0');
INSERT INTO `category` VALUES ('9', ' MongoDB', null, '0');
INSERT INTO `category` VALUES ('10', ' Mysql', null, '0');
INSERT INTO `category` VALUES ('11', 'SSM', null, '0');
INSERT INTO `category` VALUES ('12', ' Mybatis', null, '0');
INSERT INTO `category` VALUES ('13', ' JPA', null, '0');
INSERT INTO `category` VALUES ('14', ' SpringMVC', null, '0');
INSERT INTO `category` VALUES ('15', ' oAuth', null, '0');
INSERT INTO `category` VALUES ('16', ' Feign', null, '0');
INSERT INTO `category` VALUES ('17', ' Hystrix', null, '0');
INSERT INTO `category` VALUES ('18', ' Ribbon', null, '0');
INSERT INTO `category` VALUES ('19', ' Zuul', null, '0');
INSERT INTO `category` VALUES ('20', ' Shiro', null, '0');
INSERT INTO `category` VALUES ('21', ' Maven', null, '0');
INSERT INTO `category` VALUES ('22', ' Jenkins', null, '0');
INSERT INTO `category` VALUES ('23', ' Eureka', null, '0');
INSERT INTO `category` VALUES ('24', ' Netty', null, '0');
INSERT INTO `category` VALUES ('25', ' Angular', null, '0');
INSERT INTO `category` VALUES ('26', ' Vue', null, '0');
INSERT INTO `category` VALUES ('27', ' React', null, '0');
INSERT INTO `category` VALUES ('28', ' 区块链', null, '0');
INSERT INTO `category` VALUES ('29', 'OAuth', null, '1');
INSERT INTO `category` VALUES ('30', 'Oracle', null, '0');

-- ----------------------------
-- Table structure for `friendslink`
-- ----------------------------
DROP TABLE IF EXISTS `friendslink`;
CREATE TABLE `friendslink` (
  `friendName` varchar(255) NOT NULL,
  `friendBlog` varchar(1000) DEFAULT NULL,
  `friendGithub` varchar(1000) DEFAULT NULL,
  `friendQQ` varchar(20) DEFAULT NULL,
  `friendUnit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`friendName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friendslink
-- ----------------------------

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `userIP` varchar(255) DEFAULT NULL,
  `actionClassName` varchar(255) DEFAULT NULL,
  `actionDate` datetime DEFAULT NULL,
  `result` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=535 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('475', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:14:05', '用户：null');
INSERT INTO `log` VALUES ('476', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:14:41', '用户：hly');
INSERT INTO `log` VALUES ('477', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:14:51', '用户：hly');
INSERT INTO `log` VALUES ('478', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:17:02', '用户：null');
INSERT INTO `log` VALUES ('479', '', '192.168.43.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:18:55', '用户：null');
INSERT INTO `log` VALUES ('480', 'hly', '192.168.43.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:19:12', '用户：hly');
INSERT INTO `log` VALUES ('481', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:29:40', '用户：null');
INSERT INTO `log` VALUES ('482', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:30:37', '用户：null');
INSERT INTO `log` VALUES ('483', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:30:50', '用户：null');
INSERT INTO `log` VALUES ('484', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:30:50', '用户：null');
INSERT INTO `log` VALUES ('485', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:31:47', '用户：null');
INSERT INTO `log` VALUES ('486', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:31:55', '用户：hly');
INSERT INTO `log` VALUES ('487', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:31:59', '用户：hly');
INSERT INTO `log` VALUES ('488', '', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:33:24', '用户：null');
INSERT INTO `log` VALUES ('489', 'hly', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:33:32', '用户：hly');
INSERT INTO `log` VALUES ('490', 'hly', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:33:34', '用户：hly');
INSERT INTO `log` VALUES ('491', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:33:45', '用户：hly');
INSERT INTO `log` VALUES ('492', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:34:13', '用户：null');
INSERT INTO `log` VALUES ('493', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:39:37', '用户：null');
INSERT INTO `log` VALUES ('494', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:40:19', '用户：null');
INSERT INTO `log` VALUES ('495', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:40:26', '用户：null');
INSERT INTO `log` VALUES ('496', '', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:41:53', '用户：null');
INSERT INTO `log` VALUES ('497', '', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:42:01', '用户：null');
INSERT INTO `log` VALUES ('498', '', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:42:05', '用户：null');
INSERT INTO `log` VALUES ('499', '', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:42:14', '用户：null');
INSERT INTO `log` VALUES ('500', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:42:17', '用户：null');
INSERT INTO `log` VALUES ('501', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:43:27', '用户：null');
INSERT INTO `log` VALUES ('502', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:43:36', '用户：hly');
INSERT INTO `log` VALUES ('503', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:43:39', '用户：hly');
INSERT INTO `log` VALUES ('504', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:43:43', '用户：null');
INSERT INTO `log` VALUES ('505', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:43:50', '用户：hly');
INSERT INTO `log` VALUES ('506', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:44:02', '用户：hly');
INSERT INTO `log` VALUES ('507', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:44:08', '用户：null');
INSERT INTO `log` VALUES ('508', '', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:45:46', '用户：null');
INSERT INTO `log` VALUES ('509', 'hly', '127.0.0.1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:45:56', '用户：hly');
INSERT INTO `log` VALUES ('510', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:46:00', '用户：hly');
INSERT INTO `log` VALUES ('511', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:46:05', '用户：null');
INSERT INTO `log` VALUES ('512', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:47:33', '用户：null');
INSERT INTO `log` VALUES ('513', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:47:39', '用户：null');
INSERT INTO `log` VALUES ('514', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:48:06', '用户：null');
INSERT INTO `log` VALUES ('515', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:50:12', '用户：null');
INSERT INTO `log` VALUES ('516', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 04:50:29', '用户：null');
INSERT INTO `log` VALUES ('517', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 09:31:35', '用户：null');
INSERT INTO `log` VALUES ('518', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 09:31:47', '用户：hly');
INSERT INTO `log` VALUES ('519', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 09:31:56', '用户：null');
INSERT INTO `log` VALUES ('520', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:04:04', '用户：null');
INSERT INTO `log` VALUES ('521', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:04:13', '用户：null');
INSERT INTO `log` VALUES ('522', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:19:32', '用户：null');
INSERT INTO `log` VALUES ('523', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:19:43', '用户：hly');
INSERT INTO `log` VALUES ('524', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:20:37', '用户：hly');
INSERT INTO `log` VALUES ('525', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:20:49', '用户：hly');
INSERT INTO `log` VALUES ('526', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:21:09', '用户：hly');
INSERT INTO `log` VALUES ('527', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:21:25', '用户：hly');
INSERT INTO `log` VALUES ('528', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:21:28', '用户：hly');
INSERT INTO `log` VALUES ('529', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:21:37', '用户：hly');
INSERT INTO `log` VALUES ('530', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:21:48', '用户：hly');
INSERT INTO `log` VALUES ('531', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:22:21', '用户：hly');
INSERT INTO `log` VALUES ('532', '', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:26:17', '用户：null');
INSERT INTO `log` VALUES ('533', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:26:26', '用户：hly');
INSERT INTO `log` VALUES ('534', 'hly', '0:0:0:0:0:0:0:1', 'com.hly.sirius.filter.UserFilter', '2018-11-22 10:26:28', '用户：hly');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(1000) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', '111');
INSERT INTO `user` VALUES ('hly', '4a1f9c0d66ee9063c31ea2c4adeb9617');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `username` varchar(20) NOT NULL,
  `userNickName` varchar(20) DEFAULT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `userBlog` varchar(255) DEFAULT NULL,
  `userUnit` varchar(255) DEFAULT NULL,
  `userQQ` varchar(255) DEFAULT NULL,
  `userWeChat` varchar(255) DEFAULT NULL,
  `userWisdom` varchar(255) DEFAULT NULL,
  `userProfile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `FK_USER_USERINFO` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `visitor`
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `visitorId` int(11) NOT NULL AUTO_INCREMENT,
  `visitorIP` varchar(255) DEFAULT NULL,
  `visitorViewNum` int(11) DEFAULT '0',
  `visitorLastTime` datetime DEFAULT NULL,
  PRIMARY KEY (`visitorId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES ('7', '0:0:0:0:0:0:0:1', '24', '2018-11-22 10:26:12');
INSERT INTO `visitor` VALUES ('8', '192.168.43.1', '0', '2018-11-22 09:25:25');
INSERT INTO `visitor` VALUES ('9', '127.0.0.1', '1', '2018-11-22 10:17:20');

-- ----------------------------
-- Table structure for `webinfo`
-- ----------------------------
DROP TABLE IF EXISTS `webinfo`;
CREATE TABLE `webinfo` (
  `webName` varchar(20) NOT NULL,
  `webViewNum` int(11) DEFAULT NULL,
  `webViewIPNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`webName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `wisdom`
-- ----------------------------
DROP TABLE IF EXISTS `wisdom`;
CREATE TABLE `wisdom` (
  `wisdomId` int(11) NOT NULL AUTO_INCREMENT,
  `wisdomContent` varchar(255) DEFAULT NULL,
  `wisdomAddTime` datetime DEFAULT NULL,
  PRIMARY KEY (`wisdomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wisdom
-- ----------------------------
DELIMITER ;;
CREATE TRIGGER `deleteArticle` AFTER DELETE ON `article_category` FOR EACH ROW BEGIN
UPDATE category SET categoryArticleNum =categoryArticleNum-1 WHERE category.categoryId = old.categoryId;
-- DELETE FROM article WHERE article.articleId =old.articleId;

END
;;
DELIMITER ;
